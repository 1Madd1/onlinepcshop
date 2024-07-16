package com.onlinepcshop.adapters.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentDto {
    private UUID id;
    private String principalId;
    private String email;
    private String naziv;
    private String telefon;
    private UUID upravnikId;
}
