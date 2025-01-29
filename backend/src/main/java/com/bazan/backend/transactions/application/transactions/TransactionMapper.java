package com.bazan.backend.transactions.application.transactions;

import com.bazan.backend.transactions.application.transactions.create.CreateTransactionResponse;
import com.bazan.backend.transactions.application.transactions.create.PropertyResponse;
import com.bazan.backend.transactions.application.transactions.create.PurchaserResponse;
import com.bazan.backend.transactions.application.transactions.create.VendorResponse;
import com.bazan.backend.transactions.domain.listings.Listing;
import com.bazan.backend.transactions.domain.purchasers.Purchaser;
import com.bazan.backend.transactions.domain.transactions.Transaction;
import com.bazan.backend.transactions.domain.vendors.Vendor;

public class TransactionMapper {
	public static CreateTransactionResponse fromEntity(Transaction transaction, Purchaser purchaser, Vendor vendor, Listing lisitng) {
		return new CreateTransactionResponse(
					transaction.getId(),
					transaction.getAmount(),
					transaction.getStatus(),
					new VendorResponse(vendor.getId(), vendor.getName(), vendor.getEmail()),
					new PurchaserResponse(purchaser.getId(), purchaser.getName(), purchaser.getEmail()),
					new PropertyResponse(lisitng.getId(), lisitng.getTitle(), lisitng.getPrice()),
					transaction.getTransactionDate()
				);
	}
}
