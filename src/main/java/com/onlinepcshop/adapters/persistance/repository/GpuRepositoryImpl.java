package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.GpuDao;
import com.onlinepcshop.adapters.persistance.mapper.GpuMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.GpuJpaRepository;
import com.onlinepcshop.core.domain.entity.Gpu;
import com.onlinepcshop.core.repository.GpuRepository;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class GpuRepositoryImpl implements GpuRepository {
    private final GpuJpaRepository gpuJpaRepository;

    @Override
    public List<Gpu> findAllGpus() {
        return GpuMapperDB.INSTANCE.gpuDaoListToGpuList(gpuJpaRepository.findAll());
    }

    @Override
    public List<Gpu> findAllAvailableGpus() {
        return GpuMapperDB.INSTANCE.gpuDaoListToGpuList(gpuJpaRepository.findAllByQuantityGreaterThan(0));
    }

    @Override
    public Optional<Gpu> findById(UUID gpuId) {
        Gpu gpu = GpuMapperDB.INSTANCE.gpuDaoToGpu(gpuJpaRepository.findById(gpuId).orElse(null));
        return Optional.ofNullable(gpu);
    }

    @Override
    public Gpu saveGpu(Gpu gpu) {
        GpuDao gpuDao = GpuMapperDB.INSTANCE.gpuToGpuDao(gpu);
        return GpuMapperDB.INSTANCE.gpuDaoToGpu(gpuJpaRepository.save(gpuDao));
    }

    @Override
    public void deleteGpu(UUID id) {
        gpuJpaRepository.deleteById(id);
    }

    @Override
    public List<Gpu> findAllGpusByMaxPriceAndPcieInterface(Double maxPrice, String pcieType) {
        return GpuMapperDB.INSTANCE.gpuDaoListToGpuList(gpuJpaRepository.findByPriceLessThanEqualAndPcieTypeAndQuantityGreaterThan(maxPrice, pcieType, 0));
    }

    @Override
    public List<Gpu> findAllByHavingSaleAndByComponentName(String componentName) {
        return GpuMapperDB.INSTANCE.gpuDaoListToGpuList(gpuJpaRepository.findBySaleTypeNotNullAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(componentName, 0));
    }

    @Override
    public List<Gpu> searchByComponentName(String componentName) {
        return GpuMapperDB.INSTANCE.gpuDaoListToGpuList(gpuJpaRepository.findByComponentNameContainingIgnoreCaseAndQuantityGreaterThan(componentName, 0));
    }

    @Override
    public List<Gpu> findAllNewGpusByComponentName(String componentName) {
        LocalDate localDate = LocalDate.now().minusMonths(1);
        return GpuMapperDB.INSTANCE.gpuDaoListToGpuList(gpuJpaRepository.findByDateOfCreationAfterAndComponentNameContainingIgnoreCaseAndQuantityGreaterThan(localDate, componentName, 0));
    }
}
