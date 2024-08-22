package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.StorageInterfaceDto;
import com.onlinepcshop.adapters.rest.mapper.StorageInterfaceMapperApi;
import com.onlinepcshop.core.domain.entity.StorageInterface;
import com.onlinepcshop.core.usecase.StorageInterfaceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("storage-interface")
@RequiredArgsConstructor
public class StorageInterfaceController {

    private final StorageInterfaceUseCase storageInterfaceUseCase;

    @GetMapping("/{id}")
    public StorageInterfaceDto getById(@PathVariable(name = "id") UUID storageInterfaceId) {
        System.out.println("StorageInterfaceController.geyById with id: " + storageInterfaceId + " called");
        Optional<StorageInterface> storageInterface = storageInterfaceUseCase.findStorageInterfaceById(storageInterfaceId);
        if(storageInterface.isEmpty()) {
            System.out.println("StorageInterface with id " + storageInterfaceId + " not found");
            return null;
        }
        return StorageInterfaceMapperApi.INSTANCE.storageInterfaceToStorageInterfaceDto(storageInterface.get());
    }

    @PostMapping
    public StorageInterfaceDto createStorageInterface(@RequestBody StorageInterfaceDto storageInterfaceDto) {
        System.out.println("StorageInterfaceController.createStorageInterface called - " + storageInterfaceDto);

        StorageInterface createdStorageInterface = storageInterfaceUseCase.createStorageInterface(StorageInterfaceMapperApi.INSTANCE.storageInterfaceDtoToStorageInterface(storageInterfaceDto));
        return StorageInterfaceMapperApi.INSTANCE.storageInterfaceToStorageInterfaceDto(createdStorageInterface);
    }

    @PutMapping
    public StorageInterfaceDto updateStorageInterface(@RequestBody StorageInterfaceDto storageInterfaceDto) {
        System.out.println("StorageInterfaceController.updateStorageInterface called - " + storageInterfaceDto);

        StorageInterface updatedStorageInterface = storageInterfaceUseCase.updateStorageInterface(StorageInterfaceMapperApi.INSTANCE.storageInterfaceDtoToStorageInterface(storageInterfaceDto));
        return StorageInterfaceMapperApi.INSTANCE.storageInterfaceToStorageInterfaceDto(updatedStorageInterface);
    }

    @DeleteMapping
    public void deleteStorageInterfaceById(@RequestParam UUID storageInterfaceId) {
        System.out.println("StorageInterfaceController.deleteStorageInterfaceById called for storageInterfaceId - " + storageInterfaceId);
        storageInterfaceUseCase.deleteStorageInterface(storageInterfaceId);
    }

    @GetMapping
    public List<StorageInterfaceDto> findAll() {
        System.out.println("StorageInterfaceController.findAll called");
        return StorageInterfaceMapperApi.INSTANCE.storageInterfaceListToStorageInterfaceDtoList(storageInterfaceUseCase.findAllStorageInterfaces());
    }

}
