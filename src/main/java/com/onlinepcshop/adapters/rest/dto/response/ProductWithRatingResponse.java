package com.onlinepcshop.adapters.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithRatingResponse {
    private String productName;
    private int amount;
    private String image;
    private BigDecimal price;
    private int rating;
    private String saleType;
}
