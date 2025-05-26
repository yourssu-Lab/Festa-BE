package org.yourssu.festa.dto;

import java.util.List;

public record ImageResponse(
        List<String> imageList
) {
    public static ImageResponse of(List<String> imageList){
        return new ImageResponse(imageList);
    }
}
