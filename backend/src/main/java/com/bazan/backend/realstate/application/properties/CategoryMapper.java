package com.bazan.backend.realstate.application.properties;

import com.bazan.backend.realstate.application.properties.create.CategoryResponse;
import com.bazan.backend.realstate.domain.properties.Category;

public class CategoryMapper {
    public static CategoryResponse fromEntity(final Category category) {
        return new CategoryResponse(category.getId(), category.getName(), category.getDescription());
    }
}
