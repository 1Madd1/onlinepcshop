package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.MotherboardStorageInterfaceDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MotherboardStorageInterfaceJpaRepository extends JpaRepository<MotherboardStorageInterfaceDao, UUID> {
}
