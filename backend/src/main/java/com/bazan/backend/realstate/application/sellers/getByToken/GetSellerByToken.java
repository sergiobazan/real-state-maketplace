package com.bazan.backend.realstate.application.sellers.getByToken;

import com.bazan.backend.realstate.application.properties.create.SellerResponse;
import com.bazan.backend.shared.domain.abstractions.Result;

public interface GetSellerByToken {
    Result<SellerResponse> getByToken(String token);
}
