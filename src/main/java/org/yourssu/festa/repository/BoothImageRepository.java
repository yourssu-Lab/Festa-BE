package org.yourssu.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yourssu.festa.domain.entity.BoothImageEntity;

import java.util.List;
import java.util.Optional;

public interface BoothImageRepository extends JpaRepository<BoothImageEntity, Long> {
    List<BoothImageEntity> findAllByBoothId(Long boothId);

    Optional<BoothImageEntity> findFirstByBoothIdOrderByIdAsc(Long boothId);
}
