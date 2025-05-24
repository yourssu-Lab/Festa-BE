package org.yourssu.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yourssu.festa.domain.BoothEntity;
import org.yourssu.festa.domain.ProductEntity;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> getAllByBoothId(Long boothId);
}
