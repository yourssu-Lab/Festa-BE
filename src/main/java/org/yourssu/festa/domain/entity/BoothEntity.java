package org.yourssu.festa.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.yourssu.festa.domain.enums.BoothStatus;
import org.yourssu.festa.domain.enums.DayNum;
import org.yourssu.festa.domain.enums.DayPeriod;

@Entity
@Table(name = "booth")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BoothEntity extends BaseEntity {

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

    @Enumerated(EnumType.STRING)
    private BoothStatus status;

    @Column(name = "booth_num")
    private int boothNum;

    @Column
    private String description;

    @Column
    private String summary;

    public void update(String name, String summary, String description, BoothStatus status) {
        this.name = name;
        this.summary = summary;
        this.description = description;
        this.status = status;
    }
}
