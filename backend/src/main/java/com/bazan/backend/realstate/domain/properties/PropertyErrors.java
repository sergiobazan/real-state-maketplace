package com.bazan.backend.realstate.domain.properties;

import com.bazan.backend.shared.domain.abstractions.Error;

public class PropertyErrors {
    public static final Error notfound = new Error(
            "Property.NotFound",
            "Property with given Id was not found"
    );

    public static final Error categoryNotfound = new Error(
            "Property.CategoryNotFound",
            "Category with given Id was not found"
    );
}
