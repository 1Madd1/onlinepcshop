package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.PowerSupplyDto;
import com.onlinepcshop.adapters.rest.mapper.PowerSupplyMapperApi;
import com.onlinepcshop.core.domain.entity.PowerSupply;
import com.onlinepcshop.core.usecase.PowerSupplyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("power-supply")
@RequiredArgsConstructor
public class PowerSupplyController {

    private final PowerSupplyUseCase powerSupplyUseCase;

    @GetMapping("/{id}")
    public PowerSupplyDto getById(@PathVariable(name = "id") UUID powerSupplyId) {
        System.out.println("PowerSupplyController.geyById with id: " + powerSupplyId + " called");
        Optional<PowerSupply> powerSupply = powerSupplyUseCase.findPowerSupplyById(powerSupplyId);
        if(powerSupply.isEmpty()) {
            System.out.println("PowerSupply with id " + powerSupplyId + " not found");
            return null;
        }
        return PowerSupplyMapperApi.INSTANCE.powerSupplyToPowerSupplyDto(powerSupply.get());
    }

    @PostMapping
    public PowerSupplyDto createPowerSupply(@RequestBody PowerSupplyDto powerSupplyDto) {
        System.out.println("PowerSupplyController.createPowerSupply called - " + powerSupplyDto);

        PowerSupply createdPowerSupply = powerSupplyUseCase.createPowerSupply(PowerSupplyMapperApi.INSTANCE.powerSupplyDtoToPowerSupply(powerSupplyDto));
        return PowerSupplyMapperApi.INSTANCE.powerSupplyToPowerSupplyDto(createdPowerSupply);
    }

    @PutMapping
    public PowerSupplyDto updatePowerSupply(@RequestBody PowerSupplyDto powerSupplyDto) {
        System.out.println("PowerSupplyController.updatePowerSupply called - " + powerSupplyDto);

        PowerSupply updatedPowerSupply = powerSupplyUseCase.updatePowerSupply(PowerSupplyMapperApi.INSTANCE.powerSupplyDtoToPowerSupply(powerSupplyDto));
        return PowerSupplyMapperApi.INSTANCE.powerSupplyToPowerSupplyDto(updatedPowerSupply);
    }

    @DeleteMapping
    public void deletePowerSupplyById(@RequestParam UUID powerSupplyId) {
        System.out.println("PowerSupplyController.deletePowerSupplyById called for powerSupplyId - " + powerSupplyId);
        powerSupplyUseCase.deletePowerSupply(powerSupplyId);
    }

    @GetMapping
    public List<PowerSupplyDto> findAll() {
        System.out.println("PowerSupplyController.findAll called");
        return PowerSupplyMapperApi.INSTANCE.powerSupplyListToPowerSupplyDtoList(powerSupplyUseCase.findAllPowerSupplys());
    }

}
