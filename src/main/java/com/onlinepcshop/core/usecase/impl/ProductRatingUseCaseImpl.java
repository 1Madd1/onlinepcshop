package com.onlinepcshop.core.usecase.impl;

import com.onlinepcshop.core.domain.entity.ProductRating;
import com.onlinepcshop.core.repository.ProductRatingRepository;
import com.onlinepcshop.core.usecase.ProductRatingUseCase;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Builder
public class ProductRatingUseCaseImpl implements ProductRatingUseCase {
    private final ProductRatingRepository productRatingRepository;

    @Override
    public ProductRating createProductRating(ProductRating productRating) {
        return productRatingRepository.saveProductRating(productRating);
    }

    @Override
    public ProductRating updateProductRating(ProductRating productRating) {
        return productRatingRepository.saveProductRating(productRating);
    }

    @Override
    public List<ProductRating> findAllProductRatings() {
        return productRatingRepository.findAllProductRatings();
    }

    @Override
    public Optional<ProductRating> findProductRatingById(UUID productRatingId) {
        return productRatingRepository.findById(productRatingId);
    }

    @Override
    public void deleteProductRating(UUID id) {
        productRatingRepository.deleteProductRating(id);
    }

    @Override
    public Optional<ProductRating> findProductRatingByUserIdAndProductId(UUID userId, UUID productId) {
        return productRatingRepository.findByUserIdAndProductId(userId, productId);
    }
}
