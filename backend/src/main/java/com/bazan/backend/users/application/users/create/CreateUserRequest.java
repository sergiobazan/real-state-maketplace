package com.bazan.backend.users.application.users.create;

public record CreateUserRequest(
        String username,
        String email,
        String password,
        String role
) {
}
