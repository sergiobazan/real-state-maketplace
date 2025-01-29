package com.bazan.backend.transactions.application.transactions.create;

import com.bazan.backend.shared.domain.abstractions.Result;

public interface CreateTransaction {
	Result<CreateTransactionResponse> create(CreateTransactionRequest request);
}
