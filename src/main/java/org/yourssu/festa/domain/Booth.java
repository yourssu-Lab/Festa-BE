package org.yourssu.festa.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.yourssu.festa.domain.enums.DayNum;
import org.yourssu.festa.domain.enums.DayPeriod;

@Getter
@RequiredArgsConstructor
public class Booth {

    private final Long id;

    private final String name;

    private final int serialNum;

    private final DayNum dayNum;

    private final DayPeriod dayPeriod;

    private final int boothNum;

    private final String description;

    public static Booth fromEntity(BoothEntity boothEntity){
        return new Booth(boothEntity.getId(), boothEntity.getName(), boothEntity.getSerialNum(), boothEntity.getDayNum(), boothEntity.getDayPeriod(), boothEntity.getBoothNum(), boothEntity.getDescription());
    }
}
