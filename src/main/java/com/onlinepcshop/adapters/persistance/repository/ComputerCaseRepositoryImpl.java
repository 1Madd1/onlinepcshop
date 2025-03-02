package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.ComputerCaseDao;
import com.onlinepcshop.adapters.persistance.mapper.ComputerCaseMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.ComputerCaseJpaRepository;
import com.onlinepcshop.core.domain.entity.ComputerCase;
import com.onlinepcshop.core.repository.ComputerCaseRepository;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class ComputerCaseRepositoryImpl implements ComputerCaseRepository {
    private final ComputerCaseJpaRepository computerCaseJpaRepository;

    @Override
    public List<ComputerCase> findAllComputerCases() {
        return ComputerCaseMapperDB.INSTANCE.computerCaseDaoListToComputerCaseList(computerCaseJpaRepository.findAll());
    }

    @Override
    public List<ComputerCase> findAllAvailableComputerCases() {
        return ComputerCaseMapperDB.INSTANCE.computerCaseDaoListToComputerCaseList(computerCaseJpaRepository.findAllByQuantityGreaterThan(0));
    }

    @Override
    public Optional<ComputerCase> findById(UUID computerCaseId) {
        ComputerCase computerCase = ComputerCaseMapperDB.INSTANCE.computerCaseDaoToComputerCase(computerCaseJpaRepository.findById(computerCaseId).orElse(null));
        return Optional.ofNullable(computerCase);
    }

    @Override
    public ComputerCase saveComputerCase(ComputerCase computerCase) {
        ComputerCaseDao computerCaseDao = ComputerCaseMapperDB.INSTANCE.computerCaseToComputerCaseDao(computerCase);
        return ComputerCaseMapperDB.INSTANCE.computerCaseDaoToComputerCase(computerCaseJpaRepository.save(computerCaseDao));
    }

    @Override
    public void deleteComputerCase(UUID id) {
        computerCaseJpaRepository.deleteById(id);
    }

    @Override
    public List<ComputerCase> findAllComputerCasesByMaxPrice(Double maxPrice) {
        return ComputerCaseMapperDB.INSTANCE.computerCaseDaoListToComputerCaseList(computerCaseJpaRepository.findByPriceLessThanEqualAndQuantityGreaterThan(maxPrice, 0));
    }

    @Override
    public List<ComputerCase> findAllByHavingSaleAndByComponentName(String componentName) {
        return ComputerCaseMapperDB.INSTANCE.computerCaseDaoListToComputerCaseList(computerCaseJpaRepository.findBySaleTypeNotNullAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(componentName, 0));
    }

    @Override
    public List<ComputerCase> searchByComponentName(String componentName) {
        return ComputerCaseMapperDB.INSTANCE.computerCaseDaoListToComputerCaseList(computerCaseJpaRepository.findByComponentNameContainingIgnoreCaseAndQuantityGreaterThan(componentName, 0));
    }

    @Override
    public List<ComputerCase> findAllNewComputerCasesByComponentName(String componentName) {
        LocalDate localDate = LocalDate.now().minusMonths(1);
        return ComputerCaseMapperDB.INSTANCE.computerCaseDaoListToComputerCaseList(computerCaseJpaRepository.findByDateOfCreationAfterAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(localDate, componentName, 0));
    }
}
