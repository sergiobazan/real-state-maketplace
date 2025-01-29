package com.bazan.backend.transactions.domain.transactions;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "transactions", schema = "transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private BigDecimal amount;
	
	@Enumerated(EnumType.STRING)
	private TransactionStatus status;
	
	private UUID listingId;
	
	private UUID vendorId;
	
	private UUID purchaserId;
	
    private LocalDateTime transactionDate;
    
    @CreatedDate
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
	private Transaction(BigDecimal amount, TransactionStatus status, UUID listingId, UUID vendorId, UUID purchaserId,
			LocalDateTime transactionDate) {
		super();
		this.amount = amount;
		this.status = status;
		this.listingId = listingId;
		this.vendorId = vendorId;
		this.purchaserId = purchaserId;
		this.transactionDate = transactionDate;
	}
    
    public static Transaction create(BigDecimal amount, UUID listingId, UUID vendorId, UUID purchaserId) {
    	return new Transaction(amount, TransactionStatus.PENDING, listingId, vendorId, purchaserId, LocalDateTime.now());
    }
}
