package org.yourssu.festa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yourssu.festa.domain.entity.ProductEntity;
import org.yourssu.festa.repository.ProductRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductReader {
    private final ProductRepository productRepository;

    public List<ProductEntity> getAllByBoothId(Long boothId){
        return productRepository.getAllByBoothId(boothId);
    }
}
