package com.violet.hrapplication.approvals.controller.reponse;

import java.time.LocalDate;

public class LeaveRequestResponse {

    public LeaveRequestResponse() {
    }

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

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getLeaveTypeId() {
        return leaveTypeId;
    }

    @Override
    public String toString() {
        return "LeaveRequestResponse{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", leaveTypeId='" + leaveTypeId + '\'' +
                '}';
    }
}
