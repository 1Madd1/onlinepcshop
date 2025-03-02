package com.onlinepcshop.adapters.rest.mapper;

import com.onlinepcshop.adapters.rest.dto.ComputerDto;
import com.onlinepcshop.core.domain.entity.*;
import com.onlinepcshop.core.domain.value.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.UUID;

@Mapper
public interface ComputerMapperApi {
    ComputerMapperApi INSTANCE = Mappers.getMapper(ComputerMapperApi.class);

    @Named("mapMotherboardToId")
    default UUID mapMotherboardToId(Motherboard motherboard) {
        return motherboard == null ? null : motherboard.getId();
    }

    @Named("mapComputerCaseToId")
    default UUID mapComputerCaseToId(ComputerCase computerCase) {
        return computerCase == null ? null : computerCase.getId();
    }

    @Named("mapGpuToId")
    default UUID mapGpuToId(Gpu gpu) {
        return gpu == null ? null : gpu.getId();
    }

    @Named("mapPowerSupplyToId")
    default UUID mapPowerSupplyToId(PowerSupply powerSupply) {
        return powerSupply == null ? null : powerSupply.getId();
    }

    @Named("mapCoolerToId")
    default UUID mapCoolerToId(Cooler cooler) {
        return cooler == null ? null : cooler.getId();
    }

    @Named("mapCpuToId")
    default UUID mapCpuToId(Cpu cpu) {
        return cpu == null ? null : cpu.getId();
    }

    @Named("mapMoneyToCurrency")
    default String mapMoneyToCurrency(Money price) {
        return price.getCurrency().getCurrencyCode();
    }

    @Named("mapMoneyToValue")
    default BigDecimal mapMoneyToValue(Money price) {
        return price.getAmount();
    }

    @Mapping(target = "price", source = "price", qualifiedByName = "mapMoneyToValue")
    @Mapping(target = "currency", source = "price", qualifiedByName = "mapMoneyToCurrency")
    @Mapping(source = "motherboard", target = "motherboardId", qualifiedByName = "mapMotherboardToId")
    @Mapping(source = "computerCase", target = "computerCaseId", qualifiedByName = "mapComputerCaseToId")
    @Mapping(source = "gpu", target = "gpuId", qualifiedByName = "mapGpuToId")
    @Mapping(source = "powerSupply", target = "powerSupplyId", qualifiedByName = "mapPowerSupplyToId")
    @Mapping(source = "cooler", target = "coolerId", qualifiedByName = "mapCoolerToId")
    @Mapping(source = "cpu", target = "cpuId", qualifiedByName = "mapCpuToId")
    ComputerDto computerToComputerDto(Computer computer);

    @Named("mapToMoney")
    default Money mapToMoney(ComputerDto computerDto) {
        return new Money(computerDto.getPrice(), Currency.getInstance(computerDto.getCurrency()));
    }

    @Named("mapIdToMotherboard")
    default Motherboard mapIdToMotherboard(UUID motherboardId) {
        return Motherboard.builder()
                .id(motherboardId)
                .build();
    }

    @Named("mapIdToComputerCase")
    default ComputerCase mapIdToComputerCase(UUID computerCaseId) {
        return ComputerCase.builder()
                .id(computerCaseId)
                .build();
    }

    @Named("mapIdToGpu")
    default Gpu mapIdToGpu(UUID gpuId) {
        return Gpu.builder()
                .id(gpuId)
                .build();
    }

    @Named("mapIdToPowerSupply")
    default PowerSupply mapIdToPowerSupply(UUID powerSupplyId) {
        return PowerSupply.builder()
                .id(powerSupplyId)
                .build();
    }

    @Named("mapIdToCooler")
    default Cooler mapIdToCooler(UUID coolerId) {
        return Cooler.builder()
                .id(coolerId)
                .build();
    }

    @Named("mapIdToCpu")
    default Cpu mapIdToCpu(UUID cpuId) {
        return Cpu.builder()
                .id(cpuId)
                .build();
    }

    @Mapping(target = "price", source = ".", qualifiedByName = "mapToMoney")
    @Mapping(source = "price", target = ".", ignore = true)
    @Mapping(source = "currency", target = ".", ignore = true)
    @Mapping(source = "motherboardId", target = "motherboard", qualifiedByName = "mapIdToMotherboard")
    @Mapping(source = "computerCaseId", target = "computerCase", qualifiedByName = "mapIdToComputerCase")
    @Mapping(source = "gpuId", target = "gpu", qualifiedByName = "mapIdToGpu")
    @Mapping(source = "powerSupplyId", target = "powerSupply", qualifiedByName = "mapIdToPowerSupply")
    @Mapping(source = "coolerId", target = "cooler", qualifiedByName = "mapIdToCooler")
    @Mapping(source = "cpuId", target = "cpu", qualifiedByName = "mapIdToCpu")
    Computer computerDtoToComputer(ComputerDto computerDto);

    List<ComputerDto> computerListToComputerDtoList(List<Computer> computerList);

    List<Computer> computerDtoListToComputerList(List<ComputerDto> computerDtoList);
}
