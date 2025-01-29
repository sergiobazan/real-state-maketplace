package com.bazan.backend.transactions.application.handlers;

import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

import com.bazan.backend.transactions.domain.purchasers.Purchaser;
import com.bazan.backend.transactions.domain.vendors.Vendor;
import com.bazan.backend.transactions.infrastructure.repositories.PurchaserRepository;
import com.bazan.backend.transactions.infrastructure.repositories.VendorRepository;
import com.bazan.backend.users.application.abstractions.contracts.UserCreatedEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
class UsersCreatedEventHandler {
	private final VendorRepository vendorRepository;
	private final PurchaserRepository purchaserRepository;

	
	@ApplicationModuleListener
	void handle(UserCreatedEvent userCreatedEvent) throws Exception {
		log.info("Starting user created event {}", userCreatedEvent);
		
		switch(userCreatedEvent.role()) {
			case "BUYER" -> createPurchaser(userCreatedEvent);
			case "SELLER" -> createVendor(userCreatedEvent);
			default -> throw new Exception("Role no found");
		}
		
	}

	private void createVendor(UserCreatedEvent userCreatedEvent) {
		log.info("Creating Vendor {} ", userCreatedEvent);
		Vendor vendor = Vendor
				.builder()
				.id(userCreatedEvent.id())
				.name(userCreatedEvent.name())
				.email(userCreatedEvent.email())
				.build();
		vendorRepository.save(vendor);
		log.info("Vendor created successfully");
	}


	private void createPurchaser(UserCreatedEvent userCreatedEvent) {
		log.info("Creating Purchaser {} ", userCreatedEvent);
		Purchaser purchaser = Purchaser
				.builder()
				.id(userCreatedEvent.id())
				.name(userCreatedEvent.name())
				.email(userCreatedEvent.email())
				.build();
		purchaserRepository.save(purchaser);
		log.info("Purchaser created successfully");
	}
}
