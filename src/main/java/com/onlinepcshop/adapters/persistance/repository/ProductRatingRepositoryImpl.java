package com.onlinepcshop.adapters.persistance.repository;

import com.onlinepcshop.adapters.persistance.dao.ProductRatingDao;
import com.onlinepcshop.adapters.persistance.mapper.ProductRatingMapperDB;
import com.onlinepcshop.adapters.persistance.repository.jpa.ProductRatingJpaRepository;
import com.onlinepcshop.adapters.rest.dto.ProductRatingHelperDto;
import com.onlinepcshop.core.domain.entity.ProductRating;
import com.onlinepcshop.core.repository.ProductRatingRepository;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public class ProductRatingRepositoryImpl implements ProductRatingRepository {
    private final ProductRatingJpaRepository productRatingJpaRepository;


    @Override
    public List<ProductRating> findAllProductRatings() {
        return ProductRatingMapperDB.INSTANCE.productRatingDaoListToProductRatingList(productRatingJpaRepository.findAll());
    }

    @Override
    public List<ProductRating> findAllByUserId(UUID userId) {
        return ProductRatingMapperDB.INSTANCE.productRatingDaoListToProductRatingList(productRatingJpaRepository.findAllByUserId(userId));
    }

    @Override
    public Optional<ProductRating> findById(UUID productRatingId) {
        ProductRating productRating = ProductRatingMapperDB.INSTANCE.productRatingDaoToProductRating(productRatingJpaRepository.findById(productRatingId).orElse(null));
        return Optional.ofNullable(productRating);
    }

    @Override
    public ProductRating saveProductRating(ProductRating productRating) {
        ProductRatingDao productRatingDao = ProductRatingMapperDB.INSTANCE.productRatingToProductRatingDao(productRating);
        return ProductRatingMapperDB.INSTANCE.productRatingDaoToProductRating(productRatingJpaRepository.save(productRatingDao));
    }

    @Override
    public Double findAverageRatingByProductId(UUID productId) {
        return productRatingJpaRepository.findAverageRatingByProductId(productId);
    }

    @Override
    public void deleteProductRating(UUID id) {
        productRatingJpaRepository.deleteById(id);
    }

    @Override
    public List<ProductRatingHelperDto> findAllProductRatingsWithAvgRatingEqualOrHigherThan4() {
        return productRatingJpaRepository.findProductsWithAvgRatingEqualOrGreaterThan4();
    }

    @Override
    public Optional<ProductRating> findByUserIdAndProductId(UUID userId, UUID productId) {
        ProductRating productRating = ProductRatingMapperDB.INSTANCE.productRatingDaoToProductRating(productRatingJpaRepository.findByUserIdAndProductId(userId, productId).orElse(null));
        return Optional.ofNullable(productRating);
    }
}
