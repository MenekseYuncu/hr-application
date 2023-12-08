package com.violet.hrapplication.employee.controller.request;

import com.violet.hrapplication.employee.model.enums.Gender;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.EnumSet;

public record UpdateEmployeeRequest(

        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @Email
        @NotBlank
        String email,
        Gender gender
) {
    @AssertTrue(message = "Gender must be 'male' or 'female'")
    private boolean isGenderValid() {
        EnumSet<Gender> acceptableGenders = EnumSet.of(
                Gender.MALE,
                Gender.FEMALE
        );
        return acceptableGenders.contains(this.gender);
    }
}
