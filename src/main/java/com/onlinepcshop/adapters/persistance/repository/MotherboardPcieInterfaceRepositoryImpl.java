package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.MotherboardPcieInterfaceDao;
import com.onlinepcshop.adapters.persistance.mapper.MotherboardPcieInterfaceMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.MotherboardPcieInterfaceJpaRepository;
import com.onlinepcshop.core.domain.entity.MotherboardPcieInterface;
import com.onlinepcshop.core.repository.MotherboardPcieInterfaceRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class MotherboardPcieInterfaceRepositoryImpl implements MotherboardPcieInterfaceRepository {
    private final MotherboardPcieInterfaceJpaRepository motherboardPcieInterfaceJpaRepository;

    @Override
    public List<MotherboardPcieInterface> findAllMotherboardPcieInterfaces() {
        return MotherboardPcieInterfaceMapperDB.INSTANCE.motherboardPcieInterfaceDaoListToMotherboardPcieInterfaceList(motherboardPcieInterfaceJpaRepository.findAll());
    }

    @Override
    public Optional<MotherboardPcieInterface> findById(UUID motherboardPcieInterfaceId) {
        MotherboardPcieInterface motherboardPcieInterface = MotherboardPcieInterfaceMapperDB.INSTANCE.motherboardPcieInterfaceDaoToMotherboardPcieInterface(motherboardPcieInterfaceJpaRepository.findById(motherboardPcieInterfaceId).orElse(null));
        return Optional.ofNullable(motherboardPcieInterface);
    }

    @Override
    public MotherboardPcieInterface saveMotherboardPcieInterface(MotherboardPcieInterface motherboardPcieInterface) {
        MotherboardPcieInterfaceDao motherboardPcieInterfaceDao = MotherboardPcieInterfaceMapperDB.INSTANCE.motherboardPcieInterfaceToMotherboardPcieInterfaceDao(motherboardPcieInterface);
        return MotherboardPcieInterfaceMapperDB.INSTANCE.motherboardPcieInterfaceDaoToMotherboardPcieInterface(motherboardPcieInterfaceJpaRepository.save(motherboardPcieInterfaceDao));
    }

    @Override
    public void deleteMotherboardPcieInterface(UUID id) {
        motherboardPcieInterfaceJpaRepository.deleteById(id);
    }

    @Override
    public List<MotherboardPcieInterface> findAllByPcieInterfaceAndMotherboard(UUID pcieInterfaceId, UUID motherboardId) {
        return MotherboardPcieInterfaceMapperDB.INSTANCE.motherboardPcieInterfaceDaoListToMotherboardPcieInterfaceList(motherboardPcieInterfaceJpaRepository.findAllByMotherboardIdAndPcieInterfaceId(motherboardId, pcieInterfaceId));
    }
}
