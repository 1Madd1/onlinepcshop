package com.onlinepcshop.adapters.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultipleTablesRequest {
    private List<UUID> computerIds;
    private List<UUID> computerCaseIds;
    private List<UUID> motherboardIds;
    private List<UUID> cpuIds;
    private List<UUID> gpuIds;
    private List<UUID> coolerIds;
    private List<UUID> powerSupplyIds;
    private List<UUID> storageIds;
    private List<UUID> ramIds;
    private List<UUID> caseFanIds;
}
