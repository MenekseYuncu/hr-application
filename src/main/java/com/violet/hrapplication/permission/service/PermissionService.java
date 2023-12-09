package com.violet.hrapplication.permission.service;

import com.violet.hrapplication.exception.UserNotFoundException;
import com.violet.hrapplication.permission.controller.reponse.LeaveRequestResponse;
import com.violet.hrapplication.permission.controller.reponse.LeaveResponse;
import com.violet.hrapplication.permission.controller.request.CreateLeaveRequest;
import com.violet.hrapplication.permission.controller.request.UpdateLeaveRequest;

import java.util.List;

public interface PermissionService {

    void create(CreateLeaveRequest createLeaveRequest) throws UserNotFoundException;

    void update(String id, UpdateLeaveRequest createLeaveRequest) throws UserNotFoundException;

    List<LeaveResponse> getLeaves(String employeeId);

    List<LeaveRequestResponse> getAllLeaves();
}
