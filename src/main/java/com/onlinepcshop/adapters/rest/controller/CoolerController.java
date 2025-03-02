package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.CoolerDto;
import com.onlinepcshop.adapters.rest.mapper.CoolerMapperApi;
import com.onlinepcshop.core.domain.entity.Cooler;
import com.onlinepcshop.core.error.exception.CoolerAlreadyExistsException;
import com.onlinepcshop.core.usecase.CoolerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("cooler")
@RequiredArgsConstructor
public class CoolerController {

    private final CoolerUseCase coolerUseCase;

    @GetMapping("/{id}")
    public CoolerDto getById(@PathVariable(name = "id") UUID coolerId) {
        System.out.println("CoolerController.geyById with id: " + coolerId + " called");
        Optional<Cooler> cooler = coolerUseCase.findCoolerById(coolerId);
        if (cooler.isEmpty()) {
            System.out.println("Cooler with id " + coolerId + " not found");
            return null;
        }
        return CoolerMapperApi.INSTANCE.coolerToCoolerDto(cooler.get());
    }

    @PostMapping
    public CoolerDto createCooler(@RequestBody CoolerDto coolerDto) {
        System.out.println("CoolerController.createCooler called - " + coolerDto);

        for (Cooler c : coolerUseCase.findAllCoolers()) {
            if (coolerDto.getComponentName().equals(c.getComponentName())) {
                System.out.println("Cooler " + coolerDto.getComponentName() + " already exists");
                throw new CoolerAlreadyExistsException("Cooler " + coolerDto.getComponentName() + " already exists");
            }
        }

        Cooler createdCooler = coolerUseCase.createCooler(CoolerMapperApi.INSTANCE.coolerDtoToCooler(coolerDto));
        return CoolerMapperApi.INSTANCE.coolerToCoolerDto(createdCooler);
    }

    @PutMapping
    public CoolerDto updateCooler(@RequestBody CoolerDto coolerDto) {
        System.out.println("CoolerController.updateCooler called - " + coolerDto);

        Cooler updatedCooler = coolerUseCase.updateCooler(CoolerMapperApi.INSTANCE.coolerDtoToCooler(coolerDto));
        return CoolerMapperApi.INSTANCE.coolerToCoolerDto(updatedCooler);
    }

    @DeleteMapping
    public void deleteCoolerById(@RequestParam UUID coolerId) {
        System.out.println("CoolerController.deleteCoolerById called for coolerId - " + coolerId);
        coolerUseCase.deleteCooler(coolerId);
    }

    @GetMapping
    public List<CoolerDto> findAll() {
        System.out.println("CoolerController.findAll called");
        return CoolerMapperApi.INSTANCE.coolerListToCoolerDtoList(coolerUseCase.findAllCoolers());
    }

    @GetMapping("/find-all-available")
    public List<CoolerDto> findAllAvailableCoolers() {
        System.out.println("CoolerController.findAllAvailableCoolers called");
        return CoolerMapperApi.INSTANCE.coolerListToCoolerDtoList(coolerUseCase.findAllAvailableCoolers());
    }

    @GetMapping("/find-by-max-price")
    public List<CoolerDto> findAllCoolersByMaxPrice(@RequestParam Map<String, String> paramMap) {
        System.out.println("CoolerController.findAllCoolersByMaxPrice called");
        Double maxPrice = Double.valueOf(paramMap.get("maxPrice"));
        return CoolerMapperApi.INSTANCE.coolerListToCoolerDtoList(coolerUseCase.findAllCoolersByMaxPrice(maxPrice));
    }

    @GetMapping("/search-by-name")
    public List<CoolerDto> searchByName(@RequestParam Map<String, String> paramMap) {
        System.out.println("CoolerController.searchByName called");
        String name = paramMap.get("name");
        return CoolerMapperApi.INSTANCE.coolerListToCoolerDtoList(coolerUseCase.searchByName(name));
    }

    @GetMapping("/get-cooler-average-rating")
    public Double getCoolerAverageRating(@RequestParam Map<String, String> paramMap) {
        System.out.println("CoolerController.getCoolerAverageRating called");
        UUID coolerId = UUID.fromString(paramMap.get("coolerId"));
        return coolerUseCase.getCoolerAverageRating(coolerId);
    }

}
