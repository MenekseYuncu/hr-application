package com.violet.hrapplication.email.impl;

import com.violet.hrapplication.email.EmailService;
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
    public void send(String mail, String subject, String content) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(mail);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content);

        } catch (MessagingException e) {
            throw new EmailServiceException(e);
        }
        javaMailSender.send(mimeMessage);
    }
}
