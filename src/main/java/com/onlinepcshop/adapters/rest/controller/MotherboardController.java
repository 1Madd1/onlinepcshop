package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.*;
import com.onlinepcshop.adapters.rest.dto.request.MotherboardWithInterfacesRequest;
import com.onlinepcshop.adapters.rest.dto.response.MotherboardWithInterfacesResponse;
import com.onlinepcshop.adapters.rest.mapper.MotherboardMapperApi;
import com.onlinepcshop.core.domain.entity.ComputerCase;
import com.onlinepcshop.core.domain.entity.Motherboard;
import com.onlinepcshop.core.error.exception.MotherboardAlreadyExistsException;
import com.onlinepcshop.core.usecase.MotherboardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
    public MotherboardWithInterfacesResponse createMotherboard(@RequestBody MotherboardWithInterfacesRequest motherboardWithInterfacesRequest) {
        System.out.println("MotherboardController.createMotherboard called - " + motherboardWithInterfacesRequest);

        for (Motherboard cc : motherboardUseCase.findAllMotherboards()) {
            if (motherboardWithInterfacesRequest.getMotherboard().getComponentName().equals(cc.getComponentName())){
                System.out.println("Motherboard " + motherboardWithInterfacesRequest.getMotherboard().getComponentName() + " already exists");
                throw new MotherboardAlreadyExistsException("Motherboard " + motherboardWithInterfacesRequest.getMotherboard().getComponentName() + " already exists");
            }
        }

        Motherboard createdMotherboard = motherboardUseCase.createMotherboard(MotherboardMapperApi.INSTANCE.motherboardDtoToMotherboard(motherboardWithInterfacesRequest.getMotherboard()));
        for(PcieInterfaceDto pid : motherboardWithInterfacesRequest.getPcieInterfaceList()) {
            System.out.println("PID:" + pid);
            System.out.println("Created Motherboard:" + createdMotherboard);
            motherboardUseCase.assignPcieInterface(pid.getId(), createdMotherboard.getId());
        }
        for(StorageInterfaceDto sid : motherboardWithInterfacesRequest.getStorageInterfaceList()) {
            System.out.println("SID:" + sid);
            System.out.println("Created Motherboard:" + createdMotherboard);
            motherboardUseCase.assignStorageInterface(sid.getId(), createdMotherboard.getId());
        }

        MotherboardWithInterfacesResponse motherboardWithInterfacesResponse = MotherboardWithInterfacesResponse.builder()
                .motherboard(MotherboardMapperApi.INSTANCE.motherboardToMotherboardDto(createdMotherboard))
                .pcieInterfaceList(motherboardWithInterfacesRequest.getPcieInterfaceList())
                .storageInterfaceList(motherboardWithInterfacesRequest.getStorageInterfaceList())
                .build();
        return motherboardWithInterfacesResponse;
    }

    @PutMapping
    public MotherboardWithInterfacesResponse updateMotherboard(@RequestBody MotherboardWithInterfacesRequest motherboardWithInterfacesRequest) {
        System.out.println("MotherboardController.updateMotherboard called - " + motherboardWithInterfacesRequest);

        Motherboard updatedMotherboard = motherboardUseCase.updateMotherboard(MotherboardMapperApi.INSTANCE.motherboardDtoToMotherboard(motherboardWithInterfacesRequest.getMotherboard()));

        if(!motherboardWithInterfacesRequest.getPcieInterfacesToBeRemovedList().isEmpty()) {
            for(MotherboardPcieInterfaceDto motherboardPcieInterfaceDto : motherboardWithInterfacesRequest.getPcieInterfacesToBeRemovedList()) {
                motherboardUseCase.unassignPcieInterface(motherboardPcieInterfaceDto.getPcieInterfaceId(), motherboardPcieInterfaceDto.getMotherboardId());
            }
        }

        if(!motherboardWithInterfacesRequest.getStorageInterfacesToBeRemovedList().isEmpty()) {
            for (MotherboardStorageInterfaceDto motherboardStorageInterfaceDto : motherboardWithInterfacesRequest.getStorageInterfacesToBeRemovedList()) {
                motherboardUseCase.unassignStorageInterface(motherboardStorageInterfaceDto.getStorageInterfaceId(), motherboardStorageInterfaceDto.getMotherboardId());
            }
        }

        for(PcieInterfaceDto pid : motherboardWithInterfacesRequest.getPcieInterfaceList()) {
            System.out.println("PID:" + pid);
            System.out.println("Updated Motherboard:" + updatedMotherboard);
            motherboardUseCase.assignPcieInterface(pid.getId(), updatedMotherboard.getId());
        }
        for(StorageInterfaceDto sid : motherboardWithInterfacesRequest.getStorageInterfaceList()) {
            System.out.println("SID:" + sid);
            System.out.println("Updated Motherboard:" + updatedMotherboard);
            motherboardUseCase.assignStorageInterface(sid.getId(), updatedMotherboard.getId());
        }

        MotherboardWithInterfacesResponse motherboardWithInterfacesResponse = MotherboardWithInterfacesResponse.builder()
                .motherboard(MotherboardMapperApi.INSTANCE.motherboardToMotherboardDto(updatedMotherboard))
                .pcieInterfaceList(motherboardWithInterfacesRequest.getPcieInterfaceList())
                .storageInterfaceList(motherboardWithInterfacesRequest.getStorageInterfaceList())
                .build();
        return motherboardWithInterfacesResponse;
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

    @GetMapping("/find-by-max-price-and-storage-interface-limit")
    public List<MotherboardDto> findAllMotherboardsByMaxPriceAndByStorageInterfaceLimit(@RequestParam Map<String, String> paramMap) {
        System.out.println("MotherboardController.findAllMotherboardsByMaxPriceAndByStorageInterfaceLimit called");
        System.out.println(paramMap);
        Double maxPrice = Double.valueOf(paramMap.get("maxPrice"));
        Integer storageInterfaceLimit = Integer.valueOf(paramMap.get("storageInterfaceLimit"));
        return MotherboardMapperApi.INSTANCE.motherboardListToMotherboardDtoList(motherboardUseCase.findAllMotherboardsByMaxPriceAndByStorageInterfaceLimit(maxPrice, storageInterfaceLimit));
    }

}
