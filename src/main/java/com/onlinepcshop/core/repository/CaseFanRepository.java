package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.CaseFan;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CaseFanRepository {
    List<CaseFan> findAllCaseFans();

    Optional<CaseFan> findById(UUID caseFanId);

    CaseFan saveCaseFan(CaseFan caseFan);

    void deleteCaseFan(UUID id);
}
