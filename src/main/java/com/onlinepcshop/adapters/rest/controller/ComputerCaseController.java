package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.ComputerCaseDto;
import com.onlinepcshop.adapters.rest.dto.MotherboardDto;
import com.onlinepcshop.adapters.rest.mapper.ComputerCaseMapperApi;
import com.onlinepcshop.adapters.rest.mapper.MotherboardMapperApi;
import com.onlinepcshop.core.domain.entity.CaseFan;
import com.onlinepcshop.core.domain.entity.ComputerCase;
import com.onlinepcshop.core.error.exception.ComputerCaseAlreadyExistsException;
import com.onlinepcshop.core.usecase.ComputerCaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("computer-case")
@RequiredArgsConstructor
public class ComputerCaseController {

    private final ComputerCaseUseCase computerCaseUseCase;

    @GetMapping("/{id}")
    public ComputerCaseDto getById(@PathVariable(name = "id") UUID computerCaseId) {
        System.out.println("ComputerCaseController.geyById with id: " + computerCaseId + " called");
        Optional<ComputerCase> computerCase = computerCaseUseCase.findComputerCaseById(computerCaseId);
        if(computerCase.isEmpty()) {
            System.out.println("ComputerCase with id " + computerCaseId + " not found");
            return null;
        }
        return ComputerCaseMapperApi.INSTANCE.computerCaseToComputerCaseDto(computerCase.get());
    }

    @PostMapping
    public ComputerCaseDto createComputerCase(@RequestBody ComputerCaseDto computerCaseDto) {
        System.out.println("ComputerCaseController.createComputerCase called - " + computerCaseDto);

        for (ComputerCase cc : computerCaseUseCase.findAllComputerCases()) {
            if (computerCaseDto.getComponentName().equals(cc.getComponentName())){
                System.out.println("Computer case " + computerCaseDto.getComponentName() + " already exists");
                throw new ComputerCaseAlreadyExistsException("Computer case " + computerCaseDto.getComponentName() + " already exists");
            }
        }

        ComputerCase createdComputerCase = computerCaseUseCase.createComputerCase(ComputerCaseMapperApi.INSTANCE.computerCaseDtoToComputerCase(computerCaseDto));
        return ComputerCaseMapperApi.INSTANCE.computerCaseToComputerCaseDto(createdComputerCase);
    }

    @PutMapping
    public ComputerCaseDto updateComputerCase(@RequestBody ComputerCaseDto computerCaseDto) {
        System.out.println("ComputerCaseController.updateComputerCase called - " + computerCaseDto);

        ComputerCase updatedComputerCase = computerCaseUseCase.updateComputerCase(ComputerCaseMapperApi.INSTANCE.computerCaseDtoToComputerCase(computerCaseDto));
        return ComputerCaseMapperApi.INSTANCE.computerCaseToComputerCaseDto(updatedComputerCase);
    }

    @DeleteMapping
    public void deleteComputerCaseById(@RequestParam UUID computerCaseId) {
        System.out.println("ComputerCaseController.deleteComputerCaseById called for computerCaseId - " + computerCaseId);
        computerCaseUseCase.deleteComputerCase(computerCaseId);
    }

    @GetMapping
    public List<ComputerCaseDto> findAll() {
        System.out.println("ComputerCaseController.findAll called");
        return ComputerCaseMapperApi.INSTANCE.computerCaseListToComputerCaseDtoList(computerCaseUseCase.findAllComputerCases());
    }

    @GetMapping("/find-by-max-price")
    public List<ComputerCaseDto> findAllComputerCasesByMaxPrice(@RequestParam Map<String, String> paramMap) {
        System.out.println("ComputerCaseController.findAllComputerCasesByMaxPrice called");
        Double maxPrice = Double.valueOf(paramMap.get("maxPrice"));
        return ComputerCaseMapperApi.INSTANCE.computerCaseListToComputerCaseDtoList(computerCaseUseCase.findAllComputerCasesByMaxPrice(maxPrice));
    }

}
