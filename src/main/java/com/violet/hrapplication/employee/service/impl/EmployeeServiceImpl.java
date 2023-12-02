package com.violet.hrapplication.employee.service.impl;

import com.violet.hrapplication.employee.controller.request.ChangePasswordRequest;
import com.violet.hrapplication.employee.controller.request.CreateEmployeeRequest;
import com.violet.hrapplication.employee.controller.request.UpdateEmployeeRequest;
import com.violet.hrapplication.employee.model.domain.Employee;
import com.violet.hrapplication.employee.model.entity.EmployeeEntity;
import com.violet.hrapplication.employee.repository.EmployeeRepository;
import com.violet.hrapplication.employee.service.EmployeeService;
import com.violet.hrapplication.exception.AuthenticationException;
import com.violet.hrapplication.exception.UserNameAlreadyExists;
import com.violet.hrapplication.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private static final Random random = new Random();

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void create(CreateEmployeeRequest request) {

        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setFirstName(request.firstName());
        employee.setLastName(request.lastName());
        employee.setEmail(request.email());
        employee.setBirthday(request.birthday());
        employee.setStartWorkingDate(LocalDate.now());
        employee.setRole(request.role());
        employee.setGender(request.gender());
        employee.setCreator(request.creator());
        employee.setCreationTime(LocalDateTime.now());

        employee.setUsername(generateUsername(employee));
        employee.setPassword(generatePassword());

        isUsernameUniqueExists(employee);


        employeeRepository.save(employee.toEmployee());
    }

    private void isUsernameUniqueExists(Employee employee) {
        for (int attempt = 0; attempt < 3; attempt++) {
            Optional<EmployeeEntity> existingEmployee = employeeRepository.findByUsername(employee.getUsername());

            if (existingEmployee.isEmpty()) {
                return;
            }
            employee.setUsername(generateUsername(employee));
        }
        throw new UserNameAlreadyExists();
    }


    private String generateUsername(Employee employee) {
        int uniques = 1000 + EmployeeServiceImpl.random.nextInt(9000);
        return employee.getFirstName().toLowerCase() + "-" + employee.getLastName().toLowerCase() + "-" + uniques;
    }

    private String generatePassword() {
        int passwordNumber = (int) Math.pow(10, 8) + EmployeeServiceImpl.random.nextInt((int) (Math.pow(10, 8) * 9));
        return Integer.toHexString(passwordNumber);
    }

    @Override
    public void update(String id, UpdateEmployeeRequest request) {
        EmployeeEntity existingEmployeeEntity = employeeRepository.findById(id);

        if (existingEmployeeEntity != null) {
            validateUniqueEmail(request.email());
            validateUniqueUsername(request.username());

            Employee updatedEmployee = new Employee();
            updatedEmployee.setId(id);
            updatedEmployee.setUsername(request.username());
            updatedEmployee.setFirstName(request.firstName());
            updatedEmployee.setLastName(request.lastName());
            updatedEmployee.setEmail(request.email());
            updatedEmployee.setGender(request.gender());

            employeeRepository.update(updatedEmployee.toEmployee());
        }
    }


    private void validateUniqueEmail(String email) {
        if (employeeRepository.findByEmail(email).isPresent()) {
            throw new UserNotFoundException("Email already exists");
        }
    }

    private void validateUniqueUsername(String username) {
        if (employeeRepository.findByUsername(username).isPresent()) {
            throw new UserNotFoundException("Username already exists");
        }
    }


    @Override
    public void changePassword(String id, ChangePasswordRequest request) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id);

        if (employeeEntity == null) {
            throw new AuthenticationException("User not found");
        }

        String oldPassword = employeeEntity.getPassword();

        if (oldPassword == null || !oldPassword.equals(request.oldPassword())) {
            throw new AuthenticationException("Invalid password");
        }

        employeeRepository.changePassword(id, request.newPassword());
    }

}
