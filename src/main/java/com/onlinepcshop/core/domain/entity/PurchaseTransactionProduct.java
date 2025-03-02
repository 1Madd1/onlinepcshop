package com.onlinepcshop.core.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseTransactionProduct {
    UUID id;
    UUID productId;
    PurchaseTransaction purchaseTransaction;
    String productType;
    Integer amount;
    BigDecimal priceAtTheTime;
}
