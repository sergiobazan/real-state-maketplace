package com.bazan.backend.realstate.infrastructure.repositories;

import com.bazan.backend.realstate.domain.properties.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
