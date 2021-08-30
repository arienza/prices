package com.kairosds.pricesgrid.application.usecases.price;

import com.kairosds.pricesgrid.application.request.price.PriceProductUseCaseRequest;
import com.kairosds.pricesgrid.application.response.price.PriceProductUseCaseResponse;
import com.kairosds.pricesgrid.domain.enums.Currency;
import com.kairosds.pricesgrid.domain.model.brand.Brand;
import com.kairosds.pricesgrid.domain.model.price.Price;
import com.kairosds.pricesgrid.domain.model.product.Product;
import com.kairosds.pricesgrid.domain.repository.price.PriceRepositoryPort;
import com.kairosds.pricesgrid.domain.service.price.PriceService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FindPriceProductUseCaseTest {

    public static final int PRODUCT = 35455;
    public static final long BRAND = 1L;

    private final PriceRepositoryPort rep = Mockito.mock(PriceRepositoryPort.class);
    private final PriceService service = new PriceService(rep);
    private final FindPriceProductUseCase sut = new FindPriceProductUseCase(service);

    private LocalDateTime formatDate(String date) {
        return DateTimeFormatter.ISO_DATE_TIME.parse(date, LocalDateTime::from);
    }

    @Test
    void execute_nullRequest_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> sut.execute(null));
    }

    @Test
    void execute_test1_returnPriceList1() {
        Brand brand = Brand.builder().id(BRAND).name("BrandName").build();
        Product product = Product.builder().id(PRODUCT).name("ProductName").build();
        Price price = Price.builder().id(1).
                brand(brand).startDate(formatDate("2020-06-14T10:00:00")).endDate(formatDate("2020-12-31T23:59:59")).priceList(1)
                .product(product).priority(0).price(new BigDecimal("35.5")).currency(Currency.EUR).lastUpdate(
                        LocalDateTime.now().plusDays(-2)).lastUpdateBy("testUser").build();
        List<Price> prices = Arrays.asList(price);
        Mockito.when(rep.findPriceProduct(ArgumentMatchers.any(Long.class),
                ArgumentMatchers.any(Long.class), ArgumentMatchers.any(LocalDateTime.class))).thenReturn(prices);
        PriceProductUseCaseRequest request = new PriceProductUseCaseRequest(0L, 0L, formatDate("2020-06-14T10:00"));
        Optional<PriceProductUseCaseResponse> optionalPrice = sut.execute(request);
        assertNotNull(optionalPrice);
        assertTrue(optionalPrice.isPresent());
        assertEquals(price.getPrice(), optionalPrice.get().getPrice());
        assertEquals(1L, optionalPrice.get().getPriceList());
    }

    @Test
    void execute_test2_returnPriceList2() {
        Brand brand = Brand.builder().id(BRAND).name("BrandName").build();
        Product product = Product.builder().id(PRODUCT).name("ProductName").build();
        Price price = Price.builder().id(2).
                brand(brand).startDate(formatDate("2020-06-14T15:00:00")).endDate(formatDate("2020-06-14T18:30:00")).priceList(2)
                .product(product).priority(1).price(new BigDecimal("25.45")).currency(Currency.EUR).lastUpdate(
                        LocalDateTime.now().plusDays(-2)).lastUpdateBy("testUser").build();
        List<Price> prices = Arrays.asList(price);
        Mockito.when(rep.findPriceProduct(ArgumentMatchers.any(Long.class),
                ArgumentMatchers.any(Long.class), ArgumentMatchers.any(LocalDateTime.class))).thenReturn(prices);
        PriceProductUseCaseRequest request = new PriceProductUseCaseRequest(0L, 0L, formatDate("2020-06-14T16:00"));
        Optional<PriceProductUseCaseResponse> optionalPrice = sut.execute(request);
        assertNotNull(optionalPrice);
        assertTrue(optionalPrice.isPresent());
        assertEquals(price.getPrice(), optionalPrice.get().getPrice());
        assertEquals(2L, optionalPrice.get().getPriceList());
    }

    @Test
    void execute_test3_returnPriceList1() {
        Brand brand = Brand.builder().id(BRAND).name("BrandName").build();
        Product product = Product.builder().id(PRODUCT).name("ProductName").build();
        Price price = Price.builder().id(1).
                brand(brand).startDate(formatDate("2020-06-14T10:00:00")).endDate(formatDate("2020-12-31T23:59:59")).priceList(1)
                .product(product).priority(0).price(new BigDecimal("35.5")).currency(Currency.EUR).lastUpdate(
                        LocalDateTime.now().plusDays(-2)).lastUpdateBy("testUser").build();
        List<Price> prices = Arrays.asList(price);
        Mockito.when(rep.findPriceProduct(ArgumentMatchers.any(Long.class),
                ArgumentMatchers.any(Long.class), ArgumentMatchers.any(LocalDateTime.class))).thenReturn(prices);
        PriceProductUseCaseRequest request = new PriceProductUseCaseRequest(0L, 0L, formatDate("2020-06-14T21:00"));
        Optional<PriceProductUseCaseResponse> optionalPrice = sut.execute(request);
        assertNotNull(optionalPrice);
        assertTrue(optionalPrice.isPresent());
        assertEquals(price.getPrice(), optionalPrice.get().getPrice());
        assertEquals(1L, optionalPrice.get().getPriceList());
    }

    @Test
    void execute_test4_returnPriceList3() {
        Brand brand = Brand.builder().id(BRAND).name("BrandName").build();
        Product product = Product.builder().id(PRODUCT).name("ProductName").build();
        Price price = Price.builder().id(3).
                brand(brand).startDate(formatDate("2020-06-14T10:00:00")).endDate(formatDate("2020-12-31T23:59:59")).priceList(3)
                .product(product).priority(1).price(new BigDecimal("30.5")).currency(Currency.EUR).lastUpdate(
                        LocalDateTime.now().plusDays(-2)).lastUpdateBy("testUser").build();
        List<Price> prices = Arrays.asList(price);
        Mockito.when(rep.findPriceProduct(ArgumentMatchers.any(Long.class),
                ArgumentMatchers.any(Long.class), ArgumentMatchers.any(LocalDateTime.class))).thenReturn(prices);
        PriceProductUseCaseRequest request = new PriceProductUseCaseRequest(0L, 0L, formatDate("2020-06-15T10:00"));
        Optional<PriceProductUseCaseResponse> optionalPrice = sut.execute(request);
        assertNotNull(optionalPrice);
        assertTrue(optionalPrice.isPresent());
        assertEquals(price.getPrice(), optionalPrice.get().getPrice());
        assertEquals(3L, optionalPrice.get().getPriceList());
    }

    @Test
    void execute_test5_returnPriceList4() {
        Brand brand = Brand.builder().id(BRAND).name("BrandName").build();
        Product product = Product.builder().id(PRODUCT).name("ProductName").build();
        Price price = Price.builder().id(4).
                brand(brand).startDate(formatDate("2020-06-14T10:00:00")).endDate(formatDate("2020-12-31T23:59:59")).priceList(4)
                .product(product).priority(1).price(new BigDecimal("38.95")).currency(Currency.EUR).lastUpdate(
                        LocalDateTime.now().plusDays(-2)).lastUpdateBy("testUser").build();
        List<Price> prices = Arrays.asList(price);
        Mockito.when(rep.findPriceProduct(ArgumentMatchers.any(Long.class),
                ArgumentMatchers.any(Long.class), ArgumentMatchers.any(LocalDateTime.class))).thenReturn(prices);
        PriceProductUseCaseRequest request = new PriceProductUseCaseRequest(0L, 0L, formatDate("2020-06-16T21:00"));
        Optional<PriceProductUseCaseResponse> optionalPrice = sut.execute(request);
        assertNotNull(optionalPrice);
        assertTrue(optionalPrice.isPresent());
        assertEquals(price.getPrice(), optionalPrice.get().getPrice());
        assertEquals(4L, optionalPrice.get().getPriceList());
    }

}