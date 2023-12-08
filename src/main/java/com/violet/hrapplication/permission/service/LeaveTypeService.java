package com.violet.hrapplication.permission.service;

import com.violet.hrapplication.permission.controller.request.CreateLeaveTypeRequest;
import com.violet.hrapplication.permission.controller.request.UpdateLeaveTypeRequest;

public interface LeaveTypeService {

    void create(CreateLeaveTypeRequest leaveTypeRequest);

    void update(String id, UpdateLeaveTypeRequest leaveTypeRequest);

    void delete(String id);
}
