package com.violet.hrapplication.login.controller;

import com.violet.hrapplication.exception.AuthenticationException;
import com.violet.hrapplication.login.request.LoginRequest;
import com.violet.hrapplication.login.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public void login(@RequestBody @Valid LoginRequest request) throws AuthenticationException {
        authService.login(request);
    }
}
