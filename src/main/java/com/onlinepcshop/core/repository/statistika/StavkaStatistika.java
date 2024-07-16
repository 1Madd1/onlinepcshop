package com.onlinepcshop.core.repository.statistika;

import com.deavensoft.eobracuni.core.domain.entity.Stavka;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StavkaStatistika {
    Stavka stavka;
    BigDecimal cenaProsliMesec;
    BigDecimal cenaPreprosliMesec;
    BigDecimal cenaPreGodDana;
}
