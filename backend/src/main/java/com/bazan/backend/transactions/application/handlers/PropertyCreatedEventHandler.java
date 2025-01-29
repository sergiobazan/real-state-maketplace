package com.bazan.backend.transactions.application.handlers;

import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

import com.bazan.backend.realstate.application.abstractions.contracts.PropertyCreatedEvent;
import com.bazan.backend.transactions.domain.listings.Listing;
import com.bazan.backend.transactions.infrastructure.repositories.ListingRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
class PropertyCreatedEventHandler {
	private final ListingRepository listingRepository;
	
	@ApplicationModuleListener
	void handle(PropertyCreatedEvent propertyCreatedEvent) {
		log.info("Starting property created event {}", propertyCreatedEvent);
		
		Listing listing = Listing.builder()
				.id(propertyCreatedEvent.id())
				.title(propertyCreatedEvent.title())
				.price(propertyCreatedEvent.price())
				.categoryName(propertyCreatedEvent.categoryName())
				.vendorId(propertyCreatedEvent.sellerId())
				.build();
		
		listingRepository.save(listing);
	}
}
