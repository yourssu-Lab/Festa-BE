package org.yourssu.festa.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;
import org.yourssu.festa.common.code.AuthErrorCode;
import org.yourssu.festa.common.code.CommonErrorCode;
import org.yourssu.festa.common.code.ErrorCode;
import org.yourssu.festa.common.response.ApiResponse;
import org.yourssu.festa.exception.CustomException;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtExceptionFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    protected void doFilterInternal(
            @NonNull final HttpServletRequest request,
            @NonNull final HttpServletResponse response,
            @NonNull final FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (MalformedJwtException e) {
            handleException(response, AuthErrorCode.TOKEN_MALFORMED_ERROR, e);
        } catch (IllegalArgumentException e) {
            handleException(response, AuthErrorCode.TOKEN_TYPE_ERROR, e);
        } catch (ExpiredJwtException e) {
            handleException(response, AuthErrorCode.EXPIRED_TOKEN_ERROR, e);
        } catch (UnsupportedJwtException e) {
            handleException(response, AuthErrorCode.TOKEN_UNSUPPORTED_ERROR, e);
        } catch (JwtException e) {
            handleException(response, AuthErrorCode.TOKEN_UNKNOWN_ERROR, e);
        } catch (CustomException e) {
            handleException(response, e.getErrorCode(), e);
        } catch (Exception e) {
            handleException(response, CommonErrorCode.INTERNAL_SERVER_ERROR, e);
        }
    }

    private void handleException(
            HttpServletResponse response,
            ErrorCode errorCode,
            Exception e
    ) throws IOException {

        response.setStatus(errorCode.getHttpStatus().value());
        response.setContentType("application/json;charset=UTF-8");

        ApiResponse<?> baseResponse = ApiResponse.onFailure(errorCode);

        // JSON 직렬화 후 응답
        response.getWriter().write(
                objectMapper.writeValueAsString(baseResponse)
        );

    }
}
