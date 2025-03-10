package com.onlinepcshop.adapters.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemoveCreditCardRequest {
    private UUID userId;
    private UUID creditCardId;
}
