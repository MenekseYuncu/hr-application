package com.violet.hrapplication.email;

import com.violet.hrapplication.approvals.model.domain.LeaveRequest;
import com.violet.hrapplication.employee.model.entity.EmployeeEntity;

public interface EmployeeEmailService {

    void sendUsernameAndPasswordInformation(EmployeeEntity employeeEntity);

    void sendBirthDayMessage();

    void sendLeaveRequestStatusChange(LeaveRequest leave, String employeeEmail);
}
