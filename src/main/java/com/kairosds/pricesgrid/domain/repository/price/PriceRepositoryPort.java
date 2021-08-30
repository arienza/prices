package com.kairosds.pricesgrid.domain.repository.price;

import com.kairosds.pricesgrid.domain.model.price.Price;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepositoryPort {

    List<Price> findPriceProduct(long brand, long product, LocalDateTime dateTime);

}
