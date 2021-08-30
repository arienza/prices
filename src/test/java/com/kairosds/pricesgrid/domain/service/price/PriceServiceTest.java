package com.kairosds.pricesgrid.domain.service.price;

import com.kairosds.pricesgrid.domain.model.price.Price;
import com.kairosds.pricesgrid.domain.repository.price.PriceRepositoryPort;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PriceServiceTest {

    private final PriceRepositoryPort rep = Mockito.mock(PriceRepositoryPort.class);
    private final PriceService sut = new PriceService(rep);

    @Test
    void findPriceProduct_nullDateTime_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> sut.findPriceProduct(0, 0, null));
    }

    @Test
    void findPriceProduct_data_returnPrice() {
        Price price = Mockito.mock(Price.class);
        List<Price> prices = Arrays.asList(price);
        Mockito.when(rep.findPriceProduct(ArgumentMatchers.any(Long.class),
                ArgumentMatchers.any(Long.class), ArgumentMatchers.any(LocalDateTime.class))).thenReturn(prices);
        Optional<Price> optionalPrice = sut.findPriceProduct(0L, 0L, LocalDateTime.now());
        assertEquals(price, optionalPrice.get());
    }

}