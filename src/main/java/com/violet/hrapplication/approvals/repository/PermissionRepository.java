package com.violet.hrapplication.approvals.repository;

import com.violet.hrapplication.approvals.model.entity.LeaveRequestEntity;

import java.util.List;

public interface PermissionRepository {

    List<LeaveRequestEntity> findAll();

    LeaveRequestEntity findById(String id);

    List<LeaveRequestEntity> findByEmployeeId(String employeeId);

    void save(LeaveRequestEntity leaveRequestEntity);

    void update(LeaveRequestEntity leaveRequestEntity);
}
