package com.violet.hrapplication.approvals.service;

import com.violet.hrapplication.approvals.controller.request.LeaveRequestPaginationAndFilter;
import com.violet.hrapplication.approvals.model.enums.State;
import com.violet.hrapplication.exception.UserNotFoundException;
import com.violet.hrapplication.approvals.controller.reponse.LeaveRequestResponse;
import com.violet.hrapplication.approvals.controller.reponse.LeaveResponse;
import com.violet.hrapplication.approvals.controller.request.CreateLeaveRequest;
import com.violet.hrapplication.approvals.controller.request.UpdateLeaveRequest;

import java.util.List;

public interface LeaveRequestService {

    List<LeaveRequestResponse> getLeavesByState(State state, LeaveRequestPaginationAndFilter leaveRequestPaginationAndFilter);

    List<LeaveResponse> getLeaveRequestsForDate();

    List<LeaveRequestResponse> getAllLeaves(LeaveRequestPaginationAndFilter leaveRequestPaginationAndFilter);

    void create(CreateLeaveRequest createLeaveRequest) throws UserNotFoundException;

    void update(String id, UpdateLeaveRequest createLeaveRequest) throws UserNotFoundException;
}
