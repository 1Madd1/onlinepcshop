package com.onlinepcshop.config;


import com.onlinepcshop.adapters.persistance.repository.*;
import com.onlinepcshop.adapters.persistance.repository.jpa.*;
import com.onlinepcshop.core.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
//    @Bean
//    PosebniDeoRepository posebniDeoRepository(PosebniDeoJpaRepository posebniDeoJpaRepository,
//            PosebniDeoPagingAndSortingRepository posebniDeoPagingAndSortingRepository,
//            JPAStreamer jpaStreamer){
//        return PosebniDeoRepositoryImpl.builder()
//                .posebniDeoJpaRepository(posebniDeoJpaRepository)
//                .posebniDeoPagingAndSortingRepository(posebniDeoPagingAndSortingRepository)
//                .jpaStreamer(jpaStreamer)
//                .build();
//    }

    @Bean
    UserRepository userRepository(UserJpaRepository userJpaRepository) {
        return UserRepositoryImpl.builder()
                .userJpaRepository(userJpaRepository)
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
    CpuCoolerRepository cpuCoolerRepository(CpuCoolerJpaRepository cpuCoolerJpaRepository) {
        return CpuCoolerRepositoryImpl.builder()
                .cpuCoolerJpaRepository(cpuCoolerJpaRepository)
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

//    @Bean
//    VlasnikRepository vlasnikRepository(VlasnikJpaRepository vlasnikJpaRepository,
//                                        VlasnikPagingAndSortingRepository vlasnikPagingAndSortingRepository,
//                                        JPAStreamer jpaStreamer) {
//        return VlasnikRepositoryImpl.builder()
//                .vlasnikJpaRepository(vlasnikJpaRepository)
//                .vlasnikPagingAndSortingRepository(vlasnikPagingAndSortingRepository)
//                .jpaStreamer(jpaStreamer)
//                .build();
//    }
}
