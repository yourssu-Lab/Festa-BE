package org.yourssu.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yourssu.festa.domain.entity.BoothEntity;

import java.util.Optional;

public interface BoothRepository extends JpaRepository<BoothEntity, Long> {

    Optional<BoothEntity> findBySerialNumAndBoothNum(int serialNum, int boothNum);

}
