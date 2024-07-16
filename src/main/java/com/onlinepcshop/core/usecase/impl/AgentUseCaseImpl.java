package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.Agent;
import com.onlinepcshop.core.repository.AgentRepository;
import com.onlinepcshop.core.security.Role;
import com.onlinepcshop.core.security.SecurityProvider;
import com.onlinepcshop.core.usecase.AgentUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Builder
public class AgentUseCaseImpl implements AgentUseCase {
    private final AgentRepository agentRepository;
    private final SecurityProvider securityProvider;

//    @Override
//    public Agent createAgent(Agent agent) {
//        String principalId = securityProvider.createPrincipal(agent);
//        securityProvider.assignRoles(principalId, Role.UNKNOWN);
//        agent.setPrincipalId(principalId);
//        return agentRepository.saveAgent(agent);
//    }

    @Override
    public Agent createAgent(Agent agent) {
        return null;
    }

    @Override
    public Agent updateAgent(Agent agent) {
        securityProvider.updatePrincipal(agent.getPrincipalId(), agent.getEmail());
        return agentRepository.saveAgent(agent);
    }

    @Override
    public List<Agent> findAllAgents() {
        return agentRepository.findAllAgents();
    }

    @Override
    public List<Agent> findAllAgentsByUpravnikId(UUID upravnikId) {
        return agentRepository.findAllAgentsByUpravnikId(upravnikId);
    }

    @Override
    public Optional<Agent> findAgentById(UUID agentId) {
        return agentRepository.findById(agentId);
    }

    @Override
    public Optional<Agent> findAgentByEmail(String email) {
        return agentRepository.findAgentByEmail(email);
    }

    @Override
    public void deleteAgent(UUID id) {
        agentRepository.deleteAgent(id);
    }

    @Override
    public void updatePassword(String principalId, String password) {
        securityProvider.changePassword(principalId, password);
    }

    @Override
    public Optional<Agent> findAgentByPrincipalId(String principalId) {
        return agentRepository.findAgentByPrincipalId(principalId);
    }
}
