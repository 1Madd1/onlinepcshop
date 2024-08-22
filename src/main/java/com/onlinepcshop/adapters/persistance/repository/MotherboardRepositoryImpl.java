package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.MotherboardDao;
import com.onlinepcshop.adapters.persistance.mapper.MotherboardMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.MotherboardJpaRepository;
import com.onlinepcshop.core.domain.entity.Motherboard;
import com.onlinepcshop.core.repository.MotherboardRepository;
import lombok.Builder;

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
}
