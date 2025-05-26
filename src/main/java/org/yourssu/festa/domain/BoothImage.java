package org.yourssu.festa.domain;

import org.yourssu.festa.domain.entity.BoothImageEntity;

public record BoothImage(
        Long id,
        String imgUrl,
        Long boothId
) {
    public static BoothImage toDomain(BoothImageEntity boothImageEntity) {
        return new BoothImage(
                boothImageEntity.getId(),
                boothImageEntity.getImgUrl(),
                boothImageEntity.getBoothId()
        );
    }
}
