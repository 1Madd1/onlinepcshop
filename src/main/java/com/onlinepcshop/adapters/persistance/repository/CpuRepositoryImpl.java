package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.CpuDao;
import com.onlinepcshop.adapters.persistance.mapper.CpuMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.CpuJpaRepository;
import com.onlinepcshop.core.domain.entity.Cpu;
import com.onlinepcshop.core.repository.CpuRepository;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class CpuRepositoryImpl implements CpuRepository {
    private final CpuJpaRepository cpuJpaRepository;

    @Override
    public List<Cpu> findAllCpus() {
        return CpuMapperDB.INSTANCE.cpuDaoListToCpuList(cpuJpaRepository.findAll());
    }

    @Override
    public List<Cpu> findAllAvailableCpus() {
        return CpuMapperDB.INSTANCE.cpuDaoListToCpuList(cpuJpaRepository.findAllByQuantityGreaterThan(0));
    }

    @Override
    public Optional<Cpu> findById(UUID cpuId) {
        Cpu cpu = CpuMapperDB.INSTANCE.cpuDaoToCpu(cpuJpaRepository.findById(cpuId).orElse(null));
        return Optional.ofNullable(cpu);
    }

    @Override
    public Cpu saveCpu(Cpu cpu) {
        CpuDao cpuDao = CpuMapperDB.INSTANCE.cpuToCpuDao(cpu);
        return CpuMapperDB.INSTANCE.cpuDaoToCpu(cpuJpaRepository.save(cpuDao));
    }

    @Override
    public void deleteCpu(UUID id) {
        cpuJpaRepository.deleteById(id);
    }

    @Override
    public List<Cpu> findAllCpusByMaxPriceAndSocketTypeIncludesCoolerAndIntegratedGpu(Double maxPrice, String socketType, Boolean includesCooler, Boolean includesIntegratedGpu) {
        return CpuMapperDB.INSTANCE.cpuDaoListToCpuList(cpuJpaRepository.findByPriceLessThanEqualAndSocketTypeAndIncludesCoolerAndIncludesIntegratedGpuAndQuantityGreaterThan(maxPrice, socketType, includesCooler, includesIntegratedGpu, 0));
    }

    @Override
    public List<Cpu> findAllByHavingSaleAndByComponentName(String componentName) {
        return CpuMapperDB.INSTANCE.cpuDaoListToCpuList(cpuJpaRepository.findBySaleTypeNotNullAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(componentName, 0));
    }

    @Override
    public List<Cpu> searchByComponentName(String componentName) {
        return CpuMapperDB.INSTANCE.cpuDaoListToCpuList(cpuJpaRepository.findByComponentNameContainingIgnoreCaseAndQuantityGreaterThan(componentName, 0));
    }

    @Override
    public List<Cpu> findAllNewCpusByComponentName(String componentName) {
        LocalDate localDate = LocalDate.now().minusMonths(1);
        return CpuMapperDB.INSTANCE.cpuDaoListToCpuList(cpuJpaRepository.findByDateOfCreationAfterAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(localDate, componentName, 0));
    }
}
