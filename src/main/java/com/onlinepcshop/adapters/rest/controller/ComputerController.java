package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.ComputerCaseFanDto;
import com.onlinepcshop.adapters.rest.dto.ComputerDto;
import com.onlinepcshop.adapters.rest.dto.ComputerRamDto;
import com.onlinepcshop.adapters.rest.dto.ComputerStorageDto;
import com.onlinepcshop.adapters.rest.dto.request.ComputerCreationRequest;
import com.onlinepcshop.adapters.rest.dto.response.ComputerCreationResponse;
import com.onlinepcshop.adapters.rest.mapper.ComputerMapperApi;
import com.onlinepcshop.core.domain.entity.Computer;
import com.onlinepcshop.core.error.exception.ComputerAlreadyExistsException;
import com.onlinepcshop.core.usecase.ComputerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("computer")
@RequiredArgsConstructor
public class ComputerController {

    private final ComputerUseCase computerUseCase;

    @GetMapping("/{id}")
    public ComputerDto getById(@PathVariable(name = "id") UUID computerId) {
        System.out.println("ComputerController.geyById with id: " + computerId + " called");
        Optional<Computer> computer = computerUseCase.findComputerById(computerId);
        if (computer.isEmpty()) {
            System.out.println("Computer with id " + computerId + " not found");
            return null;
        }
        return ComputerMapperApi.INSTANCE.computerToComputerDto(computer.get());
    }

    @PostMapping
    public ComputerCreationResponse createComputer(@RequestBody ComputerCreationRequest computerCreationRequest) {
        System.out.println("ComputerController.createComputer called - " + computerCreationRequest);

        for (Computer c : computerUseCase.findAllComputers()) {
            if (computerCreationRequest.getComputer().equals(c)) {
                System.out.println("Computer " + computerCreationRequest.getComputer().getComputerName() + " already exists");
                throw new ComputerAlreadyExistsException("Computer " + computerCreationRequest.getComputer().getComputerName() + " already exists");
            }
        }

        Computer createdComputer = computerUseCase.createComputer(ComputerMapperApi.INSTANCE.computerDtoToComputer(computerCreationRequest.getComputer()));
        if (createdComputer != null) {
            System.out.println("Computer with id " + createdComputer.getId() + " created");

            for (ComputerRamDto crd : computerCreationRequest.getComputerRamList()) {
                computerUseCase.assignRam(crd.getRamId(), createdComputer.getId(), crd.getQuantity());
            }

            for (ComputerStorageDto csd : computerCreationRequest.getComputerStorageList()) {
                computerUseCase.assignStorage(csd.getStorageId(), createdComputer.getId(), csd.getQuantity());
            }

            for (ComputerCaseFanDto ccfd : computerCreationRequest.getComputerCaseFanList()) {
                computerUseCase.assignCaseFan(ccfd.getCaseFanId(), createdComputer.getId(), ccfd.getQuantity());
            }
        }

        ComputerCreationResponse computerCreationResponse = ComputerCreationResponse.builder()
                .computer(ComputerMapperApi.INSTANCE.computerToComputerDto(createdComputer))
                .computerRamList(computerCreationRequest.getComputerRamList())
                .computerStorageList(computerCreationRequest.getComputerStorageList())
                .computerCaseFanList(computerCreationRequest.getComputerCaseFanList())
                .build();

        return computerCreationResponse;
    }

    @PutMapping
    public ComputerCreationResponse updateComputer(@RequestBody ComputerCreationRequest computerCreationRequest) {
        System.out.println("ComputerController.updateComputer called - " + computerCreationRequest);

        Computer updatedComputer = computerUseCase.updateComputer(ComputerMapperApi.INSTANCE.computerDtoToComputer(computerCreationRequest.getComputer()));

        if (!computerCreationRequest.getComputerRamsToBeRemovedList().isEmpty()) {
            for (ComputerRamDto crd : computerCreationRequest.getComputerRamsToBeRemovedList()) {
                computerUseCase.unassignRam(crd.getRamId(), crd.getComputerId());
            }
        }

        if (!computerCreationRequest.getComputerStoragesToBeRemovedList().isEmpty()) {
            for (ComputerStorageDto csd : computerCreationRequest.getComputerStoragesToBeRemovedList()) {
                computerUseCase.unassignStorage(csd.getStorageId(), csd.getComputerId());
            }
        }

        if (updatedComputer != null) {
            System.out.println("Computer with id " + updatedComputer.getId() + " updated");

            for (ComputerRamDto crd : computerCreationRequest.getComputerRamList()) {
                computerUseCase.assignRam(crd.getRamId(), updatedComputer.getId(), crd.getQuantity());
            }

            for (ComputerStorageDto csd : computerCreationRequest.getComputerStorageList()) {
                computerUseCase.assignStorage(csd.getStorageId(), updatedComputer.getId(), csd.getQuantity());
            }

            for (ComputerCaseFanDto ccfd : computerCreationRequest.getComputerCaseFanList()) {
                computerUseCase.assignCaseFan(ccfd.getCaseFanId(), updatedComputer.getId(), ccfd.getQuantity());
            }
        }

        ComputerCreationResponse computerCreationResponse = ComputerCreationResponse.builder()
                .computer(ComputerMapperApi.INSTANCE.computerToComputerDto(updatedComputer))
                .computerRamList(computerCreationRequest.getComputerRamList())
                .computerStorageList(computerCreationRequest.getComputerStorageList())
                .computerCaseFanList(computerCreationRequest.getComputerCaseFanList())
                .build();

        return computerCreationResponse;
    }

    @DeleteMapping
    public void deleteComputerById(@RequestParam UUID computerId) {
        System.out.println("ComputerController.deleteComputerById called for computerId - " + computerId);
        computerUseCase.deleteComputer(computerId);
    }

    @GetMapping
    public List<ComputerDto> findAll() {
        System.out.println("ComputerController.findAll called");
        return ComputerMapperApi.INSTANCE.computerListToComputerDtoList(computerUseCase.findAllComputers());
    }

    @GetMapping("/find-all-available-by-type")
    public List<ComputerDto> findAllAvailableComputersByType(@RequestParam Map<String, String> paramMap) {
        System.out.println("ComputerController.findAllAvailableComputersByType called");
        String type = paramMap.get("type");
        return ComputerMapperApi.INSTANCE.computerListToComputerDtoList(computerUseCase.findAllAvailableComputersByType(type));
    }

    @GetMapping("/search-by-name-and-type")
    public List<ComputerDto> searchByNameAndType(@RequestParam Map<String, String> paramMap) {
        System.out.println("ComputerController.searchByNameAndType called");
        String name = paramMap.get("name");
        String type = paramMap.get("type");
        return ComputerMapperApi.INSTANCE.computerListToComputerDtoList(computerUseCase.searchByNameAndType(name, type));
    }

    @GetMapping("/get-computer-average-rating")
    public Double getComputerAverageRating(@RequestParam Map<String, String> paramMap) {
        System.out.println("ComputerController.getComputerAverageRating called");
        UUID computerId = UUID.fromString(paramMap.get("computerId"));
        return computerUseCase.getComputerAverageRating(computerId);
    }

}
