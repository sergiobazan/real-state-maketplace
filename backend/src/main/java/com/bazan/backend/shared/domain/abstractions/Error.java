package com.bazan.backend.shared.domain.abstractions;

public record Error(String code, String message) {
    public static Error NullValue = new Error("Error.NullValue", "Null Value");
}
