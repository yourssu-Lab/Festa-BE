package org.yourssu.festa.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
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
@Tag(name = "Storage", description = "Storage 관련 API입니다.")
public class StorageController {

    private final StorageService boothService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "파일 업로드", description = "파일을 업로드하여 URL을 생성합니다.")
    public ResponseEntity<ApiResponse<ImageResponse>> uploadFile(
            @RequestPart("file") List<MultipartFile> multipartFiles
    ) throws IOException {
        ImageResponse response = boothService.upload(multipartFiles);
        return ResponseEntity.ok(ApiResponse.onSuccess(CommonSuccessCode.CREATED, response));
    }
}
