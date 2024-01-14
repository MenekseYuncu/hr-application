package com.violet.hrapplication.approvals.controller.request;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public record PaginationRequest(

        @NotNull
        @Range(min = 1, max = Integer.MAX_VALUE)
        int page,
        @NotNull
        @Range(min = 1, max = Integer.MAX_VALUE)
        int size
) {
}
