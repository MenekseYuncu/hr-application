package com.violet.hrapplication.employee.controller.request;

public record ChangePasswordRequest(
        String username,
        String oldPassword,
        String newPassword
) {

}
