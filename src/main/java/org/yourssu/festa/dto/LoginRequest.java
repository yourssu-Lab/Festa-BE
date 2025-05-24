package org.yourssu.festa.dto;

import jakarta.validation.constraints.NotNull;

public record LoginRequest(
        @NotNull(message = "부스 번호는 비어있을 수 없습니다.")
        Integer boothNumber,
        @NotNull(message = "식별 번호는 비어있을 수 없습니다.")
        Integer serialNumber
) {

}
