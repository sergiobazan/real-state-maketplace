package com.bazan.backend.realstate.application.buyer.getBuyerByToken;

import com.bazan.backend.shared.domain.abstractions.Result;

public interface GetBuyerByToken {
    Result<BuyerResponse> getBuyer(String token);
}
