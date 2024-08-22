package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.Cooler;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CoolerUseCase {
    /***
     *  Create and persist an agent
     *
     * @param cooler newly created cooler
     * @return Valid user object with id
     */
    Cooler createCpuCooler(Cooler cooler);

    /***
     *  Update cpuCooler data fields
     * @param cooler must be a valid cpuCooler object with valid id
     * @return Updated cpuCooler object
     */
    Cooler updateCpuCooler(Cooler cooler);

    /***
     *
     * @return List of all cpuCoolers
     */
    List<Cooler> findAllCpuCoolers();


    /***
     * @param cpuCoolerId valid cpuCooler UUID
     * @return CpuCooler with provided agentId if one exists
     */
    Optional<Cooler> findCpuCoolerById(UUID cpuCoolerId);

    /***
     * Delete cpuCooler with specified id
     * @param id must be a valid
     */
    void deleteCpuCooler(UUID id);
}
