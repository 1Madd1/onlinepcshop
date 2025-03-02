package com.onlinepcshop.adapters.rest.dto.response;

import com.onlinepcshop.adapters.rest.dto.PurchaseTransactionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchasedProductsResponse {
    List<PurchasedProductResponse> purchasedProductResponseList;
    PurchaseTransactionDto purchaseTransaction;
}
