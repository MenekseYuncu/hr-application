package com.violet.hrapplication.employee.service.impl;

import com.violet.hrapplication.employee.service.EmailService;
import com.violet.hrapplication.exception.EmailServiceException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void send(String mail, String subject, String context) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(mail);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(context);

        } catch (MessagingException e) {
            throw new EmailServiceException(e);
        }
        javaMailSender.send(mimeMessage);
    }
}
