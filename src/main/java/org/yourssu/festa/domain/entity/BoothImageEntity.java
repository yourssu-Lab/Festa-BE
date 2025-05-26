package org.yourssu.festa.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "booth_img")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoothImageEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "booth_id", nullable = false)
    private Long boothId;

    public BoothImageEntity(String imgUrl, Long boothId) {
        this.imgUrl = imgUrl;
        this.boothId = boothId;
    }

    public static BoothImageEntity toEntity(String imgUrl, Long boothId) {
        return new BoothImageEntity(imgUrl, boothId);
    }
}
