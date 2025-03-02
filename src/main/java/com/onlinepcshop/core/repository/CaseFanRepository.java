package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.CaseFan;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CaseFanRepository {
    List<CaseFan> findAllCaseFans();

    List<CaseFan> findAllAvailableCaseFans();

    Optional<CaseFan> findById(UUID caseFanId);

    CaseFan saveCaseFan(CaseFan caseFan);

    void deleteCaseFan(UUID id);

    List<CaseFan> findAllCaseFansByMaxPrice(Double maxPrice);

    List<CaseFan> searchByComponentName(String componentName);

    List<CaseFan> findAllByHavingSaleAndByComponentName(String componentName);

    List<CaseFan> findAllNewCaseFansByComponentName(String componentName);

}
