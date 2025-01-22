package com.bazan.backend.realstate.infrastructure.repositories;

import com.bazan.backend.realstate.domain.properties.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PropertyRepository extends JpaRepository<Property, UUID> {
}
