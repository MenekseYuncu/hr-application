package com.violet.hrapplication.login.repository;

public interface AuthRepository {

    boolean authenticateUser(String username, String password);

}
