package org.yourssu.festa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yourssu.festa.common.code.CommonSuccessCode;
import org.yourssu.festa.common.response.ApiResponse;
import org.yourssu.festa.dto.BoothDetailResponse;
import org.yourssu.festa.service.BoothService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/booths")
public class BoothController {

    private final BoothService boothService;

    @GetMapping("/{boothId}")
    public ApiResponse<BoothDetailResponse> getBoothDetail(@PathVariable Long boothId) {
        BoothDetailResponse response = boothService.getBoothDetail(boothId);
        return ApiResponse.onSuccess(CommonSuccessCode.OK, response);
    }
}
