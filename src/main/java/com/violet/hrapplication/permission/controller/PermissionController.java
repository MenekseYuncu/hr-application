package com.violet.hrapplication.permission.controller;

import com.violet.hrapplication.permission.controller.reponse.LeaveRequestResponse;
import com.violet.hrapplication.permission.controller.request.CreateLeaveRequest;
import com.violet.hrapplication.permission.service.PermissionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissions")
class PermissionController {

    private final PermissionService permissionService;

    PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping("/create")
    public void createEmployee(
            @RequestBody @Valid CreateLeaveRequest request
    ) {
        permissionService.create(request);
    }

    @GetMapping("/all")
    public List<LeaveRequestResponse> getAllLeaves() {
        return permissionService.getAllLeaves();
    }
}
