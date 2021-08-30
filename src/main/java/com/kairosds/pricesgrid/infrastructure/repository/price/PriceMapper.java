package com.kairosds.pricesgrid.infrastructure.repository.price;

import com.kairosds.pricesgrid.domain.model.brand.Brand;
import com.kairosds.pricesgrid.domain.model.price.Price;
import com.kairosds.pricesgrid.domain.model.product.Product;

class PriceMapper {

    static Price mapToDomainEntity(PriceEntity price) {
        Brand brand = Brand.builder().id(price.getBrand().getId()).name(price.getBrand().getName()).build();
        Product product = Product.builder().id(price.getProduct().getId()).name(price.getProduct().getName()).build();
        return Price.builder().id(price.getId()).
                brand(brand).startDate(price.getStartDate()).endDate(price.getEndDate()).priceList(price.getPriceList())
                .product(product).priority(price.getPriority()).price(price.getPrice()).currency(price.getCurrency()).lastUpdate(
                        price.getLastUpdate()).lastUpdateBy(price.getLastUpdateBy()).build();
    }

}
