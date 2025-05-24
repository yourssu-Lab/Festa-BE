package org.yourssu.festa.dto;

public record ProductResponse(
        Long id,
        String name,
        int price,
        String description,
        boolean soldout,
        String imgUrl
) {
}