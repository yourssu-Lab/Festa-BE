package org.yourssu.festa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.yourssu.festa.common.code.CommonSuccessCode;
import org.yourssu.festa.common.response.ApiResponse;
import org.yourssu.festa.dto.ImageResponse;
import org.yourssu.festa.service.StorageService;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/storage")
public class StorageController {

    private final StorageService boothService;

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse<ImageResponse>> uploadFile(
            @RequestPart("file") List<MultipartFile> multipartFiles
    ) throws IOException {
        ImageResponse response = boothService.upload(multipartFiles);
        return ResponseEntity.ok(ApiResponse.onSuccess(CommonSuccessCode.CREATED, response));
    }
}
