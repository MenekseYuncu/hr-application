package com.violet.hrapplication.approvals.controller;

import com.violet.hrapplication.approvals.controller.reponse.LeaveRequestResponse;
import com.violet.hrapplication.approvals.controller.reponse.LeaveResponse;
import com.violet.hrapplication.approvals.controller.request.CreateLeaveRequest;
import com.violet.hrapplication.approvals.controller.request.PaginationAndFilter;
import com.violet.hrapplication.approvals.controller.request.PaginationRequest;
import com.violet.hrapplication.approvals.controller.request.UpdateLeaveRequest;
import com.violet.hrapplication.approvals.model.enums.State;
import com.violet.hrapplication.approvals.service.LeaveRequestService;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Validated
@RestController
@RequestMapping("/api/leave-request")
class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    LeaveRequestController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @PostMapping
    public List<LeaveRequestResponse> getAllLeaves(
            @Valid @RequestBody PaginationAndFilter paginationAndFilter
    ) {
        return leaveRequestService.getAllLeaves(paginationAndFilter);
    }

    @PostMapping("/{employeeId}")
    public ResponseEntity<List<LeaveResponse>> getLeavesOfUsers(
            @PathVariable @UUID String employeeId,
            @RequestBody @Valid PaginationAndFilter paginationAndFilter
    ) {
        return ResponseEntity.ok(leaveRequestService.getLeaves(employeeId, paginationAndFilter));
    }

    @PostMapping("/pending")
    public ResponseEntity<List<LeaveRequestResponse>> getPendingLeaves(
            @Valid @RequestBody PaginationRequest paginationRequest
    ) {
        return ResponseEntity.ok(leaveRequestService.getLeavesByState(State.PENDING, paginationRequest));
    }

    @PostMapping("/approved")
    public ResponseEntity<List<LeaveRequestResponse>> getApprovedLeaves(
             @Valid @RequestBody PaginationRequest paginationRequest
    ) {
        return ResponseEntity.ok(leaveRequestService.getLeavesByState(State.APPROVED, paginationRequest));
    }

    @PostMapping("/rejected")
    public ResponseEntity<List<LeaveRequestResponse>> getRejectedLeaves(
            @Valid @RequestBody PaginationRequest paginationRequest
    ) {
        return ResponseEntity.ok(leaveRequestService.getLeavesByState(State.REJECTED, paginationRequest));
    }

    @GetMapping("/daily")
    public ResponseEntity<List<LeaveResponse>> getDailyLeaves() {
        return ResponseEntity.ok(leaveRequestService.getLeaveRequestsForDate());
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(
            @RequestBody @Valid CreateLeaveRequest request
    ) {
        leaveRequestService.create(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable String id,
            @RequestBody @Valid UpdateLeaveRequest request
    ) {
        leaveRequestService.update(id, request);
        return ResponseEntity.ok().build();
    }
}
