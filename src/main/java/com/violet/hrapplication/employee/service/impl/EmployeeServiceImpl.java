package com.violet.hrapplication.employee.service.impl;

import com.violet.hrapplication.employee.controller.request.CreateEmployeeRequest;
import com.violet.hrapplication.employee.exception.UserNameAlreadyExists;
import com.violet.hrapplication.employee.model.dto.EmployeeDTO;
import com.violet.hrapplication.employee.repository.EmployeeRepository;
import com.violet.hrapplication.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    final Random random = new Random();

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO createEmployee(CreateEmployeeRequest request) {

        EmployeeDTO employee = new EmployeeDTO();
        employee.setId(UUID.randomUUID().toString());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setBirthday(request.getBirthday());
        employee.setStartWorkingDate(request.getStartWorkingDate());
        employee.setRole(request.getRole());
        employee.setGender(request.getGender());

        employee.setUsername(generateUsername(employee));
        employee.setPassword(generatePassword());

        isUsernameUniqueExists(employee);
        employeeRepository.createEmployee(employee.toEmployee());
        return employee;
    }

    private void isUsernameUniqueExists(EmployeeDTO employee) {
        var isExists = employeeRepository.isUsernameExists(employee.getUsername());
        int i = 0;
        while (i < 5) {
            if (Boolean.TRUE.equals(isExists)) {
                employee.setUsername(generateUsername(employee));
                isExists = employeeRepository.isUsernameExists(employee.getUsername());
            } else {
                break;
            }
            i++;
        }
        if (Boolean.TRUE.equals(isExists)) {
            throw new UserNameAlreadyExists();
        }
    }

    private String generateUsername(EmployeeDTO employee) {
        int uniques = 1000 + this.random.nextInt(9000);
        return employee.getFirstName().toLowerCase() + "." + employee.getLastName().toLowerCase() + "." + uniques;
    }

    private String generatePassword() {
        int passwordNumber = (int) Math.pow(10, 8) + this.random.nextInt((int) (Math.pow(10, 8) * 9));
        return Integer.toHexString(passwordNumber);
    }
}
