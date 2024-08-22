package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.StorageInterfaceDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StorageInterfaceJpaRepository extends JpaRepository<StorageInterfaceDao, UUID> {
}
