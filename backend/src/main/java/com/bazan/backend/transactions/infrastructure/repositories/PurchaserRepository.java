package com.bazan.backend.transactions.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bazan.backend.transactions.domain.purchasers.Purchaser;

public interface PurchaserRepository extends JpaRepository<Purchaser, UUID> {

}
