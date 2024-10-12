package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.CpuDto;
import com.onlinepcshop.adapters.rest.mapper.CpuMapperApi;
import com.onlinepcshop.core.domain.entity.Cpu;
import com.onlinepcshop.core.error.exception.CpuAlreadyExistsException;
import com.onlinepcshop.core.usecase.CpuUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("cpu")
@RequiredArgsConstructor
public class CpuController {

    private final CpuUseCase cpuUseCase;

    @GetMapping("/{id}")
    public CpuDto getById(@PathVariable(name = "id") UUID cpuId) {
        System.out.println("CpuController.geyById with id: " + cpuId + " called");
        Optional<Cpu> cpu = cpuUseCase.findCpuById(cpuId);
        if(cpu.isEmpty()) {
            System.out.println("Cpu with id " + cpuId + " not found");
            return null;
        }
        return CpuMapperApi.INSTANCE.cpuToCpuDto(cpu.get());
    }

    @PostMapping
    public CpuDto createCpu(@RequestBody CpuDto cpuDto) {
        System.out.println("CpuController.createCpu called - " + cpuDto);

        for (Cpu c : cpuUseCase.findAllCpus()) {
            if (cpuDto.getComponentName().equals(c.getComponentName())){
                System.out.println("Cpu " + cpuDto.getComponentName() + " already exists");
                throw new CpuAlreadyExistsException("Cpu " + cpuDto.getComponentName() + " already exists");
            }
        }

        Cpu createdCpu = cpuUseCase.createCpu(CpuMapperApi.INSTANCE.cpuDtoToCpu(cpuDto));
        return CpuMapperApi.INSTANCE.cpuToCpuDto(createdCpu);
    }

    @PutMapping
    public CpuDto updateCpu(@RequestBody CpuDto cpuDto) {
        System.out.println("CpuController.updateCpu called - " + cpuDto);

        Cpu updatedCpu = cpuUseCase.updateCpu(CpuMapperApi.INSTANCE.cpuDtoToCpu(cpuDto));
        return CpuMapperApi.INSTANCE.cpuToCpuDto(updatedCpu);
    }

    @DeleteMapping
    public void deleteCpuById(@RequestParam UUID cpuId) {
        System.out.println("CpuController.deleteCpuById called for cpuId - " + cpuId);
        cpuUseCase.deleteCpu(cpuId);
    }

    @GetMapping
    public List<CpuDto> findAll() {
        System.out.println("CpuController.findAll called");
        return CpuMapperApi.INSTANCE.cpuListToCpuDtoList(cpuUseCase.findAllCpus());
    }

    @GetMapping("/find-by-requested-params")
    public List<CpuDto> findAllCpusByRequestedParams(@RequestParam Map<String, String> paramMap) {
//        Smisliti drugaciji nacin fetch-ovanja procesora
        System.out.println("CpuController.findAllCpusByRequestedParams called");
        Double maxPrice = Double.valueOf(paramMap.get("maxPrice"));
        Boolean includesIntegratedGpu = Boolean.valueOf(paramMap.get("includesIntegratedGpu"));
        Boolean includesCooler = Boolean.valueOf(paramMap.get("includesCooler"));
        String socketType = paramMap.get("socketType");
        return CpuMapperApi.INSTANCE.cpuListToCpuDtoList(cpuUseCase.findAllCpusByMaxPriceAndSocketTypeIncludesCoolerAndIntegratedGpu(maxPrice, socketType, includesCooler, includesIntegratedGpu));
    }
}
