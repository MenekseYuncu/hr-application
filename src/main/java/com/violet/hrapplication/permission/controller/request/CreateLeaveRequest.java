package com.violet.hrapplication.permission.controller.request;

import java.time.LocalDate;

public record CreateLeaveRequest (

        String id,
        String employeeId,
        LocalDate startDate,
        LocalDate endDate,
        String leaveTypeId,
        boolean approved,
        String creator
){

}
