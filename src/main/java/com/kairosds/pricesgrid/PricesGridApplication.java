package com.kairosds.pricesgrid;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PricesGridApplication {

    static Logger logger = Logger.getLogger(PricesGridApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PricesGridApplication.class, args);
        logger.debug("Log4j appender configuration is successful!!");
    }

}
