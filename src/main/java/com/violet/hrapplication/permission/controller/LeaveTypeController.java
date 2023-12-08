package com.violet.hrapplication.permission.controller;

import com.violet.hrapplication.permission.controller.request.CreateLeaveTypeRequest;
import com.violet.hrapplication.permission.controller.request.UpdateLeaveTypeRequest;
import com.violet.hrapplication.permission.service.LeaveTypeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leave-type")
public class LeaveTypeController {

    private final LeaveTypeService leaveTypeService;

    public LeaveTypeController(LeaveTypeService leaveTypeService) {
        this.leaveTypeService = leaveTypeService;
    }

    @PostMapping("/create")
    public void createLeaveType(
            @RequestBody CreateLeaveTypeRequest request
    ) {
        leaveTypeService.create(request);
    }

    @PutMapping("/{id}")
    public void updateLeaveType(
            @PathVariable String id,
            @RequestBody UpdateLeaveTypeRequest request
    ) {
        leaveTypeService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteLeaveType(
            @PathVariable String id
    ) {
        leaveTypeService.delete(id);
    }
}
