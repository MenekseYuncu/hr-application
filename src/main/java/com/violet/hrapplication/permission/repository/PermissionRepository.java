package com.violet.hrapplication.permission.repository;

import com.violet.hrapplication.permission.model.entity.LeaveRequestEntity;

import java.util.Set;

public interface PermissionRepository {

    void save(LeaveRequestEntity leaveRequestEntity);

    Set<LeaveRequestEntity> findAll();

}
