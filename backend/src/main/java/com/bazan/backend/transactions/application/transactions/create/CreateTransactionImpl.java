package com.bazan.backend.transactions.application.transactions.create;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bazan.backend.shared.domain.abstractions.Result;
import com.bazan.backend.transactions.application.transactions.TransactionMapper;
import com.bazan.backend.transactions.domain.listings.Listing;
import com.bazan.backend.transactions.domain.listings.ListingErrors;
import com.bazan.backend.transactions.domain.purchasers.Purchaser;
import com.bazan.backend.transactions.domain.purchasers.PurchaserErrors;
import com.bazan.backend.transactions.domain.transactions.Transaction;
import com.bazan.backend.transactions.domain.vendors.Vendor;
import com.bazan.backend.transactions.domain.vendors.VendorErrors;
import com.bazan.backend.transactions.infrastructure.repositories.ListingRepository;
import com.bazan.backend.transactions.infrastructure.repositories.PurchaserRepository;
import com.bazan.backend.transactions.infrastructure.repositories.TransactionRepository;
import com.bazan.backend.transactions.infrastructure.repositories.VendorRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CreateTransactionImpl implements CreateTransaction {
	private final TransactionRepository transactionRepository;
	private final VendorRepository vendorRepository;
	private final ListingRepository listingRepository;
	private final PurchaserRepository purchaserRepository;

	@Override
	@Transactional
	public Result<CreateTransactionResponse> create(CreateTransactionRequest request) {
		Optional<Vendor> vendor = vendorRepository.findById(request.vendorId());
		
		if (vendor.isEmpty()) {
			return Result.failure(VendorErrors.notFound);
		}
		
		Optional<Purchaser> purchaser = purchaserRepository.findById(request.purchaserId());
		
		if (purchaser.isEmpty()) {
			return Result.failure(PurchaserErrors.notFound);
		}
		
		Optional<Listing> listing = listingRepository.findById(request.listingId());
		
		if (listing.isEmpty()) {
			return Result.failure(ListingErrors.notfound);
		}
		
		Transaction transaction = Transaction.create(listing.get().getPrice(), listing.get().getId(), vendor.get().getId(), purchaser.get().getId());
		
		var transactionSaved = transactionRepository.save(transaction);
		
		return Result.success(TransactionMapper.fromEntity(transactionSaved, purchaser.get(), vendor.get(), listing.get()));
	}
}
