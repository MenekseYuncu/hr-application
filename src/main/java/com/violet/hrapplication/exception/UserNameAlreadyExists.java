package com.violet.hrapplication.exception;

public class UserNameAlreadyExists extends RuntimeException {

    public UserNameAlreadyExists() {
        super("Username already exists");
    }
}
