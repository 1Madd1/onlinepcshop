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
     *
     * @return List of all computer cases that have quantity greater than 0
     */
    List<ComputerCase> findAllAvailableComputerCases();


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

    /**
     * @param maxPrice - max. allowed price of searched computer case
     * @return - List of all computer cases that are equal or below max. price
     */
    List<ComputerCase> findAllComputerCasesByMaxPrice(Double maxPrice);

    /**
     * @param name - valid component name of existing computer case
     * @return - List of all computer cases that include given component name
     */
    List<ComputerCase> searchByName(String name);

    /**
     * @param computerCaseId - valid UUID of existing computer case
     * @return - average computer case rating based on given computer case id
     */
    Double getComputerCaseAverageRating(UUID computerCaseId);
}
