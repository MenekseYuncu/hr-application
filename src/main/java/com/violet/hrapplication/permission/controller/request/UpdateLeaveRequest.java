package com.violet.hrapplication.permission.controller.request;

import java.time.LocalDate;

public record UpdateLeaveRequest(

        LocalDate startDate,
        LocalDate endDate
) {
}
