package com.violet.hrapplication.permission.controller;

import com.violet.hrapplication.permission.controller.request.CreateLeaveTypeRequest;
import com.violet.hrapplication.permission.controller.request.UpdateLeaveTypeRequest;
import com.violet.hrapplication.permission.service.LeaveTypeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leave-type")
public class LeaveTypeController {

    private final LeaveTypeService leaveTypeService;

    public LeaveTypeController(LeaveTypeService leaveTypeService) {
        this.leaveTypeService = leaveTypeService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createLeaveType(
            @RequestBody @Valid CreateLeaveTypeRequest request
    ) {
        leaveTypeService.create(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLeaveType(
            @PathVariable String id,
            @RequestBody @Valid UpdateLeaveTypeRequest request
    ) {
        leaveTypeService.update(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeaveType(
            @PathVariable String id
    ) {
        leaveTypeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
