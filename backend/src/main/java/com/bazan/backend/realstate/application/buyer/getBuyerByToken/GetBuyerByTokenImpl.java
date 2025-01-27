package com.bazan.backend.realstate.application.buyer.getBuyerByToken;

import com.bazan.backend.realstate.application.buyer.BuyerMapper;
import com.bazan.backend.realstate.domain.buyers.Buyer;
import com.bazan.backend.realstate.domain.buyers.BuyerErrors;
import com.bazan.backend.realstate.infrastructure.repositories.BuyerRepository;
import com.bazan.backend.shared.domain.abstractions.Result;
import com.bazan.backend.shared.infrastructure.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetBuyerByTokenImpl implements GetBuyerByToken {
    private final BuyerRepository buyerRepository;
    private final JwtService jwtService;

    @Override
    public Result<BuyerResponse> getBuyer(String token) {
        token = token.replace("Bearer ", "");
        String email = jwtService.getUserEmailFromToken(token);

        if (email == null) {
            return Result.failure(BuyerErrors.notFound);
        }

        Buyer buyer = buyerRepository.findByEmail(email);

        return Result.success(BuyerMapper.fromEntity(buyer));
    }
}
