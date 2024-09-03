package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.CoolerDto;
import com.onlinepcshop.adapters.rest.mapper.CoolerMapperApi;
import com.onlinepcshop.core.domain.entity.Cooler;
import com.onlinepcshop.core.usecase.CoolerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("cooler")
@RequiredArgsConstructor
public class CoolerController {

    private final CoolerUseCase coolerUseCase;

    @GetMapping("/{id}")
    public CoolerDto getById(@PathVariable(name = "id") UUID cpuCoolerId) {
        System.out.println("CpuCoolerController.geyById with id: " + cpuCoolerId + " called");
        Optional<Cooler> cpuCooler = coolerUseCase.findCoolerById(cpuCoolerId);
        if(cpuCooler.isEmpty()) {
            System.out.println("CpuCooler with id " + cpuCoolerId + " not found");
            return null;
        }
        return CoolerMapperApi.INSTANCE.cpuCoolerToCpuCoolerDto(cpuCooler.get());
    }

    @PostMapping
    public CoolerDto createCpuCooler(@RequestBody CoolerDto coolerDto) {
        System.out.println("CpuCoolerController.createCpuCooler called - " + coolerDto);

        Cooler createdCooler = coolerUseCase.createCooler(CoolerMapperApi.INSTANCE.cpuCoolerDtoToCpuCooler(coolerDto));
        return CoolerMapperApi.INSTANCE.cpuCoolerToCpuCoolerDto(createdCooler);
    }

    @PutMapping
    public CoolerDto updateCpuCooler(@RequestBody CoolerDto coolerDto) {
        System.out.println("CpuCoolerController.updateCpuCooler called - " + coolerDto);

        Cooler updatedCooler = coolerUseCase.updateCooler(CoolerMapperApi.INSTANCE.cpuCoolerDtoToCpuCooler(coolerDto));
        return CoolerMapperApi.INSTANCE.cpuCoolerToCpuCoolerDto(updatedCooler);
    }

    @DeleteMapping
    public void deleteCpuCoolerById(@RequestParam UUID cpuCoolerId) {
        System.out.println("CpuCoolerController.deleteCpuCoolerById called for cpuCoolerId - " + cpuCoolerId);
        coolerUseCase.deleteCooler(cpuCoolerId);
    }

    @GetMapping
    public List<CoolerDto> findAll() {
        System.out.println("CpuCoolerController.findAll called");
        return CoolerMapperApi.INSTANCE.cpuCoolerListToCpuCoolerDtoList(coolerUseCase.findAllCoolers());
    }

}
