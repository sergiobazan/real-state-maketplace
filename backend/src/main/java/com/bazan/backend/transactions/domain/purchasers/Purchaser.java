package com.bazan.backend.transactions.domain.purchasers;

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
@Table(name = "purchasers", schema = "transactions")
public class Purchaser {
	@Id
	private UUID id;
	
	private String name;
	
	private String email;
}
