package com.bazan.backend.realstate.infrastructure.repositories;

import com.bazan.backend.realstate.domain.sellers.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SellerRepository extends JpaRepository<Seller, UUID> {
}
