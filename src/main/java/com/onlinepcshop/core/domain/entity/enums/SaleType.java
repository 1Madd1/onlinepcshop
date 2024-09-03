package com.onlinepcshop.core.domain.entity.enums;

public enum SaleType {
    SALE_10("SALE 10% OFF"),
    SALE_15("SALE 15% OFF"),
    SALE_20("SALE 20% OFF"),
    SALE_25("SALE 25% OFF"),
    SALE_30("SALE 30% OFF"),
    SALE_35("SALE 35% OFF"),
    SALE_40("SALE 40% OFF"),
    SALE_45("SALE 45% OFF"),
    SALE_50("SALE 50% OFF");

    private final String description;

    // Constructor for the enum
    SaleType(String description) {
        this.description = description;
    }

    // Getter to retrieve the description
    public String getDescription() {
        return description;
    }
}
