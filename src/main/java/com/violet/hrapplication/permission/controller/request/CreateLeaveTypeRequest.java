package com.violet.hrapplication.permission.controller.request;

import com.violet.hrapplication.employee.model.enums.Gender;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;

public record CreateLeaveTypeRequest(

        //String id,
        @NotBlank
        String name,
        int maxDays,
        Gender gender,
        @NotBlank
        String creator
) {
        @AssertTrue(message = "Gender must be 'male' or 'female'")
        private boolean isGenderValid() {
                return "male".equalsIgnoreCase(this.gender.name()) || "female".equalsIgnoreCase(this.gender.name());
        }
}
