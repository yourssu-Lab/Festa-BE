package org.yourssu.festa.domain;

import org.yourssu.festa.dto.ProductRequest;

public record Product(
        Long id,
        String name,
        int price,
        String description,
        boolean soldout,
        String imgUrl,
        Long boothId
) {
    public static Product toDomain(ProductEntity productEntity){
        return new Product(productEntity.getId(), productEntity.getName(), productEntity.getPrice(), productEntity.getDescription(), productEntity.isSoldout(), productEntity.getImgUrl(), productEntity.getBoothId());
    }
}
