package com.violet.hrapplication.approvals.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public record CreateLeaveTypeRequest(

        @NotBlank
        @Size(min = 2, max = 50)
        String name,

        @NotNull
        @Range(min = 1, max = 50)
        Integer maxDays,

        @NotBlank
        String creator
) {

}
