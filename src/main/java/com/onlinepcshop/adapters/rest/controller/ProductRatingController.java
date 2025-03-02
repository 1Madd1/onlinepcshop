package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.ProductRatingDto;
import com.onlinepcshop.adapters.rest.mapper.ProductRatingMapperApi;
import com.onlinepcshop.core.domain.entity.ProductRating;
import com.onlinepcshop.core.usecase.ProductRatingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("product-rating")
@RequiredArgsConstructor
public class ProductRatingController {

    private final ProductRatingUseCase productRatingUseCase;

    @GetMapping("/{id}")
    public ProductRatingDto getById(@PathVariable(name = "id") UUID productRatingId) {
        System.out.println("ProductRatingController.geyById with id: " + productRatingId + " called");
        Optional<ProductRating> productRating = productRatingUseCase.findProductRatingById(productRatingId);
        if (productRating.isEmpty()) {
            System.out.println("ProductRating with id " + productRatingId + " not found");
            return null;
        }
        return ProductRatingMapperApi.INSTANCE.productRatingToProductRatingDto(productRating.get());
    }

    @PostMapping
    public ProductRatingDto createProductRating(@RequestBody ProductRatingDto productRatingDto) {
        System.out.println("ProductRatingController.createProductRating called - " + productRatingDto);

        ProductRating createdProductRating = productRatingUseCase.createProductRating(ProductRatingMapperApi.INSTANCE.productRatingDtoToProductRating(productRatingDto));
        return ProductRatingMapperApi.INSTANCE.productRatingToProductRatingDto(createdProductRating);
    }

    @PutMapping
    public ProductRatingDto updateProductRating(@RequestBody ProductRatingDto productRatingDto) {
        System.out.println("ProductRatingController.updateProductRating called - " + productRatingDto);

        ProductRating updatedProductRating = productRatingUseCase.updateProductRating(ProductRatingMapperApi.INSTANCE.productRatingDtoToProductRating(productRatingDto));
        return ProductRatingMapperApi.INSTANCE.productRatingToProductRatingDto(updatedProductRating);
    }

    @DeleteMapping
    public void deleteProductRatingById(@RequestParam UUID productRatingId) {
        System.out.println("ProductRatingController.deleteProductRatingById called for productRatingId - " + productRatingId);
        productRatingUseCase.deleteProductRating(productRatingId);
    }

    @GetMapping
    public List<ProductRatingDto> findAll() {
        System.out.println("ProductRatingController.findAll called");
        return ProductRatingMapperApi.INSTANCE.productRatingListToProductRatingDtoList(productRatingUseCase.findAllProductRatings());
    }

    @GetMapping("find-by-user-id-and-product-id")
    public ProductRatingDto findProductRatingByUserIdAndProductId(@RequestParam Map<String, String> paramMap) {
        System.out.println("ProductRatingController.findAll called");
        UUID userId = UUID.fromString(paramMap.get("userId"));
        UUID productId = UUID.fromString(paramMap.get("productId"));
        Optional<ProductRating> productRating = productRatingUseCase.findProductRatingByUserIdAndProductId(userId, productId);
        if (productRating.isEmpty()) {
            System.out.println("ProductRating with user id " + userId + " and product id" + productId + " not found");
            return null;
        }
        return ProductRatingMapperApi.INSTANCE.productRatingToProductRatingDto(productRating.get());
    }

}
