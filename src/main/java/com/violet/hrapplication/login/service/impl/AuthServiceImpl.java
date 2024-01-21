package com.violet.hrapplication.login.service.impl;

import com.violet.hrapplication.employee.model.entity.EmployeeEntity;
import com.violet.hrapplication.employee.repository.EmployeeRepository;
import com.violet.hrapplication.exception.AuthenticationException;
import com.violet.hrapplication.login.request.LoginRequest;
import com.violet.hrapplication.login.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
class AuthServiceImpl implements AuthService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    AuthServiceImpl(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void login(LoginRequest loginRequest) throws AuthenticationException {
        EmployeeEntity employeeEntity = employeeRepository.findByUsername(loginRequest.username())
                .orElseThrow(() -> new AuthenticationException("Invalid username or password"));

        if (!passwordEncoder.matches(loginRequest.password(), employeeEntity.getPassword())) {
            throw new AuthenticationException("Invalid username or password");
        }
    }
}
