package org.yourssu.festa.common.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BoothErrorCode implements ErrorCode{
    BOOTH_NOT_FOUND(HttpStatus.NOT_FOUND, "요청한 부스를 찾을 수 없습니다."),
    BOOTH_UPLOAD_IMAGE_FAILED(HttpStatus.BAD_REQUEST, "File 전환 실패");
    private final HttpStatus httpStatus;
    private final String message;
}
