package com.violet.hrapplication.approvals.controller;

import com.violet.hrapplication.approvals.controller.request.leavetype.CreateLeaveTypeRequest;
import com.violet.hrapplication.approvals.controller.request.leavetype.UpdateLeaveTypeRequest;
import com.violet.hrapplication.approvals.service.LeaveTypeService;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/leave-type")
class LeaveTypeController {

    private final LeaveTypeService leaveTypeService;

    public LeaveTypeController(LeaveTypeService leaveTypeService) {
        this.leaveTypeService = leaveTypeService;
    }

    @PostMapping
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
            @PathVariable @UUID String id
    ) {
        leaveTypeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
