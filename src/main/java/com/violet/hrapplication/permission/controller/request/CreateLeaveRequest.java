package com.violet.hrapplication.permission.controller.request;

import com.violet.hrapplication.permission.model.enums.State;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateLeaveRequest(

        @NotEmpty
        String employeeId,
        @NotNull
        LocalDate startDate,
        @NotNull
        LocalDate endDate,
        @NotEmpty
        String leaveTypeId,
        State state,
        @NotBlank
        String creator
) {
    public CreateLeaveRequest {
        if (state == null) {
            state = State.APPROVED;
        }
    }
}
