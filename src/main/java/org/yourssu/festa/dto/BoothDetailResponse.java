package org.yourssu.festa.dto;

import org.yourssu.festa.domain.Booth;
import org.yourssu.festa.domain.BoothImage;
import org.yourssu.festa.domain.enums.BoothStatus;

import java.util.List;

public record BoothDetailResponse(
        String name,
        String summary,
        String description,
        BoothStatus status,
        List<String> posterImages
) {
    public static BoothDetailResponse from(Booth booth, List<BoothImage> boothImages) {
        List<String> imageUrls = boothImages.stream()
                .map(BoothImage::imgUrl)
                .toList();

        return new BoothDetailResponse(
                booth.name(),
                booth.summary(),
                booth.description(),
                booth.status(),
                imageUrls
        );
    }
}
