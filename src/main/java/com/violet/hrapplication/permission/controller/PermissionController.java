package com.violet.hrapplication.permission.controller;

import com.violet.hrapplication.permission.controller.reponse.LeaveRequestResponse;
import com.violet.hrapplication.permission.controller.reponse.LeaveResponse;
import com.violet.hrapplication.permission.controller.request.CreateLeaveRequest;
import com.violet.hrapplication.permission.controller.request.UpdateLeaveRequest;
import com.violet.hrapplication.permission.service.PermissionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> create(
            @RequestBody @Valid CreateLeaveRequest request
    ) {
        permissionService.create(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable String id,
            @RequestBody UpdateLeaveRequest request
    ) {
        permissionService.update(id, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<LeaveResponse>> getLeaves(
            @PathVariable String id
    ) {
        return ResponseEntity.ok(permissionService.getLeaves(id));
    }

    @GetMapping("/all")
    public List<LeaveRequestResponse> getAllLeaves() {
        return permissionService.getAllLeaves();
    }
}
