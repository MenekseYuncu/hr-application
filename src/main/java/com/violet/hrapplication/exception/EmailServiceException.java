package com.violet.hrapplication.exception;

import jakarta.mail.MessagingException;

public class EmailServiceException extends RuntimeException {

    public EmailServiceException(String message) {
        super(message);
    }

    public EmailServiceException(MessagingException messagingException){
        super(messagingException.getMessage());
    }
}
