package com.kairosds.pricesgrid.infrastructure.repository.brand;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRANDS")
@Getter
@NoArgsConstructor
public class BrandEntity {

    @Id
    @Column(name = "Id", updatable = false, nullable = false)
    @NonNull
    private long id;

    @Column(name = "Name", nullable = false)
    @NonNull
    private String name;

}
