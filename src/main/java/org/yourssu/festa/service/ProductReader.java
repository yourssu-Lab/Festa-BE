package org.yourssu.festa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yourssu.festa.common.code.BoothErrorCode;
import org.yourssu.festa.domain.Product;
import org.yourssu.festa.domain.ProductEntity;
import org.yourssu.festa.exception.CustomException;
import org.yourssu.festa.repository.BoothRepository;
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
