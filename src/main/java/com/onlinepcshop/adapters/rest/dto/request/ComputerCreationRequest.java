package com.onlinepcshop.adapters.rest.dto.request;

import com.onlinepcshop.adapters.rest.dto.ComputerCaseFanDto;
import com.onlinepcshop.adapters.rest.dto.ComputerDto;
import com.onlinepcshop.adapters.rest.dto.ComputerRamDto;
import com.onlinepcshop.adapters.rest.dto.ComputerStorageDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComputerCreationRequest {
    ComputerDto computer;
    List<ComputerRamDto> computerRamList;
    List<ComputerStorageDto> computerStorageList;
    List<ComputerCaseFanDto> computerCaseFanList;
    List<ComputerRamDto> computerRamsToBeRemovedList;
    List<ComputerStorageDto> computerStoragesToBeRemovedList;
    List<ComputerCaseFanDto> computerCaseFansToBeRemovedList;
}
