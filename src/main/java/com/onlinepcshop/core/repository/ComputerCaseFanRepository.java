package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.ComputerCaseFan;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComputerCaseFanRepository {
    List<ComputerCaseFan> findAllComputerCaseFans();

    Optional<ComputerCaseFan> findById(UUID computerCaseFanId);

    ComputerCaseFan saveComputerCaseFan(ComputerCaseFan computerCaseFan);

    void deleteComputerCaseFan(UUID id);

    List<ComputerCaseFan> findAllByCaseFanAndComputer(UUID caseFanId, UUID computerId);

    List<ComputerCaseFan> findAllByComputer(UUID computerId);

    Integer findQuantityByCaseFanIdAndComputerId(UUID caseFanId, UUID computerId);
}
