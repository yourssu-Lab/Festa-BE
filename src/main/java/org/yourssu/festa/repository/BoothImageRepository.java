package org.yourssu.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yourssu.festa.domain.entity.BoothImageEntity;

import java.util.List;

public interface BoothImageRepository extends JpaRepository<BoothImageEntity, Long> {
    List<BoothImageEntity> getAllByBoothId(Long boothId);
}
