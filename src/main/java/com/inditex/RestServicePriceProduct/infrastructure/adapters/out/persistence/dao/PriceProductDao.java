package com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.dao;

import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface PriceProductDao extends JpaRepository<PriceEntity, Long> {

    @Query(value = "SELECT * " +
            "FROM PRICE price " +
            "WHERE price.PRODUCT_ID = :#{#priceEntity.product.id} " +
            "AND price.BRAND_ID = :#{#priceEntity.brand.id} " +
            "AND :applicationDate BETWEEN price.START_DATE AND price.END_DATE " +
            "ORDER BY price.priority DESC " +
            "LIMIT 1", nativeQuery = true)
    PriceEntity getPriceByPriceEntityAndApplicationDate(@Param("priceEntity") PriceEntity priceEntity, LocalDateTime applicationDate);
}
