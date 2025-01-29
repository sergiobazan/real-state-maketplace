package com.bazan.backend.transactions.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bazan.backend.transactions.domain.vendors.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, UUID> {

}
