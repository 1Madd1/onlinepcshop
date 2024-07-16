package com.onlinepcshop.core.domain.entity;


import com.onlinepcshop.core.domain.value.Money;

import java.util.UUID;

public record Uplatnica(UUID id, String pozivNaBroj, String model,
                        String uplatilac, String primalac, String svrhaUplate,
                        String racunPrimaoca, Money iznos, String sifraPlacanja) {

}
