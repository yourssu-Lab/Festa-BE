package org.yourssu.festa.domain;

import org.yourssu.festa.domain.entity.BoothEntity;
import org.yourssu.festa.domain.enums.BoothStatus;
import org.yourssu.festa.domain.enums.DayNum;
import org.yourssu.festa.domain.enums.DayPeriod;

public record Booth(
        Long id,
        String name,
        int serialNum,
        DayNum dayNum,
        DayPeriod dayPeriod,

        BoothStatus status,

        int boothNum,
        String description,
        String summary
) {

    public static Booth toDomain(BoothEntity boothEntity){
        return new Booth(boothEntity.getId(),
                boothEntity.getName(),
                boothEntity.getSerialNum(),
                boothEntity.getDayNum(),
                boothEntity.getDayPeriod(),
                boothEntity.getStatus(),
                boothEntity.getBoothNum(),
                boothEntity.getDescription(),
                boothEntity.getSummary()
        );
    }
}
