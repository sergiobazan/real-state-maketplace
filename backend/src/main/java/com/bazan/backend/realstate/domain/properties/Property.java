package com.bazan.backend.realstate.domain.properties;

import com.bazan.backend.realstate.domain.sellers.Seller;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    private Property(String title,
                     String description,
                     BigDecimal price,
                     Address address,
                     String measures,
                     String imageUrl,
                     PropertyType type,
                     PropertyStatus status,
                     Category category,
                     Seller seller) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.address = address;
        this.measures = measures;
        this.imageUrl = imageUrl;
        this.type = type;
        this.status = status;
        this.category = category;
        this.seller = seller;
    }

    public static Property create(String title,
                                  String description,
                                  BigDecimal price,
                                  Address address,
                                  String measures,
                                  String imageUrl,
                                  PropertyType type,
                                  PropertyStatus status,
                                  Category category,
                                  Seller seller) {
        return new Property(title, description, price, address, measures, imageUrl, type, status, category, seller);
    }
}
