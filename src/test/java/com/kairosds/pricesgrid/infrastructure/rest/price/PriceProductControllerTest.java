package com.kairosds.pricesgrid.infrastructure.rest.price;

import com.kairosds.pricesgrid.PricesGridApplication;
import com.kairosds.pricesgrid.application.response.price.PriceProductUseCaseResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = PricesGridApplication.class)
class PriceProductControllerTest {

    public static final int PRODUCT = 35455;
    public static final long BRAND = 1L;

    @Autowired
    private PriceProductController sut;

    private LocalDateTime formatDate(String date){
        return DateTimeFormatter.ISO_DATE_TIME.parse(date, LocalDateTime::from);
    }

    @Test
    void getPrice_test1_returnPriceList1() {
        PriceProductUseCaseResponse price = sut.getPrice(BRAND, PRODUCT, formatDate("2020-06-14T10:00")).getBody();
        assertNotNull(price);
        assertEquals(1L, price.getPriceList());
    }

    @Test
    void getPrice_test2_returnPriceList2() {
        PriceProductUseCaseResponse price = sut.getPrice(BRAND, PRODUCT, formatDate("2020-06-14T16:00")).getBody();
        assertNotNull(price);
        assertEquals(2L, price.getPriceList());
    }

    @Test
    void getPrice_test3_returnPriceList1() {
        PriceProductUseCaseResponse price = sut.getPrice(BRAND, PRODUCT, formatDate("2020-06-14T21:00")).getBody();
        assertNotNull(price);
        assertEquals(1L, price.getPriceList());
    }

    @Test
    void getPrice_test4_returnPriceList3() {
        PriceProductUseCaseResponse price = sut.getPrice(BRAND, PRODUCT, formatDate("2020-06-15T10:00")).getBody();
        assertNotNull(price);
        assertEquals(3L, price.getPriceList());
    }

    @Test
    void getPrice_test5_returnPriceList4() {
        PriceProductUseCaseResponse price = sut.getPrice(BRAND, PRODUCT, formatDate("2020-06-16T21:00")).getBody();
        assertNotNull(price);
        assertEquals(4L, price.getPriceList());
    }

    @Test
    void getPrice_badRequest_throwsDateTimeParseException(){
        assertThrows(DateTimeParseException.class, () -> sut.getPrice(BRAND, PRODUCT, formatDate("2020-06")).getBody());
    }

}