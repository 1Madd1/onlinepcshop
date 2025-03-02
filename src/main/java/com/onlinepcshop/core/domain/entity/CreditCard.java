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
public class CreditCard {
    UUID id;
    String cardNumber;
    String nameOnCard;
    String expiryDate;
    String cvv;
}
