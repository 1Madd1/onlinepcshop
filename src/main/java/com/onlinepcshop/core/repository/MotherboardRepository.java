package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.Motherboard;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MotherboardRepository {
    List<Motherboard> findAllMotherboards();

    List<Motherboard> findAllAvailableMotherboards();

    Optional<Motherboard> findById(UUID motherboardId);

    Motherboard saveMotherboard(Motherboard motherboard);

    void deleteMotherboard(UUID id);

    List<Motherboard> findAllMotherboardsByMaxPrice(Double maxPrice);

    List<Motherboard> findAllByHavingSaleAndByComponentName(String componentName);

    List<Motherboard> searchByComponentName(String componentName);

    List<Motherboard> findAllNewMotherboardsByComponentName(String componentName);
}
