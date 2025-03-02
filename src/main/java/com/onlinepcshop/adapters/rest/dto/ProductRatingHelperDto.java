package com.onlinepcshop.adapters.rest.dto;

import java.util.UUID;

public class ProductRatingHelperDto {
    private UUID productId;
    private String productType;
    private Double avgRating;

    public ProductRatingHelperDto(UUID productId, String productType, Double avgRating) {
        this.productId = productId;
        this.productType = productType;
        this.avgRating = avgRating;
    }

    public UUID getProductId() {
        return productId;
    }

    public String getProductType() {
        return productType;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    @Override
    public String toString() {
        return "ProductRatingHelperDto{" +
                "productId=" + productId +
                ", productType='" + productType + '\'' +
                ", totalPurchased=" + avgRating +
                '}';
    }
}
