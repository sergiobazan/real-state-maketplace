package com.bazan.backend.realstate.application.properties.create;

import com.bazan.backend.realstate.domain.properties.Address;
import com.bazan.backend.realstate.domain.properties.PropertyStatus;
import com.bazan.backend.realstate.domain.properties.PropertyType;

import java.math.BigDecimal;
import java.util.UUID;

public record CreatePropertyResponse(
        UUID id,
        String title,
        String description,
        BigDecimal price,
        Address address,
        String measures,
        String imageUrl,
        PropertyType type,
        PropertyStatus status,
        CategoryResponse category,
        SellerResponse seller
) {
}

record CategoryResponse(UUID id, String name, String description) {}
record SellerResponse(UUID id, String name, String email) {}