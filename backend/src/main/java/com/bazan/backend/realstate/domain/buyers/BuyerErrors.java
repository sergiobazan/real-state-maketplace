package com.bazan.backend.realstate.domain.buyers;

import com.bazan.backend.shared.domain.abstractions.Error;

public class BuyerErrors {
    public static Error notFound = new Error("Buyer.NotFound", "Buyer was not found");
}
