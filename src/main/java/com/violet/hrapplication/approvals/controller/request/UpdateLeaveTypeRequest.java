package com.violet.hrapplication.approvals.controller.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateLeaveTypeRequest(
        @NotBlank
        String name,
        Integer maxDays
) {
}
