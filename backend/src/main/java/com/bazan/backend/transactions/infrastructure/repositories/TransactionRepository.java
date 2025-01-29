package com.bazan.backend.transactions.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bazan.backend.transactions.domain.transactions.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

}
