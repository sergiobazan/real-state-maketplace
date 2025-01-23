package com.bazan.backend.realstate.domain.sellers;

import com.bazan.backend.realstate.domain.properties.Property;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "sellers", schema = "real_state")
public class Seller {
    @Id
    private UUID id;

    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    private String address;
    private String description;
    private int numberOfPropertiesSold;

    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Property> properties = new ArrayList<>();
}
