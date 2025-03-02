package com.onlinepcshop.core.repository;

import com.onlinepcshop.core.domain.entity.ComputerCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComputerCaseRepository {
    List<ComputerCase> findAllComputerCases();

    List<ComputerCase> findAllAvailableComputerCases();

    Optional<ComputerCase> findById(UUID computerCaseId);

    ComputerCase saveComputerCase(ComputerCase computerCase);

    void deleteComputerCase(UUID id);

    List<ComputerCase> findAllComputerCasesByMaxPrice(Double maxPrice);

    List<ComputerCase> findAllByHavingSaleAndByComponentName(String componentName);

    List<ComputerCase> searchByComponentName(String componentName);

    List<ComputerCase> findAllNewComputerCasesByComponentName(String componentName);

}
