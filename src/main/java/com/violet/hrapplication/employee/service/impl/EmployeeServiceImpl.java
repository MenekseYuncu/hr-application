package com.violet.hrapplication.employee.service.impl;

import com.violet.hrapplication.employee.controller.request.ChangePasswordRequest;
import com.violet.hrapplication.employee.controller.request.CreateEmployeeRequest;
import com.violet.hrapplication.employee.controller.request.UpdateEmployeeRequest;
import com.violet.hrapplication.employee.controller.response.EmployeeResponse;
import com.violet.hrapplication.employee.model.domain.Employee;
import com.violet.hrapplication.employee.model.entity.EmployeeEntity;
import com.violet.hrapplication.employee.repository.EmployeeRepository;
import com.violet.hrapplication.employee.service.EmployeeService;
import com.violet.hrapplication.exception.AuthenticationException;
import com.violet.hrapplication.exception.UserNameAlreadyExists;
import com.violet.hrapplication.exception.UserNotFoundException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
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
    public List<EmployeeResponse> findAll() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.stream()
                .map(employeeEntity -> new EmployeeResponse(
                        employeeEntity.getUsername(),
                        employeeEntity.getFirstName(),
                        employeeEntity.getLastName(),
                        employeeEntity.getEmail(),
                        employeeEntity.getBirthday(),
                        employeeEntity.getStartWorkingDate(),
                        employeeEntity.getRole(),
                        employeeEntity.getGender(),
                        employeeEntity.getCreator(),
                        employeeEntity.getCreationTime()
                )).toList();
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
        employee.setPassword(RandomStringUtils.random(9, false, true));

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
        String[] names = employee.getFirstName().split("\\s+");
        String firstName = names[0].toLowerCase(); // Sadece ilk ismi al
        return firstName + "-" + employee.getLastName().toLowerCase() + "-" + uniques;
    }

    public void update(String id, UpdateEmployeeRequest request) {
        EmployeeEntity employeeEntityFromDatabase = employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee not found with id: " + id));

        if (!employeeEntityFromDatabase.getEmail().equals(request.email())) {
            this.validateUniqueEmail(request.email());
        }

        employeeEntityFromDatabase.update(
                request.firstName(),
                request.lastName(),
                request.email(),
                request.gender()
        );
        employeeRepository.update(employeeEntityFromDatabase);
    }

    private void validateUniqueEmail(String email) {
        if (employeeRepository.findByEmail(email).isPresent()) {
            throw new UserNotFoundException("Email already exists");
        }
    }


    @Override
    public void changePassword(String id, ChangePasswordRequest request) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);

        if (employeeEntity.isEmpty()) {
            throw new AuthenticationException("User not found");
        }
        String oldPassword = employeeEntity.get().getPassword();
        if (!oldPassword.equals(request.oldPassword())) {
            throw new AuthenticationException("Invalid password");
        }
        employeeRepository.changePassword(id, request.newPassword());
    }
}
