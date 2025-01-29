package com.bazan.backend.transactions.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bazan.backend.transactions.domain.listings.Listing;

public interface ListingRepository extends JpaRepository<Listing, UUID> {

}
