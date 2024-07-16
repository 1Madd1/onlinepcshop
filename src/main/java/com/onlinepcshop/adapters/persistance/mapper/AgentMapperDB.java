package com.onlinepcshop.adapters.persistance.mapper;

import com.onlinepcshop.adapters.persistance.dao.AgentDao;
import com.onlinepcshop.core.domain.entity.Agent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AgentMapperDB {
    AgentMapperDB INSTANCE = Mappers.getMapper(AgentMapperDB.class);

    AgentDao agentToAgentDao(Agent agent);

    Agent agentDaoToAgent(AgentDao agentDao);

    List<AgentDao> agentListToAgentDaoList(List<Agent> agentList);
    List<Agent> agentDaoListToAgentList(List<AgentDao> agentDaoList);

}
