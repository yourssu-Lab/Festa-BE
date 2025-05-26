package org.yourssu.festa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yourssu.festa.domain.entity.ProductEntity;
import org.yourssu.festa.repository.ProductRepository;

@Component
@RequiredArgsConstructor
public class ProductSaver {
    private final ProductRepository productRepository;

    public void save(ProductEntity productEntity){
        productRepository.save(productEntity);
    }
}
