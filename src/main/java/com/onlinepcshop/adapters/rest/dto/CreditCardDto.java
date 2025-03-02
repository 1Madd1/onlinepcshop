package com.onlinepcshop.adapters.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDto {
    private UUID id;
    private String cardNumber;
    private String nameOnCard;
    private String expiryDate;
    private String cvv;
}
