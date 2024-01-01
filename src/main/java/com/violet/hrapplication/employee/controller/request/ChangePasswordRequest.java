package com.violet.hrapplication.employee.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ChangePasswordRequest(

        @NotBlank
        @Size(min = 8, max = 50)
        String oldPassword,

        @NotBlank
        @Size(min = 8, max = 50)
        String newPassword
) {

}
