package com.onlinepcshop.core.repository;

import com.onlinepcshop.adapters.rest.dto.ProductRatingHelperDto;
import com.onlinepcshop.core.domain.entity.ProductRating;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRatingRepository {
    List<ProductRating> findAllProductRatings();

    List<ProductRating> findAllByUserId(UUID userId);

    Optional<ProductRating> findById(UUID productRatingId);

    ProductRating saveProductRating(ProductRating productRating);

    Double findAverageRatingByProductId(UUID productId);

    void deleteProductRating(UUID id);

    List<ProductRatingHelperDto> findAllProductRatingsWithAvgRatingEqualOrHigherThan4();

    Optional<ProductRating> findByUserIdAndProductId(UUID userId, UUID productId);
}
