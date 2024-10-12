package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.CaseFanDto;
import com.onlinepcshop.adapters.rest.dto.CaseFanDto;
import com.onlinepcshop.adapters.rest.mapper.CaseFanMapperApi;
import com.onlinepcshop.adapters.rest.mapper.CaseFanMapperApi;
import com.onlinepcshop.core.domain.entity.CaseFan;
import com.onlinepcshop.core.domain.entity.Computer;
import com.onlinepcshop.core.error.exception.CaseFanAlreadyExistsException;
import com.onlinepcshop.core.error.exception.ComputerAlreadyExistsException;
import com.onlinepcshop.core.usecase.CaseFanUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("case-fan")
@RequiredArgsConstructor
public class CaseFanController {

    private final CaseFanUseCase caseFanUseCase;

    @GetMapping("/{id}")
    public CaseFanDto getById(@PathVariable(name = "id") UUID caseFanId) {
        System.out.println("CaseFanController.geyById with id: " + caseFanId + " called");
        Optional<CaseFan> caseFan = caseFanUseCase.findCaseFanById(caseFanId);
        if(caseFan.isEmpty()) {
            System.out.println("CaseFan with id " + caseFanId + " not found");
            return null;
        }
        return CaseFanMapperApi.INSTANCE.caseFanToCaseFanDto(caseFan.get());
    }

    @PostMapping
    public CaseFanDto createCaseFan(@RequestBody CaseFanDto caseFanDto) {
        System.out.println("CaseFanController.createCaseFan called - " + caseFanDto);

        for (CaseFan cf : caseFanUseCase.findAllCaseFans()) {
            if (caseFanDto.getComponentName().equals(cf.getComponentName())){
                System.out.println("Case Fan " + caseFanDto.getComponentName() + " already exists");
                throw new CaseFanAlreadyExistsException("Case fan " + caseFanDto.getComponentName() + " already exists");
            }
        }

        CaseFan createdCaseFan = caseFanUseCase.createCaseFan(CaseFanMapperApi.INSTANCE.caseFanDtoToCaseFan(caseFanDto));
        return CaseFanMapperApi.INSTANCE.caseFanToCaseFanDto(createdCaseFan);
    }

    @PutMapping
    public CaseFanDto updateCaseFan(@RequestBody CaseFanDto caseFanDto) {
        System.out.println("CaseFanController.updateCaseFan called - " + caseFanDto);

        CaseFan updatedCaseFan = caseFanUseCase.updateCaseFan(CaseFanMapperApi.INSTANCE.caseFanDtoToCaseFan(caseFanDto));
        return CaseFanMapperApi.INSTANCE.caseFanToCaseFanDto(updatedCaseFan);
    }

    @DeleteMapping
    public void deleteCaseFanById(@RequestParam UUID caseFanId) {
        System.out.println("CaseFanController.deleteCaseFanById called for caseFanId - " + caseFanId);
        caseFanUseCase.deleteCaseFan(caseFanId);
    }

    @GetMapping
    public List<CaseFanDto> findAll() {
        System.out.println("CaseFanController.findAll called");
        return CaseFanMapperApi.INSTANCE.caseFanListToCaseFanDtoList(caseFanUseCase.findAllCaseFans());
    }

    @GetMapping("/find-by-max-price")
    public List<CaseFanDto> findAllCaseFansByMaxPrice(@RequestParam Map<String, String> paramMap) {
        System.out.println("CaseFanController.findAllCaseFansByMaxPrice called");
        Double maxPrice = Double.valueOf(paramMap.get("maxPrice"));
        return CaseFanMapperApi.INSTANCE.caseFanListToCaseFanDtoList(caseFanUseCase.findAllCaseFansByMaxPrice(maxPrice));
    }

    @GetMapping("/find-by-computer-id")
    public List<CaseFanDto> findAllCaseFansByComputerId(@RequestParam Map<String, String> paramMap) {
        System.out.println("CaseFanController.findAllCaseFansByComputerId called");
        UUID computerId = UUID.fromString(paramMap.get("computerId"));
        return CaseFanMapperApi.INSTANCE.caseFanListToCaseFanDtoList(caseFanUseCase.findAllCaseFansByComputerId(computerId));
    }

    @GetMapping("/find-quantity-by-case-fan-id-and-computer-id")
    public Integer findQuantityByCaseFanIdAndComputerId(@RequestParam Map<String, String> paramMap) {
        System.out.println("CaseFanController.findAllCaseFansByComputerId called");
        UUID caseFanId = UUID.fromString(paramMap.get("caseFanId"));
        UUID computerId = UUID.fromString(paramMap.get("computerId"));
        return caseFanUseCase.findQuantityByCaseFanIdAndComputerId(caseFanId, computerId);
    }

}
