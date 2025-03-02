package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.ProductRating;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRatingUseCase {
    /***
     *  Create and persist an agent
     *
     * @param productRating newly created productRating
     * @return Valid productRating object with id
     */
    ProductRating createProductRating(ProductRating productRating);

    /***
     *  Update productRating data fields
     * @param productRating must be a valid productRating object with valid id
     * @return Updated productRating object
     */
    ProductRating updateProductRating(ProductRating productRating);

    /***
     *
     * @return List of all productRatings
     */
    List<ProductRating> findAllProductRatings();


    /***
     * @param productRatingId valid productRating UUID
     * @return ProductRating with provided agentId if one exists
     */
    Optional<ProductRating> findProductRatingById(UUID productRatingId);

    /***
     * Delete productRating with specified id
     * @param id must be a valid
     */
    void deleteProductRating(UUID id);

    /**
     * @param userId    valid user UUID
     * @param productId valid product UUID
     * @return - Existing ProductRating with given user id and product id
     */
    Optional<ProductRating> findProductRatingByUserIdAndProductId(UUID userId, UUID productId);
}
