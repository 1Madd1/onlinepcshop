package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.PcieInterfaceDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PcieInterfaceJpaRepository extends JpaRepository<PcieInterfaceDao, UUID> {
}
