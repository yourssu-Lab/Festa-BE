package org.yourssu.festa.dto;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import org.yourssu.festa.domain.Booth;
import org.yourssu.festa.domain.BoothImage;
import org.yourssu.festa.domain.enums.BoothStatus;

import java.util.List;

public record BoothDetailResponse(
        @Schema(description = "부스 이름", nullable = false, example = "...")
        String name,
        @Schema(description = "부스 한 줄 설명", nullable = false, example = "...")
        String summary,
        @Schema(description = "부스 설명", nullable = false, example = "...")
        String description,
        @Schema(description = "부스 상태", nullable = false, example = "OPEN")
        BoothStatus status,

        @ArraySchema(
                schema = @Schema(description = "포스터 이미지 URL 목록", example = "https://festa-bucket.s3.ap-northeast-2.amazonaws.com/image1.jpg")
        )
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
