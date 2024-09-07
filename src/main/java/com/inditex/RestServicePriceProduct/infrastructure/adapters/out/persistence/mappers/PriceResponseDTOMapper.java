package com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.mappers;

import com.inditex.RestServicePriceProduct.domain.Price;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.in.web.dto.PriceResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceResponseDTOMapper {
    PriceResponseDTOMapper INSTANCE = Mappers.getMapper(PriceResponseDTOMapper.class);

    @Mapping(source = "brand.id", target = "idBrand")
    @Mapping(source = "product.id", target = "idProduct")
    PriceResponseDTO priceDomainToPriceResponseDTO(Price priceDomain);

}
