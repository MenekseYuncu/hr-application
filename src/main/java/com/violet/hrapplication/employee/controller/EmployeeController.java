package com.violet.hrapplication.employee.controller;

import com.violet.hrapplication.employee.controller.request.ChangePasswordRequest;
import com.violet.hrapplication.employee.controller.request.CreateEmployeeRequest;
import com.violet.hrapplication.employee.controller.request.UpdateEmployeeRequest;
import com.violet.hrapplication.employee.controller.response.EmployeeResponse;
import com.violet.hrapplication.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/employee")
class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeResponse> findAll() {
        return employeeService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> createEmployee(
            @RequestBody @Valid CreateEmployeeRequest request
    ) {
        employeeService.create(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(
            @PathVariable @UUID String id,
            @RequestBody @Valid UpdateEmployeeRequest request
    ) {
        employeeService.update(id, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<Void> changePassword(
            @PathVariable String id,
            @RequestBody @Valid ChangePasswordRequest changePasswordRequest
    ) {
        employeeService.changePassword(id, changePasswordRequest);
        return ResponseEntity.ok().build();
    }
}
