//package com.onlinepcshop.adapters.rest.mapper;
//
//import com.onlinepcshop.adapters.rest.dto.AgentDto;
//import com.onlinepcshop.core.domain.entity.Agent;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Named;
//import org.mapstruct.factory.Mappers;
//
//import java.util.List;
//import java.util.UUID;
//
//@Mapper
//public interface AgentMapperApi {
//    AgentMapperApi INSTANCE = Mappers.getMapper(AgentMapperApi.class);
//
//    @Named("upravnikToUpravnikId")
//    default UUID upravnikToUpravnikId(Upravnik upravnik) {
//        return upravnik == null ? null : upravnik.getId();
//    }
//
//    @Named("upravnikIdToUpravnik")
//    default Upravnik upravnikIdToUpravnik(UUID upravnikID) {
//        return Upravnik.builder()
//                .id(upravnikID)
//                .build();
//    }
//
//    @Mapping(source = "upravnik", target = "upravnikId", qualifiedByName = "upravnikToUpravnikId")
//    AgentDto agentToAgentDto(Agent agent);
//
//    @Mapping(source = "upravnikId", target = "upravnik", qualifiedByName = "upravnikIdToUpravnik")
//    Agent agentDtoToAgent(AgentDto agentDto);
//
//    List<AgentDto> agentListToAgentDtoList(List<Agent> agentList);
//    List<Agent> agentDtoListToAgentList(List<AgentDto> agentDtoList);
//}
