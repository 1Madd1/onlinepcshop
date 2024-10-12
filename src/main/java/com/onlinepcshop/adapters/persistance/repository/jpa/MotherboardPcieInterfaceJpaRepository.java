package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.MotherboardPcieInterfaceDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MotherboardPcieInterfaceJpaRepository extends JpaRepository<MotherboardPcieInterfaceDao, UUID> {
    List<MotherboardPcieInterfaceDao> findAllByMotherboardIdAndPcieInterfaceId(UUID motherboardId, UUID pcieInterfaceId);
    List<MotherboardPcieInterfaceDao> findAllByMotherboardId(UUID motherboardId);
}
