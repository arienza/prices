package com.kairosds.pricesgrid.domain.service.price;

import com.kairosds.pricesgrid.domain.model.price.Price;
import com.kairosds.pricesgrid.domain.repository.price.PriceRepositoryPort;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    private PriceRepositoryPort repository;

    public PriceService(@NonNull PriceRepositoryPort repository) {
        this.repository = repository;
    }

    public Optional<Price> findPriceProduct(long brand, long product, @NonNull LocalDateTime dateTime) {
        List<Price> prices = repository.findPriceProduct(brand, product, dateTime);
        return prices.isEmpty() ? Optional.empty() : prices.stream().sorted().findFirst();
    }

}
