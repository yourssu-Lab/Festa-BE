package org.yourssu.festa.controller;

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
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{boothId}/products")
    public ResponseEntity<ApiResponse<ProductListResponse>> getAllProduct(
            @PathVariable Long boothId
    ){
        ProductListResponse response = productService.getAllProduct(boothId);
        return ResponseEntity.ok(ApiResponse.onSuccess(CommonSuccessCode.OK, response));
    }

    @PostMapping("/product")
    public ResponseEntity<ApiResponse<Void>> postProduct(
            @AuthenticationPrincipal Long boothId,
            @Valid @RequestBody ProductRequest request
    ){
        productService.create(boothId, request);
        return ResponseEntity.ok().build();
    }

}
