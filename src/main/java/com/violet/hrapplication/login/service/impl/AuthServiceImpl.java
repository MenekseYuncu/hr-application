package com.violet.hrapplication.login.service.impl;

import com.violet.hrapplication.employee.model.entity.EmployeeEntity;
import com.violet.hrapplication.employee.repository.EmployeeRepository;
import com.violet.hrapplication.exception.AuthenticationException;
import com.violet.hrapplication.login.request.LoginRequest;
import com.violet.hrapplication.login.service.AuthService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class AuthServiceImpl implements AuthService {

    private final EmployeeRepository employeeRepository;

    AuthServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void login(LoginRequest loginRequest) throws AuthenticationException {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findByUsername(loginRequest.username());

        if (employeeEntity.isEmpty() || !BCrypt.checkpw(loginRequest.password(), employeeEntity.get().getPassword())) {
            throw new AuthenticationException("Invalid username or password");
        }
    }
}
