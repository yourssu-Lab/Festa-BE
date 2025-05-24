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
            @NonNull final FilterChain filterChain) throws IOException,ServletException {
        try {
            filterChain.doFilter(request, response);
        } catch (MalformedJwtException e) {
            request.setAttribute("exception", AuthErrorCode.TOKEN_MALFORMED_ERROR);
        } catch (IllegalArgumentException e) {
            request.setAttribute("exception", AuthErrorCode.TOKEN_TYPE_ERROR);
        } catch (ExpiredJwtException e) {
            request.setAttribute("exception", AuthErrorCode.EXPIRED_TOKEN_ERROR);
        } catch (UnsupportedJwtException e) {
            request.setAttribute("exception", AuthErrorCode.TOKEN_UNSUPPORTED_ERROR);
        } catch (JwtException e) {
            request.setAttribute("exception", AuthErrorCode.TOKEN_UNKNOWN_ERROR);
        } catch (CustomException e) {
            request.setAttribute("exception", e.getErrorCode());
        } catch (Exception e) {
            request.setAttribute("exception", CommonErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
}
