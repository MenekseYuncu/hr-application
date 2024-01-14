package com.violet.hrapplication.approvals.controller.request;

import com.violet.hrapplication.approvals.model.enums.State;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UUID;

import java.util.HashMap;
import java.util.Map;

public class PaginationAndFilter {

    @Valid
    @NotNull
    private PaginationRequest pagination;
    private final Filter filter;

    public static class Filter {
        State state;
        @UUID
        private String employeeId;

        public State getState() {
            return state;
        }

        public String getEmployeeId() {
            return employeeId;
        }
    }

    public Map<String, Object> filterToMap() {

        Map<String, Object> filterMap = new HashMap<>();

        if (this.filter == null) {
            return filterMap;
        }
        if (this.filter.state != null) {
            filterMap.put("state", this.filter.state);
        }
        if (this.filter.employeeId != null) {
            filterMap.put("employeeId", this.filter.employeeId);
        }
        return filterMap;
    }

    public PaginationAndFilter(PaginationRequest pagination, Filter filter) {
        this.pagination = pagination;
        this.filter = filter;
    }

    public Filter getFilter() {
        return filter;
    }

    public PaginationRequest getPaginationRequest() {
        return pagination;
    }
}
