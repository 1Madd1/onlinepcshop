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
    UserUseCase userUseCase(UserRepository userRepository,
                            SecurityProvider securityProvider) {
        return UserUseCaseImpl.builder()
                .userRepository(userRepository)
                .securityProvider(securityProvider)
                .build();
    }

    @Bean
    CreditCardUseCase creditCardUseCase(CreditCardRepository creditCardRepository) {
        return CreditCardUseCaseImpl.builder()
                .creditCardRepository(creditCardRepository)
                .build();
    }

    @Bean
    CaseFanUseCase caseFanUseCase(CaseFanRepository caseFanRepository,
                                  ComputerCaseFanRepository computerCaseFanRepository,
                                  ProductRatingRepository productRatingRepository) {
        return CaseFanUseCaseImpl.builder()
                .caseFanRepository(caseFanRepository)
                .productRatingRepository(productRatingRepository)
                .computerCaseFanRepository(computerCaseFanRepository)
                .build();
    }

    @Bean
    ComputerCaseUseCase computerCaseUseCase(ComputerCaseRepository computerCaseRepository,
                                            ProductRatingRepository productRatingRepository) {
        return ComputerCaseUseCaseImpl.builder()
                .computerCaseRepository(computerCaseRepository)
                .productRatingRepository(productRatingRepository)
                .build();
    }

    @Bean
    CpuUseCase cpuUseCase(CpuRepository cpuRepository,
                          ProductRatingRepository productRatingRepository) {
        return CpuUseCaseImpl.builder()
                .cpuRepository(cpuRepository)
                .productRatingRepository(productRatingRepository)
                .build();
    }

    @Bean
    MotherboardUseCase motherboardUseCase(MotherboardRepository motherboardRepository,
                                          PcieInterfaceRepository pcieInterfaceRepository,
                                          StorageInterfaceRepository storageInterfaceRepository,
                                          MotherboardPcieInterfaceRepository motherboardPcieInterfaceRepository,
                                          MotherboardStorageInterfaceRepository motherboardStorageInterfaceRepository,
                                          ProductRatingRepository productRatingRepository) {
        return MotherboardUseCaseImpl.builder()
                .motherboardRepository(motherboardRepository)
                .pcieInterfaceRepository(pcieInterfaceRepository)
                .storageInterfaceRepository(storageInterfaceRepository)
                .motherboardPcieInterfaceRepository(motherboardPcieInterfaceRepository)
                .motherboardStorageInterfaceRepository(motherboardStorageInterfaceRepository)
                .productRatingRepository(productRatingRepository)
                .build();
    }

    @Bean
    CoolerUseCase coolerUseCase(CoolerRepository coolerRepository,
                                ProductRatingRepository productRatingRepository) {
        return CoolerUseCaseImpl.builder()
                .coolerRepository(coolerRepository)
                .productRatingRepository(productRatingRepository)
                .build();
    }

    @Bean
    GpuUseCase gpuUseCase(GpuRepository gpuRepository,
                          MotherboardPcieInterfaceRepository motherboardPcieInterfaceRepository,
                          PcieInterfaceRepository pcieInterfaceRepository,
                          ProductRatingRepository productRatingRepository) {
        return GpuUseCaseImpl.builder()
                .gpuRepository(gpuRepository)
                .motherboardPcieInterfaceRepository(motherboardPcieInterfaceRepository)
                .pcieInterfaceRepository(pcieInterfaceRepository)
                .productRatingRepository(productRatingRepository)
                .build();
    }

    @Bean
    PowerSupplyUseCase powerSupplyUseCase(PowerSupplyRepository powerSupplyRepository,
                                          ProductRatingRepository productRatingRepository) {
        return PowerSupplyUseCaseImpl.builder()
                .powerSupplyRepository(powerSupplyRepository)
                .productRatingRepository(productRatingRepository)
                .build();
    }

    @Bean
    RamUseCase ramUseCase(RamRepository ramRepository,
                          ComputerRamRepository computerRamRepository,
                          ProductRatingRepository productRatingRepository) {
        return RamUseCaseImpl.builder()
                .ramRepository(ramRepository)
                .computerRamRepository(computerRamRepository)
                .productRatingRepository(productRatingRepository)
                .build();
    }

    @Bean
    StorageUseCase storageUseCase(StorageRepository storageRepository,
                                  MotherboardStorageInterfaceRepository motherboardStorageInterfaceRepository,
                                  StorageInterfaceRepository storageInterfaceRepository,
                                  ComputerStorageRepository computerStorageRepository,
                                  ProductRatingRepository productRatingRepository) {
        return StorageUseCaseImpl.builder()
                .storageRepository(storageRepository)
                .motherboardStorageInterfaceRepository(motherboardStorageInterfaceRepository)
                .storageInterfaceRepository(storageInterfaceRepository)
                .computerStorageRepository(computerStorageRepository)
                .productRatingRepository(productRatingRepository)
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
    ProductRatingUseCase productRatingUseCase(ProductRatingRepository productRatingRepository) {
        return ProductRatingUseCaseImpl.builder()
                .productRatingRepository(productRatingRepository)
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
                                    ComputerCaseFanRepository computerCaseFanRepository,
                                    ProductRatingRepository productRatingRepository) {
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
                .productRatingRepository(productRatingRepository)
                .build();
    }

    @Bean
    MultipleTablesUseCase multipleTablesUseCase(ComputerRepository computerRepository,
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
                                                ComputerCaseFanRepository computerCaseFanRepository,
                                                PurchaseTransactionRepository purchaseTransactionRepository,
                                                PurchaseTransactionProductRepository purchaseTransactionProductRepository,
                                                ProductRatingRepository productRatingRepository) {
        return MultipleTablesUseCaseImpl.builder()
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
                .computerStorageRepository(computerStorageRepository)
                .computerCaseFanRepository(computerCaseFanRepository)
                .computerRamRepository(computerRamRepository)
                .purchaseTransactionRepository(purchaseTransactionRepository)
                .purchaseTransactionProductRepository(purchaseTransactionProductRepository)
                .productRatingRepository(productRatingRepository)
                .build();
    }
}
