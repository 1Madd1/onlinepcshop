package com.onlinepcshop.adapters.rest.dto.response;

import com.onlinepcshop.adapters.rest.dto.MotherboardDto;
import com.onlinepcshop.adapters.rest.dto.PcieInterfaceDto;
import com.onlinepcshop.adapters.rest.dto.StorageInterfaceDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MotherboardWithInterfacesResponse {
    MotherboardDto motherboard;
    List<PcieInterfaceDto> pcieInterfaceList;
    List<StorageInterfaceDto> storageInterfaceList;
}
