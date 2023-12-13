package com.violet.hrapplication.approvals.controller.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateLeaveRequest(

        @NotNull
        @FutureOrPresent
        LocalDate startDate,
        @NotNull
        @FutureOrPresent
        LocalDate endDate
) {
}
