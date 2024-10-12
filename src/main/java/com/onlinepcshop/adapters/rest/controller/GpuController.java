package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.ComputerCaseDto;
import com.onlinepcshop.adapters.rest.dto.GpuDto;
import com.onlinepcshop.adapters.rest.mapper.ComputerCaseMapperApi;
import com.onlinepcshop.adapters.rest.mapper.GpuMapperApi;
import com.onlinepcshop.core.domain.entity.ComputerCase;
import com.onlinepcshop.core.domain.entity.Gpu;
import com.onlinepcshop.core.error.exception.GpuAlreadyExistsException;
import com.onlinepcshop.core.usecase.GpuUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("gpu")
@RequiredArgsConstructor
public class GpuController {

    private final GpuUseCase gpuUseCase;

    @GetMapping("/{id}")
    public GpuDto getById(@PathVariable(name = "id") UUID gpuId) {
        System.out.println("GpuController.geyById with id: " + gpuId + " called");
        Optional<Gpu> gpu = gpuUseCase.findGpuById(gpuId);
        if(gpu.isEmpty()) {
            System.out.println("Gpu with id " + gpuId + " not found");
            return null;
        }
        return GpuMapperApi.INSTANCE.gpuToGpuDto(gpu.get());
    }

    @PostMapping
    public GpuDto createGpu(@RequestBody GpuDto gpuDto) {
        System.out.println("GpuController.createGpu called - " + gpuDto);

        for (Gpu cc : gpuUseCase.findAllGpus()) {
            if (gpuDto.getComponentName().equals(cc.getComponentName())){
                System.out.println("Gpu " + gpuDto.getComponentName() + " already exists");
                throw new GpuAlreadyExistsException("Gpu " + gpuDto.getComponentName() + " already exists");
            }
        }

        Gpu createdGpu = gpuUseCase.createGpu(GpuMapperApi.INSTANCE.gpuDtoToGpu(gpuDto));
        return GpuMapperApi.INSTANCE.gpuToGpuDto(createdGpu);
    }

    @PutMapping
    public GpuDto updateGpu(@RequestBody GpuDto gpuDto) {
        System.out.println("GpuController.updateGpu called - " + gpuDto);

        Gpu updatedGpu = gpuUseCase.updateGpu(GpuMapperApi.INSTANCE.gpuDtoToGpu(gpuDto));
        return GpuMapperApi.INSTANCE.gpuToGpuDto(updatedGpu);
    }

    @DeleteMapping
    public void deleteGpuById(@RequestParam UUID gpuId) {
        System.out.println("GpuController.deleteGpuById called for gpuId - " + gpuId);
        gpuUseCase.deleteGpu(gpuId);
    }

    @GetMapping
    public List<GpuDto> findAll() {
        System.out.println("GpuController.findAll called");
        return GpuMapperApi.INSTANCE.gpuListToGpuDtoList(gpuUseCase.findAllGpus());
    }

    @GetMapping("/find-by-max-price-and-motherboard-id")
    public List<GpuDto> findAllGpusByMaxPriceAndMotherboardId(@RequestParam Map<String, String> paramMap) {
        System.out.println("GpuController.findAllGpusByMaxPriceAndMotherboardId called");
        Double maxPrice = Double.valueOf(paramMap.get("maxPrice"));
        UUID motherboardId = UUID.fromString(paramMap.get("motherboardId"));
        return GpuMapperApi.INSTANCE.gpuListToGpuDtoList(gpuUseCase.findAllGpusByMaxPriceAndMotherboard(maxPrice, motherboardId));
    }

}
