package com.violet.hrapplication.approvals.controller;

import com.violet.hrapplication.approvals.controller.reponse.LeaveRequestResponse;
import com.violet.hrapplication.approvals.controller.reponse.LeaveResponse;
import com.violet.hrapplication.approvals.controller.request.CreateLeaveRequest;
import com.violet.hrapplication.approvals.controller.request.UpdateLeaveRequest;
import com.violet.hrapplication.approvals.service.LeaveRequestService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/leave-request")
class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    LeaveRequestController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @GetMapping
    public List<LeaveRequestResponse> getAllLeaves() {
        return leaveRequestService.getAllLeaves();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<LeaveResponse>> getLeavesOfUsers(
            @PathVariable String id
    ) {
        return ResponseEntity.ok(leaveRequestService.getLeaves(id));
    }

    @PostMapping
    public ResponseEntity<Void> create(
            @RequestBody @Valid CreateLeaveRequest request
    ) {
        leaveRequestService.create(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable String id,
            @RequestBody UpdateLeaveRequest request
    ) {
        leaveRequestService.update(id, request);
        return ResponseEntity.ok().build();
    }
}
