package org.yourssu.festa.common.code;

import org.springframework.http.HttpStatus;

public interface ApiCode {
    HttpStatus getHttpStatus();
    String getMessage();
}
