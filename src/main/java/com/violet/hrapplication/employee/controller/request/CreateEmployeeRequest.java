package com.violet.hrapplication.employee.controller.request;

import com.violet.hrapplication.employee.model.enums.Gender;
import com.violet.hrapplication.employee.model.enums.Role;

import java.time.LocalDate;

public record CreateEmployeeRequest(
        String firstName,
        String lastName,
        String email,
        LocalDate birthday,
        Role role,
        Gender gender,
        String creator
) {

}
