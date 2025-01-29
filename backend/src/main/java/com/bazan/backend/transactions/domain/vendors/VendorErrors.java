package com.bazan.backend.transactions.domain.vendors;

import com.bazan.backend.shared.domain.abstractions.Error;

public class VendorErrors {
    public static final Error notFound = new Error(
            "Vendor.NotFound",
            "Vendor with given Id was not found"
    );
}
