package org.yourssu.festa.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "booth_img")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoothImageEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "booth_id", nullable = false)
    private Long boothId;

}
