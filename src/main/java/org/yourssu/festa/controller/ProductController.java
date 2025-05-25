package org.yourssu.festa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yourssu.festa.common.code.CommonSuccessCode;
import org.yourssu.festa.common.response.ApiResponse;
import org.yourssu.festa.dto.ProductListResponse;
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

}
