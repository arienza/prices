package com.kairosds.pricesgrid.application.request.price;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;

@Getter
public class PriceProductUseCaseRequest {

    private final long brand;
    private final long product;
    private final LocalDateTime dateTime;

    @Builder
    public PriceProductUseCaseRequest(long brand, long product, @NonNull LocalDateTime dateTime) {
        this.brand = brand;
        this.product = product;
        this.dateTime = dateTime;
    }

}
