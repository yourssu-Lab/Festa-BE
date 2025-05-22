package org.yourssu.festa.common.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum AuthErrorCode implements ErrorCode{
    USER_NOT_REGISTERED(HttpStatus.BAD_REQUEST, "존재하지 않는 유저입니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
