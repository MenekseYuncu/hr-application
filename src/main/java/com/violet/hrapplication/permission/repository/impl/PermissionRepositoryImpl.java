package com.violet.hrapplication.permission.repository.impl;

import com.violet.hrapplication.permission.model.entity.LeaveRequestEntity;
import com.violet.hrapplication.permission.repository.PermissionRepository;
import com.violet.hrapplication.permission.repository.mapping.LeaveRequestMapping;
import com.violet.hrapplication.permission.repository.script.LeaveRequestScripts;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Repository
class PermissionRepositoryImpl implements PermissionRepository {

    private final Sql2o sql2o;

    public PermissionRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void save(LeaveRequestEntity leaveRequestEntity) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveRequestScripts.SAVE)) {
            query
                    .addParameter(LeaveRequestMapping.ID.getPropertyName(), leaveRequestEntity.getId())
                    .addParameter(LeaveRequestMapping.EMPLOYEE_ID.getPropertyName(), leaveRequestEntity.getEmployeeId())
                    .addParameter(LeaveRequestMapping.START_DATE.getPropertyName(), leaveRequestEntity.getStartDate())
                    .addParameter(LeaveRequestMapping.END_DATE.getPropertyName(), leaveRequestEntity.getEndDate())
                    .addParameter(LeaveRequestMapping.LEAVE_TYPE_ID.getPropertyName(), leaveRequestEntity.getLeaveTypeId())
                    .addParameter(LeaveRequestMapping.STATE.getPropertyName(), leaveRequestEntity.getState())
                    .addParameter(LeaveRequestMapping.CREATOR.getPropertyName(), leaveRequestEntity.getCreator())
                    .addParameter(LeaveRequestMapping.CREATION_TIME.getPropertyName(), leaveRequestEntity.getCreationTime())
                    .executeUpdate();
        }
    }

    @Override
    public void update(LeaveRequestEntity leaveRequestEntity) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveRequestScripts.UPDATE)) {
            query
                    .addParameter(LeaveRequestMapping.ID.getPropertyName(), leaveRequestEntity.getId())
                    .addParameter(LeaveRequestMapping.START_DATE.getPropertyName(), leaveRequestEntity.getStartDate())
                    .addParameter(LeaveRequestMapping.END_DATE.getPropertyName(), leaveRequestEntity.getEndDate())
                    .executeUpdate();
        }
    }

    @Override
    public LeaveRequestEntity findById(String id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveRequestScripts.FIND_BY_ID)) {
            return query
                    .addParameter(LeaveRequestMapping.ID.getPropertyName(), id)
                    .setColumnMappings(LeaveRequestMapping.COLUMN_MAPPING)
                    .executeAndFetchFirst(LeaveRequestEntity.class);
        }
    }

    @Override
    public List<LeaveRequestEntity> findByEmployeeId(String employeeId) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveRequestScripts.FIND_BY_EMPLOYEE_ID)) {
            return query
                    .addParameter(LeaveRequestMapping.EMPLOYEE_ID.getPropertyName(), employeeId)
                    .setColumnMappings(LeaveRequestMapping.COLUMN_MAPPING)
                    .executeAndFetch(LeaveRequestEntity.class);
        }
    }

    @Override
    public List<LeaveRequestEntity> findAll() {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveRequestScripts.FIND_ALL)) {
            List<LeaveRequestEntity> result = query
                    .setColumnMappings(LeaveRequestMapping.COLUMN_MAPPING)
                    .executeAndFetch(LeaveRequestEntity.class);
            return Objects.requireNonNullElse(result, Collections.emptyList());
        }
    }
}


