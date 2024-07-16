package com.onlinepcshop.core.usecase;



import com.onlinepcshop.core.domain.entity.Agent;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AgentUseCase {

    /***
     *  Create and persist an agent
     *
     * @param agent newly created agent
     * @return Valid agent object with id
     */
    Agent createAgent(Agent agent);

    /***
     *  Update agent data fields
     * @param agent must be a valid agent object with valid id
     * @return Updated agent object
     */
    Agent updateAgent(Agent agent);

    /***
     *
     * @return List of all agents
     */
    List<Agent> findAllAgents();

    /***
     * @param upravnikId valid upravnik UUID
     * @return List of all agents provided by valid upravnik UUID
     */
    List<Agent> findAllAgentsByUpravnikId(UUID upravnikId);


    /***
     * @param agentId valid agent UUID
     * @return Agent with provided agentId if one exists
     */
    Optional<Agent> findAgentById(UUID agentId);

    /***
     *
     * @param email address of an existing agent
     * @return Agent with provided email if one exists
     */
    Optional<Agent> findAgentByEmail(String email);

    /***
     * Delete agent with specified id
     * @param id must be a valid
     */
    void deleteAgent(UUID id);

    /***
     * Updates the password
     * @param principalId must be a valid principalId
     * @param password valid password string
     */
    void updatePassword(String principalId, String password);

    Optional<Agent> findAgentByPrincipalId(String principalId);
}
