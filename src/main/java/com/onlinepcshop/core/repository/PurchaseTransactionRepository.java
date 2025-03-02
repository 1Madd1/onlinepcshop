package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.PurchaseTransaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PurchaseTransactionRepository {
    List<PurchaseTransaction> findAllPurchaseTransactions();

    List<PurchaseTransaction> findAllPurchaseTransactionsByUserId(UUID userId);

    Optional<PurchaseTransaction> findById(UUID purchaseTransactionId);

    PurchaseTransaction savePurchaseTransaction(PurchaseTransaction purchaseTransaction);

    void deletePurchaseTransaction(UUID id);
}
