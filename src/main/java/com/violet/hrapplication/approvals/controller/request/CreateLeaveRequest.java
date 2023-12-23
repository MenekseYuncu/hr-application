package com.violet.hrapplication.approvals.controller.request;

import com.violet.hrapplication.approvals.model.enums.State;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateLeaveRequest(

        @NotEmpty
        String employeeId,
        @NotNull
        @Future
        LocalDate startDate,
        @NotNull
        @Future
        LocalDate endDate,
        @NotEmpty
        String leaveTypeId,
        State state,
        @NotBlank
        @Size(min = 2, max = 50)
        String creator
) {
    public CreateLeaveRequest {
        if (state == null) {
            state = State.APPROVED;
        }
    }
}
