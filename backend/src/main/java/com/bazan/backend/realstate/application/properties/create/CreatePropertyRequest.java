package com.bazan.backend.realstate.application.properties.create;

import com.bazan.backend.realstate.domain.properties.PropertyStatus;
import com.bazan.backend.realstate.domain.properties.PropertyType;

import java.math.BigDecimal;
import java.util.UUID;

public record CreatePropertyRequest(
        String title,
        String description,
        BigDecimal price,
        String city,
        String street,
        String zipCode,
        String measures,
        PropertyType type,
        PropertyStatus status,
        UUID categoryId,
        UUID sellerId
) {
}