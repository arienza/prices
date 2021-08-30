package com.kairosds.pricesgrid.infrastructure.repository.price;

import com.kairosds.pricesgrid.domain.model.price.Price;
import com.kairosds.pricesgrid.domain.repository.price.PriceRepositoryPort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PriceJpaRepositoryAdapter implements PriceRepositoryPort {

    private final PriceJpaRepository repository;

    public PriceJpaRepositoryAdapter(PriceJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Price> findPriceProduct(long brand, long product, LocalDateTime dateTime) {
        List<PriceEntity> prices = repository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(brand, product, dateTime, dateTime);
        return prices.stream().map(PriceMapper::mapToDomainEntity).collect(Collectors.toList());
    }

}
