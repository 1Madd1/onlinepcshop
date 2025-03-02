package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.RamDto;
import com.onlinepcshop.adapters.rest.mapper.RamMapperApi;
import com.onlinepcshop.core.domain.entity.Ram;
import com.onlinepcshop.core.error.exception.RamAlreadyExistsException;
import com.onlinepcshop.core.usecase.RamUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("ram")
@RequiredArgsConstructor
public class RamController {

    private final RamUseCase ramUseCase;

    @GetMapping("/{id}")
    public RamDto getById(@PathVariable(name = "id") UUID ramId) {
        System.out.println("RamController.geyById with id: " + ramId + " called");
        Optional<Ram> ram = ramUseCase.findRamById(ramId);
        if (ram.isEmpty()) {
            System.out.println("Ram with id " + ramId + " not found");
            return null;
        }
        return RamMapperApi.INSTANCE.ramToRamDto(ram.get());
    }

    @PostMapping
    public RamDto createRam(@RequestBody RamDto ramDto) {
        System.out.println("RamController.createRam called - " + ramDto);

        for (Ram ram : ramUseCase.findAllRams()) {
            if (ramDto.getComponentName().equals(ram.getComponentName())) {
                System.out.println("Ram " + ramDto.getComponentName() + " already exists");
                throw new RamAlreadyExistsException("Ram " + ramDto.getComponentName() + " already exists");
            }
        }

        Ram createdRam = ramUseCase.createRam(RamMapperApi.INSTANCE.ramDtoToRam(ramDto));
        return RamMapperApi.INSTANCE.ramToRamDto(createdRam);
    }

    @PutMapping
    public RamDto updateRam(@RequestBody RamDto ramDto) {
        System.out.println("RamController.updateRam called - " + ramDto);

        Ram updatedRam = ramUseCase.updateRam(RamMapperApi.INSTANCE.ramDtoToRam(ramDto));
        return RamMapperApi.INSTANCE.ramToRamDto(updatedRam);
    }

    @DeleteMapping
    public void deleteRamById(@RequestParam UUID ramId) {
        System.out.println("RamController.deleteRamById called for ramId - " + ramId);
        ramUseCase.deleteRam(ramId);
    }

    @GetMapping
    public List<RamDto> findAll() {
        System.out.println("RamController.findAll called");
        return RamMapperApi.INSTANCE.ramListToRamDtoList(ramUseCase.findAllRams());
    }

    @GetMapping("/find-all-available")
    public List<RamDto> findAllAvailableRams() {
        System.out.println("RamController.findAllAvailableRams called");
        return RamMapperApi.INSTANCE.ramListToRamDtoList(ramUseCase.findAllAvailableRams());
    }

    @GetMapping("/find-by-max-price-and-memory-type")
    public List<RamDto> findAllRamsByMaxPrice(@RequestParam Map<String, String> paramMap) {
        System.out.println("RamController.findAllRamsByMaxPrice called");
        Double maxPrice = Double.valueOf(paramMap.get("maxPrice"));
        String memoryType = paramMap.get("memoryType");
        return RamMapperApi.INSTANCE.ramListToRamDtoList(ramUseCase.findAllRamsByMaxPriceAndMemoryType(maxPrice, memoryType));
    }

    @GetMapping("/find-by-computer-id")
    public List<RamDto> findAllRamsByComputerId(@RequestParam Map<String, String> paramMap) {
        System.out.println("RamController.findAllRamsByComputerId called");
        UUID computerId = UUID.fromString(paramMap.get("computerId"));
        return RamMapperApi.INSTANCE.ramListToRamDtoList(ramUseCase.findAllRamsByComputerId(computerId));
    }

    @GetMapping("/find-quantity-by-ram-id-and-computer-id")
    public Integer findQuantityByRamIdAndComputerId(@RequestParam Map<String, String> paramMap) {
        System.out.println("RamController.findAllRamsByComputerId called");
        UUID ramId = UUID.fromString(paramMap.get("ramId"));
        UUID computerId = UUID.fromString(paramMap.get("computerId"));
        return ramUseCase.findQuantityByRamIdAndComputerId(ramId, computerId);
    }

    @GetMapping("/search-by-name")
    public List<RamDto> searchByName(@RequestParam Map<String, String> paramMap) {
        System.out.println("RamController.searchByName called");
        String name = paramMap.get("name");
        return RamMapperApi.INSTANCE.ramListToRamDtoList(ramUseCase.searchByName(name));
    }

    @GetMapping("/get-ram-average-rating")
    public Double getRamAverageRating(@RequestParam Map<String, String> paramMap) {
        System.out.println("RamController.getRamAverageRating called");
        UUID ramId = UUID.fromString(paramMap.get("ramId"));
        return ramUseCase.getRamAverageRating(ramId);
    }

}
