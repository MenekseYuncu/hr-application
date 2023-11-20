package com.violet.hrapplication.employee.service;

import com.violet.hrapplication.employee.controller.request.CreateEmployeeRequest;
import com.violet.hrapplication.employee.model.domain.Employee;

public interface EmployeeService {

    Employee create(CreateEmployeeRequest request);
    
}
