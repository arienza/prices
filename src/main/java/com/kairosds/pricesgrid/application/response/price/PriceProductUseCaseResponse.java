package com.kairosds.pricesgrid.application.response.price;

import com.kairosds.pricesgrid.domain.model.price.Price;
import lombok.*;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class PriceProductUseCaseResponse {

    private long product;
    private long brand;
    private long priceList;
    private String startDate;
    private String endDate;
    private BigDecimal price;

    @Builder
    public PriceProductUseCaseResponse(@NonNull Price price) {
        this.product = price.getProduct().getId();
        this.brand = price.getBrand().getId();
        this.priceList = price.getPriceList();
        this.startDate = price.getStartDate().format(DateTimeFormatter.ISO_DATE_TIME);
        this.endDate = price.getEndDate().format(DateTimeFormatter.ISO_DATE_TIME);
        this.price = price.getPrice();
    }

}
