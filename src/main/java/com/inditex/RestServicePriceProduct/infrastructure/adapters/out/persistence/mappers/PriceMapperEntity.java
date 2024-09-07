package com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.mappers;

import com.inditex.RestServicePriceProduct.domain.Price;
import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapperEntity {
    PriceMapperEntity INSTANCE = Mappers.getMapper(PriceMapperEntity.class);

    @Mapping(target = "brand.prices", ignore = true)
    @Mapping(target = "product.prices", ignore = true)
    Price priceEntityToPrice(PriceEntity priceEntity);

    @Mapping(source = "idBrand", target = "brand.id")
    @Mapping(source = "idProduct", target = "product.id")
    PriceEntity priceRequestToPriceEntity(PriceRequest priceRequest);
}
