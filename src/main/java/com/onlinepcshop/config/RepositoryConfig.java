package com.onlinepcshop.config;


import com.onlinepcshop.adapters.persistance.repository.*;
import com.onlinepcshop.adapters.persistance.repository.jpa.*;
import com.onlinepcshop.core.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    UserRepository userRepository(UserJpaRepository userJpaRepository) {
        return UserRepositoryImpl.builder()
                .userJpaRepository(userJpaRepository)
                .build();
    }

    @Bean
    CreditCardRepository creditCardRepository(CreditCardJpaRepository creditCardJpaRepository) {
        return CreditCardRepositoryImpl.builder()
                .creditCardJpaRepository(creditCardJpaRepository)
                .build();
    }

    @Bean
    CaseFanRepository caseFanRepository(CaseFanJpaRepository caseFanJpaRepository) {
        return CaseFanRepositoryImpl.builder()
                .caseFanJpaRepository(caseFanJpaRepository)
                .build();
    }

    @Bean
    ComputerCaseRepository computerCaseRepository(ComputerCaseJpaRepository computerCaseJpaRepository) {
        return ComputerCaseRepositoryImpl.builder()
                .computerCaseJpaRepository(computerCaseJpaRepository)
                .build();
    }

    @Bean
    CpuRepository cpuRepository(CpuJpaRepository cpuJpaRepository) {
        return CpuRepositoryImpl.builder()
                .cpuJpaRepository(cpuJpaRepository)
                .build();
    }

    @Bean
    MotherboardRepository motherboardRepository(MotherboardJpaRepository motherboardJpaRepository) {
        return MotherboardRepositoryImpl.builder()
                .motherboardJpaRepository(motherboardJpaRepository)
                .build();
    }

    @Bean
    CoolerRepository coolerRepository(CoolerJpaRepository coolerJpaRepository) {
        return CoolerRepositoryImpl.builder()
                .coolerJpaRepository(coolerJpaRepository)
                .build();
    }

    @Bean
    GpuRepository gpuRepository(GpuJpaRepository gpuJpaRepository) {
        return GpuRepositoryImpl.builder()
                .gpuJpaRepository(gpuJpaRepository)
                .build();
    }

    @Bean
    PowerSupplyRepository powerSupplyRepository(PowerSupplyJpaRepository powerSupplyJpaRepository) {
        return PowerSupplyRepositoryImpl.builder()
                .powerSupplyJpaRepository(powerSupplyJpaRepository)
                .build();
    }

    @Bean
    RamRepository ramRepository(RamJpaRepository ramJpaRepository) {
        return RamRepositoryImpl.builder()
                .ramJpaRepository(ramJpaRepository)
                .build();
    }

    @Bean
    StorageRepository storageRepository(StorageJpaRepository storageJpaRepository) {
        return StorageRepositoryImpl.builder()
                .storageJpaRepository(storageJpaRepository)
                .build();
    }

    @Bean
    PcieInterfaceRepository pcieInterfaceRepository(PcieInterfaceJpaRepository pcieInterfaceJpaRepository) {
        return PcieInterfaceRepositoryImpl.builder()
                .pcieInterfaceJpaRepository(pcieInterfaceJpaRepository)
                .build();
    }

    @Bean
    StorageInterfaceRepository storageInterfaceRepository(StorageInterfaceJpaRepository storageInterfaceJpaRepository) {
        return StorageInterfaceRepositoryImpl.builder()
                .storageInterfaceJpaRepository(storageInterfaceJpaRepository)
                .build();
    }

    @Bean
    MotherboardPcieInterfaceRepository motherboardPcieInterfaceRepository(MotherboardPcieInterfaceJpaRepository motherboardPcieInterfaceJpaRepository) {
        return MotherboardPcieInterfaceRepositoryImpl.builder()
                .motherboardPcieInterfaceJpaRepository(motherboardPcieInterfaceJpaRepository)
                .build();
    }

    @Bean
    MotherboardStorageInterfaceRepository motherboardStorageInterfaceRepository(MotherboardStorageInterfaceJpaRepository motherboardStorageInterfaceJpaRepository) {
        return MotherboardStorageInterfaceRepositoryImpl.builder()
                .motherboardStorageInterfaceJpaRepository(motherboardStorageInterfaceJpaRepository)
                .build();
    }

    @Bean
    ComputerRepository computerRepository(ComputerJpaRepository computerJpaRepository) {
        return ComputerRepositoryImpl.builder()
                .computerJpaRepository(computerJpaRepository)
                .build();
    }

    @Bean
    ComputerCaseFanRepository computerCaseFanRepository(ComputerCaseFanJpaRepository computerCaseFanJpaRepository) {
        return ComputerCaseFanRepositoryImpl.builder()
                .computerCaseFanJpaRepository(computerCaseFanJpaRepository)
                .build();
    }

    @Bean
    ComputerRamRepository computerRamRepository(ComputerRamJpaRepository computerRamJpaRepository) {
        return ComputerRamRepositoryImpl.builder()
                .computerRamJpaRepository(computerRamJpaRepository)
                .build();
    }

    @Bean
    ComputerStorageRepository computerStorageRepository(ComputerStorageJpaRepository computerStorageJpaRepository) {
        return ComputerStorageRepositoryImpl.builder()
                .computerStorageJpaRepository(computerStorageJpaRepository)
                .build();
    }

    @Bean
    PurchaseTransactionRepository purchaseTransactionRepository(PurchaseTransactionJpaRepository purchaseTransactionJpaRepository) {
        return PurchaseTransactionRepositoryImpl.builder()
                .purchaseTransactionJpaRepository(purchaseTransactionJpaRepository)
                .build();
    }

    @Bean
    PurchaseTransactionProductRepository purchaseTransactionProductRepository(PurchaseTransactionProductJpaRepository purchaseTransactionProductJpaRepository) {
        return PurchaseTransactionProductRepositoryImpl.builder()
                .purchaseTransactionProductJpaRepository(purchaseTransactionProductJpaRepository)
                .build();
    }

    @Bean
    ProductRatingRepository productRatingRepository(ProductRatingJpaRepository productRatingJpaRepository) {
        return ProductRatingRepositoryImpl.builder()
                .productRatingJpaRepository(productRatingJpaRepository)
                .build();
    }
}
