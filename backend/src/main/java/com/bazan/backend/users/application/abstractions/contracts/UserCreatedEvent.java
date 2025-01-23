package com.bazan.backend.users.application.abstractions.contracts;

import java.util.UUID;

public record UserCreatedEvent(UUID id, String name, String email, String role) {
}
