package org.yourssu.festa.dto;

import org.yourssu.festa.domain.enums.BoothStatus;

import java.util.List;

public record BoothRequest(
        String name,
        String summary,
        String description,
        BoothStatus status,
        List<String> posterImages
) {
}
