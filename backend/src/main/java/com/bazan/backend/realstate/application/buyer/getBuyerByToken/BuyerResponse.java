package com.bazan.backend.realstate.application.buyer.getBuyerByToken;

import java.util.UUID;

public record BuyerResponse(UUID id, String name, String email) {
}
