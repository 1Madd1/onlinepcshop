package com.onlinepcshop.adapters.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchasedProductResponse {
    private String productName;
    private int amount;
    private String image;
    private BigDecimal price;
    private LocalDate dateOfPurchase;
    private UUID productId;
}
