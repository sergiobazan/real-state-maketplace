package com.bazan.backend.realstate.domain.properties;

import jakarta.persistence.Embeddable;

@Embeddable
public record Address(
        String city,
        String street,
        String zipCode
) {
}
