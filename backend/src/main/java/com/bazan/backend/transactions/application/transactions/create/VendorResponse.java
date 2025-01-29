package com.bazan.backend.transactions.application.transactions.create;

import java.util.UUID;

public record VendorResponse(
		UUID id,
		String name,
		String email) {

}
