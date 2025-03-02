package com.onlinepcshop.adapters.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRatingDto {
    private UUID id;
    private UUID productId;
    private String productType;
    private Integer rating;
    private UUID userId;
}
