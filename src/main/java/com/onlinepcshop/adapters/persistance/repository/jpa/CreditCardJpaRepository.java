package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.CreditCardDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreditCardJpaRepository extends JpaRepository<CreditCardDao, UUID> {
}
