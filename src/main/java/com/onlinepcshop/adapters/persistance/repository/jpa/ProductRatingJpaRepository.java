package com.onlinepcshop.adapters.persistance.repository.jpa;

import com.onlinepcshop.adapters.persistance.dao.ProductRatingDao;
import com.onlinepcshop.adapters.rest.dto.ProductRatingHelperDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRatingJpaRepository extends JpaRepository<ProductRatingDao, UUID> {
    List<ProductRatingDao> findAllByUserId(UUID userId);

    Optional<ProductRatingDao> findByUserIdAndProductId(UUID productId, UUID userId);

    @Query("SELECT new com.onlinepcshop.adapters.rest.dto.ProductRatingHelperDto(p.productId, p.productType, AVG(p.rating)) " +
            "FROM product_rating p " +
            "GROUP BY p.productId, p.productType " +
            "HAVING AVG(p.rating) >= 4")
    List<ProductRatingHelperDto> findProductsWithAvgRatingEqualOrGreaterThan4();

    @Query("SELECT COALESCE(AVG(pr.rating), 0) FROM product_rating pr WHERE pr.productId = :productId")
    Double findAverageRatingByProductId(@Param("productId") UUID productId);
}
