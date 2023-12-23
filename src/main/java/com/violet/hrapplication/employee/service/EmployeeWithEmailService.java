package com.violet.hrapplication.employee.service;

import com.violet.hrapplication.employee.model.entity.EmployeeEntity;

public interface EmployeeWithEmailService {

    void sendUsernameAndPasswordInformation(EmployeeEntity employeeEntity);

    void sendBirthDayMessage();
}
