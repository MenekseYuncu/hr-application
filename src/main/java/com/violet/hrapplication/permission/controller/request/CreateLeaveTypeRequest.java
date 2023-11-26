package com.violet.hrapplication.permission.controller.request;

import com.violet.hrapplication.employee.model.enums.Gender;

public record CreateLeaveTypeRequest(

        String id,
        String name,
        int maxDays,
        Gender gender,
        String creator
) {

}
