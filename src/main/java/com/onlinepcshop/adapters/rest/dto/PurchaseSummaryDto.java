package com.onlinepcshop.adapters.rest.dto;

import java.util.UUID;

public class PurchaseSummaryDto {
    private UUID productId;
    private String productType;
    private Long totalPurchased;

    public PurchaseSummaryDto(UUID productId, String productType, Long totalPurchased) {
        this.productId = productId;
        this.productType = productType;
        this.totalPurchased = totalPurchased;
    }

    public UUID getProductId() {
        return productId;
    }

    public String getProductType() {
        return productType;
    }

    public Long getTotalPurchased() {
        return totalPurchased;
    }

    @Override
    public String toString() {
        return "PurchaseSummaryDto{" +
                "productId=" + productId +
                ", productType='" + productType + '\'' +
                ", totalPurchased=" + totalPurchased +
                '}';
    }
}
