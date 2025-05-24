package org.yourssu.festa.dto;

import java.util.List;

public record ProductListResponse(
        List<ProductResponse> productList
) {
}
