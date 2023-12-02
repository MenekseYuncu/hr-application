package com.violet.hrapplication.permission.repository.impl;

import com.violet.hrapplication.permission.model.entity.LeaveTypeEntity;
import com.violet.hrapplication.permission.repository.LeaveTypeRepository;
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
        final String sql = "INSERT INTO LEAVE_TYPE (" +
                "ID, NAME, MAX_DAYS, CREATOR, CREATION_TIME) " +
                "VALUES (" +
                ":id, :name, :maxDays, :creator, :creationTime)";

        try (Connection con = sql2o.open();
             Query query = con.createQuery(sql)
                     .addParameter("id", leaveTypeEntity.getId())
                     .addParameter("name", leaveTypeEntity.getName())
                     .addParameter("maxDays", leaveTypeEntity.getMaxDays())
                     .addParameter("creator", leaveTypeEntity.getCreator())
                     .addParameter("creationTime", leaveTypeEntity.getCreationTime())) {
            query.executeUpdate();
        }
    }
}
