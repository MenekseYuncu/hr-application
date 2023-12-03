package com.violet.hrapplication.employee.service;

import com.violet.hrapplication.employee.controller.request.ChangePasswordRequest;
import com.violet.hrapplication.employee.controller.request.CreateEmployeeRequest;
import com.violet.hrapplication.employee.controller.request.UpdateEmployeeRequest;
import com.violet.hrapplication.employee.controller.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    void create(CreateEmployeeRequest request);

    void update(String id, UpdateEmployeeRequest request);

    List<EmployeeResponse> findAll();

    void changePassword(String id, ChangePasswordRequest changePasswordRequest);

}
