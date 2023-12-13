package com.violet.hrapplication.approvals.model.domain;

import com.violet.hrapplication.approvals.model.entity.LeaveRequestEntity;
import com.violet.hrapplication.approvals.model.enums.State;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeaveRequest {

    private String id;
    private String employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveTypeId;
    private State state;
    private String creator;
    private LocalDateTime creationTime;

    public LeaveRequestEntity toLeaveRequest() {
        return new LeaveRequestEntity(
                id,
                employeeId,
                startDate,
                endDate,
                leaveTypeId,
                state,
                creator,
                creationTime
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(String leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
}
