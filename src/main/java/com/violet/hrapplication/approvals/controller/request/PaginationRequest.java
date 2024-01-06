package com.violet.hrapplication.approvals.controller.request;

import jakarta.validation.constraints.NotNull;

public record PaginationRequest(

        @NotNull
        Integer page,
        @NotNull
        Integer size
) {
}
