package com.bazan.backend.transactions.application.transactions.create;

import java.util.UUID;

public record CreateTransactionRequest(
		UUID listingId, 
		UUID vendorId, 
		UUID purchaserId) {

}
