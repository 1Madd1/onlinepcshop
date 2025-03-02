package com.onlinepcshop.adapters.rest.controller;

import com.onlinepcshop.adapters.rest.dto.request.MultipleTablesRequest;
import com.onlinepcshop.adapters.rest.dto.request.PurchaseProductsRequest;
import com.onlinepcshop.adapters.rest.dto.response.MultipleTablesResponse;
import com.onlinepcshop.adapters.rest.dto.response.PurchasedProductsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("multiple-tables")
@RequiredArgsConstructor
public class MultipleTablesController {
    private final MultipleTablesUseCase multipleTablesUseCase;

    @GetMapping("/all-products-on-sale")
    public MultipleTablesResponse getAllProductsOnSale(@RequestParam Map<String, String> paramMap) {
        System.out.println("MultipleTablesController.getAllProductsOnSale called");
        String productName = paramMap.get("productName");
        if (productName == null) {
            productName = "";
        }
        return multipleTablesUseCase.getAllProductsOnSale(productName);
    }

    @GetMapping("/all-top-rated-products")
    public MultipleTablesResponse getAllTopRatedProducts() {
        System.out.println("MultipleTablesController.getAllTopRatedProducts called");
        return multipleTablesUseCase.getAllTopRatedProducts();
    }

    @GetMapping("/all-popular-products")
    public MultipleTablesResponse getAllPopularProducts(@RequestParam Map<String, String> paramMap) {
        System.out.println("MultipleTablesController.getAllPopularProducts called");
        String productName = paramMap.get("productName");
        if (productName == null) {
            productName = "";
        }
        return multipleTablesUseCase.getAllPopularProducts(productName);
    }

    @GetMapping("/all-new-products")
    public MultipleTablesResponse getAllNewProducts(@RequestParam Map<String, String> paramMap) {
        System.out.println("MultipleTablesController.getAllProductsOnSale called");
        String productName = paramMap.get("productName");
        if (productName == null) {
            productName = "";
        }
        return multipleTablesUseCase.getAllNewProducts(productName);
    }

    @GetMapping("/all-products-by-product-name")
    public MultipleTablesResponse getAllProductsByProductName(@RequestParam Map<String, String> paramMap) {
        System.out.println("MultipleTablesController.getAllProductsByProductName called");
        String productName = paramMap.get("productName");
        if (productName == null) {
            productName = "";
        }
        return multipleTablesUseCase.getAllProductsByProductName(productName);
    }

    @PostMapping("/all-requested-components")
    public MultipleTablesResponse getAllRequestedComponents(@RequestBody MultipleTablesRequest multipleTablesRequest) {
        System.out.println("MultipleTablesController.getAllRequestedComponents called");
        return multipleTablesUseCase.getAllRequestedComponents(multipleTablesRequest);
    }

    @PostMapping("/purchase-products")
    public boolean purchaseProducts(@RequestBody PurchaseProductsRequest purchaseProductsRequest) {
        System.out.println("MultipleTablesController.purchaseProducts called");
        return multipleTablesUseCase.purchaseProducts(purchaseProductsRequest);
    }

    @GetMapping("/purchase-history")
    public List<PurchasedProductsResponse> getPurchaseHistory(@RequestParam Map<String, String> paramMap) {
        System.out.println("MultipleTablesController.getPurchaseHistory called");
        UUID userId = UUID.fromString(paramMap.get("userId"));
        return multipleTablesUseCase.getPurchaseHistoryByUserId(userId);
    }
}
