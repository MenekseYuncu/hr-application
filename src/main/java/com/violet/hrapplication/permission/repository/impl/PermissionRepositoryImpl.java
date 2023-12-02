package com.violet.hrapplication.permission.repository.impl;

import com.violet.hrapplication.permission.model.entity.LeaveRequestEntity;
import com.violet.hrapplication.permission.model.mapandscript.LeaveRequestMapping;
import com.violet.hrapplication.permission.model.mapandscript.LeaveRequestScripts;
import com.violet.hrapplication.permission.repository.PermissionRepository;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
class PermissionRepositoryImpl implements PermissionRepository {

    private final Sql2o sql2o;

    public PermissionRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void save(LeaveRequestEntity leaveRequestEntity) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveRequestScripts.SAVE)
                .addParameter(LeaveRequestMapping.ID.getPropertyName(), leaveRequestEntity.getId())
                .addParameter(LeaveRequestMapping.EMPLOYEE_ID.getPropertyName(), leaveRequestEntity.getEmployeeId())
                .addParameter(LeaveRequestMapping.START_DATE.getPropertyName(), leaveRequestEntity.getStartDate())
                .addParameter(LeaveRequestMapping.END_DATE.getPropertyName(), leaveRequestEntity.getEndDate())
                .addParameter(LeaveRequestMapping.LEAVE_TYPE_ID.getPropertyName(), leaveRequestEntity.getLeaveTypeId())
                .addParameter(LeaveRequestMapping.STATE.getPropertyName(), leaveRequestEntity.getState())
                .addParameter(LeaveRequestMapping.CREATOR.getPropertyName(), leaveRequestEntity.getCreator())
                .addParameter(LeaveRequestMapping.CREATION_TIME.getPropertyName(), leaveRequestEntity.getCreationTime())) {
            query.executeUpdate();
        }
    }

    @Override
    public Optional<LeaveRequestEntity> findById(String id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveRequestScripts.FIND_BY_ID)
                .addParameter(LeaveRequestMapping.ID.getPropertyName(), id)
                .setColumnMappings(LeaveRequestMapping.getMapping())) {

            return Optional.ofNullable(query.executeAndFetchFirst(LeaveRequestEntity.class));
        }
    }

    @Override
    public List<LeaveRequestEntity> findByEmployeeId(String id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveRequestScripts.FIND_BY_EMPLOYEE_ID)){
            return query
                    .addParameter(LeaveRequestMapping.ID.getPropertyName(), id)
                    .setColumnMappings(LeaveRequestMapping.getMapping())
                    .executeAndFetch(LeaveRequestEntity.class);
        }
    }


    @Override
    public List<LeaveRequestEntity> findAll() {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveRequestScripts.FIND_ALL)){
            return query
                    .setColumnMappings(LeaveRequestMapping.getMapping())
                    .executeAndFetch(LeaveRequestEntity.class);
        }
    }


}


