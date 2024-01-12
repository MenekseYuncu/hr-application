package com.violet.hrapplication.approvals.controller.request;

import jakarta.validation.constraints.NotNull;

public record PaginationRequest(


        Integer page,

        Integer size
) {
}
