package com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities;

import com.inditex.RestServicePriceProduct.infrastructure.commons.Constants;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "PRICE")
public class PriceEntity {

    @Id
    @Column(name="PRICE_ID")
    private Long idPrice;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID")
    private BrandEntity brand;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name= "END_DATE")
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity product;

    private int priority;

    private double price;

    @Enumerated(EnumType.STRING)
    private Constants.Currency curr;


}
