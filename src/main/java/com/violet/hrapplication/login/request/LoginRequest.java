package com.violet.hrapplication.login.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(

        @NotBlank
        @Size(min = 2, max = 50)
        String username,
        @NotBlank
        @Size(min = 2, max = 100)
        String password
) {
}
