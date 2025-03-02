package com.onlinepcshop.adapters.rest.dto.request;

import com.onlinepcshop.adapters.rest.dto.CreditCardDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCreditCardRequest {
    private UUID userId;
    private CreditCardDto creditCard;
}
