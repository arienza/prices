package com.kairosds.pricesgrid.infrastructure.repository.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
@Getter
@NoArgsConstructor
public class ProductEntity {

    @Id
    @Column(name = "Id", updatable = false, nullable = false)
    @NonNull
    private long id;

    @Column(name = "Name", nullable = false)
    @NonNull
    private String name;

}
