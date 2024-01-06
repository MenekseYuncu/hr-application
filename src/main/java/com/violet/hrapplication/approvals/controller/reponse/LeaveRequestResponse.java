package com.violet.hrapplication.approvals.controller.reponse;

import com.violet.hrapplication.approvals.model.enums.State;

import java.time.LocalDate;

public class LeaveRequestResponse {

    public LeaveRequestResponse() {
    }

    private String id;
    private LocalDate startDate;
    private LocalDate endDate;
    private State state;
    private String leaveTypeId;

    public LeaveRequestResponse(String id, LocalDate startDate, LocalDate endDate, State state, String leaveTypeId) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.leaveTypeId = leaveTypeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(String leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

}