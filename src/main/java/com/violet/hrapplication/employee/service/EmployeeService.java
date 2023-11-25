package com.violet.hrapplication.employee.service;

import com.violet.hrapplication.employee.controller.request.ChangePasswordRequest;
import com.violet.hrapplication.employee.controller.request.CreateEmployeeRequest;

public interface EmployeeService {

    void create(CreateEmployeeRequest request);

    Boolean changePassword(ChangePasswordRequest changePasswordRequest);
}
