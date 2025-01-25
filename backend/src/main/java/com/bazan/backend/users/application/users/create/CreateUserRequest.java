package com.bazan.backend.users.application.users.create;

public record CreateUserRequest(
        String name,
        String email,
        String password,
        String role
) {
}
