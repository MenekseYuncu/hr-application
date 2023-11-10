package com.violet.hrapplication.employee.controller;

import com.violet.hrapplication.employee.controller.endpoints.EmployeControllerEndpoint;
import com.violet.hrapplication.employee.controller.request.CreateEmployeeRequest;
import com.violet.hrapplication.employee.model.dto.EmployeeDTO;
import com.violet.hrapplication.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EmployeControllerEndpoint.EMPLOYEE)
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public EmployeeDTO createEmployee(
            @RequestBody CreateEmployeeRequest request
    ) {
        return employeeService.createEmployee(request);
    }
}
