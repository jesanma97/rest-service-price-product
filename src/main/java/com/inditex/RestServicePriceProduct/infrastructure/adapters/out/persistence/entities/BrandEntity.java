package com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "BRAND")
public class BrandEntity {
    @Id
    private long id;

    @Column(name = "BRAND_NAME")
    private String nameBrand;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<PriceEntity> prices;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public List<PriceEntity> getPrices() {
        return prices;
    }

    public void setPrices(List<PriceEntity> prices) {
        this.prices = prices;
    }
}
