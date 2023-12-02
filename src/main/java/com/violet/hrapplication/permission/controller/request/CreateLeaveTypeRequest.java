package com.violet.hrapplication.permission.controller.request;

import jakarta.validation.constraints.NotBlank;

public record CreateLeaveTypeRequest(

        @NotBlank
        String name,
        int maxDays,
        @NotBlank
        String creator
) {

}
