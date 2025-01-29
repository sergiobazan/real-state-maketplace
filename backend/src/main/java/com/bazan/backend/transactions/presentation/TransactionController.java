package com.bazan.backend.transactions.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bazan.backend.transactions.application.transactions.create.CreateTransaction;
import com.bazan.backend.transactions.application.transactions.create.CreateTransactionRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transactions")
class TransactionController {
	private final CreateTransaction createTransaction;
	
	@PostMapping
	ResponseEntity<?> createTransaction(@RequestBody CreateTransactionRequest request) {
		var result = createTransaction.create(request);
		
		if (result.isFailure()) {
			return ResponseEntity.badRequest().body(result.error());
		}
		
		return ResponseEntity.ok(result.getValue());
	}
}
