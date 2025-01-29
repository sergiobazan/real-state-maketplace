package com.bazan.backend.transactions.domain.listings;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "listings", schema = "transactions")
public class Listing {
	@Id
	private UUID id;
	
	private String title;
	
	private BigDecimal price;
	
	private String categoryName;
	
	private UUID vendorId;
}
