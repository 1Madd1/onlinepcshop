package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.GpuDto;
import com.onlinepcshop.adapters.rest.dto.StorageDto;
import com.onlinepcshop.adapters.rest.dto.StorageDto;
import com.onlinepcshop.adapters.rest.dto.StorageInterfaceDto;
import com.onlinepcshop.adapters.rest.mapper.*;
import com.onlinepcshop.core.domain.entity.ComputerCase;
import com.onlinepcshop.core.domain.entity.MotherboardStorageInterface;
import com.onlinepcshop.core.domain.entity.Storage;
import com.onlinepcshop.core.domain.entity.StorageInterface;
import com.onlinepcshop.core.error.exception.StorageAlreadyExistsException;
import com.onlinepcshop.core.usecase.StorageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("storage")
@RequiredArgsConstructor
public class StorageController {

    private final StorageUseCase storageUseCase;

    @GetMapping("/{id}")
    public StorageDto getById(@PathVariable(name = "id") UUID storageId) {
        System.out.println("StorageController.geyById with id: " + storageId + " called");
        Optional<Storage> storage = storageUseCase.findStorageById(storageId);
        if(storage.isEmpty()) {
            System.out.println("Storage with id " + storageId + " not found");
            return null;
        }
        return StorageMapperApi.INSTANCE.storageToStorageDto(storage.get());
    }

    @PostMapping
    public StorageDto createStorage(@RequestBody StorageDto storageDto) {
        System.out.println("StorageController.createStorage called - " + storageDto);

        for (Storage cc : storageUseCase.findAllStorages()) {
            if (storageDto.getComponentName().equals(cc.getComponentName())){
                System.out.println("Storage " + storageDto.getComponentName() + " already exists");
                throw new StorageAlreadyExistsException("Storage " + storageDto.getComponentName() + " already exists");
            }
        }

        Storage createdStorage = storageUseCase.createStorage(StorageMapperApi.INSTANCE.storageDtoToStorage(storageDto));
        return StorageMapperApi.INSTANCE.storageToStorageDto(createdStorage);
    }

    @PutMapping
    public StorageDto updateStorage(@RequestBody StorageDto storageDto) {
        System.out.println("StorageController.updateStorage called - " + storageDto);

        Storage updatedStorage = storageUseCase.updateStorage(StorageMapperApi.INSTANCE.storageDtoToStorage(storageDto));
        return StorageMapperApi.INSTANCE.storageToStorageDto(updatedStorage);
    }

    @DeleteMapping
    public void deleteStorageById(@RequestParam UUID storageId) {
        System.out.println("StorageController.deleteStorageById called for storageId - " + storageId);
        storageUseCase.deleteStorage(storageId);
    }

    @GetMapping
    public List<StorageDto> findAll() {
        System.out.println("StorageController.findAll called");
        return StorageMapperApi.INSTANCE.storageListToStorageDtoList(storageUseCase.findAllStorages());
    }

    @GetMapping("/find-by-max-price-and-motherboard-id")
    public List<StorageDto> findAllStoragesByMaxPriceAndMotherboardId(@RequestParam Map<String, String> paramMap) {
        System.out.println("StorageController.findAllStoragesByMaxPriceAndMotherboardId called");
        Double maxPrice = Double.valueOf(paramMap.get("maxPrice"));
        UUID motherboardId = UUID.fromString(paramMap.get("motherboardId"));
        return StorageMapperApi.INSTANCE.storageListToStorageDtoList(storageUseCase.findAllStoragesByMaxPriceAndMotherboard(maxPrice, motherboardId));
    }

    @GetMapping("/find-by-computer-id")
    public List<StorageDto> findAllStoragesByComputerId(@RequestParam Map<String, String> paramMap) {
        System.out.println("StorageController.findAllStoragesByComputerId called");
        UUID computerId = UUID.fromString(paramMap.get("computerId"));
        return StorageMapperApi.INSTANCE.storageListToStorageDtoList(storageUseCase.findAllStoragesByComputerId(computerId));
    }

    @GetMapping("/find-quantity-by-storage-id-and-computer-id")
    public Integer findQuantityByStorageIdAndComputerId(@RequestParam Map<String, String> paramMap) {
        System.out.println("StorageController.findAllStoragesByComputerId called");
        UUID storageId = UUID.fromString(paramMap.get("storageId"));
        UUID computerId = UUID.fromString(paramMap.get("computerId"));
        return storageUseCase.findQuantityByStorageIdAndComputerId(storageId, computerId);
    }

}
