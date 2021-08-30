package com.kairosds.pricesgrid.domain.model.price;

import com.kairosds.pricesgrid.domain.enums.Currency;
import com.kairosds.pricesgrid.domain.model.brand.Brand;
import com.kairosds.pricesgrid.domain.model.product.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Price implements Comparable, Serializable {

    @NonNull
    private long id;

    @NonNull
    private Brand brand;

    @NonNull
    private LocalDateTime startDate;

    @NonNull
    private LocalDateTime endDate;

    @NonNull
    private long priceList;

    @NonNull
    private Product product;

    @NonNull
    private int priority;

    @NonNull
    private BigDecimal price;

    @NonNull
    private Currency currency;

    @NonNull
    private LocalDateTime lastUpdate;

    @NonNull
    private String lastUpdateBy;

    @Builder
    public Price(long id, @NonNull Brand brand, @NonNull LocalDateTime startDate, @NonNull LocalDateTime endDate, long priceList, @NonNull Product product, int priority, @NonNull BigDecimal price, @NonNull Currency currency, @NonNull LocalDateTime lastUpdate, @NonNull String lastUpdateBy) {
        this.id = id;
        this.brand = brand;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.product = product;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }

    @Override
    public int compareTo(Object other) {
        if (other == null) {
            return -1;
        }
        return this.getPriority() > ((Price) other).getPriority() ? -1 : 1;
    }

}
