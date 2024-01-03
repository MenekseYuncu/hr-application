package com.violet.hrapplication.approvals.controller.request;

public record PaginationRequest(
        Integer page,
        Integer size
) {
}
