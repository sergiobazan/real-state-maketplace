package com.bazan.backend.realstate.domain.properties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "properties", schema = "real_state")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;
    private BigDecimal price;
    @Embedded
    private Address address;
    private String measures;
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    private PropertyType type;
    @Enumerated(EnumType.STRING)
    private PropertyStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
