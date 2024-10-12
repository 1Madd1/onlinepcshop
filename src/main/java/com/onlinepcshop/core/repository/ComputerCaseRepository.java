package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.ComputerCase;
import com.onlinepcshop.core.domain.entity.Motherboard;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComputerCaseRepository {
    List<ComputerCase> findAllComputerCases();

    Optional<ComputerCase> findById(UUID computerCaseId);

    ComputerCase saveComputerCase(ComputerCase computerCase);

    void deleteComputerCase(UUID id);

    List<ComputerCase> findAllComputerCasesByMaxPrice(Double maxPrice);
}
