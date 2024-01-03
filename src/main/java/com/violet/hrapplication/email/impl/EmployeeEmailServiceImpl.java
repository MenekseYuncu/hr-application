package com.violet.hrapplication.email.impl;

import com.violet.hrapplication.approvals.model.domain.LeaveRequest;
import com.violet.hrapplication.approvals.model.enums.State;
import com.violet.hrapplication.email.EmailService;
import com.violet.hrapplication.email.EmployeeEmailService;
import com.violet.hrapplication.employee.model.entity.EmployeeEntity;
import com.violet.hrapplication.employee.repository.EmployeeRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
class EmployeeEmailServiceImpl implements EmployeeEmailService {

    private final EmployeeRepository employeeRepository;
    private final EmailService emailService;

    EmployeeEmailServiceImpl(EmployeeRepository employeeRepository, EmailService emailService) {
        this.employeeRepository = employeeRepository;
        this.emailService = emailService;
    }

    @Override
    public void sendUsernameAndPasswordInformation(EmployeeEntity employeeEntity) {
        String subject = "Your New Account Information";
        String context = "Dear " + employeeEntity.getFirstName() + ",\n\n" +
                "We are delighted to welcome you to [Castilla of Developer]\n\n" +
                "Your account has been successfully created, and you can now access our systems with the following credentials:\n\n" +
                "Username: " + employeeEntity.getUsername() + "\n" +
                "Password: " + employeeEntity.getPassword() + "\n\n" +
                "For security reasons, we recommend that you change your password after your first login.\n\n" +
                "Best regards,\n\n" +
                "[Castilla of Developer]";
        emailService.send(employeeEntity.getEmail(), subject, context);
    }

    @Override
    @Scheduled(cron = "0 0 9 * * ?")
    public void sendBirthDayMessage() {
        List<EmployeeEntity> employeesWithBirthDay = employeeRepository.findByBirthDate(LocalDate.now().plusDays(1));

        for (EmployeeEntity employee : employeesWithBirthDay) {
            String subject = "Happy Birthday!";
            String context = "Dear " + employee.getFirstName() + " " + employee.getLastName() + ",\n\n" +
                    "Happy Birthday! We wish you a fantastic day filled with joy and success.\n\n" +
                    "Best regards,\n\n" +
                    "[Castilla of Developer]";
            emailService.send(employee.getEmail(), subject, context);
        }
    }

    @Override
    public void sendLeaveRequestStatusChange(LeaveRequest leave, String employeeEmail) {
        String subject = leave.getState() == State.APPROVED ? "Leave Request Approved"
                : "Leave Request Rejected";
        String content = "Dear Employee, \n\n" +
                "Your leave request has been " + leave.getState().toString().toLowerCase() + ".\n\n" +
                "Leave Details:\n" +
                "Start Date: " + leave.getStartDate() + "\n" +
                "End Date: " + leave.getEndDate() + "\n" +
                "Leave Type: " + leave.getLeaveTypeId() + "\n\n" +
                "Best regards,\n" +
                "[Castilla of Developer]";

        emailService.send(employeeEmail, subject, content);
    }
}
