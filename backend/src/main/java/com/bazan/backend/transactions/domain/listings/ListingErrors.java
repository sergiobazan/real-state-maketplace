package com.bazan.backend.transactions.domain.listings;

import com.bazan.backend.shared.domain.abstractions.Error;

public class ListingErrors {
    public static final Error notfound = new Error(
            "Listing.NotFound",
            "Listing with given Id was not found"
    );

    public static final Error categoryNotfound = new Error(
            "Listing.CategoryNotFound",
            "Category with given Id was not found"
    );
}
