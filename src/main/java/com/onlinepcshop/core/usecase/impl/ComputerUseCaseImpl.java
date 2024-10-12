package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.*;
import com.onlinepcshop.core.error.exception.*;
import com.onlinepcshop.core.repository.*;
import com.onlinepcshop.core.usecase.ComputerUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Builder
public class ComputerUseCaseImpl implements ComputerUseCase {
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

    @Override
    public Computer createComputer(Computer computer) {
        Optional<Motherboard> motherboardOptional = motherboardRepository.findById(computer.getMotherboard().getId());
        Optional<ComputerCase> computerCaseOptional = computerCaseRepository.findById(computer.getComputerCase().getId());
        Optional<Gpu> gpuOptional = Optional.empty();
        if (computer.getGpu().getId() != null) {
            gpuOptional = gpuRepository.findById(computer.getGpu().getId());
        }
        Optional<PowerSupply> powerSupplyOptional = powerSupplyRepository.findById(computer.getPowerSupply().getId());
        Optional<Cooler> coolerOptional = Optional.empty();
        if (computer.getCooler().getId() != null) {
            coolerOptional = coolerRepository.findById(computer.getCooler().getId());
        }
        Optional<Cpu> cpuOptional = cpuRepository.findById(computer.getCpu().getId());

        if(computerCaseOptional.isEmpty()) {
            System.out.println("ComputerCase with id " + computer.getComputerCase().getId() + " not found");
            throw new ComputerCaseNotFoundException("Computer Case with id " + computer.getComputerCase().getId() + " not found.");
        }

        if(motherboardOptional.isEmpty()) {
            System.out.println("Motherboard with id " + computer.getMotherboard().getId() + " not found");
            throw new MotherboardNotFoundException("Motherboard with id " + computer.getMotherboard().getId() + " not found.");
        }

        if(cpuOptional.isEmpty()) {
            System.out.println("Cpu with id " + computer.getCpu().getId() + " not found");
            throw new CpuNotFoundException("Cpu with id " + computer.getCpu().getId() + " not found.");
        }

        if(gpuOptional.isEmpty() && !cpuOptional.get().getIncludesIntegratedGpu()) {
            System.out.println("Gpu with id " + computer.getGpu().getId() + " not found");
            throw new GpuNotFoundException("Gpu with id " + computer.getGpu().getId() + " not found.");
        }

        if(coolerOptional.isEmpty() && !cpuOptional.get().getIncludesCooler()) {
            System.out.println("Cooler with id " + computer.getCooler().getId() + " not found");
            throw new CoolerNotFoundException("Cooler with id " + computer.getCooler().getId() + " not found.");
        }

        if(powerSupplyOptional.isEmpty()) {
            System.out.println("PowerSupply with id " + computer.getPowerSupply().getId() + " not found");
            throw new PowerSupplyNotFoundException("Power Supply with id " + computer.getPowerSupply().getId() + " not found.");
        }

        computer.setMotherboard(motherboardOptional.get());
        computer.setComputerCase(computerCaseOptional.get());
        if (!gpuOptional.isEmpty()) {
            computer.setGpu(gpuOptional.get());
        } else {
            computer.setGpu(null);
        }
        computer.setPowerSupply(powerSupplyOptional.get());
        if (!coolerOptional.isEmpty()) {
            computer.setCooler(coolerOptional.get());
        } else {
            computer.setCooler(null);
        }
        computer.setCpu(cpuOptional.get());

        return computerRepository.saveComputer(computer);
    }

    @Override
    public Computer updateComputer(Computer computer) {
        return computerRepository.saveComputer(computer);
    }

    @Override
    public List<Computer> findAllComputers() {
        return computerRepository.findAllComputers();
    }

    @Override
    public Optional<Computer> findComputerById(UUID cpuComputerId) {
        return computerRepository.findById(cpuComputerId);
    }

    @Override
    public void deleteComputer(UUID id) {
        computerRepository.deleteComputer(id);
    }

    @Override
    public ComputerRam assignRam(UUID ramId, UUID computerId, Integer quantity) {
        Optional<Ram> ramOptional = ramRepository.findById(ramId);
        if(ramOptional.isEmpty()) {
            System.out.println("Ram with id " + ramId + " not found");
            throw new RamNotFoundException("Ram with id " + ramId + " not found");
        }
        Optional<Computer> computerOptional = computerRepository.findById(computerId);

        if(computerOptional.isEmpty()) {
            System.out.println("Computer with id " + computerId + " not found");
            throw new ComputerNotFoundException("Computer with id " + computerId + "not found");
        }

        for(ComputerRam computerRam : computerRamRepository.findAllByRamAndComputer(ramId, computerId)) {
            if (computerRam.getComputer().getId().equals(computerId)) {
                if (computerRam.getRam().getId().equals(ramId)) {
                    return null;
                }
            }
        }

        ComputerRam computerRam = ComputerRam.builder()
                .computer(Computer.builder().id(computerId).build())
                .ram(Ram.builder().id(ramId).build())
                .quantity(quantity)
                .build();
        return computerRamRepository.saveComputerRam(computerRam);
    }

    @Override
    public void unassignRam(UUID ramId, UUID computerId) {
        List<ComputerRam> computerRamList = computerRamRepository.findAllByRamAndComputer(ramId, computerId);
        if(computerRamList.isEmpty()) {
            System.out.println("Computer with id " + computerId + ", has no Ram with id " + ramId + " assigned");
            throw new RamNotAssignedException("Computer with id " + computerId + ", has no Ram with id " + ramId +" assigned.");
        }

        ComputerRam computerRam = computerRamList.get(0);

        computerRamRepository.deleteComputerRam(computerRam.getId());
    }

    @Override
    public ComputerStorage assignStorage(UUID storageId, UUID computerId, Integer quantity) {
        Optional<Storage> storageOptional = storageRepository.findById(storageId);
        if(storageOptional.isEmpty()) {
            System.out.println("Storage with id " + storageId + " not found");
            throw new StorageNotFoundException("Storage with id " + storageId + " not found");
        }
        Optional<Computer> computerOptional = computerRepository.findById(computerId);

        if(computerOptional.isEmpty()) {
            System.out.println("Computer with id " + computerId + " not found");
            throw new ComputerNotFoundException("Computer with id " + computerId + "not found");
        }

        for(ComputerStorage computerStorage : computerStorageRepository.findAllByStorageAndComputer(storageId, computerId)) {
            if (computerStorage.getComputer().getId().equals(computerId)) {
                if (computerStorage.getStorage().getId().equals(storageId)) {
                    return null;
                }
            }
        }

        ComputerStorage computerStorage = ComputerStorage.builder()
                .computer(Computer.builder().id(computerId).build())
                .storage(Storage.builder().id(storageId).build())
                .quantity(quantity)
                .build();
        return computerStorageRepository.saveComputerStorage(computerStorage);
    }

    @Override
    public void unassignStorage(UUID storageId, UUID computerId) {
        List<ComputerStorage> computerStorageList = computerStorageRepository.findAllByStorageAndComputer(storageId, computerId);
        if(computerStorageList.isEmpty()) {
            System.out.println("Computer with id " + computerId + ", has no Storage with id " + storageId + " assigned");
            throw new StorageNotAssignedException("Computer with id " + computerId + ", has no Storage with id " + storageId +" assigned.");
        }

        ComputerStorage computerStorage = computerStorageList.get(0);

        computerStorageRepository.deleteComputerStorage(computerStorage.getId());
    }

    @Override
    public ComputerCaseFan assignCaseFan(UUID caseFanId, UUID computerId, Integer quantity) {
        Optional<CaseFan> caseFanOptional = caseFanRepository.findById(caseFanId);
        if(caseFanOptional.isEmpty()) {
            System.out.println("Case Fan with id " + caseFanId + " not found");
            throw new StorageNotFoundException("Case fan with id " + caseFanId + " not found");
        }
        Optional<Computer> computerOptional = computerRepository.findById(computerId);

        if(computerOptional.isEmpty()) {
            System.out.println("Computer with id " + computerId + " not found");
            throw new ComputerNotFoundException("Computer with id " + computerId + "not found");
        }

        for(ComputerCaseFan computerCaseFan : computerCaseFanRepository.findAllByCaseFanAndComputer(caseFanId, computerId)) {
            if (computerCaseFan.getComputer().getId().equals(computerId)) {
                if (computerCaseFan.getCaseFan().getId().equals(caseFanId)) {
                    return null;
                }
            }
        }

        ComputerCaseFan computerCaseFan = ComputerCaseFan.builder()
                .computer(Computer.builder().id(computerId).build())
                .caseFan(CaseFan.builder().id(caseFanId).build())
                .quantity(quantity)
                .build();
        return computerCaseFanRepository.saveComputerCaseFan(computerCaseFan);
    }

    @Override
    public void unassignCaseFan(UUID caseFanId, UUID computerId) {
        List<ComputerCaseFan> computerCaseFanList = computerCaseFanRepository.findAllByCaseFanAndComputer(caseFanId, computerId);
        if(computerCaseFanList.isEmpty()) {
            System.out.println("Computer with id " + computerId + ", has no Case Fan with id " + caseFanId + " assigned");
            throw new CaseFanNotAssignedException("Computer with id " + computerId + ", has no Case Fan with id " + caseFanId +" assigned.");
        }

        ComputerCaseFan computerCaseFan = computerCaseFanList.get(0);

        computerCaseFanRepository.deleteComputerCaseFan(computerCaseFan.getId());
    }

//    Dodati da komponente budu assignovani
}
