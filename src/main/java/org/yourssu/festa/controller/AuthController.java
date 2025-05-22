package org.yourssu.festa.controller;

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
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(
            @Valid @RequestBody LoginRequest request
            ){
        LoginResponse response = authService.login(request);
        return ResponseEntity.ok(ApiResponse.onSuccess(CommonSuccessCode.OK, response));
    }
}
