package com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.mappers;

import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.domain.PriceResponse;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapperEntity {
    PriceMapperEntity INSTANCE = Mappers.getMapper(PriceMapperEntity.class);

    @Mapping(source = "brand.id", target = "idBrand")
    @Mapping(source = "product.id", target = "idProduct")
    PriceResponse priceEntityToPriceResponse(PriceEntity priceEntity);

    @Mapping(source = "idBrand", target = "brand.id")
    @Mapping(source = "idProduct", target = "product.id")
    PriceEntity priceRequestToPriceEntity(PriceRequest priceRequest);

    List<PriceResponse> listPriceEntityToListPriceResponse(List<PriceEntity> priceEntityList);
}
