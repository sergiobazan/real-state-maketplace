package com.bazan.backend.users.infrastructure.repositories;

import com.bazan.backend.users.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
