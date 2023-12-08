package com.violet.hrapplication.permission.controller.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateLeaveTypeRequest(
        @NotBlank
        String name,
        int maxDays
) {
}
