package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.adapters.rest.dto.ProductRatingHelperDto;
import com.onlinepcshop.adapters.rest.dto.PurchaseSummaryDto;
import com.onlinepcshop.adapters.rest.dto.request.MultipleTablesRequest;
import com.onlinepcshop.adapters.rest.dto.request.PurchaseProductRequest;
import com.onlinepcshop.adapters.rest.dto.request.PurchaseProductsRequest;
import com.onlinepcshop.adapters.rest.dto.response.MultipleTablesResponse;
import com.onlinepcshop.adapters.rest.dto.response.PurchasedProductResponse;
import com.onlinepcshop.adapters.rest.dto.response.PurchasedProductsResponse;
import com.onlinepcshop.adapters.rest.mapper.*;
import com.onlinepcshop.core.domain.entity.*;
import com.onlinepcshop.core.repository.*;
import com.onlinepcshop.core.util.UtilMethods;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Builder
public class MultipleTablesUseCaseImpl implements MultipleTablesUseCase {

    private final ComputerRepository computerRepository;
    private final MotherboardRepository motherboardRepository;
    private final ComputerCaseRepository computerCaseRepository;
    private final GpuRepository gpuRepository;
    private final PowerSupplyRepository powerSupplyRepository;
    private final CoolerRepository coolerRepository;
    private final CpuRepository cpuRepository;
    private final RamRepository ramRepository;
    private final StorageRepository storageRepository;
    private final CaseFanRepository caseFanRepository;
    private final ComputerRamRepository computerRamRepository;
    private final ComputerStorageRepository computerStorageRepository;
    private final ComputerCaseFanRepository computerCaseFanRepository;
    private final PurchaseTransactionRepository purchaseTransactionRepository;
    private final PurchaseTransactionProductRepository purchaseTransactionProductRepository;
    private final ProductRatingRepository productRatingRepository;

    @Override
    public MultipleTablesResponse getAllProductsOnSale(String productName) {
        return MultipleTablesResponse.builder()
                .caseFanList(CaseFanMapperApi.INSTANCE.caseFanListToCaseFanDtoList(caseFanRepository.findAllByHavingSaleAndByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .computerCaseList(ComputerCaseMapperApi.INSTANCE.computerCaseListToComputerCaseDtoList(computerCaseRepository.findAllByHavingSaleAndByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .computerList(ComputerMapperApi.INSTANCE.computerListToComputerDtoList(computerRepository.findAllByHavingSaleAndByComputerName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .motherboardList(MotherboardMapperApi.INSTANCE.motherboardListToMotherboardDtoList(motherboardRepository.findAllByHavingSaleAndByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .gpuList(GpuMapperApi.INSTANCE.gpuListToGpuDtoList(gpuRepository.findAllByHavingSaleAndByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .cpuList(CpuMapperApi.INSTANCE.cpuListToCpuDtoList(cpuRepository.findAllByHavingSaleAndByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .ramList(RamMapperApi.INSTANCE.ramListToRamDtoList(ramRepository.findAllByHavingSaleAndByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .storageList(StorageMapperApi.INSTANCE.storageListToStorageDtoList(storageRepository.findAllByHavingSaleAndByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .powerSupplyList(PowerSupplyMapperApi.INSTANCE.powerSupplyListToPowerSupplyDtoList(powerSupplyRepository.findAllByHavingSaleAndByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .coolerList(CoolerMapperApi.INSTANCE.coolerListToCoolerDtoList(coolerRepository.findAllByHavingSaleAndByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public MultipleTablesResponse getAllTopRatedProducts() {
        List<ProductRatingHelperDto> productRatingHelperDtoList = productRatingRepository.findAllProductRatingsWithAvgRatingEqualOrHigherThan4();
        List<Computer> computerList = new ArrayList<>();
        List<Motherboard> motherboardList = new ArrayList<>();
        List<ComputerCase> computerCaseList = new ArrayList<>();
        List<Gpu> gpuList = new ArrayList<>();
        List<PowerSupply> powerSupplyList = new ArrayList<>();
        List<Cooler> coolerList = new ArrayList<>();
        List<Cpu> cpuList = new ArrayList<>();
        List<Ram> ramList = new ArrayList<>();
        List<Storage> storageList = new ArrayList<>();
        List<CaseFan> caseFanList = new ArrayList<>();
        for (ProductRatingHelperDto productRatingHelperDto : productRatingHelperDtoList) {
            switch (productRatingHelperDto.getProductType()) {
                case "case-fan":
                    CaseFan caseFan = caseFanRepository.findById(productRatingHelperDto.getProductId()).orElse(null);
                    if (caseFan.getQuantity() > 0) {
                        caseFan.setAvgRating(productRatingHelperDto.getAvgRating());
                        caseFanList.add(caseFan);
                    }
                    break;
                case "computer":
                    Computer computer = computerRepository.findById(productRatingHelperDto.getProductId()).orElse(null);
                    if (computer.getQuantity() > 0) {
                        computer.setAvgRating(productRatingHelperDto.getAvgRating());
                        computerList.add(computer);
                    }
                    break;
                case "motherboard":
                    Motherboard motherboard = motherboardRepository.findById(productRatingHelperDto.getProductId()).orElse(null);
                    if (motherboard.getQuantity() > 0) {
                        motherboard.setAvgRating(productRatingHelperDto.getAvgRating());
                        motherboardList.add(motherboard);
                    }
                    break;
                case "cpu":
                    Cpu cpu = cpuRepository.findById(productRatingHelperDto.getProductId()).orElse(null);
                    if (cpu.getQuantity() > 0) {
                        cpu.setAvgRating(productRatingHelperDto.getAvgRating());
                        cpuList.add(cpu);
                    }
                    break;
                case "gpu":
                    Gpu gpu = gpuRepository.findById(productRatingHelperDto.getProductId()).orElse(null);
                    if (gpu.getQuantity() > 0) {
                        gpu.setAvgRating(productRatingHelperDto.getAvgRating());
                        gpuList.add(gpu);
                    }
                    break;
                case "cooler":
                    Cooler cooler = coolerRepository.findById(productRatingHelperDto.getProductId()).orElse(null);
                    if (cooler.getQuantity() > 0) {
                        cooler.setAvgRating(productRatingHelperDto.getAvgRating());
                        coolerList.add(cooler);
                    }
                    break;
                case "ram":
                    Ram ram = ramRepository.findById(productRatingHelperDto.getProductId()).orElse(null);
                    if (ram.getQuantity() > 0) {
                        ram.setAvgRating(productRatingHelperDto.getAvgRating());
                        ramList.add(ram);
                    }
                    break;
                case "storage":
                    Storage storage = storageRepository.findById(productRatingHelperDto.getProductId()).orElse(null);
                    if (storage.getQuantity() > 0) {
                        storage.setAvgRating(productRatingHelperDto.getAvgRating());
                        storageList.add(storage);
                    }
                    break;
                case "power-supply":
                    PowerSupply powerSupply = powerSupplyRepository.findById(productRatingHelperDto.getProductId()).orElse(null);
                    if (powerSupply.getQuantity() > 0) {
                        powerSupply.setAvgRating(productRatingHelperDto.getAvgRating());
                        powerSupplyList.add(powerSupply);
                    }
                    break;
                case "computer-case":
                    ComputerCase computerCase = computerCaseRepository.findById(productRatingHelperDto.getProductId()).orElse(null);
                    if (computerCase.getQuantity() > 0) {
                        computerCase.setAvgRating(productRatingHelperDto.getAvgRating());
                        computerCaseList.add(computerCase);
                    }
                    break;
            }
        }
        return MultipleTablesResponse.builder()
                .caseFanList(CaseFanMapperApi.INSTANCE.caseFanListToCaseFanDtoList(caseFanList))
                .computerCaseList(ComputerCaseMapperApi.INSTANCE.computerCaseListToComputerCaseDtoList(computerCaseList))
                .computerList(ComputerMapperApi.INSTANCE.computerListToComputerDtoList(computerList))
                .motherboardList(MotherboardMapperApi.INSTANCE.motherboardListToMotherboardDtoList(motherboardList))
                .gpuList(GpuMapperApi.INSTANCE.gpuListToGpuDtoList(gpuList))
                .cpuList(CpuMapperApi.INSTANCE.cpuListToCpuDtoList(cpuList))
                .ramList(RamMapperApi.INSTANCE.ramListToRamDtoList(ramList))
                .storageList(StorageMapperApi.INSTANCE.storageListToStorageDtoList(storageList))
                .powerSupplyList(PowerSupplyMapperApi.INSTANCE.powerSupplyListToPowerSupplyDtoList(powerSupplyList))
                .coolerList(CoolerMapperApi.INSTANCE.coolerListToCoolerDtoList(coolerList))
                .build();
    }

    @Override
    public MultipleTablesResponse getAllPopularProducts(String productName) {
        List<PurchaseSummaryDto> purchaseSummaryDtoList = purchaseTransactionProductRepository.findAllPurchaseTransactionProductsWithTotalAmountHigherThan2();
        List<Computer> computerList = new ArrayList<>();
        List<Motherboard> motherboardList = new ArrayList<>();
        List<ComputerCase> computerCaseList = new ArrayList<>();
        List<Gpu> gpuList = new ArrayList<>();
        List<PowerSupply> powerSupplyList = new ArrayList<>();
        List<Cooler> coolerList = new ArrayList<>();
        List<Cpu> cpuList = new ArrayList<>();
        List<Ram> ramList = new ArrayList<>();
        List<Storage> storageList = new ArrayList<>();
        List<CaseFan> caseFanList = new ArrayList<>();
        for (PurchaseSummaryDto purchaseSummaryDto : purchaseSummaryDtoList) {
            switch (purchaseSummaryDto.getProductType()) {
                case "case-fan":
                    CaseFan caseFan = caseFanRepository.findById(purchaseSummaryDto.getProductId()).orElse(null);
                    if (UtilMethods.containsIgnoreCase(caseFan.getComponentName(), productName) && caseFan.getQuantity() > 0) {
                        caseFanList.add(caseFan);
                    }
                    break;
                case "computer":
                    Computer computer = computerRepository.findById(purchaseSummaryDto.getProductId()).orElse(null);
                    if (UtilMethods.containsIgnoreCase(computer.getComputerName(), productName) && computer.getQuantity() > 0) {
                        computerList.add(computer);
                    }
                    break;
                case "motherboard":
                    Motherboard motherboard = motherboardRepository.findById(purchaseSummaryDto.getProductId()).orElse(null);
                    if (UtilMethods.containsIgnoreCase(motherboard.getComponentName(), productName) && motherboard.getQuantity() > 0) {
                        motherboardList.add(motherboard);
                    }
                    break;
                case "cpu":
                    Cpu cpu = cpuRepository.findById(purchaseSummaryDto.getProductId()).orElse(null);
                    if (UtilMethods.containsIgnoreCase(cpu.getComponentName(), productName) && cpu.getQuantity() > 0) {
                        cpuList.add(cpu);
                    }
                    break;
                case "gpu":
                    Gpu gpu = gpuRepository.findById(purchaseSummaryDto.getProductId()).orElse(null);
                    if (UtilMethods.containsIgnoreCase(gpu.getComponentName(), productName) && gpu.getQuantity() > 0) {
                        gpuList.add(gpu);
                    }
                    break;
                case "cooler":
                    Cooler cooler = coolerRepository.findById(purchaseSummaryDto.getProductId()).orElse(null);
                    if (UtilMethods.containsIgnoreCase(cooler.getComponentName(), productName) && cooler.getQuantity() > 0) {
                        coolerList.add(cooler);
                    }
                    break;
                case "ram":
                    Ram ram = ramRepository.findById(purchaseSummaryDto.getProductId()).orElse(null);
                    if (UtilMethods.containsIgnoreCase(ram.getComponentName(), productName) && ram.getQuantity() > 0) {
                        ramList.add(ram);
                    }
                    break;
                case "storage":
                    Storage storage = storageRepository.findById(purchaseSummaryDto.getProductId()).orElse(null);
                    if (UtilMethods.containsIgnoreCase(storage.getComponentName(), productName) && storage.getQuantity() > 0) {
                        storageList.add(storage);
                    }
                    break;
                case "power-supply":
                    PowerSupply powerSupply = powerSupplyRepository.findById(purchaseSummaryDto.getProductId()).orElse(null);
                    if (UtilMethods.containsIgnoreCase(powerSupply.getComponentName(), productName) && powerSupply.getQuantity() > 0) {
                        powerSupplyList.add(powerSupply);
                    }
                    break;
                case "computer-case":
                    ComputerCase computerCase = computerCaseRepository.findById(purchaseSummaryDto.getProductId()).orElse(null);
                    if (UtilMethods.containsIgnoreCase(computerCase.getComponentName(), productName) && computerCase.getQuantity() > 0) {
                        computerCaseList.add(computerCase);
                    }
                    break;
            }
        }
        return MultipleTablesResponse.builder()
                .caseFanList(CaseFanMapperApi.INSTANCE.caseFanListToCaseFanDtoList(caseFanList).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .computerCaseList(ComputerCaseMapperApi.INSTANCE.computerCaseListToComputerCaseDtoList(computerCaseList).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .computerList(ComputerMapperApi.INSTANCE.computerListToComputerDtoList(computerList).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .motherboardList(MotherboardMapperApi.INSTANCE.motherboardListToMotherboardDtoList(motherboardList).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .gpuList(GpuMapperApi.INSTANCE.gpuListToGpuDtoList(gpuList).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .cpuList(CpuMapperApi.INSTANCE.cpuListToCpuDtoList(cpuList).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .ramList(RamMapperApi.INSTANCE.ramListToRamDtoList(ramList).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .storageList(StorageMapperApi.INSTANCE.storageListToStorageDtoList(storageList).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .powerSupplyList(PowerSupplyMapperApi.INSTANCE.powerSupplyListToPowerSupplyDtoList(powerSupplyList).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .coolerList(CoolerMapperApi.INSTANCE.coolerListToCoolerDtoList(coolerList).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public MultipleTablesResponse getAllProductsByProductName(String productName) {
        return MultipleTablesResponse.builder()
                .caseFanList(CaseFanMapperApi.INSTANCE.caseFanListToCaseFanDtoList(caseFanRepository.searchByComponentName(productName)).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .computerCaseList(ComputerCaseMapperApi.INSTANCE.computerCaseListToComputerCaseDtoList(computerCaseRepository.searchByComponentName(productName)).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .computerList(ComputerMapperApi.INSTANCE.computerListToComputerDtoList(computerRepository.searchByComputerNameAndType(productName, "")).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .motherboardList(MotherboardMapperApi.INSTANCE.motherboardListToMotherboardDtoList(motherboardRepository.searchByComponentName(productName)).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .gpuList(GpuMapperApi.INSTANCE.gpuListToGpuDtoList(gpuRepository.searchByComponentName(productName)).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .cpuList(CpuMapperApi.INSTANCE.cpuListToCpuDtoList(cpuRepository.searchByComponentName(productName)).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .ramList(RamMapperApi.INSTANCE.ramListToRamDtoList(ramRepository.searchByComponentName(productName)).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .storageList(StorageMapperApi.INSTANCE.storageListToStorageDtoList(storageRepository.searchByComponentName(productName)).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .powerSupplyList(PowerSupplyMapperApi.INSTANCE.powerSupplyListToPowerSupplyDtoList(powerSupplyRepository.searchByComponentName(productName)).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .coolerList(CoolerMapperApi.INSTANCE.coolerListToCoolerDtoList(coolerRepository.searchByComponentName(productName)).stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public MultipleTablesResponse getAllNewProducts(String productName) {
        return MultipleTablesResponse.builder()
                .caseFanList(CaseFanMapperApi.INSTANCE.caseFanListToCaseFanDtoList(caseFanRepository.findAllNewCaseFansByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .computerCaseList(ComputerCaseMapperApi.INSTANCE.computerCaseListToComputerCaseDtoList(computerCaseRepository.findAllNewComputerCasesByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .computerList(ComputerMapperApi.INSTANCE.computerListToComputerDtoList(computerRepository.findAllNewComputersByComputerName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .motherboardList(MotherboardMapperApi.INSTANCE.motherboardListToMotherboardDtoList(motherboardRepository.findAllNewMotherboardsByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .gpuList(GpuMapperApi.INSTANCE.gpuListToGpuDtoList(gpuRepository.findAllNewGpusByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .cpuList(CpuMapperApi.INSTANCE.cpuListToCpuDtoList(cpuRepository.findAllNewCpusByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .ramList(RamMapperApi.INSTANCE.ramListToRamDtoList(ramRepository.findAllNewRamsByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .storageList(StorageMapperApi.INSTANCE.storageListToStorageDtoList(storageRepository.findAllNewStoragesByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .powerSupplyList(PowerSupplyMapperApi.INSTANCE.powerSupplyListToPowerSupplyDtoList(powerSupplyRepository.findAllNewPowerSuppliesByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .coolerList(CoolerMapperApi.INSTANCE.coolerListToCoolerDtoList(coolerRepository.findAllNewCoolersByComponentName(productName))
                        .stream()
                        .peek(pd -> pd.setAvgRating(productRatingRepository.findAverageRatingByProductId(pd.getId())))
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public MultipleTablesResponse getAllRequestedComponents(MultipleTablesRequest request) {
        List<Computer> computerList = new ArrayList<>();
        List<Motherboard> motherboardList = new ArrayList<>();
        List<ComputerCase> computerCaseList = new ArrayList<>();
        List<Gpu> gpuList = new ArrayList<>();
        List<PowerSupply> powerSupplyList = new ArrayList<>();
        List<Cooler> coolerList = new ArrayList<>();
        List<Cpu> cpuList = new ArrayList<>();
        List<Ram> ramList = new ArrayList<>();
        List<Storage> storageList = new ArrayList<>();
        List<CaseFan> caseFanList = new ArrayList<>();
        for (UUID computerId : request.getComputerIds()) {
            Computer computer = computerRepository.findById(computerId).orElse(null);
            if (computer.getQuantity() > 0) computerList.add(computer);
        }
        for (UUID motherboardId : request.getMotherboardIds()) {
            Motherboard motherboard = motherboardRepository.findById(motherboardId).orElse(null);
            if (motherboard.getQuantity() > 0) motherboardList.add(motherboard);
        }
        for (UUID computerCaseId : request.getComputerCaseIds()) {
            ComputerCase computerCase = computerCaseRepository.findById(computerCaseId).orElse(null);
            if (computerCase.getQuantity() > 0) computerCaseList.add(computerCase);
        }
        for (UUID gpuId : request.getGpuIds()) {
            Gpu gpu = gpuRepository.findById(gpuId).orElse(null);
            if (gpu.getQuantity() > 0) gpuList.add(gpu);
        }
        for (UUID powerSupplyId : request.getPowerSupplyIds()) {
            PowerSupply powerSupply = powerSupplyRepository.findById(powerSupplyId).orElse(null);
            if (powerSupply.getQuantity() > 0) powerSupplyList.add(powerSupply);
        }
        for (UUID coolerId : request.getCoolerIds()) {
            Cooler cooler = coolerRepository.findById(coolerId).orElse(null);
            if (cooler.getQuantity() > 0) coolerList.add(cooler);
        }
        for (UUID cpuId : request.getCpuIds()) {
            Cpu cpu = cpuRepository.findById(cpuId).orElse(null);
            if (cpu.getQuantity() > 0) cpuList.add(cpu);
        }
        if (request.getRamIds().size() > 0) {
            for (UUID ramId : request.getRamIds()) {
                Ram ram = ramRepository.findById(ramId).orElse(null);
                if (ram.getQuantity() > 0) ramList.add(ram);
            }
        } else {
            for (ComputerRam cr : computerRamRepository.findAllByComputer(request.getComputerIds().getFirst())) {
                ramList.add(cr.getRam());
            }
        }
        if (request.getStorageIds().size() > 0) {
            for (UUID storageId : request.getStorageIds()) {
                Storage storage = storageRepository.findById(storageId).orElse(null);
                if (storage.getQuantity() > 0) storageList.add(storage);
            }
        } else {
            for (ComputerStorage cs : computerStorageRepository.findAllByComputer(request.getComputerIds().getFirst())) {
                storageList.add(cs.getStorage());
            }
        }
        if (request.getCaseFanIds().size() > 0) {
            for (UUID caseFanId : request.getCaseFanIds()) {
                CaseFan cf = caseFanRepository.findById(caseFanId).orElse(null);
                if (cf.getQuantity() > 0) caseFanList.add(cf);
            }
        } else {
            for (ComputerCaseFan ccs : computerCaseFanRepository.findAllByComputer(request.getComputerIds().getFirst())) {
                caseFanList.add(ccs.getCaseFan());
            }
        }

        return MultipleTablesResponse.builder()
                .computerList(ComputerMapperApi.INSTANCE.computerListToComputerDtoList(computerList))
                .computerCaseList(ComputerCaseMapperApi.INSTANCE.computerCaseListToComputerCaseDtoList(computerCaseList))
                .motherboardList(MotherboardMapperApi.INSTANCE.motherboardListToMotherboardDtoList(motherboardList))
                .cpuList(CpuMapperApi.INSTANCE.cpuListToCpuDtoList(cpuList))
                .gpuList(GpuMapperApi.INSTANCE.gpuListToGpuDtoList(gpuList))
                .caseFanList(CaseFanMapperApi.INSTANCE.caseFanListToCaseFanDtoList(caseFanList))
                .coolerList(CoolerMapperApi.INSTANCE.coolerListToCoolerDtoList(coolerList))
                .ramList(RamMapperApi.INSTANCE.ramListToRamDtoList(ramList))
                .storageList(StorageMapperApi.INSTANCE.storageListToStorageDtoList(storageList))
                .powerSupplyList(PowerSupplyMapperApi.INSTANCE.powerSupplyListToPowerSupplyDtoList(powerSupplyList))
                .build();
    }

    @Override
    public boolean purchaseProducts(PurchaseProductsRequest request) {
        List<PurchaseProductRequest> purchaseProductRequestList = request.getPurchaseProductRequests();
        PurchaseTransaction pt = PurchaseTransactionMapperApi.INSTANCE.purchaseTransactionDtoToPurchaseTransaction(request.getPurchaseTransaction());
        PurchaseTransaction addedPurchaseTransaction = purchaseTransactionRepository.savePurchaseTransaction(pt);
        if (addedPurchaseTransaction != null && addedPurchaseTransaction.getId() != null) {
            for (PurchaseProductRequest purchaseProductRequest : purchaseProductRequestList) {
                PurchaseTransactionProduct ptp = new PurchaseTransactionProduct();
                ptp.setProductId(purchaseProductRequest.getProductId());
                ptp.setProductType(purchaseProductRequest.getProductType());
                ptp.setAmount(purchaseProductRequest.getAmount());
                ptp.setPriceAtTheTime(purchaseProductRequest.getPrice());
                ptp.setPurchaseTransaction(addedPurchaseTransaction);
                PurchaseTransactionProduct savedPTP = purchaseTransactionProductRepository.savePurchaseTransactionProduct(ptp);
                if (savedPTP == null || savedPTP.getId() == null) {
                    return false;
                }
                switch (savedPTP.getProductType()) {
                    case "case-fan":
                        CaseFan caseFan = caseFanRepository.findById(savedPTP.getProductId()).orElse(null);
                        caseFan.setQuantity(caseFan.getQuantity() - savedPTP.getAmount());
                        caseFanRepository.saveCaseFan(caseFan);
                        break;
                    case "computer":
                        Computer computer = computerRepository.findById(savedPTP.getProductId()).orElse(null);
                        computer.setQuantity(computer.getQuantity() - savedPTP.getAmount());
                        computerRepository.saveComputer(computer);
                        break;
                    case "motherboard":
                        Motherboard motherboard = motherboardRepository.findById(savedPTP.getProductId()).orElse(null);
                        motherboard.setQuantity(motherboard.getQuantity() - savedPTP.getAmount());
                        motherboardRepository.saveMotherboard(motherboard);
                        break;
                    case "cpu":
                        Cpu cpu = cpuRepository.findById(savedPTP.getProductId()).orElse(null);
                        cpu.setQuantity(cpu.getQuantity() - savedPTP.getAmount());
                        cpuRepository.saveCpu(cpu);
                        break;
                    case "gpu":
                        Gpu gpu = gpuRepository.findById(savedPTP.getProductId()).orElse(null);
                        gpu.setQuantity(gpu.getQuantity() - savedPTP.getAmount());
                        gpuRepository.saveGpu(gpu);
                        break;
                    case "cooler":
                        Cooler cooler = coolerRepository.findById(savedPTP.getProductId()).orElse(null);
                        cooler.setQuantity(cooler.getQuantity() - savedPTP.getAmount());
                        coolerRepository.saveCooler(cooler);
                        break;
                    case "ram":
                        Ram ram = ramRepository.findById(savedPTP.getProductId()).orElse(null);
                        ram.setQuantity(ram.getQuantity() - savedPTP.getAmount());
                        ramRepository.saveRam(ram);
                        break;
                    case "storage":
                        Storage storage = storageRepository.findById(savedPTP.getProductId()).orElse(null);
                        storage.setQuantity(storage.getQuantity() - savedPTP.getAmount());
                        storageRepository.saveStorage(storage);
                        break;
                    case "power-supply":
                        PowerSupply powerSupply = powerSupplyRepository.findById(savedPTP.getProductId()).orElse(null);
                        powerSupply.setQuantity(powerSupply.getQuantity() - savedPTP.getAmount());
                        powerSupplyRepository.savePowerSupply(powerSupply);
                        break;
                    case "computer-case":
                        ComputerCase computerCase = computerCaseRepository.findById(savedPTP.getProductId()).orElse(null);
                        computerCase.setQuantity(computerCase.getQuantity() - savedPTP.getAmount());
                        computerCaseRepository.saveComputerCase(computerCase);
                        break;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public List<PurchasedProductsResponse> getPurchaseHistoryByUserId(UUID userId) {
        List<PurchaseTransaction> purchaseTransactionList = purchaseTransactionRepository.findAllPurchaseTransactionsByUserId(userId);
        List<PurchasedProductsResponse> purchasedProductsResponseList = new ArrayList<>();
        for (PurchaseTransaction purchaseTransaction : purchaseTransactionList) {
            List<PurchasedProductResponse> purchasedProductResponseList = new ArrayList<>();
            List<PurchaseTransactionProduct> purchaseTransactionProductList = new ArrayList<>(purchaseTransactionProductRepository.findAllPurchaseTransactionProductsByTransactionId(purchaseTransaction.getId()));
            PurchasedProductResponse purchasedProductResponse;
            for (PurchaseTransactionProduct purchaseTransactionProduct : purchaseTransactionProductList) {
                switch (purchaseTransactionProduct.getProductType()) {
                    case "case-fan":
                        CaseFan tempCaseFan = caseFanRepository.findById(purchaseTransactionProduct.getProductId()).orElse(null);
                        purchasedProductResponse = PurchasedProductResponse.builder()
                                .dateOfPurchase(purchaseTransaction.getDateOfPurchase())
                                .image(tempCaseFan.getImage())
                                .price(purchaseTransactionProduct.getPriceAtTheTime())
                                .productName(tempCaseFan.getComponentName())
                                .amount(purchaseTransactionProduct.getAmount())
                                .productId(purchaseTransactionProduct.getProductId())
                                .build();
                        purchasedProductResponseList.add(purchasedProductResponse);
                        break;
                    case "computer":
                        Computer tempComputer = computerRepository.findById(purchaseTransactionProduct.getProductId()).orElse(null);
                        purchasedProductResponse = PurchasedProductResponse.builder()
                                .dateOfPurchase(purchaseTransaction.getDateOfPurchase())
                                .image(tempComputer.getImage())
                                .price(purchaseTransactionProduct.getPriceAtTheTime())
                                .productName(tempComputer.getComputerName())
                                .amount(purchaseTransactionProduct.getAmount())
                                .productId(purchaseTransactionProduct.getProductId())
                                .build();
                        purchasedProductResponseList.add(purchasedProductResponse);
                        break;
                    case "motherboard":
                        Motherboard tempMotherboard = motherboardRepository.findById(purchaseTransactionProduct.getProductId()).orElse(null);
                        purchasedProductResponse = PurchasedProductResponse.builder()
                                .dateOfPurchase(purchaseTransaction.getDateOfPurchase())
                                .image(tempMotherboard.getImage())
                                .price(purchaseTransactionProduct.getPriceAtTheTime())
                                .productName(tempMotherboard.getComponentName())
                                .amount(purchaseTransactionProduct.getAmount())
                                .productId(purchaseTransactionProduct.getProductId())
                                .build();
                        purchasedProductResponseList.add(purchasedProductResponse);
                        break;
                    case "cpu":
                        Cpu tempCpu = cpuRepository.findById(purchaseTransactionProduct.getProductId()).orElse(null);
                        purchasedProductResponse = PurchasedProductResponse.builder()
                                .dateOfPurchase(purchaseTransaction.getDateOfPurchase())
                                .image(tempCpu.getImage())
                                .price(purchaseTransactionProduct.getPriceAtTheTime())
                                .productName(tempCpu.getComponentName())
                                .amount(purchaseTransactionProduct.getAmount())
                                .productId(purchaseTransactionProduct.getProductId())
                                .build();
                        purchasedProductResponseList.add(purchasedProductResponse);
                        break;
                    case "gpu":
                        Gpu tempGpu = gpuRepository.findById(purchaseTransactionProduct.getProductId()).orElse(null);
                        purchasedProductResponse = PurchasedProductResponse.builder()
                                .dateOfPurchase(purchaseTransaction.getDateOfPurchase())
                                .image(tempGpu.getImage())
                                .price(purchaseTransactionProduct.getPriceAtTheTime())
                                .productName(tempGpu.getComponentName())
                                .amount(purchaseTransactionProduct.getAmount())
                                .productId(purchaseTransactionProduct.getProductId())
                                .build();
                        purchasedProductResponseList.add(purchasedProductResponse);
                        break;
                    case "cooler":
                        Cooler tempCooler = coolerRepository.findById(purchaseTransactionProduct.getProductId()).orElse(null);
                        purchasedProductResponse = PurchasedProductResponse.builder()
                                .dateOfPurchase(purchaseTransaction.getDateOfPurchase())
                                .image(tempCooler.getImage())
                                .price(purchaseTransactionProduct.getPriceAtTheTime())
                                .productName(tempCooler.getComponentName())
                                .amount(purchaseTransactionProduct.getAmount())
                                .productId(purchaseTransactionProduct.getProductId())
                                .build();
                        purchasedProductResponseList.add(purchasedProductResponse);
                        break;
                    case "ram":
                        Ram tempRam = ramRepository.findById(purchaseTransactionProduct.getProductId()).orElse(null);
                        purchasedProductResponse = PurchasedProductResponse.builder()
                                .dateOfPurchase(purchaseTransaction.getDateOfPurchase())
                                .image(tempRam.getImage())
                                .price(purchaseTransactionProduct.getPriceAtTheTime())
                                .productName(tempRam.getComponentName())
                                .amount(purchaseTransactionProduct.getAmount())
                                .productId(purchaseTransactionProduct.getProductId())
                                .build();
                        purchasedProductResponseList.add(purchasedProductResponse);
                        break;
                    case "storage":
                        Storage tempStorage = storageRepository.findById(purchaseTransactionProduct.getProductId()).orElse(null);
                        purchasedProductResponse = PurchasedProductResponse.builder()
                                .dateOfPurchase(purchaseTransaction.getDateOfPurchase())
                                .image(tempStorage.getImage())
                                .price(purchaseTransactionProduct.getPriceAtTheTime())
                                .productName(tempStorage.getComponentName())
                                .amount(purchaseTransactionProduct.getAmount())
                                .productId(purchaseTransactionProduct.getProductId())
                                .build();
                        purchasedProductResponseList.add(purchasedProductResponse);
                        break;
                    case "power-supply":
                        PowerSupply tempPowerSupply = powerSupplyRepository.findById(purchaseTransactionProduct.getProductId()).orElse(null);
                        purchasedProductResponse = PurchasedProductResponse.builder()
                                .dateOfPurchase(purchaseTransaction.getDateOfPurchase())
                                .image(tempPowerSupply.getImage())
                                .price(purchaseTransactionProduct.getPriceAtTheTime())
                                .productName(tempPowerSupply.getComponentName())
                                .amount(purchaseTransactionProduct.getAmount())
                                .productId(purchaseTransactionProduct.getProductId())
                                .build();
                        purchasedProductResponseList.add(purchasedProductResponse);
                        break;
                    case "computer-case":
                        ComputerCase tempComputerCase = computerCaseRepository.findById(purchaseTransactionProduct.getProductId()).orElse(null);
                        purchasedProductResponse = PurchasedProductResponse.builder()
                                .dateOfPurchase(purchaseTransaction.getDateOfPurchase())
                                .image(tempComputerCase.getImage())
                                .price(purchaseTransactionProduct.getPriceAtTheTime())
                                .productName(tempComputerCase.getComponentName())
                                .amount(purchaseTransactionProduct.getAmount())
                                .productId(purchaseTransactionProduct.getProductId())
                                .build();
                        purchasedProductResponseList.add(purchasedProductResponse);
                        break;
                }
            }
            PurchasedProductsResponse purchasedProductsResponse = PurchasedProductsResponse.builder()
                    .purchasedProductResponseList(purchasedProductResponseList)
                    .purchaseTransaction(PurchaseTransactionMapperApi.INSTANCE.purchaseTransactionToPurchaseTransactionDto(purchaseTransaction))
                    .build();
            purchasedProductsResponseList.add(purchasedProductsResponse);
        }

        return purchasedProductsResponseList;
    }
}
