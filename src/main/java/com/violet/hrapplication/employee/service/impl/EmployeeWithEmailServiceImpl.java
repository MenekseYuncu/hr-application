package com.violet.hrapplication.employee.service.impl;

import com.violet.hrapplication.employee.model.entity.EmployeeEntity;
import com.violet.hrapplication.employee.repository.EmployeeRepository;
import com.violet.hrapplication.employee.service.EmailService;
import com.violet.hrapplication.employee.service.EmployeeWithEmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
class EmployeeWithEmailServiceImpl implements EmployeeWithEmailService {

    private final EmployeeRepository employeeRepository;
    private final EmailService emailService;

    EmployeeWithEmailServiceImpl(EmployeeRepository employeeRepository, EmailService emailService) {
        this.employeeRepository = employeeRepository;
        this.emailService = emailService;
    }

    @Override
    public void sendUsernameAndPasswordInformation(EmployeeEntity employeeEntity) {
        String subject = "Your New Account Information";
        String context = "Dear " + employeeEntity.getFirstName() + ",\n\n" +
                "We are delighted to welcome you to [Violet Innovate Solutions]\n\n" +
                "Your account has been successfully created, and you can now access our systems with the following credentials:\n\n" +
                "Username: " + employeeEntity.getUsername() + "\n" +
                "Password: " + employeeEntity.getPassword() + "\n\n" +
                "For security reasons, we recommend that you change your password after your first login.\n\n" +
                "Best regards,\n\n" +
                "[Violet Innovate Solutions]";
        emailService.send(employeeEntity.getEmail(), subject, context);
    }

    @Override
    @Scheduled(cron = "0 35 1 * * ?")
    public void sendBirthDayMessage() {
        List<EmployeeEntity> employeesWithBirthDay = employeeRepository.findByBirthDate(LocalDate.now().plusDays(1));

        for (EmployeeEntity employee : employeesWithBirthDay) {
            String subject = "Happy Birthday!";
            String context = "Dear " + employee.getFirstName() + " " + employee.getLastName() + ",\n\n" +
                    "Happy Birthday! We wish you a fantastic day filled with joy and success.\n\n" +
                    "Best regards,\n\n" +
                    "[Violet Innovate Solutions]";
            emailService.send(employee.getEmail(), subject, context);
        }
    }
}
