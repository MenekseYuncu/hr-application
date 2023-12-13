package com.violet.hrapplication.approvals.controller.reponse;

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
}
