package com.violet.hrapplication.permission.repository;

import com.violet.hrapplication.permission.model.entity.LeaveTypeEntity;

public interface LeaveTypeRepository {

    void save(LeaveTypeEntity leaveTypeEntity);

    void update(LeaveTypeEntity leaveTypeEntity);

    LeaveTypeEntity findById(String id);

    void delete(String id);
}
