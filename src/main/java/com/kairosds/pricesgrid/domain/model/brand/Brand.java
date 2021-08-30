package com.kairosds.pricesgrid.domain.model.brand;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Objects;

@Getter
@NoArgsConstructor
public class Brand implements Serializable {

    @NonNull
    private long id;

    @NonNull
    private String name;

    @Builder
    public Brand(long id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return name.equals(brand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
