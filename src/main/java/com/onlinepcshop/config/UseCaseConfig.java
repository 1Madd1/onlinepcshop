package com.onlinepcshop.config;

import com.onlinepcshop.core.repository.*;
import com.onlinepcshop.core.security.SecurityProvider;
import com.onlinepcshop.core.usecase.*;
import com.onlinepcshop.core.usecase.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    UserUseCase userUseCase(UserRepository userRepository, SecurityProvider securityProvider) {
        return UserUseCaseImpl.builder()
                .userRepository(userRepository)
                .securityProvider(securityProvider)
                .build();
    }

    @Bean
    CaseFanUseCase caseFanUseCase(CaseFanRepository caseFanRepository) {
        return CaseFanUseCaseImpl.builder()
                .caseFanRepository(caseFanRepository)
                .build();
    }

    @Bean
    ComputerCaseUseCase computerCaseUseCase(ComputerCaseRepository computerCaseRepository) {
        return ComputerCaseUseCaseImpl.builder()
                .computerCaseRepository(computerCaseRepository)
                .build();
    }

    @Bean
    CpuUseCase cpuUseCase(CpuRepository cpuRepository) {
        return CpuUseCaseImpl.builder()
                .cpuRepository(cpuRepository)
                .build();
    }

    @Bean
    MotherboardUseCase motherboardUseCase(MotherboardRepository motherboardRepository,
                                          PcieInterfaceRepository pcieInterfaceRepository,
                                          StorageInterfaceRepository storageInterfaceRepository,
                                          MotherboardPcieInterfaceRepository motherboardPcieInterfaceRepository,
                                          MotherboardStorageInterfaceRepository motherboardStorageInterfaceRepository) {
        return MotherboardUseCaseImpl.builder()
                .motherboardRepository(motherboardRepository)
                .pcieInterfaceRepository(pcieInterfaceRepository)
                .storageInterfaceRepository(storageInterfaceRepository)
                .motherboardPcieInterfaceRepository(motherboardPcieInterfaceRepository)
                .motherboardStorageInterfaceRepository(motherboardStorageInterfaceRepository)
                .build();
    }

    @Bean
    CoolerUseCase coolerUseCase(CoolerRepository coolerRepository) {
        return CoolerUseCaseImpl.builder()
                .coolerRepository(coolerRepository)
                .build();
    }

    @Bean
    GpuUseCase gpuUseCase(GpuRepository gpuRepository) {
        return GpuUseCaseImpl.builder()
                .gpuRepository(gpuRepository)
                .build();
    }

    @Bean
    PowerSupplyUseCase powerSupplyUseCase(PowerSupplyRepository powerSupplyRepository) {
        return PowerSupplyUseCaseImpl.builder()
                .powerSupplyRepository(powerSupplyRepository)
                .build();
    }

    @Bean
    RamUseCase ramUseCase(RamRepository ramRepository) {
        return RamUseCaseImpl.builder()
                .ramRepository(ramRepository)
                .build();
    }

    @Bean
    StorageUseCase storageUseCase(StorageRepository storageRepository) {
        return StorageUseCaseImpl.builder()
                .storageRepository(storageRepository)
                .build();
    }

    @Bean
    PcieInterfaceUseCase pcieInterfaceUseCase(PcieInterfaceRepository pcieInterfaceRepository) {
        return PcieInterfaceUseCaseImpl.builder()
                .pcieInterfaceRepository(pcieInterfaceRepository)
                .build();
    }

    @Bean
    StorageInterfaceUseCase storageInterfaceUseCase(StorageInterfaceRepository storageInterfaceRepository) {
        return StorageInterfaceUseCaseImpl.builder()
                .storageInterfaceRepository(storageInterfaceRepository)
                .build();
    }
}
