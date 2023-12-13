package com.violet.hrapplication.employee.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.violet.hrapplication.employee.model.enums.Gender;
import com.violet.hrapplication.employee.model.enums.Role;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.EnumSet;

public record CreateEmployeeRequest(

        @NotBlank
        @Size(min = 2, max = 100)
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

    @JsonIgnore
    @AssertTrue(message = "Role must be 'employee'")
    @SuppressWarnings("This method is unused by the application directly but Spring is using it in the background.")
    private boolean isEmployeeRoleValid() {

        if (this.role == null) {
            return true;
        }

        EnumSet<Role> acceptableRoles = EnumSet.of(
                Role.EMPLOYEE
        );
        return acceptableRoles.contains(this.role);
    }

    @JsonIgnore
    @SuppressWarnings("This method is unused by the application directly but Spring is using it in the background.")
    @AssertTrue(message = "Gender must be 'male' or 'female'")
    private boolean isGenderValid() {
        if (this.gender == null) {
            return true;
        }

        EnumSet<Gender> acceptableGenders = EnumSet.of(
                Gender.MALE,
                Gender.FEMALE
        );
        return acceptableGenders.contains(this.gender);
    }
}
