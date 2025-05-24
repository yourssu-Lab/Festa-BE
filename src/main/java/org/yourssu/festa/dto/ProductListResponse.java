package org.yourssu.festa.dto;

import org.yourssu.festa.domain.Product;

import java.util.List;

public record ProductListResponse(
        List<ProductResponse> productList
) {
    public static ProductListResponse from(List<ProductResponse> productList){
        return new ProductListResponse(productList);
    }
}
