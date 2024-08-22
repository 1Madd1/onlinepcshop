package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.MotherboardDto;
import com.onlinepcshop.adapters.rest.mapper.MotherboardMapperApi;
import com.onlinepcshop.core.domain.entity.Motherboard;
import com.onlinepcshop.core.usecase.MotherboardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("motherboard")
@RequiredArgsConstructor
public class MotherboardController {

    private final MotherboardUseCase motherboardUseCase;

    @GetMapping("/{id}")
    public MotherboardDto getById(@PathVariable(name = "id") UUID motherboardId) {
        System.out.println("MotherboardController.geyById with id: " + motherboardId + " called");
        Optional<Motherboard> motherboard = motherboardUseCase.findMotherboardById(motherboardId);
        if(motherboard.isEmpty()) {
            System.out.println("Motherboard with id " + motherboardId + " not found");
            return null;
        }
        return MotherboardMapperApi.INSTANCE.motherboardToMotherboardDto(motherboard.get());
    }

    @PostMapping
    public MotherboardDto createMotherboard(@RequestBody MotherboardDto motherboardDto) {
        System.out.println("MotherboardController.createMotherboard called - " + motherboardDto);

        Motherboard createdMotherboard = motherboardUseCase.createMotherboard(MotherboardMapperApi.INSTANCE.motherboardDtoToMotherboard(motherboardDto));
        return MotherboardMapperApi.INSTANCE.motherboardToMotherboardDto(createdMotherboard);
    }

    @PutMapping
    public MotherboardDto updateMotherboard(@RequestBody MotherboardDto motherboardDto) {
        System.out.println("MotherboardController.updateMotherboard called - " + motherboardDto);

        Motherboard updatedMotherboard = motherboardUseCase.updateMotherboard(MotherboardMapperApi.INSTANCE.motherboardDtoToMotherboard(motherboardDto));
        return MotherboardMapperApi.INSTANCE.motherboardToMotherboardDto(updatedMotherboard);
    }

    @DeleteMapping
    public void deleteMotherboardById(@RequestParam UUID motherboardId) {
        System.out.println("MotherboardController.deleteMotherboardById called for motherboardId - " + motherboardId);
        motherboardUseCase.deleteMotherboard(motherboardId);
    }

    @GetMapping
    public List<MotherboardDto> findAll() {
        System.out.println("MotherboardController.findAll called");
        return MotherboardMapperApi.INSTANCE.motherboardListToMotherboardDtoList(motherboardUseCase.findAllMotherboards());
    }

}
