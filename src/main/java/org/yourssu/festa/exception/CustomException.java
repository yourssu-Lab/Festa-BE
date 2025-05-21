package org.yourssu.festa.exception;

import lombok.Getter;
import org.yourssu.festa.common.code.ErrorCode;

@Getter
public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}