package com.bazan.backend.transactions.domain.vendors;

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
@Table(name = "vendors", schema = "transactions")
public class Vendor {
	@Id
	private UUID id;
	
	private String name;
	
	private String email;
}
