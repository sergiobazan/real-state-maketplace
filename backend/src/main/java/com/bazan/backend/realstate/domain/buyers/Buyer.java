package com.bazan.backend.realstate.domain.buyers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "buyers", schema = "real_state")
public class Buyer {
    @Id
    private UUID id;

    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
}
