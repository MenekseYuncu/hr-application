package com.violet.hrapplication.login.service.impl;

import com.violet.hrapplication.exception.AuthenticationException;
import com.violet.hrapplication.login.repository.AuthRepository;
import com.violet.hrapplication.login.request.LoginRequest;
import com.violet.hrapplication.login.service.AuthService;
import org.springframework.stereotype.Service;

@Service
class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;

    AuthServiceImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public String login(LoginRequest loginRequest) throws AuthenticationException {
        return null;
    }

    public boolean authenticateUser(String username, String password) {
        return authRepository.authenticateUser(username, password);
    }
}
