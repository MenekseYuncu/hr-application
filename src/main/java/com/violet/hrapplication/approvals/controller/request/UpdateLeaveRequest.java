package com.violet.hrapplication.approvals.controller.request;

import com.violet.hrapplication.approvals.model.enums.State;
import jakarta.validation.constraints.NotNull;

public record UpdateLeaveRequest(

        String id,
        @NotNull
        State state
) {
}
