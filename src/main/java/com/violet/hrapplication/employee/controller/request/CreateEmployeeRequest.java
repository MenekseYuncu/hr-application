package com.violet.hrapplication.employee.controller.request;

import com.violet.hrapplication.employee.model.enums.Gender;
import com.violet.hrapplication.employee.model.enums.Role;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.EnumSet;

public record CreateEmployeeRequest(
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @Email
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
        EnumSet<Role> acceptableRoles = EnumSet.of(
                Role.EMPLOYEE
        );
        return acceptableRoles.contains(this.role);
    }

    @AssertTrue(message = "Gender must be 'male' or 'female'")
    private boolean isGenderValid() {
        EnumSet<Gender> acceptableGenders = EnumSet.of(
                Gender.MALE,
                Gender.FEMALE
        );
        return acceptableGenders.contains(this.gender);
    }
}
