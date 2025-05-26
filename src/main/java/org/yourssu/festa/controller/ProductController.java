package org.yourssu.festa.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.yourssu.festa.common.code.CommonSuccessCode;
import org.yourssu.festa.common.response.ApiResponse;
import org.yourssu.festa.dto.ProductListResponse;
import org.yourssu.festa.dto.ProductRequest;
import org.yourssu.festa.dto.ProductResponse;
import org.yourssu.festa.service.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/booths")
@Tag(name = "Product", description = "Product 관련 API입니다.")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{boothId}/products")
    @Operation(summary = "상품 목록 조회", description = "부스 ID를 통해 해당 부스의 상품 목록을 조회합니다.")
    public ResponseEntity<ApiResponse<ProductListResponse>> getAllProduct(
            @PathVariable Long boothId
    ){
        ProductListResponse response = productService.getAllProduct(boothId);
        return ResponseEntity.ok(ApiResponse.onSuccess(CommonSuccessCode.OK, response));
    }

    @PostMapping("/product")
    @Operation(summary = "상품 정보 입력", description = "상품 정보를 입력(생성)합니다.")
    public ResponseEntity<ApiResponse<Void>> postProduct(
            @AuthenticationPrincipal Long boothId,
            @Valid @RequestBody ProductRequest request
    ){
        productService.create(boothId, request);
        return ResponseEntity.ok().build();
    }

}
