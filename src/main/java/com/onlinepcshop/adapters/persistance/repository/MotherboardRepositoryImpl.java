package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.MotherboardDao;
import com.onlinepcshop.adapters.persistance.mapper.MotherboardMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.MotherboardJpaRepository;
import com.onlinepcshop.core.domain.entity.Motherboard;
import com.onlinepcshop.core.repository.MotherboardRepository;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class MotherboardRepositoryImpl implements MotherboardRepository {
    private final MotherboardJpaRepository motherboardJpaRepository;

    @Override
    public List<Motherboard> findAllMotherboards() {
        return MotherboardMapperDB.INSTANCE.motherboardDaoListToMotherboardList(motherboardJpaRepository.findAll());
    }

    @Override
    public List<Motherboard> findAllAvailableMotherboards() {
        return MotherboardMapperDB.INSTANCE.motherboardDaoListToMotherboardList(motherboardJpaRepository.findAllByQuantityGreaterThan(0));
    }

    @Override
    public Optional<Motherboard> findById(UUID motherboardId) {
        Motherboard motherboard = MotherboardMapperDB.INSTANCE.motherboardDaoToMotherboard(motherboardJpaRepository.findById(motherboardId).orElse(null));
        return Optional.ofNullable(motherboard);
    }

    @Override
    public Motherboard saveMotherboard(Motherboard motherboard) {
        MotherboardDao motherboardDao = MotherboardMapperDB.INSTANCE.motherboardToMotherboardDao(motherboard);
        return MotherboardMapperDB.INSTANCE.motherboardDaoToMotherboard(motherboardJpaRepository.save(motherboardDao));
    }

    @Override
    public void deleteMotherboard(UUID id) {
        motherboardJpaRepository.deleteById(id);
    }

    @Override
    public List<Motherboard> findAllMotherboardsByMaxPrice(Double maxPrice) {
        return MotherboardMapperDB.INSTANCE.motherboardDaoListToMotherboardList(motherboardJpaRepository.findByPriceLessThanEqualAndQuantityGreaterThan(maxPrice, 0));
    }

    @Override
    public List<Motherboard> findAllByHavingSaleAndByComponentName(String componentName) {
        return MotherboardMapperDB.INSTANCE.motherboardDaoListToMotherboardList(motherboardJpaRepository.findBySaleTypeNotNullAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(componentName, 0));
    }

    @Override
    public List<Motherboard> searchByComponentName(String componentName) {
        return MotherboardMapperDB.INSTANCE.motherboardDaoListToMotherboardList(motherboardJpaRepository.findByComponentNameContainingIgnoreCaseAndQuantityGreaterThan(componentName, 0));
    }

    @Override
    public List<Motherboard> findAllNewMotherboardsByComponentName(String componentName) {
        LocalDate localDate = LocalDate.now().minusMonths(1);
        return MotherboardMapperDB.INSTANCE.motherboardDaoListToMotherboardList(motherboardJpaRepository.findByDateOfCreationAfterAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(localDate, componentName, 0));
    }
}
