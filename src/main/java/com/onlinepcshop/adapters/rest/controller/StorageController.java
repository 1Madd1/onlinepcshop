package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.StorageDto;
import com.onlinepcshop.adapters.rest.mapper.StorageMapperApi;
import com.onlinepcshop.core.domain.entity.Storage;
import com.onlinepcshop.core.usecase.StorageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

}
