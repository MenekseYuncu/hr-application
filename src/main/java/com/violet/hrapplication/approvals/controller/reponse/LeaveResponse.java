package com.violet.hrapplication.approvals.controller.reponse;

import java.time.LocalDate;

public class LeaveResponse {

    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveTypeId;

    public LeaveResponse(LocalDate startDate, LocalDate endDate, String leaveTypeId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveTypeId = leaveTypeId;
    }
}
