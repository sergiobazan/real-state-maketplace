package com.bazan.backend.realstate.application.sellers;

import com.bazan.backend.realstate.application.properties.create.SellerResponse;
import com.bazan.backend.realstate.domain.sellers.Seller;

public class SellerMapper {
    public static SellerResponse fromEntity(Seller seller) {
        return new SellerResponse(
                seller.getId(),
                seller.getName(),
                seller.getEmail()
        );
    }
}
