package com.onlinepcshop.adapters.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseProductRequest {
    private UUID productId;
    private int amount;
    private BigDecimal price;
    private String productType;
}
