package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.ComputerCase;
import com.onlinepcshop.core.domain.entity.Gpu;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GpuUseCase {
    /***
     *  Create and persist an agent
     *
     * @param gpu newly created gpu
     * @return Valid user object with id
     */
    Gpu createGpu(Gpu gpu);

    /***
     *  Update gpu data fields
     * @param gpu must be a valid gpu object with valid id
     * @return Updated gpu object
     */
    Gpu updateGpu(Gpu gpu);

    /***
     *
     * @return List of all gpus
     */
    List<Gpu> findAllGpus();


    /***
     * @param gpuId valid gpu UUID
     * @return Gpu with provided agentId if one exists
     */
    Optional<Gpu> findGpuById(UUID gpuId);

    /***
     * Delete gpu with specified id
     * @param id must be a valid
     */
    void deleteGpu(UUID id);

    /**
     *
     * @param maxPrice - max. allowed price of searched gpu
     * @param motherboardId - id of given motherboard to get its list of all PCIe interfaces
     * @return - List of all gpus that are equal or below max. price and that are the same interface with given motherboard
     */
    List<Gpu> findAllGpusByMaxPriceAndMotherboard(Double maxPrice, UUID motherboardId);
}
