package com.violet.hrapplication.approvals.model.entity;


import com.violet.hrapplication.approvals.model.enums.State;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeaveRequestEntity {

    private String id;
    private String employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveTypeId;
    private State state;
    private String creator;
    private LocalDateTime creationTime;

    public LeaveRequestEntity(String id, String employeeId, LocalDate startDate, LocalDate endDate, String leaveTypeId, State state, String creator, LocalDateTime creationTime) {
        this.id = id;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveTypeId = leaveTypeId;
        this.state = state;
        this.creator = creator;
        this.creationTime = creationTime;
    }

    public void update(LocalDate startDate,
                       LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
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