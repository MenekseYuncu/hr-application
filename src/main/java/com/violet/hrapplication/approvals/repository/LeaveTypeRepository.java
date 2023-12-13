package com.violet.hrapplication.approvals.repository;

import com.violet.hrapplication.approvals.model.entity.LeaveTypeEntity;

public interface LeaveTypeRepository {

    LeaveTypeEntity findById(String id);

    void save(LeaveTypeEntity leaveTypeEntity);

    void update(LeaveTypeEntity leaveTypeEntity);

    void delete(String id);
}
