package org.yourssu.festa.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yourssu.festa.common.code.CommonSuccessCode;
import org.yourssu.festa.common.code.SuccessCode;
import org.yourssu.festa.common.response.ApiResponse;
import org.yourssu.festa.dto.LoginRequest;
import org.yourssu.festa.dto.LoginResponse;
import org.yourssu.festa.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
@Tag(name = "Auth", description = "Auth 관련 API입니다.")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "로그인", description = "부스 번호와 일련 번호를 통해 로그인 후, JWT accessToken을 발급합니다.")
    public ResponseEntity<ApiResponse<LoginResponse>> login(
            @Valid @RequestBody LoginRequest request
            ){
        LoginResponse response = authService.login(request);
        return ResponseEntity.ok(ApiResponse.onSuccess(CommonSuccessCode.OK, response));
    }
}
