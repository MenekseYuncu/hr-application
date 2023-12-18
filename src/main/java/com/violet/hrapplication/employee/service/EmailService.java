package com.violet.hrapplication.employee.service;

import com.violet.hrapplication.exception.EmailServiceException;

public interface EmailService {

    void send(String mail, String subject, String context) throws EmailServiceException;
}
