package com.onlinepcshop.adapters.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateObracunPDFRequest {
    private UUID obracunskiPeriodId;
    private UUID obracunId;
    private UUID posebanDeoId;
}
