package com.kairosds.pricesgrid.infrastructure.rest.price;

import com.kairosds.pricesgrid.application.response.price.PriceProductUseCaseResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceProductRestTest {

    public static final String LOCALHOST = "http://localhost:";

    @Autowired
    private PriceProductController controller;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void getRestPrice_test1_returnPriceList1() {
        PriceProductUseCaseResponse price = this.restTemplate.getForObject(LOCALHOST + port + "/price/1/35455/2020-06-14T10:00", PriceProductUseCaseResponse.class);
        assertNotNull(price);
        assertEquals(1L, price.getBrand());
        assertEquals(1L, price.getPriceList());
        assertEquals("2020-06-14T00:00:00", price.getStartDate());
        assertEquals("2020-12-31T23:59:59", price.getEndDate());
        assertEquals("35.50", price.getPrice().toString());
    }

    @Test
    void getRestPrice_test2_returnPriceList2() {
        PriceProductUseCaseResponse price = this.restTemplate.getForObject(LOCALHOST + port + "/price/1/35455/2020-06-14T16:00", PriceProductUseCaseResponse.class);
        assertNotNull(price);
        assertEquals(1L, price.getBrand());
        assertEquals(2L, price.getPriceList());
        assertEquals("2020-06-14T15:00:00", price.getStartDate());
        assertEquals("2020-06-14T18:30:00", price.getEndDate());
        assertEquals("25.45", price.getPrice().toString());
    }

    @Test
    void getRestPrice_test3_returnPriceList1() {
        PriceProductUseCaseResponse price = this.restTemplate.getForObject(LOCALHOST + port + "/price/1/35455/2020-06-14T21:00", PriceProductUseCaseResponse.class);
        assertNotNull(price);
        assertEquals(1L, price.getBrand());
        assertEquals(1L, price.getPriceList());
        assertEquals("2020-06-14T00:00:00", price.getStartDate());
        assertEquals("2020-12-31T23:59:59", price.getEndDate());
        assertEquals("35.50", price.getPrice().toString());
    }

    @Test
    void getRestPrice_test4_returnPriceList3() {
        PriceProductUseCaseResponse price = this.restTemplate.getForObject(LOCALHOST + port + "/price/1/35455/2020-06-15T10:00", PriceProductUseCaseResponse.class);
        assertNotNull(price);
        assertEquals(1L, price.getBrand());
        assertEquals(3L, price.getPriceList());
        assertEquals("2020-06-15T00:00:00", price.getStartDate());
        assertEquals("2020-06-15T11:00:00", price.getEndDate());
        assertEquals("30.50", price.getPrice().toString());
    }

    @Test
    void getRestPrice_test5_returnPriceList4() {
        PriceProductUseCaseResponse price = this.restTemplate.getForObject(LOCALHOST + port + "/price/1/35455/2020-06-16T21:00", PriceProductUseCaseResponse.class);
        assertNotNull(price);
        assertEquals(1L, price.getBrand());
        assertEquals(4L, price.getPriceList());
        assertEquals("2020-06-15T16:00:00", price.getStartDate());
        assertEquals("2020-12-31T23:59:59", price.getEndDate());
        assertEquals("38.95", price.getPrice().toString());
    }

    @Test
    void getRestPrice_badRequest_returnBadRequestStatus() {
        ResponseEntity<PriceProductUseCaseResponse> responseEntity =
                this.restTemplate.getForEntity(LOCALHOST + port + "/price/1/35455/2020", PriceProductUseCaseResponse.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

}