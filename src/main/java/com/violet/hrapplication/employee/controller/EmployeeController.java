package com.violet.hrapplication.employee.controller;

import com.violet.hrapplication.employee.controller.request.ChangePasswordRequest;
import com.violet.hrapplication.employee.controller.request.CreateEmployeeRequest;
import com.violet.hrapplication.employee.controller.request.UpdateEmployeeRequest;
import com.violet.hrapplication.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public void createEmployee(
            @RequestBody @Valid CreateEmployeeRequest request
    ) {
        employeeService.create(request);
    }

    @PostMapping("/update/{id}")
    public void updateEmployee(
            @PathVariable String id,
            @RequestBody  UpdateEmployeeRequest request
    ) {
        employeeService.update(id, request);
    }

    @PostMapping("/{id}/change-password")
    public ResponseEntity<Void> changePassword(
            @PathVariable String id,
            @RequestBody @Valid ChangePasswordRequest changePasswordRequest
    ) {
        employeeService.changePassword(id, changePasswordRequest);

        return ResponseEntity.ok().build();
    }


}
