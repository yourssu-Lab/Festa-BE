package org.yourssu.festa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yourssu.festa.common.code.CommonSuccessCode;
import org.yourssu.festa.common.response.ApiResponse;
import org.yourssu.festa.domain.enums.DayPeriod;
import org.yourssu.festa.dto.BoothDetailResponse;
import org.yourssu.festa.dto.BoothPreviewResponse;
import org.yourssu.festa.dto.BoothRequest;
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

    @GetMapping
    public ApiResponse<BoothPreviewResponse> getBoothPreview(@RequestParam int boothNum,
                                                             @RequestParam int dayNum,
                                                             @RequestParam DayPeriod dayPeriod) {
        BoothPreviewResponse response = boothService.getBoothPreview(boothNum, dayNum, dayPeriod);
        return ApiResponse.onSuccess(CommonSuccessCode.OK, response);
    }

    @PatchMapping
    public ApiResponse<Void> updateBooth(@AuthenticationPrincipal Long boothId, BoothRequest request) {
        boothService.updateBooth(boothId, request);
        return ApiResponse.onSuccess(CommonSuccessCode.OK);
    }
}
