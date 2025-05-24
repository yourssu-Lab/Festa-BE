package org.yourssu.festa.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.yourssu.festa.common.code.AuthErrorCode;
import org.yourssu.festa.common.code.CommonErrorCode;
import org.yourssu.festa.common.code.ErrorCode;
import org.yourssu.festa.common.response.ApiResponse;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;


    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) throws IOException {
        ErrorCode errorCode = (ErrorCode) request.getAttribute("exception");
        if (errorCode == null) {
            errorCode = AuthErrorCode.UNAUTHORIZED;
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(errorCode.getHttpStatus().value());

        ApiResponse<?> baseResponse = ApiResponse.onFailure(errorCode);

        // JSON 직렬화
        response.getWriter().write(
            objectMapper.writeValueAsString(baseResponse)
        );
    }
}
