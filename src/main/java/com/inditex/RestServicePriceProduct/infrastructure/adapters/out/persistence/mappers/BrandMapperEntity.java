package com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.mappers;

import com.inditex.RestServicePriceProduct.domain.Brand;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapperEntity {
    BrandMapperEntity INSTANCE = Mappers.getMapper(BrandMapperEntity.class);

    Brand brandEntityToBrand(BrandEntity brand);
}
