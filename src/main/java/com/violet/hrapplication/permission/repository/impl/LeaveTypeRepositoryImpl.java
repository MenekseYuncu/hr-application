package com.violet.hrapplication.permission.repository.impl;

import com.violet.hrapplication.permission.model.entity.LeaveTypeEntity;
import com.violet.hrapplication.permission.repository.LeaveTypeRepository;
import com.violet.hrapplication.permission.repository.mapping.LeaveTypeMapping;
import com.violet.hrapplication.permission.repository.script.LeaveTypeScripts;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

@Repository
class LeaveTypeRepositoryImpl implements LeaveTypeRepository {

    private final Sql2o sql2o;

    public LeaveTypeRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void save(LeaveTypeEntity leaveTypeEntity) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveTypeScripts.SAVE)) {
            query
                    .addParameter(LeaveTypeMapping.ID.getPropertyName(), leaveTypeEntity.getId())
                    .addParameter(LeaveTypeMapping.NAME.getPropertyName(), leaveTypeEntity.getName())
                    .addParameter(LeaveTypeMapping.MAX_DAYS.getPropertyName(), leaveTypeEntity.getMaxDays())
                    .addParameter(LeaveTypeMapping.CREATOR.getPropertyName(), leaveTypeEntity.getCreator())
                    .addParameter(LeaveTypeMapping.CREATION_TIME.getPropertyName(), leaveTypeEntity.getCreationTime())
                    .executeUpdate();
        }
    }

    @Override
    public void update(LeaveTypeEntity leaveTypeEntity) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveTypeScripts.UPDATE)) {
            query
                    .addParameter(LeaveTypeMapping.ID.getPropertyName(), leaveTypeEntity.getId())
                    .addParameter(LeaveTypeMapping.NAME.getPropertyName(), leaveTypeEntity.getName())
                    .addParameter(LeaveTypeMapping.MAX_DAYS.getPropertyName(), leaveTypeEntity.getMaxDays())
                    .executeUpdate();
        }
    }

    @Override
    public LeaveTypeEntity findById(String id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveTypeScripts.FIND_BY_ID)) {
            return query
                    .addParameter(LeaveTypeMapping.ID.getPropertyName(), id)
                    .setColumnMappings(LeaveTypeMapping.COLUMN_MAPPING)
                    .executeAndFetchFirst(LeaveTypeEntity.class);
        }
    }

    @Override
    public void delete(String id) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveTypeScripts.DELETE)) {
            query
                    .addParameter(LeaveTypeMapping.ID.getPropertyName(), id)
                    .executeUpdate();
        }
    }
}
