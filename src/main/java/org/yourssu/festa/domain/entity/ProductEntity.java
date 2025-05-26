package org.yourssu.festa.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.yourssu.festa.dto.ProductRequest;

@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductEntity extends BaseEntity {
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

    public ProductEntity(String name, int price, String description, String imgUrl, Long boothId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.soldout = false; // 기본값
        this.imgUrl = imgUrl;
        this.boothId = boothId;
    }

    public static ProductEntity toEntity(final Long boothId, final ProductRequest productRequest) {
        return new ProductEntity(
                productRequest.name(),
                productRequest.price(),
                productRequest.description(),
                productRequest.imgUrl(),
                boothId
        );
    }
}


