package com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "PRODUCT")
public class ProductEntity {
    @Id
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<PriceEntity> prices;
}
