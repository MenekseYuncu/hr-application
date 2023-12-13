package com.violet.hrapplication.employee.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.violet.hrapplication.employee.model.enums.Gender;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.EnumSet;

public record UpdateEmployeeRequest(

        @NotBlank
        @Size(min = 2, max = 50)
        String firstName,
        @NotBlank
        @Size(min = 2, max = 50)
        String lastName,
        @Email
        @NotBlank
        String email,
        Gender gender
) {
    @JsonIgnore
    @SuppressWarnings("This method is unused by the application directly but Spring is using it in the background.")
    @AssertTrue(message = "Gender must be 'male' or 'female'")
    private boolean isGenderValid() {
        EnumSet<Gender> acceptableGenders = EnumSet.of(
                Gender.MALE,
                Gender.FEMALE
        );
        return acceptableGenders.contains(this.gender);
    }
}
