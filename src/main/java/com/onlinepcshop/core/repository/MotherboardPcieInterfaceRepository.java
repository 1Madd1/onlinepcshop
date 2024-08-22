package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.MotherboardPcieInterface;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MotherboardPcieInterfaceRepository {
    List<MotherboardPcieInterface> findAllMotherboardPcieInterfaces();

    Optional<MotherboardPcieInterface> findById(UUID motherboardPcieInterfaceId);

    MotherboardPcieInterface saveMotherboardPcieInterface(MotherboardPcieInterface motherboardPcieInterface);

    void deleteMotherboardPcieInterface(UUID id);
}
