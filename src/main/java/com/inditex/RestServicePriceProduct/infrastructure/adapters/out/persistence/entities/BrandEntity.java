package com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "BRAND")
public class BrandEntity {
    @Id
    private long id;

    @Column(name = "BRAND_NAME")
    private String nameBrand;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<PriceEntity> prices;
}
