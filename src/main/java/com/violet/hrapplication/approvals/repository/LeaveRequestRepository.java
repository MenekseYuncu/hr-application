package com.violet.hrapplication.approvals.repository;

import com.violet.hrapplication.approvals.model.entity.LeaveRequestEntity;
import com.violet.hrapplication.approvals.model.enums.State;

import java.time.LocalDate;
import java.util.List;

public interface LeaveRequestRepository {

    List<LeaveRequestEntity> findAll(Integer page, Integer size);

    LeaveRequestEntity findById(String id);

    List<LeaveRequestEntity> findByEmployeeId(String employeeId, Integer page, Integer size);

    List<LeaveRequestEntity> findByState(State state);

    List<LeaveRequestEntity> findByStateAndDate(LocalDate date);
    void save(LeaveRequestEntity leaveRequestEntity);

    void update(LeaveRequestEntity leaveRequestEntity);

    Boolean isExistByDate(String employeeId, LocalDate startDate, LocalDate endDate);
}
