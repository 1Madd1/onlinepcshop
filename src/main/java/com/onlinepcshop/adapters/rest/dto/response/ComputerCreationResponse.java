package com.onlinepcshop.adapters.rest.dto.response;

import com.onlinepcshop.adapters.rest.dto.ComputerCaseFanDto;
import com.onlinepcshop.adapters.rest.dto.ComputerDto;
import com.onlinepcshop.adapters.rest.dto.ComputerRamDto;
import com.onlinepcshop.adapters.rest.dto.ComputerStorageDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComputerCreationResponse {
    ComputerDto computer;
    List<ComputerRamDto> computerRamList;
    List<ComputerStorageDto> computerStorageList;
    List<ComputerCaseFanDto> computerCaseFanList;
}
