package com.bazan.backend.users.application.users.create;

import java.util.UUID;

public record CreateUserResponse(
        UUID id,
        String username,
        String email
) {
}
