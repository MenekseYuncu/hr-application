package com.violet.hrapplication.approvals.repository.impl;

import com.violet.hrapplication.approvals.model.entity.LeaveRequestEntity;
import com.violet.hrapplication.approvals.model.enums.State;
import com.violet.hrapplication.approvals.repository.LeaveRequestRepository;
import com.violet.hrapplication.approvals.repository.mapping.LeaveRequestMapping;
import com.violet.hrapplication.approvals.repository.script.LeaveRequestScripts;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Repository
class LeaveRequestRepositoryImpl implements LeaveRequestRepository {

    private final Sql2o sql2o;

    public LeaveRequestRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<LeaveRequestEntity> findAll(Integer page, Integer size) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveRequestScripts.FIND_ALL)) {
            List<LeaveRequestEntity> result = query
                    .addParameter("limit", size)
                    .addParameter("offset", page )
                    .setColumnMappings(LeaveRequestMapping.COLUMN_MAPPING)
                    .executeAndFetch(LeaveRequestEntity.class);
            return Objects.requireNonNullElse(result, Collections.emptyList());
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
    public List<LeaveRequestEntity> findByEmployeeId(String employeeId, Integer page, Integer size) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveRequestScripts.FIND_BY_EMPLOYEE_ID)) {
            return query
                    .addParameter(LeaveRequestMapping.EMPLOYEE_ID.getPropertyName(), employeeId)
                    .addParameter("limit", size)
                    .addParameter("offset", page)
                    .setColumnMappings(LeaveRequestMapping.COLUMN_MAPPING)
                    .executeAndFetch(LeaveRequestEntity.class);
        }
    }

    @Override
    public List<LeaveRequestEntity> findByState(State state) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveRequestScripts.FIND_BY_STATE)) {
            return query
                    .addParameter(LeaveRequestMapping.STATE.getPropertyName(), state)
                    .setColumnMappings(LeaveRequestMapping.COLUMN_MAPPING)
                    .executeAndFetch(LeaveRequestEntity.class);

        }
    }

    @Override
    public List<LeaveRequestEntity> findByStateAndDate(LocalDate date) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveRequestScripts.FIND_BY_DATE)) {
            return query
                    .addParameter("date", date)
                    .setColumnMappings(LeaveRequestMapping.COLUMN_MAPPING)
                    .executeAndFetch(LeaveRequestEntity.class);
        }
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
                    .addParameter(LeaveRequestMapping.STATE.getPropertyName(), leaveRequestEntity.getState())
                    .executeUpdate();
        }
    }

    @Override
    public Boolean isExistByDate(String employeeId, LocalDate startDate, LocalDate endDate) {
        try (Connection con = sql2o.open(); Query query = con.createQuery(LeaveRequestScripts.IS_EXIST_BY_DATE)) {
            return query
                    .addParameter(LeaveRequestMapping.EMPLOYEE_ID.getPropertyName(), employeeId)
                    .addParameter(LeaveRequestMapping.START_DATE.getPropertyName(), startDate)
                    .addParameter(LeaveRequestMapping.END_DATE.getPropertyName(), endDate)
                    .executeScalar(Boolean.class);
        }
    }
}


