package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.PurchaseTransactionDao;
import com.onlinepcshop.adapters.persistance.mapper.PurchaseTransactionMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.PurchaseTransactionJpaRepository;
import com.onlinepcshop.adapters.persistance.repository.jpa.RamJpaRepository;
import com.onlinepcshop.core.domain.entity.PurchaseTransaction;
import com.onlinepcshop.core.repository.PurchaseTransactionRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class PurchaseTransactionRepositoryImpl implements PurchaseTransactionRepository {
    private final PurchaseTransactionJpaRepository purchaseTransactionJpaRepository;

    @Override
    public List<PurchaseTransaction> findAllPurchaseTransactions() {
        return PurchaseTransactionMapperDB.INSTANCE.purchaseTransactionDaoListToPurchaseTransactionList(purchaseTransactionJpaRepository.findAll());
    }

    @Override
    public List<PurchaseTransaction> findAllPurchaseTransactionsByUserId(UUID userId) {
        return PurchaseTransactionMapperDB.INSTANCE.purchaseTransactionDaoListToPurchaseTransactionList(purchaseTransactionJpaRepository.findAllByUserId(userId));
    }

    @Override
    public Optional<PurchaseTransaction> findById(UUID purchaseTransactionId) {
        PurchaseTransaction purchaseTransaction = PurchaseTransactionMapperDB.INSTANCE.purchaseTransactionDaoToPurchaseTransaction(purchaseTransactionJpaRepository.findById(purchaseTransactionId).orElse(null));
        return Optional.ofNullable(purchaseTransaction);
    }

    @Override
    public PurchaseTransaction savePurchaseTransaction(PurchaseTransaction purchaseTransaction) {
        PurchaseTransactionDao purchaseTransactionDao = PurchaseTransactionMapperDB.INSTANCE.purchaseTransactionToPurchaseTransactionDao(purchaseTransaction);
        return PurchaseTransactionMapperDB.INSTANCE.purchaseTransactionDaoToPurchaseTransaction(purchaseTransactionJpaRepository.save(purchaseTransactionDao));
    }

    @Override
    public void deletePurchaseTransaction(UUID id) {
        purchaseTransactionJpaRepository.deleteById(id);
    }
}
