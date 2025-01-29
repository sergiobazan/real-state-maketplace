package com.bazan.backend.transactions.domain.purchasers;

import com.bazan.backend.shared.domain.abstractions.Error;

public class PurchaserErrors {
    public static Error notFound = new Error("Purchaser.NotFound", "Buyer was not found");
}
