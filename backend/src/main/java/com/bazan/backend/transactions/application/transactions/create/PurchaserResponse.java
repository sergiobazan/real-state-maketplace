package com.bazan.backend.transactions.application.transactions.create;

import java.util.UUID;

public record PurchaserResponse(
		UUID id,
		String name,
		String email) {

}
