package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.CaseFanDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CaseFanJpaRepository extends JpaRepository<CaseFanDao, UUID> {
    List<CaseFanDao> findByPriceLessThanEqual(Double maxPrice);
}
