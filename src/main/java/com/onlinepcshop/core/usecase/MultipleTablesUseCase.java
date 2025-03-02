package com.onlinepcshop.core.usecase;

import com.onlinepcshop.adapters.rest.dto.request.MultipleTablesRequest;
import com.onlinepcshop.adapters.rest.dto.request.PurchaseProductsRequest;
import com.onlinepcshop.adapters.rest.dto.response.MultipleTablesResponse;
import com.onlinepcshop.adapters.rest.dto.response.PurchasedProductsResponse;

import java.util.List;
import java.util.UUID;

public interface MultipleTablesUseCase {

    /**
     * @param productName - given product name for searching
     * @return A MultipleTableResponse which has data of all products that are on sale and contain given product name
     */
    MultipleTablesResponse getAllProductsOnSale(String productName);

    /**
     * @return A MultipleTableResponse which has data of all products that have 5 start rating
     */
    MultipleTablesResponse getAllTopRatedProducts();

    /**
     * @param productName - given product name for searching
     * @return A MultipleTableResponse which has data of all products that have been bought more than 2 times and
     * contain given product name
     */
    MultipleTablesResponse getAllPopularProducts(String productName);

    /**
     * @param productName - given product name for searching
     * @return A MultipleTableResponse which has data of all products that contain the given product name
     */
    MultipleTablesResponse getAllProductsByProductName(String productName);

    /**
     * @param productName - valid product name of existing products
     * @return A MultipleTableResponse which has data of all products that have been added recently and that pass the criteria
     */
    MultipleTablesResponse getAllNewProducts(String productName);

    /**
     * @param request - A request that holds id's of all requested components
     * @return - all requested components dto's
     */
    MultipleTablesResponse getAllRequestedComponents(MultipleTablesRequest request);

    /**
     * @param request - A request that holds buyer form info and all products to be purchased
     * @return - true if purchase process is successful, false if not
     */
    boolean purchaseProducts(PurchaseProductsRequest request);

    /**
     * @param userId - A valid user id
     * @return - A list of PurchasedProductsResponse which has transaction and a list of all bought products from the related transaction
     */
    List<PurchasedProductsResponse> getPurchaseHistoryByUserId(UUID userId);

}