package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.PcieInterface;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PcieInterfaceUseCase {
    /***
     *  Create and persist an agent
     *
     * @param pcieInterface newly created pcie interface
     * @return Valid user object with id
     */
    PcieInterface createPcieInterface(PcieInterface pcieInterface);

    /***
     *  Update pcieInterface data fields
     * @param pcieInterface must be a valid pcie interface object with valid id
     * @return Updated pcieInterface object
     */
    PcieInterface updatePcieInterface(PcieInterface pcieInterface);

    /***
     *
     * @return List of all pcie interfaces
     */
    List<PcieInterface> findAllPcieInterfaces();


    /***
     * @param pcieInterfaceId valid pcie interface UUID
     * @return PcieInterface with provided agentId if one exists
     */
    Optional<PcieInterface> findPcieInterfaceById(UUID pcieInterfaceId);

    /***
     * Delete pcie interface with specified id
     * @param id must be a valid
     */
    void deletePcieInterface(UUID id);
}
