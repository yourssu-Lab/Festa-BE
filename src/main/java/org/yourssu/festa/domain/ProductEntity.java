package org.yourssu.festa.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private String description;

    @ColumnDefault("false")
    private boolean soldout;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "booth_id", nullable = false)
    private Long boothId;

}
