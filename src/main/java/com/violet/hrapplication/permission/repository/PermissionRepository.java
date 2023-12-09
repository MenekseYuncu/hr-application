package com.violet.hrapplication.permission.repository;

import com.violet.hrapplication.permission.model.entity.LeaveRequestEntity;

import java.util.List;

public interface PermissionRepository {

    void save(LeaveRequestEntity leaveRequestEntity);

    void update(LeaveRequestEntity leaveRequestEntity);

    LeaveRequestEntity findById(String id);

    List<LeaveRequestEntity> findByEmployeeId(String employeeId);

    List<LeaveRequestEntity> findAll();
}
