package com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.dao;

import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceProductDao extends JpaRepository<PriceEntity, Long> {

    @Query(value = "SELECT price " +
            "FROM PriceEntity price " +
            "WHERE price.product.id = :#{#priceEntity.product.id} " +
            "AND price.brand.id = :#{#priceEntity.brand.id} " +
            "AND :#{#priceEntity.applicationDate} BETWEEN price.startDate AND price.endDate " +
            "ORDER BY price.priority DESC")
    List<PriceEntity> getAllPricesByPriceEntity(@Param("priceEntity") PriceEntity priceEntity);
}
