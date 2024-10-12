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
    CaseFanUseCase caseFanUseCase(CaseFanRepository caseFanRepository,
                                  ComputerCaseFanRepository computerCaseFanRepository) {
        return CaseFanUseCaseImpl.builder()
                .caseFanRepository(caseFanRepository)
                .computerCaseFanRepository(computerCaseFanRepository)
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
    GpuUseCase gpuUseCase(GpuRepository gpuRepository,
                          MotherboardPcieInterfaceRepository motherboardPcieInterfaceRepository,
                          PcieInterfaceRepository pcieInterfaceRepository) {
        return GpuUseCaseImpl.builder()
                .gpuRepository(gpuRepository)
                .motherboardPcieInterfaceRepository(motherboardPcieInterfaceRepository)
                .pcieInterfaceRepository(pcieInterfaceRepository)
                .build();
    }

    @Bean
    PowerSupplyUseCase powerSupplyUseCase(PowerSupplyRepository powerSupplyRepository) {
        return PowerSupplyUseCaseImpl.builder()
                .powerSupplyRepository(powerSupplyRepository)
                .build();
    }

    @Bean
    RamUseCase ramUseCase(RamRepository ramRepository,
                          ComputerRamRepository computerRamRepository) {
        return RamUseCaseImpl.builder()
                .ramRepository(ramRepository)
                .computerRamRepository(computerRamRepository)
                .build();
    }

    @Bean
    StorageUseCase storageUseCase(StorageRepository storageRepository,
                                  MotherboardStorageInterfaceRepository motherboardStorageInterfaceRepository,
                                  StorageInterfaceRepository storageInterfaceRepository,
                                  ComputerStorageRepository computerStorageRepository) {
        return StorageUseCaseImpl.builder()
                .storageRepository(storageRepository)
                .motherboardStorageInterfaceRepository(motherboardStorageInterfaceRepository)
                .storageInterfaceRepository(storageInterfaceRepository)
                .computerStorageRepository(computerStorageRepository)
                .build();
    }

    @Bean
    PcieInterfaceUseCase pcieInterfaceUseCase(PcieInterfaceRepository pcieInterfaceRepository,
                                              MotherboardPcieInterfaceRepository motherboardPcieInterfaceRepository) {
        return PcieInterfaceUseCaseImpl.builder()
                .pcieInterfaceRepository(pcieInterfaceRepository)
                .motherboardPcieInterfaceRepository(motherboardPcieInterfaceRepository)
                .build();
    }

    @Bean
    StorageInterfaceUseCase storageInterfaceUseCase(StorageInterfaceRepository storageInterfaceRepository,
                                                    MotherboardStorageInterfaceRepository motherboardStorageInterfaceRepository) {
        return StorageInterfaceUseCaseImpl.builder()
                .storageInterfaceRepository(storageInterfaceRepository)
                .motherboardStorageInterfaceRepository(motherboardStorageInterfaceRepository)
                .build();
    }

    @Bean
    ComputerUseCase computerUseCase(ComputerRepository computerRepository,
                                    ComputerCaseRepository computerCaseRepository,
                                    MotherboardRepository motherboardRepository,
                                    CpuRepository cpuRepository,
                                    CoolerRepository coolerRepository,
                                    GpuRepository gpuRepository,
                                    PowerSupplyRepository powerSupplyRepository,
                                    RamRepository ramRepository,
                                    StorageRepository storageRepository,
                                    CaseFanRepository caseFanRepository,
                                    ComputerRamRepository computerRamRepository,
                                    ComputerStorageRepository computerStorageRepository,
                                    ComputerCaseFanRepository computerCaseFanRepository) {
        return ComputerUseCaseImpl.builder()
                .computerRepository(computerRepository)
                .computerCaseRepository(computerCaseRepository)
                .motherboardRepository(motherboardRepository)
                .cpuRepository(cpuRepository)
                .coolerRepository(coolerRepository)
                .gpuRepository(gpuRepository)
                .powerSupplyRepository(powerSupplyRepository)
                .ramRepository(ramRepository)
                .storageRepository(storageRepository)
                .caseFanRepository(caseFanRepository)
                .computerRamRepository(computerRamRepository)
                .computerStorageRepository(computerStorageRepository)
                .computerCaseFanRepository(computerCaseFanRepository)
                .build();
    }
}
