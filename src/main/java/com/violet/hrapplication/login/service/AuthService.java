package com.violet.hrapplication.login.service;

import com.violet.hrapplication.exception.AuthenticationException;
import com.violet.hrapplication.login.request.LoginRequest;

public interface AuthService {

    String login(LoginRequest loginRequest) throws AuthenticationException;

    boolean authenticateUser(String username, String password) throws AuthenticationException;
}
