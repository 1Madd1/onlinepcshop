package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.PurchaseTransactionProductDao;
import com.onlinepcshop.adapters.persistance.mapper.PurchaseTransactionProductMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.PurchaseTransactionProductJpaRepository;
import com.onlinepcshop.adapters.rest.dto.PurchaseSummaryDto;
import com.onlinepcshop.core.domain.entity.PurchaseTransactionProduct;
import com.onlinepcshop.core.repository.PurchaseTransactionProductRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class PurchaseTransactionProductRepositoryImpl implements PurchaseTransactionProductRepository {
    private final PurchaseTransactionProductJpaRepository purchaseTransactionProductJpaRepository;

    @Override
    public List<PurchaseTransactionProduct> findAllPurchaseTransactionProducts() {
        return PurchaseTransactionProductMapperDB.INSTANCE.purchaseTransactionProductDaoListToPurchaseTransactionProductList(purchaseTransactionProductJpaRepository.findAll());
    }

    @Override
    public List<PurchaseTransactionProduct> findAllPurchaseTransactionProductsByTransactionId(UUID id) {
        return PurchaseTransactionProductMapperDB.INSTANCE.purchaseTransactionProductDaoListToPurchaseTransactionProductList(purchaseTransactionProductJpaRepository.findAllByPurchaseTransactionId(id));
    }

    @Override
    public Optional<PurchaseTransactionProduct> findById(UUID purchaseTransactionProductId) {
        PurchaseTransactionProduct purchaseTransactionProduct = PurchaseTransactionProductMapperDB.INSTANCE.purchaseTransactionProductDaoToPurchaseTransactionProduct(purchaseTransactionProductJpaRepository.findById(purchaseTransactionProductId).orElse(null));
        return Optional.ofNullable(purchaseTransactionProduct);
    }

    @Override
    public PurchaseTransactionProduct savePurchaseTransactionProduct(PurchaseTransactionProduct purchaseTransactionProduct) {
        PurchaseTransactionProductDao purchaseTransactionProductDao = PurchaseTransactionProductMapperDB.INSTANCE.purchaseTransactionProductToPurchaseTransactionProductDao(purchaseTransactionProduct);
        return PurchaseTransactionProductMapperDB.INSTANCE.purchaseTransactionProductDaoToPurchaseTransactionProduct(purchaseTransactionProductJpaRepository.save(purchaseTransactionProductDao));
    }

    @Override
    public List<PurchaseSummaryDto> findAllPurchaseTransactionProductsWithTotalAmountHigherThan2() {
        return purchaseTransactionProductJpaRepository.findProductsWithTotalAmountGreaterThan2();
    }

    @Override
    public void deletePurchaseTransactionProduct(UUID id) {
        purchaseTransactionProductJpaRepository.deleteById(id);
    }
}
