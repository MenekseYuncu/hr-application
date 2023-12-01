package com.violet.hrapplication.employee.controller.request;

import com.violet.hrapplication.employee.model.enums.Gender;
import com.violet.hrapplication.employee.model.enums.Role;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record CreateEmployeeRequest(
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @Email
        @NotBlank
        String email,
        @Past
        LocalDate birthday,
        Role role,
        Gender gender,
        @NotBlank
        String creator
) {
    @AssertTrue(message = "Role must be 'employee'")
    private boolean isEmployeeRoleValid() {
        return "EMPLOYEE".equalsIgnoreCase(this.role.name());
    }

    @AssertTrue(message = "Gender must be 'male' or 'female'")
    private boolean isGenderValid() {
        return "male".equalsIgnoreCase(this.gender.name()) || "female".equalsIgnoreCase(this.gender.name());
    }
}
