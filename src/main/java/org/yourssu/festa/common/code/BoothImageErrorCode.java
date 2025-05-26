package org.yourssu.festa.common.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BoothImageErrorCode implements ErrorCode {
    BOOTH_IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "요청한 부스 이미지를 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
