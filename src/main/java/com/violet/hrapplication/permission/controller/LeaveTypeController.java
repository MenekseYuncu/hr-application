package com.violet.hrapplication.permission.controller;

import com.violet.hrapplication.permission.controller.reponse.LeaveRequestResponse;
import com.violet.hrapplication.permission.controller.request.CreateLeaveTypeRequest;
import com.violet.hrapplication.permission.service.LeaveTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    ){
        leaveTypeService.create(request);
    }
}
