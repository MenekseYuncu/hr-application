package com.violet.hrapplication.employee.service;

import com.violet.hrapplication.employee.controller.request.ChangePasswordRequest;
import com.violet.hrapplication.employee.controller.request.CreateEmployeeRequest;
import com.violet.hrapplication.employee.controller.request.UpdateEmployeeRequest;

public interface EmployeeService {

    void create(CreateEmployeeRequest request);

    void update(UpdateEmployeeRequest request, String id);

    void changePassword(ChangePasswordRequest changePasswordRequest);
}
