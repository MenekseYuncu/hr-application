package com.violet.hrapplication.permission.service;

import com.violet.hrapplication.exception.UserNotFoundException;
import com.violet.hrapplication.permission.controller.request.CreateLeaveTypeRequest;

public interface PermissionService {

    void create(CreateLeaveTypeRequest createLeaveTypeRequest) throws UserNotFoundException;

}
