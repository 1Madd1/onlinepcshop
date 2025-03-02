package com.onlinepcshop.adapters.rest.dto.request;

import com.onlinepcshop.adapters.rest.dto.PurchaseTransactionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseProductsRequest {
    private List<PurchaseProductRequest> purchaseProductRequests;
    PurchaseTransactionDto purchaseTransaction;
}
