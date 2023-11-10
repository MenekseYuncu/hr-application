package com.violet.hrapplication.employee.service;

import com.violet.hrapplication.employee.controller.request.CreateEmployeeRequest;
import com.violet.hrapplication.employee.model.dto.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO createEmployee(CreateEmployeeRequest request);

}
