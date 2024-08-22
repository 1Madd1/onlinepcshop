package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.PcieInterfaceDao;
import com.onlinepcshop.adapters.persistance.mapper.PcieInterfaceMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.PcieInterfaceJpaRepository;
import com.onlinepcshop.core.domain.entity.PcieInterface;
import com.onlinepcshop.core.repository.PcieInterfaceRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class PcieInterfaceRepositoryImpl implements PcieInterfaceRepository {
    private final PcieInterfaceJpaRepository pcieInterfaceJpaRepository;

    @Override
    public List<PcieInterface> findAllPcieInterfaces() {
        return PcieInterfaceMapperDB.INSTANCE.pcieInterfaceDaoListToPcieInterfaceList(pcieInterfaceJpaRepository.findAll());
    }

    @Override
    public Optional<PcieInterface> findById(UUID pcieInterfaceId) {
        PcieInterface pcieInterface = PcieInterfaceMapperDB.INSTANCE.pcieInterfaceDaoToPcieInterface(pcieInterfaceJpaRepository.findById(pcieInterfaceId).orElse(null));
        return Optional.ofNullable(pcieInterface);
    }

    @Override
    public PcieInterface savePcieInterface(PcieInterface pcieInterface) {
        PcieInterfaceDao pcieInterfaceDao = PcieInterfaceMapperDB.INSTANCE.pcieInterfaceToPcieInterfaceDao(pcieInterface);
        return PcieInterfaceMapperDB.INSTANCE.pcieInterfaceDaoToPcieInterface(pcieInterfaceJpaRepository.save(pcieInterfaceDao));
    }

    @Override
    public void deletePcieInterface(UUID id) {
        pcieInterfaceJpaRepository.deleteById(id);
    }
}
