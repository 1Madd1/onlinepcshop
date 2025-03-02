package com.onlinepcshop.adapters.rest.dto.response;

import com.onlinepcshop.adapters.rest.dto.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultipleTablesResponse {
    List<ComputerDto> computerList;
    List<MotherboardDto> motherboardList;
    List<CpuDto> cpuList;
    List<GpuDto> gpuList;
    List<CaseFanDto> caseFanList;
    List<CoolerDto> coolerList;
    List<RamDto> ramList;
    List<StorageDto> storageList;
    List<PowerSupplyDto> powerSupplyList;
    List<ComputerCaseDto> computerCaseList;
}
