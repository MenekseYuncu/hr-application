package com.violet.hrapplication.permission.repository;

import com.violet.hrapplication.permission.model.entity.LeaveRequestEntity;

public interface PermissionRepository {

    void save(LeaveRequestEntity leaveRequestEntity);
}
