package org.yourssu.festa.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Product {

    private final Long id;

    private final String name;

    private final int price;

    private final String description;

    private final boolean soldout;

    private final String imgUrl;

    private final Long boothId;

    public static Product fromEntity(ProductEntity productEntity){
        return new Product(productEntity.getId(), productEntity.getName(), productEntity.getPrice(), productEntity.getDescription(), productEntity.isSoldout(), productEntity.getImgUrl(), productEntity.getBoothId());
    }
}
