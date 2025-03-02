package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.PcieInterfaceDto;
import com.onlinepcshop.adapters.rest.mapper.PcieInterfaceMapperApi;
import com.onlinepcshop.core.domain.entity.PcieInterface;
import com.onlinepcshop.core.usecase.PcieInterfaceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("pcie-interface")
@RequiredArgsConstructor
public class PcieInterfaceController {

    private final PcieInterfaceUseCase pcieInterfaceUseCase;

    @GetMapping("/{id}")
    public PcieInterfaceDto getById(@PathVariable(name = "id") UUID pcieInterfaceId) {
        System.out.println("PcieInterfaceController.geyById with id: " + pcieInterfaceId + " called");
        Optional<PcieInterface> pcieInterface = pcieInterfaceUseCase.findPcieInterfaceById(pcieInterfaceId);
        if (pcieInterface.isEmpty()) {
            System.out.println("PcieInterface with id " + pcieInterfaceId + " not found");
            return null;
        }
        return PcieInterfaceMapperApi.INSTANCE.pcieInterfaceToPcieInterfaceDto(pcieInterface.get());
    }

    @PostMapping
    public PcieInterfaceDto createPcieInterface(@RequestBody PcieInterfaceDto pcieInterfaceDto) {
        System.out.println("PcieInterfaceController.createPcieInterface called - " + pcieInterfaceDto);

        PcieInterface createdPcieInterface = pcieInterfaceUseCase.createPcieInterface(PcieInterfaceMapperApi.INSTANCE.pcieInterfaceDtoToPcieInterface(pcieInterfaceDto));
        return PcieInterfaceMapperApi.INSTANCE.pcieInterfaceToPcieInterfaceDto(createdPcieInterface);
    }

    @PutMapping
    public PcieInterfaceDto updatePcieInterface(@RequestBody PcieInterfaceDto pcieInterfaceDto) {
        System.out.println("PcieInterfaceController.updatePcieInterface called - " + pcieInterfaceDto);

        PcieInterface updatedPcieInterface = pcieInterfaceUseCase.updatePcieInterface(PcieInterfaceMapperApi.INSTANCE.pcieInterfaceDtoToPcieInterface(pcieInterfaceDto));
        return PcieInterfaceMapperApi.INSTANCE.pcieInterfaceToPcieInterfaceDto(updatedPcieInterface);
    }

    @DeleteMapping
    public void deletePcieInterfaceById(@RequestParam UUID pcieInterfaceId) {
        System.out.println("PcieInterfaceController.deletePcieInterfaceById called for pcieInterfaceId - " + pcieInterfaceId);
        pcieInterfaceUseCase.deletePcieInterface(pcieInterfaceId);
    }

    @GetMapping
    public List<PcieInterfaceDto> findAll() {
        System.out.println("PcieInterfaceController.findAll called");
        return PcieInterfaceMapperApi.INSTANCE.pcieInterfaceListToPcieInterfaceDtoList(pcieInterfaceUseCase.findAllPcieInterfaces());
    }

    @GetMapping("/find-all-by-motherboard-id")
    public List<PcieInterfaceDto> findAllPcieInterfacesByMotherboardId(@RequestParam Map<String, String> paramMap) {
        System.out.println("PcieInterfaceController.findAllPcieInterfacesByMotherboardId called");
        UUID motherboardId = UUID.fromString(paramMap.get("motherboardId"));
        return PcieInterfaceMapperApi.INSTANCE.pcieInterfaceListToPcieInterfaceDtoList(pcieInterfaceUseCase.findAllPcieInterfacesByMotherboard(motherboardId));
    }

}
