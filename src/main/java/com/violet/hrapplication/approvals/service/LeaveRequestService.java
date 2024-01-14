package com.violet.hrapplication.approvals.service;

import com.violet.hrapplication.approvals.controller.request.PaginationAndFilter;
import com.violet.hrapplication.approvals.model.enums.State;
import com.violet.hrapplication.exception.UserNotFoundException;
import com.violet.hrapplication.approvals.controller.reponse.LeaveRequestResponse;
import com.violet.hrapplication.approvals.controller.reponse.LeaveResponse;
import com.violet.hrapplication.approvals.controller.request.CreateLeaveRequest;
import com.violet.hrapplication.approvals.controller.request.UpdateLeaveRequest;

import java.util.List;

public interface LeaveRequestService {

    List<LeaveRequestResponse> getLeavesByState(State state, PaginationAndFilter paginationAndFilter);

    List<LeaveResponse> getLeaveRequestsForDate();

    List<LeaveRequestResponse> getAllLeaves(PaginationAndFilter paginationAndFilter);

    void create(CreateLeaveRequest createLeaveRequest) throws UserNotFoundException;

    void update(String id, UpdateLeaveRequest createLeaveRequest) throws UserNotFoundException;
}
