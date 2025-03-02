package com.onlinepcshop.core.repository;

import com.onlinepcshop.adapters.rest.dto.PurchaseSummaryDto;
import com.onlinepcshop.core.domain.entity.PurchaseTransactionProduct;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PurchaseTransactionProductRepository {
    List<PurchaseTransactionProduct> findAllPurchaseTransactionProducts();

    List<PurchaseTransactionProduct> findAllPurchaseTransactionProductsByTransactionId(UUID id);

    Optional<PurchaseTransactionProduct> findById(UUID purchaseTransactionProductId);

    PurchaseTransactionProduct savePurchaseTransactionProduct(PurchaseTransactionProduct purchaseTransactionProduct);

    List<PurchaseSummaryDto> findAllPurchaseTransactionProductsWithTotalAmountHigherThan2();

    void deletePurchaseTransactionProduct(UUID id);
}
