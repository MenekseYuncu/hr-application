package com.violet.hrapplication.login.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginRequest(

        @NotBlank
        String username,
        @NotNull
        String password
) {
}
