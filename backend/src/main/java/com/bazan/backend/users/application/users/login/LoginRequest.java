package com.bazan.backend.users.application.users.login;

public record LoginRequest(
        String email,
        String password
) {
}
