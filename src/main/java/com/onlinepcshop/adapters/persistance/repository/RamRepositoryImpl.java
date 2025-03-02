package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.RamDao;
import com.onlinepcshop.adapters.persistance.mapper.RamMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.RamJpaRepository;
import com.onlinepcshop.core.domain.entity.Ram;
import com.onlinepcshop.core.repository.RamRepository;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class RamRepositoryImpl implements RamRepository {
    private final RamJpaRepository ramJpaRepository;

    @Override
    public List<Ram> findAllRams() {
        return RamMapperDB.INSTANCE.ramDaoListToRamList(ramJpaRepository.findAll());
    }

    @Override
    public List<Ram> findAllAvailableRams() {
        return RamMapperDB.INSTANCE.ramDaoListToRamList(ramJpaRepository.findAllByQuantityGreaterThan(0));
    }

    @Override
    public Optional<Ram> findById(UUID ramId) {
        Ram ram = RamMapperDB.INSTANCE.ramDaoToRam(ramJpaRepository.findById(ramId).orElse(null));
        return Optional.ofNullable(ram);
    }

    @Override
    public Ram saveRam(Ram ram) {
        RamDao ramDao = RamMapperDB.INSTANCE.ramToRamDao(ram);
        return RamMapperDB.INSTANCE.ramDaoToRam(ramJpaRepository.save(ramDao));
    }

    @Override
    public void deleteRam(UUID id) {
        ramJpaRepository.deleteById(id);
    }

    @Override
    public List<Ram> findAllRamsByMaxPriceAndMemoryType(Double maxPrice, String memoryType) {
        return RamMapperDB.INSTANCE.ramDaoListToRamList(ramJpaRepository.findByPriceLessThanEqualAndMemoryTypeAndQuantityGreaterThan(maxPrice, memoryType, 0));
    }

    @Override
    public List<Ram> findAllByHavingSaleAndByComponentName(String componentName) {
        return RamMapperDB.INSTANCE.ramDaoListToRamList(ramJpaRepository.findBySaleTypeNotNullAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(componentName, 0));
    }

    @Override
    public List<Ram> searchByComponentName(String componentName) {
        return RamMapperDB.INSTANCE.ramDaoListToRamList(ramJpaRepository.findByComponentNameContainingIgnoreCaseAndQuantityGreaterThan(componentName, 0));
    }

    @Override
    public List<Ram> findAllNewRamsByComponentName(String componentName) {
        LocalDate localDate = LocalDate.now().minusMonths(1);
        return RamMapperDB.INSTANCE.ramDaoListToRamList(ramJpaRepository.findByDateOfCreationAfterAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(localDate, componentName, 0));
    }
}
