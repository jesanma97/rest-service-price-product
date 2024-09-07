package com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.mappers;

import com.inditex.RestServicePriceProduct.domain.Product;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapperEntity {
    ProductMapperEntity INSTANCE = Mappers.getMapper(ProductMapperEntity.class);

    Product productEntityToProduct(ProductEntity productEntity);

}
