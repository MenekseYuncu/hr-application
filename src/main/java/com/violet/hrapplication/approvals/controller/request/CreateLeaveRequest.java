package com.violet.hrapplication.approvals.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.violet.hrapplication.approvals.model.enums.State;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.EnumSet;

public record CreateLeaveRequest(

        @NotEmpty
        String employeeId,
        @NotNull
        @FutureOrPresent
        LocalDate startDate,
        @NotNull
        @FutureOrPresent
        LocalDate endDate,
        @NotEmpty
        String leaveTypeId,
        State state,
        @NotBlank
        @Size(min = 2, max = 50)
        String creator
) {

    @JsonIgnore
    @SuppressWarnings("This method is unused by the application directly but Spring is using it in the background.")
    @AssertTrue(message = "State must be 'pending'")
    private boolean isStateValid() {

        if (this.state == null) {
            return true;
        }

        EnumSet<State> acceptableStates = EnumSet.of(
                State.PENDING
        );
        return acceptableStates.contains(this.state);
    }
}