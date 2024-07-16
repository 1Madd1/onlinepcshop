package com.onlinepcshop.core.repository;



import com.onlinepcshop.core.domain.entity.Agent;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AgentRepository {

    List<Agent> findAllAgents();

    List<Agent> findAllAgentsByUpravnikId(UUID upravnikId);

    Optional<Agent> findById(UUID agentId);
    Optional<Agent> findAgentByEmail(String email);
    Agent saveAgent(Agent agent);

    void deleteAgent(UUID id);

    Optional<Agent> findAgentByPrincipalId(String principalId);
}
