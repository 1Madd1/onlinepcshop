package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.ComputerCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ComputerCaseUseCase {
    /***
     *  Create and persist an agent
     *
     * @param computerCase newly created computer case
     * @return Valid user object with id
     */
    ComputerCase createComputerCase(ComputerCase computerCase);

    /***
     *  Update computerCase data fields
     * @param computerCase must be a valid computer case object with valid id
     * @return Updated computerCase object
     */
    ComputerCase updateComputerCase(ComputerCase computerCase);

    /***
     *
     * @return List of all computer cases
     */
    List<ComputerCase> findAllComputerCases();


    /***
     * @param computerCaseId valid computerCase UUID
     * @return ComputerCase with provided agentId if one exists
     */
    Optional<ComputerCase> findComputerCaseById(UUID computerCaseId);

    /***
     * Delete computer case with specified id
     * @param id must be a valid
     */
    void deleteComputerCase(UUID id);
}
