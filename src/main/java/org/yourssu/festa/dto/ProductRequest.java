package org.yourssu.festa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequest(
        @NotBlank(message = "상품 이름은 비어있을수없습니다.")
        String name,
        @NotNull(message = "상품 가격은 비어있을수없습니다.")
        Integer price,
        @NotBlank(message = "상품 설명은 비어있을수없습니다.")
        String description,
        boolean soldout,
        @NotBlank(message = "상품 이미지는 비어있을수없습니다.")
        String imgUrl
) {
}