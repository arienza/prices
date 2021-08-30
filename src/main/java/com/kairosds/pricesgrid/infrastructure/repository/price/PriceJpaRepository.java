package com.kairosds.pricesgrid.infrastructure.repository.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    List<PriceEntity> findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(long brand, long product, LocalDateTime dateTimeBefore, LocalDateTime dateTimeAfter);

}
