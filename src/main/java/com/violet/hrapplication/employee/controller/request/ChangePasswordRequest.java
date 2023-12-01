package com.violet.hrapplication.employee.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ChangePasswordRequest(
        @NotBlank
        String id,
        @NotBlank
        String oldPassword,
        @NotBlank
        @Size(min = 6)
        String newPassword
) {

}
