package org.yourssu.festa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yourssu.festa.domain.Product;
import org.yourssu.festa.dto.ProductListResponse;
import org.yourssu.festa.dto.ProductResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductReader productReader;

    public ProductListResponse getAllProduct(Long boothId){
        List<Product> productList = productReader.getAllByBoothId(boothId).stream()
                .map(Product::fromEntity).toList();
        return ProductListResponse.from(productList.stream().map(ProductResponse::from).toList());
    }
}
