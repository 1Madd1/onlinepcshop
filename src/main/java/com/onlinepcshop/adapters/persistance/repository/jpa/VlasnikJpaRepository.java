package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.VlasnikDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VlasnikJpaRepository  extends JpaRepository<VlasnikDao, UUID> {
    Optional<VlasnikDao> findByPrincipalId(String principalId);
}
