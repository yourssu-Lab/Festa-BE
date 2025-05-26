package org.yourssu.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yourssu.festa.domain.entity.BoothEntity;
import org.yourssu.festa.domain.enums.DayNum;
import org.yourssu.festa.domain.enums.DayPeriod;

import java.util.List;
import java.util.Optional;

public interface BoothRepository extends JpaRepository<BoothEntity, Long> {

    Optional<BoothEntity> findBySerialNumAndBoothNum(int serialNum, int boothNum);
    Optional<BoothEntity> findFirstByBoothNumAndDayNumInAndDayPeriod(
            int boothNum,
            List<DayNum> dayNums,
            DayPeriod dayPeriod
    );
}
