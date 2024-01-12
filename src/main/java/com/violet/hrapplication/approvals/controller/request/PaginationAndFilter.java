package com.violet.hrapplication.approvals.controller.request;

import com.violet.hrapplication.approvals.model.enums.State;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class PaginationAndFilter {

    @Valid
    @NotNull(message = "paginationRequest must not be null")
    private PaginationRequest paginationRequest;

    private final FilterState filterState;

    public static class FilterState {
        State state;

        public State getState() {
            return state;
        }
    }

    public PaginationAndFilter(PaginationRequest paginationRequest, FilterState filterState) {
        this.paginationRequest = paginationRequest;
        this.filterState = filterState;
    }


    public PaginationRequest getPaginationRequest() {
        return paginationRequest;
    }

    public FilterState getFilterState() {
        return filterState;
    }
}
