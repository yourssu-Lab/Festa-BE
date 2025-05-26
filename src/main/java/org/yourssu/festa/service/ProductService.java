package org.yourssu.festa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yourssu.festa.domain.Product;
import org.yourssu.festa.domain.entity.ProductEntity;
import org.yourssu.festa.dto.ProductListResponse;
import org.yourssu.festa.dto.ProductRequest;
import org.yourssu.festa.dto.ProductResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductReader productReader;
    private final BoothReader boothReader;
    private final ProductSaver productSaver;

    public ProductListResponse getAllProduct(Long boothId){
        boothReader.findById(boothId);

        List<Product> productList = productReader.getAllByBoothId(boothId)
                .stream()
                .map(Product::toDomain)
                .toList();

        return ProductListResponse.of(
                productList.stream().map(ProductResponse::from).toList()
        );
    }

    @Transactional
    public void create(Long boothId, ProductRequest request){
        ProductEntity productEntity = ProductEntity.toEntity(boothId, request);
        productSaver.save(productEntity);
    }
}
