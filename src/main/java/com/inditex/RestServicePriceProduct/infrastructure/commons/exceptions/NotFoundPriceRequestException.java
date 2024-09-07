package com.inditex.RestServicePriceProduct.infrastructure.commons.exceptions;

public class NotFoundPriceRequestException extends RuntimeException {

    public NotFoundPriceRequestException(String message) {
        super(message);
    }
}
