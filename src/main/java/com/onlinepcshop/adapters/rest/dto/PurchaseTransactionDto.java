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
public class PurchaseTransactionDto {
    private UUID id;
    private LocalDate dateOfPurchase;
    private BigDecimal totalPrice;
    private String buyerFirstName;
    private String buyerLastName;
    private String buyerEmail;
    private String buyerPhoneNumber;
    private String buyerStreet;
    private String buyerPostalCode;
    private String paymentType;

    private UUID userId;
}
