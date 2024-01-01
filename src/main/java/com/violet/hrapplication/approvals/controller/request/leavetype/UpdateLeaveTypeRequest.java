package com.violet.hrapplication.approvals.controller.request.leavetype;

import jakarta.validation.constraints.NotBlank;

public record UpdateLeaveTypeRequest(
        @NotBlank
        String name,
        Integer maxDays
) {
}
