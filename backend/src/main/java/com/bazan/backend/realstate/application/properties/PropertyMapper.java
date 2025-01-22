package com.bazan.backend.realstate.application.properties;

import com.bazan.backend.realstate.application.properties.create.CategoryResponse;
import com.bazan.backend.realstate.application.properties.create.CreatePropertyResponse;
import com.bazan.backend.realstate.application.properties.create.SellerResponse;
import com.bazan.backend.realstate.domain.properties.Property;

public class PropertyMapper {
    public static CreatePropertyResponse fromEntity(final Property property) {
        return new CreatePropertyResponse(
                property.getId(),
                property.getTitle(),
                property.getDescription(),
                property.getPrice(),
                property.getAddress(),
                property.getMeasures(),
                property.getImageUrl(),
                property.getType(),
                property.getStatus(),
                new CategoryResponse(
                        property.getCategory().getId(),
                        property.getCategory().getName(),
                        property.getCategory().getDescription()
                ),
                new SellerResponse(
                        property.getSeller().getId(),
                        property.getSeller().getName(),
                        property.getSeller().getEmail()
                )
        );
    }
}
