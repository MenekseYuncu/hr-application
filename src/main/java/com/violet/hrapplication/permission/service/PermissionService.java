package com.violet.hrapplication.permission.service;

import com.violet.hrapplication.exception.UserNotFoundException;
import com.violet.hrapplication.permission.controller.reponse.LeaveRequestResponse;
import com.violet.hrapplication.permission.controller.request.CreateLeaveRequest;

import java.util.List;

public interface PermissionService {

    void create(CreateLeaveRequest createLeaveRequest) throws UserNotFoundException;

    List<LeaveRequestResponse> getAllLeaves();
}
