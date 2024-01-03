package com.violet.hrapplication.approvals.controller;

import com.violet.hrapplication.approvals.controller.reponse.LeaveRequestResponse;
import com.violet.hrapplication.approvals.controller.reponse.LeaveResponse;
import com.violet.hrapplication.approvals.controller.request.CreateLeaveRequest;
import com.violet.hrapplication.approvals.controller.request.FilterByStateRequest;
import com.violet.hrapplication.approvals.controller.request.PaginationRequest;
import com.violet.hrapplication.approvals.controller.request.UpdateLeaveRequest;
import com.violet.hrapplication.approvals.model.enums.State;
import com.violet.hrapplication.approvals.service.LeaveRequestService;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<LeaveRequestResponse> getAllLeaves(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam(value = "state", required = false) State state
    ) {
        PaginationRequest paginationRequest = new PaginationRequest(page, size);
        FilterByStateRequest filterByStateRequest = new FilterByStateRequest(state);

        return leaveRequestService.getAllLeaves(paginationRequest, filterByStateRequest);
    }


    @GetMapping("/{employeeId}")
    public ResponseEntity<List<LeaveResponse>> getLeavesOfUsers(
            @PathVariable @UUID String employeeId,
            @RequestBody PaginationRequest paginationRequest,
            @RequestBody FilterByStateRequest filterByStateRequest
    ) {
        return ResponseEntity.ok(leaveRequestService.getLeaves(employeeId, paginationRequest, filterByStateRequest));
    }

    @GetMapping("/pending")
    public ResponseEntity<List<LeaveRequestResponse>> getPendingLeaves(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        PaginationRequest paginationRequest = new PaginationRequest(page, size);
        return ResponseEntity.ok(leaveRequestService.getLeavesByState(State.PENDING, paginationRequest));
    }

    @GetMapping("/approved")
    public ResponseEntity<List<LeaveRequestResponse>> getApprovedLeaves(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        PaginationRequest paginationRequest = new PaginationRequest(page, size);
        return ResponseEntity.ok(leaveRequestService.getLeavesByState(State.APPROVED, paginationRequest));
    }

    @GetMapping("/rejected")
    public ResponseEntity<List<LeaveRequestResponse>> getRejectedLeaves(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        PaginationRequest paginationRequest = new PaginationRequest(page, size);
        return ResponseEntity.ok(leaveRequestService.getLeavesByState(State.REJECTED, paginationRequest));
    }

    @GetMapping("/daily")
    public ResponseEntity<List<LeaveResponse>> getDailyLeaves() {
        return ResponseEntity.ok(leaveRequestService.getLeaveRequestsForDate());
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
            @RequestBody @Valid UpdateLeaveRequest request
    ) {
        leaveRequestService.update(id, request);
        return ResponseEntity.ok().build();
    }
}
