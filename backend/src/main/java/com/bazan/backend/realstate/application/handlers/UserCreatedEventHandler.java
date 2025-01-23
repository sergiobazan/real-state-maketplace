package com.bazan.backend.realstate.application.handlers;

import com.bazan.backend.realstate.domain.buyers.Buyer;
import com.bazan.backend.realstate.domain.sellers.Seller;
import com.bazan.backend.realstate.infrastructure.repositories.BuyerRepository;
import com.bazan.backend.realstate.infrastructure.repositories.SellerRepository;
import com.bazan.backend.users.application.abstractions.contracts.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class UserCreatedEventHandler {
    private final SellerRepository sellerRepository;
    private final BuyerRepository buyerRepository;

    @ApplicationModuleListener
    void onUserCreated(UserCreatedEvent event) {
        log.info("Starting user created event {}", event);

        switch (event.role()) {
            case "SELLER" -> createSeller(event);
            case "BUYER" -> createBuyer(event);
            default -> throw new IllegalStateException("Unexpected value: " + event.role());
        }
    }

    private void createBuyer(UserCreatedEvent event) {
        log.info("Creating buyer");
        final Buyer buyer = Buyer.builder()
                .id(event.id())
                .name(event.name())
                .email(event.email())
                .build();

        buyerRepository.save(buyer);
        log.info("Buyer created successfully");
    }

    private void createSeller(UserCreatedEvent event) {
        log.info("Creating seller");
        final Seller seller = Seller.builder()
                .id(event.id())
                .name(event.name())
                .email(event.email())
                .build();

        sellerRepository.save(seller);
        log.info("Seller created successfully");
    }
}
