package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.PurchaseTransactionProductDao;
import com.onlinepcshop.adapters.rest.dto.PurchaseSummaryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PurchaseTransactionProductJpaRepository extends JpaRepository<PurchaseTransactionProductDao, UUID> {
    List<PurchaseTransactionProductDao> findAllByPurchaseTransactionId(UUID purchaseTransactionId);

    @Query("SELECT new com.onlinepcshop.adapters.rest.dto.PurchaseSummaryDto(p.productId, p.productType, SUM(p.amount)) " +
            "FROM purchase_transaction_product p " +
            "GROUP BY p.productId, p.productType " +
            "HAVING SUM(p.amount) > 2")
    List<PurchaseSummaryDto> findProductsWithTotalAmountGreaterThan2();
}
