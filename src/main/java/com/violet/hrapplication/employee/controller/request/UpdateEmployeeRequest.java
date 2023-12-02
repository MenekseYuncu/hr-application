package com.violet.hrapplication.employee.controller.request;

import com.violet.hrapplication.employee.model.enums.Gender;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateEmployeeRequest(

        //@NotBlank
        String username,
        String password,
        //@NotBlank
        String firstName,
        //@NotBlank
        String lastName,
       // @Email
        //@NotBlank
        String email,
      //  @Nullable
        Gender gender
) {
    @AssertTrue(message = "Gender must be 'male' or 'female'")
    private boolean isGenderValid() {
        return "male".equalsIgnoreCase(this.gender.name()) || "female".equalsIgnoreCase(this.gender.name());
    }
}
