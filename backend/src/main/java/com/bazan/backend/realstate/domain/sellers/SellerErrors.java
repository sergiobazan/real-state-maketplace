package com.bazan.backend.realstate.domain.sellers;

import com.bazan.backend.shared.domain.abstractions.Error;

public class SellerErrors {
    public static final Error notFound = new Error(
            "Seller.NotFound",
            "Seller with given Id was not found"
    );
}
