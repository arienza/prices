package com.kairosds.pricesgrid.application.usecases.price;

import com.kairosds.pricesgrid.application.request.price.PriceProductUseCaseRequest;
import com.kairosds.pricesgrid.application.response.price.PriceProductUseCaseResponse;
import com.kairosds.pricesgrid.domain.model.price.Price;
import com.kairosds.pricesgrid.domain.service.price.PriceService;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindPriceProductUseCase {

    private final PriceService service;

    public FindPriceProductUseCase(@NonNull PriceService service) {
        this.service = service;
    }

    public Optional<PriceProductUseCaseResponse> execute(@NonNull PriceProductUseCaseRequest request) {
        Optional<Price> price = service.findPriceProduct(request.getBrand(), request.getProduct(),request.getDateTime());
        return price.isEmpty() ? Optional.empty() : Optional.of(PriceProductUseCaseResponse.builder().price(price.get()).build());
    }

}
