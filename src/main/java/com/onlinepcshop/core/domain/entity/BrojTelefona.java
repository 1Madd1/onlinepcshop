package com.onlinepcshop.core.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrojTelefona {
    UUID id;
    String brojTelefona;
    Vlasnik vlasnik;
}
