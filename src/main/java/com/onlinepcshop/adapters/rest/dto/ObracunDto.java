package com.onlinepcshop.adapters.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObracunDto {
        UUID id;
        String broj;
        LocalDate datumIzdavanjaRacuna;
        LocalDate datumPrometa;
        LocalDate datumValute;
        BigDecimal prethodniDug;
        String valuta;
        UUID obracunskiPeriodId;
        UUID posebniDeoId;
}
