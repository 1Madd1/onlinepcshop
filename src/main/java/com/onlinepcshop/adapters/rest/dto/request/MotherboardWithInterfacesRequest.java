package com.onlinepcshop.adapters.rest.dto.request;

import com.onlinepcshop.adapters.rest.dto.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotherboardWithInterfacesRequest {
    MotherboardDto motherboard;
    List<PcieInterfaceDto> pcieInterfaceList;
    List<StorageInterfaceDto> storageInterfaceList;
    List<MotherboardStorageInterfaceDto> storageInterfacesToBeRemovedList;
    List<MotherboardPcieInterfaceDto> pcieInterfacesToBeRemovedList;
}
