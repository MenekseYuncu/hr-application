package com.violet.hrapplication.approvals.service;

import com.violet.hrapplication.approvals.controller.request.FilterByStateRequest;
import com.violet.hrapplication.approvals.controller.request.PaginationRequest;
import com.violet.hrapplication.approvals.model.enums.State;
import com.violet.hrapplication.exception.UserNotFoundException;
import com.violet.hrapplication.approvals.controller.reponse.LeaveRequestResponse;
import com.violet.hrapplication.approvals.controller.reponse.LeaveResponse;
import com.violet.hrapplication.approvals.controller.request.CreateLeaveRequest;
import com.violet.hrapplication.approvals.controller.request.UpdateLeaveRequest;

import java.util.List;

public interface LeaveRequestService {

    List<LeaveResponse> getLeaves(String employeeId, PaginationRequest paginationRequest, FilterByStateRequest filterByStateRequest);

    List<LeaveRequestResponse> getLeavesByState(State state, PaginationRequest paginationRequest);

    List<LeaveResponse> getLeaveRequestsForDate();

    List<LeaveRequestResponse> getAllLeaves(PaginationRequest paginationRequest, FilterByStateRequest filterByStateRequest);

    void create(CreateLeaveRequest createLeaveRequest) throws UserNotFoundException;

    void update(String id, UpdateLeaveRequest createLeaveRequest) throws UserNotFoundException;
}
