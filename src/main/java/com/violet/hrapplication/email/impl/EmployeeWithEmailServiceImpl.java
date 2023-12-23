package com.violet.hrapplication.email.impl;

import com.violet.hrapplication.approvals.model.domain.LeaveRequest;
import com.violet.hrapplication.email.EmailService;
import com.violet.hrapplication.email.EmployeeWithEmailService;
import com.violet.hrapplication.employee.model.entity.EmployeeEntity;
import com.violet.hrapplication.employee.repository.EmployeeRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public void sendLeaveRequestApprovalMail(LeaveRequest leave, String approveId) {
        Optional<EmployeeEntity> approve = employeeRepository.findById(approveId);

        if (approve.isPresent()) {
            String approverEmail = approve.get().getEmail();
            if (approverEmail == null) {
                return;
            }

            String subject = "Leave Request Approval";
            String content = "Dear Manager, \n\n" +
                    "A leave request has been submitted and requires your approval.\n" +
                    "Please log in to the system to review and take action.\n\n" +
                    "Leave Details:\n" +
                    "Start Date: " + leave.getStartDate() + "\n" +
                    "End Date: " + leave.getEndDate() + "\n" +
                    "Leave Type: " + leave.getLeaveTypeId() + "\n\n" +
                    "Best regards,\n" +
                    "[Your Company Name]";

            emailService.send(approverEmail, subject, content);
        }
    }
}
