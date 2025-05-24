package org.yourssu.festa.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.yourssu.festa.domain.enums.DayNum;
import org.yourssu.festa.domain.enums.DayPeriod;

@Entity
@Table(name = "booth")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BoothEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "serial_num")
    private int serialNum;

    @Enumerated(EnumType.STRING)
    private DayNum dayNum;

    @Enumerated(EnumType.STRING)
    private DayPeriod dayPeriod;

    @Column(name = "booth_num")
    private int boothNum;

    @Column
    private String description;
}
