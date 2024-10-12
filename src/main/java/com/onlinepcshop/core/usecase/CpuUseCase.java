package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.Cpu;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CpuUseCase {
    /***
     *  Create and persist an agent
     *
     * @param cpu newly created cpu
     * @return Valid user object with id
     */
    Cpu createCpu(Cpu cpu);

    /***
     *  Update cpu data fields
     * @param cpu must be a valid cpu object with valid id
     * @return Updated cpu object
     */
    Cpu updateCpu(Cpu cpu);

    /***
     *
     * @return List of all cpus
     */
    List<Cpu> findAllCpus();


    /***
     * @param cpuId valid cpu UUID
     * @return Cpu with provided agentId if one exists
     */
    Optional<Cpu> findCpuById(UUID cpuId);

    /***
     * Delete cpu with specified id
     * @param id must be a valid
     */
    void deleteCpu(UUID id);

    /**
     *
     * @param maxPrice - max. allowed price of searched cpu
     * @param includesCooler - cpu has cooler
     * @param includesIntegratedGpu - cpu has integrated gpu
     * @param socketType - socket type of cpu
     * @return - List of all cpu's that are equal or below max. price, are of same socket type and match rest of criteria
     */
    List<Cpu> findAllCpusByMaxPriceAndSocketTypeIncludesCoolerAndIntegratedGpu(Double maxPrice, String socketType, Boolean includesCooler, Boolean includesIntegratedGpu);
}
