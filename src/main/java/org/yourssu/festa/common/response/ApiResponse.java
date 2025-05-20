package org.yourssu.festa.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.yourssu.festa.common.code.CommonSuccessCode;
import org.yourssu.festa.common.code.ErrorCode;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ApiResponse<T> {

    private final boolean isSuccess;
    private final int code;
    private final String message;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private T result;

    public static <T> ApiResponse<T> onSuccess(CommonSuccessCode successCode){
        return new ApiResponse<>(true, successCode.getHttpStatus().value(), successCode.getMessage());
    }

    public static <T> ApiResponse<T> onSuccess(CommonSuccessCode successCode, T data){
        return new ApiResponse<>(true, successCode.getHttpStatus().value(), successCode.getMessage(), data);
    }

    public static <T> ApiResponse<T> onFailure(ErrorCode errorCode){
        return new ApiResponse<>(false, errorCode.getHttpStatus().value(), errorCode.getMessage());
    }
}
