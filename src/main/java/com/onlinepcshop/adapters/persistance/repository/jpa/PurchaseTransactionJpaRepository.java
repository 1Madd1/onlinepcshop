package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.PurchaseTransactionDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PurchaseTransactionJpaRepository extends JpaRepository<PurchaseTransactionDao, UUID> {
    List<PurchaseTransactionDao> findAllByUserId(UUID userId);
}
