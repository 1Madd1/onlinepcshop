//package com.onlinepcshop.adapters.persistance.repository;
//
//import com.onlinepcshop.adapters.persistance.dao.AgentDao;
//import com.onlinepcshop.adapters.persistance.mapper.AgentMapperDB;
//import com.onlinepcshop.adapters.persistance.repository.jpa.AgentJpaRepository;
//import com.onlinepcshop.core.domain.entity.Agent;
//import com.onlinepcshop.core.repository.AgentRepository;
//import lombok.Builder;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Builder
//public class AgentRepositoryImpl implements AgentRepository {
//    private AgentJpaRepository agentJpaRepository;
//
//    @Override
//    public List<Agent> findAllAgents() {
//        return AgentMapperDB.INSTANCE.agentDaoListToAgentList(agentJpaRepository.findAll());
//    }
//
//    @Override
//    public List<Agent> findAllAgentsByUpravnikId(UUID upravnikId) {
//        return AgentMapperDB.INSTANCE.agentDaoListToAgentList(agentJpaRepository.findAllByUpravnikId(upravnikId));
//    }
//
//    @Override
//    public Optional<Agent> findById(UUID agentId) {
//        Agent agent = AgentMapperDB.INSTANCE.agentDaoToAgent(agentJpaRepository.findById(agentId).orElse(null));
//        return Optional.ofNullable(agent);
//    }
//
//    @Override
//    public Optional<Agent> findAgentByEmail(String email) {
//        Agent agent = AgentMapperDB.INSTANCE.agentDaoToAgent(agentJpaRepository.findByEmail(email).orElse(null));
//        return Optional.ofNullable(agent);
//    }
//
//    @Override
//    public Agent saveAgent(Agent agent) {
//        AgentDao agentDao = AgentMapperDB.INSTANCE.agentToAgentDao(agent);
//        return AgentMapperDB.INSTANCE.agentDaoToAgent(agentJpaRepository.save(agentDao));
//    }
//
//    @Override
//    public void deleteAgent(UUID id) {
//        agentJpaRepository.deleteById(id);
//    }
//
//    @Override
//    public Optional<Agent> findAgentByPrincipalId(String principalId) {
//        Agent agent = AgentMapperDB.INSTANCE.agentDaoToAgent(agentJpaRepository.findByPrincipalId(principalId).orElse(null));
//        return Optional.ofNullable(agent);
//    }
//}
