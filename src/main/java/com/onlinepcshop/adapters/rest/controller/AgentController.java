//package com.onlinepcshop.adapters.rest.controller;
//
//import com.onlinepcshop.adapters.rest.dto.AgentDto;
//import com.onlinepcshop.core.domain.entity.Agent;
//import com.onlinepcshop.core.error.exception.AgentNotFoundException;
//import com.onlinepcshop.core.usecase.AgentUseCase;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@RestController()
//@RequestMapping("agent")
//@RequiredArgsConstructor
//@Data
//@Slf4j
//public class AgentController {
//    private final AgentUseCase agentUseCase;
//
//    @GetMapping("/{id}")
//    public AgentDto getById(@PathVariable(name = "id") UUID agentId) {
//        log.info("AgentController.geyById with id: {} called", agentId);
//        Optional<Agent> agent = agentUseCase.findAgentById(agentId);
//        if(agent.isEmpty()) {
//            log.info("Not found");
//            return null;
//        }
//        return AgentMapperApi.INSTANCE.agentToAgentDto(agent.get());
//    }
//
//    @GetMapping("/me")
//    public AgentDto getLoggedAgent(Principal principal) {
//        log.info("AgentController.getLoggedAgent called - principalId  {}", principal.getName());
//        Optional<Agent> agentOptional = agentUseCase.findAgentByPrincipalId(principal.getName());
//        if ( agentOptional.isEmpty()) {
//            throw new AgentNotFoundException("Agent not found for the given principal id!");
//        }
//        return AgentMapperApi.INSTANCE.agentToAgentDto(agentOptional.get());
//    }
//
//    @PostMapping
//    public AgentDto createAgent(@RequestBody AgentDto agentDto) {
//        log.info("AgentController.createAgent called - {}", agentDto);
//
//        Agent createdAgent = agentUseCase.createAgent(AgentMapperApi.INSTANCE.agentDtoToAgent(agentDto));
//        return AgentMapperApi.INSTANCE.agentToAgentDto(createdAgent);
//    }
//
//    @PutMapping
//    public AgentDto updateAgent(@RequestBody AgentDto agentDto) {
//        log.info("AgentController.updateAgent called - {}", agentDto);
//
//        Agent updatedAgent = agentUseCase.updateAgent(AgentMapperApi.INSTANCE.agentDtoToAgent(agentDto));
//        return AgentMapperApi.INSTANCE.agentToAgentDto(updatedAgent);
//    }
//
//    @DeleteMapping
//    public void deleteAgentById(@RequestParam UUID agentId) {
//        agentUseCase.deleteAgent(agentId);
//    }
//
//    @GetMapping
//    public List<AgentDto> findAll() {
//        return AgentMapperApi.INSTANCE.agentListToAgentDtoList(agentUseCase.findAllAgents());
//    }
//
//    @GetMapping("/upravnik/{id}")
//    public List<AgentDto> findAllByUpravnikId(@PathVariable(name = "id") UUID upravnikId) {
//        return AgentMapperApi.INSTANCE.agentListToAgentDtoList(agentUseCase.findAllAgentsByUpravnikId(upravnikId));
//    }
//
//}
