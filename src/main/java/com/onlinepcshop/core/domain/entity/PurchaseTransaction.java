package com.onlinepcshop.core.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseTransaction {
    UUID id;
    User user;
    LocalDate dateOfPurchase;
    BigDecimal totalPrice;
    String buyerFirstName;
    String buyerLastName;
    String buyerEmail;
    String buyerPhoneNumber;
    String buyerStreet;
    String buyerPostalCode;
    String paymentType;
}
