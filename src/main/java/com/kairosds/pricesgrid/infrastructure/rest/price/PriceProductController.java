package com.kairosds.pricesgrid.infrastructure.rest.price;

import com.kairosds.pricesgrid.application.request.price.PriceProductUseCaseRequest;
import com.kairosds.pricesgrid.application.response.price.PriceProductUseCaseResponse;
import com.kairosds.pricesgrid.application.usecases.price.FindPriceProductUseCase;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class PriceProductController {

    private final FindPriceProductUseCase service;

    public PriceProductController(FindPriceProductUseCase service) {
        this.service = service;
    }

    @GetMapping(value = "/price/{brand}/{product}/{date}")
    public ResponseEntity<PriceProductUseCaseResponse> getPrice(@PathVariable("brand") long brand, @PathVariable("product") long product, @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime dateTime) {
        Optional<PriceProductUseCaseResponse> price = this.service.execute(PriceProductUseCaseRequest.builder().brand(brand).product(product).dateTime(dateTime).build());
        if (price.isPresent()) {
            return ResponseEntity.ok(price.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}