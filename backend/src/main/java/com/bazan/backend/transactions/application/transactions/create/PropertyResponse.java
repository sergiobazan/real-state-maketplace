package com.bazan.backend.transactions.application.transactions.create;

import java.math.BigDecimal;
import java.util.UUID;

public record PropertyResponse(
		UUID id,
		String title,
		BigDecimal price) {

}
