package com.bazan.backend.realstate.application.sellers.getByToken;

import com.bazan.backend.realstate.application.properties.create.SellerResponse;
import com.bazan.backend.realstate.application.sellers.SellerMapper;
import com.bazan.backend.realstate.domain.sellers.Seller;
import com.bazan.backend.realstate.domain.sellers.SellerErrors;
import com.bazan.backend.realstate.infrastructure.repositories.SellerRepository;
import com.bazan.backend.shared.domain.abstractions.Result;
import com.bazan.backend.shared.infrastructure.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetSellerByTokenImpl implements GetSellerByToken {
    private final SellerRepository sellerRepository;
    private final JwtService jwtService;

    @Override
    public Result<SellerResponse> getByToken(String token) {
        token = token.replace("Bearer ", "");

        String email = jwtService.getUserEmailFromToken(token);

        if (email == null) {
            Result.failure(SellerErrors.notFound);
        }
        Seller seller = sellerRepository.findByEmail(email);

        return Result.success(SellerMapper.fromEntity(seller));
    }
}
