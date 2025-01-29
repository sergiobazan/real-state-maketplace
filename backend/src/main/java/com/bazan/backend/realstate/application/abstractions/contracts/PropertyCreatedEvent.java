package com.bazan.backend.realstate.application.abstractions.contracts;

import java.math.BigDecimal;
import java.util.UUID;

public record PropertyCreatedEvent(UUID id, String title, BigDecimal price, String categoryName, UUID sellerId) {

}
