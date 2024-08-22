package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.PcieInterface;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PcieInterfaceRepository {
    List<PcieInterface> findAllPcieInterfaces();

    Optional<PcieInterface> findById(UUID pcieInterfaceId);

    PcieInterface savePcieInterface(PcieInterface pcieInterface);

    void deletePcieInterface(UUID id);
}
