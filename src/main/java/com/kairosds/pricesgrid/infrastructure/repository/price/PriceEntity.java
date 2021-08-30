package com.kairosds.pricesgrid.infrastructure.repository.price;

import com.kairosds.pricesgrid.domain.enums.Currency;
import com.kairosds.pricesgrid.infrastructure.repository.brand.BrandEntity;
import com.kairosds.pricesgrid.infrastructure.repository.product.ProductEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
@Getter
@NoArgsConstructor
public class PriceEntity {

    @Id
    @Column(name = "Id", updatable = false, nullable = false)
    @NonNull
    private long id;

    @ManyToOne
    @JoinColumn(name = "BrandId")
    @NonNull
    private BrandEntity brand;

    @Column(name = "StartDate", nullable = false)
    @NonNull
    private LocalDateTime startDate;

    @Column(name = "EndDate", nullable = false)
    @NonNull
    private LocalDateTime endDate;

    @Column(name = "PriceList", nullable = false)
    @NonNull
    private long priceList;

    @ManyToOne
    @JoinColumn(name = "ProductId")
    @NonNull
    private ProductEntity product;

    @Column(name = "Priority", nullable = false)
    @NonNull
    private int priority;

    @Column(name = "Price", nullable = false)
    @NonNull
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "Currency", nullable = false)
    @NonNull
    private Currency currency;

    @Column(name = "LastUpdate", nullable = false)
    @NonNull
    private LocalDateTime lastUpdate;

    @Column(name = "LastUpdateBy", nullable = false)
    @NonNull
    private String lastUpdateBy;

}
