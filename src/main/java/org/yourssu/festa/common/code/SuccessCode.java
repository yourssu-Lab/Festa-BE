package org.yourssu.festa.common.code;

import org.springframework.http.HttpStatus;

public interface SuccessCode {
    HttpStatus getHttpStatus();
    String getMessage();
}

