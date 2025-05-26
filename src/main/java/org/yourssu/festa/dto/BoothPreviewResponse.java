package org.yourssu.festa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import org.yourssu.festa.domain.Booth;
import org.yourssu.festa.domain.BoothImage;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BoothPreviewResponse(
        @Schema(description = "부스 ID", nullable = false, example = "1")
        Long boothId,
        @Schema(description = "부스 이름", nullable = false, example = "...")
        String name,
        @Schema(description = "부스 한 줄 설명", nullable = false, example = "...")
        String summary,
        @Schema(description = "부스 이미지 URL", nullable = false, example = "...")
        String imgUrl
) {
    public static BoothPreviewResponse from(Booth booth, BoothImage boothImage) {
        return new BoothPreviewResponse(
                booth.id(),
                booth.name(),
                booth.summary(),
                boothImage != null ? boothImage.imgUrl() : null
        );
    }
}
