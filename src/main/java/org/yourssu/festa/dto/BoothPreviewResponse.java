package org.yourssu.festa.dto;

import org.yourssu.festa.domain.Booth;
import org.yourssu.festa.domain.BoothImage;

public record BoothPreviewResponse(
        Long boothId,
        String name,
        String summary,
        String imgUrl
) {
    public static BoothPreviewResponse from(Booth booth, BoothImage boothImage) {
        return new BoothPreviewResponse(
                booth.id(),
                booth.name(),
                booth.summary(),
                boothImage.imgUrl()
        );
    }
}
