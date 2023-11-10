package com.violet.hrapplication.employee.exception;

public class UserNameAlreadyExists extends RuntimeException {

    public UserNameAlreadyExists() {
        super("Username already exists");
    }
}
