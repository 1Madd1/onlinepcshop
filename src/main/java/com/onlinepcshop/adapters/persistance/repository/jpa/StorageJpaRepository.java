package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.StorageDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StorageJpaRepository extends JpaRepository<StorageDao, UUID> {
}
