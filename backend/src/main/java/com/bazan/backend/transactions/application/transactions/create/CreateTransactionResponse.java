package com.bazan.backend.transactions.application.transactions.create;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.bazan.backend.transactions.domain.transactions.TransactionStatus;

public record CreateTransactionResponse(
		UUID id, 
		BigDecimal amount, 
		TransactionStatus status,
		VendorResponse vendor,
		PurchaserResponse purchaser,
		PropertyResponse property,
		LocalDateTime transactionDate) {

}
