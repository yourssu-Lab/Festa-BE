package org.yourssu.festa.controller;

import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "부스 상세 조회", description = "부스 ID를 통해 해당 부스의 상세 정보를 조회합니다.")
    public ApiResponse<BoothDetailResponse> getBoothDetail(@PathVariable Long boothId) {
        BoothDetailResponse response = boothService.getBoothDetail(boothId);
        return ApiResponse.onSuccess(CommonSuccessCode.OK, response);
    }

    @GetMapping
    @Operation(summary = "부스 미리보기", description = "부스 번호, 일차, 주야간 구분 정보를 통해 부스를 조회합니다.")
    public ApiResponse<BoothPreviewResponse> getBoothPreview(@RequestParam int boothNum,
                                                             @RequestParam int dayNum,
                                                             @RequestParam DayPeriod dayPeriod) {
        BoothPreviewResponse response = boothService.getBoothPreview(boothNum, dayNum, dayPeriod);
        return ApiResponse.onSuccess(CommonSuccessCode.OK, response);
    }

    @PatchMapping
    @Operation(summary = "부스 정보 입력", description = "부스 정보를 입력(수정)합니다.")
    public ApiResponse<Void> updateBooth(@AuthenticationPrincipal Long boothId, BoothRequest request) {
        boothService.updateBooth(boothId, request);
        return ApiResponse.onSuccess(CommonSuccessCode.OK);
    }
}
