package com.violet.hrapplication.permission.repository;

import com.violet.hrapplication.permission.model.entity.LeaveRequestEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PermissionRepository {

    void save(LeaveRequestEntity leaveRequestEntity);

    Optional<LeaveRequestEntity> findById(String id);

    List<LeaveRequestEntity> findByEmployeeId(String id);

    List<LeaveRequestEntity> findAll();

}
