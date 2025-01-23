package com.bazan.backend.users.infrastructure.repositories;

import com.bazan.backend.users.domain.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(String name);

    @Query("SELECT r FROM Role r where r.name = 'USER'")
    Role defaultRole();
}
