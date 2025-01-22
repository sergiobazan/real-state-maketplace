package com.bazan.backend.realstate.infrastructure.repositories;

import com.bazan.backend.realstate.domain.buyers.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BuyerRepository extends JpaRepository<Buyer, UUID> {
}
