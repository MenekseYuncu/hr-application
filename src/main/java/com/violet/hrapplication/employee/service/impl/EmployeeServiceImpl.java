package com.violet.hrapplication.employee.service.impl;

import com.violet.hrapplication.employee.controller.request.CreateEmployeeRequest;
import com.violet.hrapplication.exception.UserNameAlreadyExists;
import com.violet.hrapplication.employee.model.domain.Employee;
import com.violet.hrapplication.employee.repository.EmployeeRepository;
import com.violet.hrapplication.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final Random random = new Random();

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(CreateEmployeeRequest request) {

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
        return employee;
    }

    private void isUsernameUniqueExists(Employee employee) {
        var isExists = employeeRepository.findByUsername(employee.getUsername());
        int i = 0;
        while (i < 3) {
            if (Boolean.TRUE.equals(isExists)) {
                employee.setUsername(generateUsername(employee));
                isExists = employeeRepository.findByUsername(employee.getUsername());
            } else {
                break;
            }
            i++;
        }
        if (Boolean.FALSE.equals(isExists)) {
            throw new UserNameAlreadyExists();
        }
    }

    private String generateUsername(Employee employee) {
        int uniques = 1000 + this.random.nextInt(9000);
        return employee.getFirstName().toLowerCase() + "-" + employee.getLastName().toLowerCase() + "-" + uniques;
    }

    private String generatePassword() {
        int passwordNumber = (int) Math.pow(10, 8) + this.random.nextInt((int) (Math.pow(10, 8) * 9));
        return Integer.toHexString(passwordNumber);
    }
}
