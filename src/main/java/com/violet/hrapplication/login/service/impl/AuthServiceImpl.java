package com.violet.hrapplication.login.service.impl;

import com.violet.hrapplication.employee.model.entity.EmployeeEntity;
import com.violet.hrapplication.employee.repository.EmployeeRepository;
import com.violet.hrapplication.exception.AuthenticationException;
import com.violet.hrapplication.login.request.LoginRequest;
import com.violet.hrapplication.login.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class AuthServiceImpl implements AuthService {

    private final EmployeeRepository employeeRepository;

    AuthServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String login(LoginRequest loginRequest) throws AuthenticationException {

        Optional<EmployeeEntity> employee = employeeRepository.findByUsername(loginRequest.username());

        if (employee.isEmpty()) {
            throw new AuthenticationException("Invalid username or password");
        }
        if (!employee.get().getPassword().equals(loginRequest.password())) {
            throw new AuthenticationException("Invalid username or password");
        }

        return "Login successful";
    }
}
