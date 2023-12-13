package com.violet.hrapplication.approvals.service;

import com.violet.hrapplication.approvals.controller.request.CreateLeaveTypeRequest;
import com.violet.hrapplication.approvals.controller.request.UpdateLeaveTypeRequest;

public interface LeaveTypeService {

    void create(CreateLeaveTypeRequest leaveTypeRequest);

    void update(String id, UpdateLeaveTypeRequest leaveTypeRequest);

    void delete(String id);
}
