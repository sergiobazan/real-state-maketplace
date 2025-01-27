package com.bazan.backend.realstate.application.buyer;

import com.bazan.backend.realstate.application.buyer.getBuyerByToken.BuyerResponse;
import com.bazan.backend.realstate.domain.buyers.Buyer;

public class BuyerMapper {
    public static BuyerResponse fromEntity(Buyer buyer) {
        return new BuyerResponse(
                buyer.getId(),
                buyer.getName(),
                buyer.getEmail()
        );
    }
}
