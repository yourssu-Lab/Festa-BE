package org.yourssu.festa.dto;

import org.yourssu.festa.domain.Product;

public record ProductResponse(
        Long id,
        String name,
        int price,
        String description,
        boolean soldout,
        String imgUrl
) {
    public static ProductResponse from(Product product){
        return new ProductResponse(product.getId(), product.getName(), product.getPrice(), product.getDescription(), product.isSoldout(), product.getImgUrl());
    }
}