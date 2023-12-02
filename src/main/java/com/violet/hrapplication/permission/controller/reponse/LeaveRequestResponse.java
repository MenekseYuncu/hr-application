package com.violet.hrapplication.permission.controller.reponse;

import java.time.LocalDate;

public class LeaveRequestResponse {

    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveTypeId;

    public LeaveRequestResponse(LocalDate startDate, LocalDate endDate, String leaveTypeId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveTypeId = leaveTypeId;
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

    public String getLeaveType() {
        return leaveTypeId;
    }

    public void setLeaveType(String leaveType) {
        this.leaveTypeId = leaveType;
    }
}
