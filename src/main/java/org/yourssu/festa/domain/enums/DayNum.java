package org.yourssu.festa.domain.enums;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public enum DayNum {
    ONE(List.of(1)),
    TWO(List.of(2)),
    THREE(List.of(3)),
    ONE_TWO(List.of(1, 2)),
    TWO_THREE(List.of(2, 3));

    private final List<Integer> dayNumbers;

    public boolean contains(int input) {
        return dayNumbers.contains(input);
    }
}
