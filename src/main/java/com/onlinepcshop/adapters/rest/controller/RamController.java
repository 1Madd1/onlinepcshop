package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.RamDto;
import com.onlinepcshop.adapters.rest.mapper.RamMapperApi;
import com.onlinepcshop.core.domain.entity.Ram;
import com.onlinepcshop.core.usecase.RamUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        if(ram.isEmpty()) {
            System.out.println("Ram with id " + ramId + " not found");
            return null;
        }
        return RamMapperApi.INSTANCE.ramToRamDto(ram.get());
    }

    @PostMapping
    public RamDto createRam(@RequestBody RamDto ramDto) {
        System.out.println("RamController.createRam called - " + ramDto);

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

}
