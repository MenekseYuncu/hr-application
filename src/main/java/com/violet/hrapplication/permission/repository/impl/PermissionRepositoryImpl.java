package com.violet.hrapplication.permission.repository.impl;

import com.violet.hrapplication.permission.model.entity.LeaveRequestEntity;
import com.violet.hrapplication.permission.repository.PermissionRepository;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

@Repository
class PermissionRepositoryImpl implements PermissionRepository {

    private final Sql2o sql2o;

    public PermissionRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void save(LeaveRequestEntity leaveRequestEntity) {
        final String sql = "INSERT INTO LEAVE_REQUEST (" +
                "ID, EMPLOYEE_ID, START_DATE, END_DATE, LEAVE_TYPE_ID,STATE,CREATOR, CREATION_TIME) " +
                "VALUES (" +
                ":id, :employeeId, :startDate, :endDate,:leaveTypeId,:state ,:creator, :creationTime)";

        try (Connection con = sql2o.open();
             Query query = con.createQuery(sql)
                     .addParameter("id", leaveRequestEntity.getId())
                     .addParameter("employeeId", leaveRequestEntity.getEmployeeId())
                     .addParameter("startDate", leaveRequestEntity.getStartDate())
                     .addParameter("endDate", leaveRequestEntity.getEndDate())
                     .addParameter("leaveTypeId", leaveRequestEntity.getLeaveTypeId())
                     .addParameter("state", leaveRequestEntity.getState())
                     .addParameter("creator", leaveRequestEntity.getCreator())
                     .addParameter("creationTime", leaveRequestEntity.getCreationTime())) {
            query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


