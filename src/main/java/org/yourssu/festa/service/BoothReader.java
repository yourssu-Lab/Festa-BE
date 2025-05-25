package org.yourssu.festa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yourssu.festa.common.code.AuthErrorCode;
import org.yourssu.festa.common.code.BoothErrorCode;
import org.yourssu.festa.domain.entity.BoothEntity;
import org.yourssu.festa.domain.enums.DayNum;
import org.yourssu.festa.domain.enums.DayPeriod;
import org.yourssu.festa.exception.CustomException;
import org.yourssu.festa.repository.BoothRepository;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BoothReader {
    private final BoothRepository boothRepository;

    public BoothEntity findBySerialNumAndBoothNum(int serialNum, int boothNum){
        return boothRepository.findBySerialNumAndBoothNum(serialNum, boothNum)
                .orElseThrow(() -> new CustomException(AuthErrorCode.USER_NOT_REGISTERED));
    }

    public BoothEntity findById(Long id){
        return boothRepository.findById(id)
                .orElseThrow(() -> new CustomException(BoothErrorCode.BOOTH_NOT_FOUND));
    }

    public BoothEntity findByBoothNumAndDay(int boothNum, int dayNum, DayPeriod dayPeriod) {
        List<DayNum> matchedDayNums = Arrays.stream(DayNum.values())
                .filter(dn -> dn.contains(dayNum))
                .toList();

        return boothRepository.findFirstByBoothNumAndDayNumInAndDayPeriod(boothNum, matchedDayNums, dayPeriod)
                .orElseThrow(() -> new CustomException(BoothErrorCode.BOOTH_NOT_FOUND));
    }
}
