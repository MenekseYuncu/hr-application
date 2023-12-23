package com.violet.hrapplication.email;

import com.violet.hrapplication.approvals.model.domain.LeaveRequest;
import com.violet.hrapplication.employee.model.entity.EmployeeEntity;

public interface EmployeeWithEmailService {

    void sendUsernameAndPasswordInformation(EmployeeEntity employeeEntity);

    void sendBirthDayMessage();

    void sendLeaveRequestApprovalMail(LeaveRequest leave, String approverId);
}
