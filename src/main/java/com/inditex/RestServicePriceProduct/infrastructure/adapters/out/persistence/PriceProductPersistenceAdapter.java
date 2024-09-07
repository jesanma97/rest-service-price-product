package com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence;

import com.inditex.RestServicePriceProduct.application.ports.out.PriceProductPersistencePort;
import com.inditex.RestServicePriceProduct.domain.PriceRequest;
import com.inditex.RestServicePriceProduct.domain.Price;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.in.web.dto.PriceResponseDTO;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.dao.PriceProductDao;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.entities.PriceEntity;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.mappers.PriceMapperEntity;
import com.inditex.RestServicePriceProduct.infrastructure.adapters.out.persistence.mappers.PriceResponseDTOMapper;
import com.inditex.RestServicePriceProduct.infrastructure.commons.exceptions.NotFoundPriceRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceProductPersistenceAdapter implements PriceProductPersistencePort {

    private final PriceProductDao priceProductDao;


    @Autowired
    public PriceProductPersistenceAdapter(PriceProductDao priceProductDao){
        this.priceProductDao = priceProductDao;
    }

    @Override
    public PriceResponseDTO getPriceByPriceRequest(PriceRequest priceRequest) {
        PriceEntity priceEntity = PriceMapperEntity.INSTANCE.priceRequestToPriceEntity(priceRequest);
        PriceEntity foundPriceEntity  = priceProductDao.getPriceByPriceEntityAndApplicationDate(priceEntity, priceRequest.getApplicationDate());
        if (foundPriceEntity == null) {
            throw new NotFoundPriceRequestException("No price found for the given parameters.");
        }
        Price priceDomain = PriceMapperEntity.INSTANCE.priceEntityToPrice(foundPriceEntity);
        return  PriceResponseDTOMapper.INSTANCE.priceDomainToPriceResponseDTO(priceDomain);
    }
}
