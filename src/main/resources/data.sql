DROP TABLE IF EXISTS PRICES;
CREATE TABLE PRICES (
    Id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    BrandId INT NOT NULL,
    StartDate TIMESTAMP NOT NULL,
    EndDate TIMESTAMP NOT NULL,
    PriceList INT NOT NULL,
    ProductId INT NOT NULL,
    Priority INT NOT NULL,
    Price NUMERIC(8,2) NOT NULL,
    Currency VARCHAR(3) NOT NULL,
    LastUpdate TIMESTAMP NOT NULL,
    LastUpdateBy VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS BRANDS;
CREATE TABLE BRANDS (
                        Id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
                        Name VARCHAR(30) NOT NULL
);

DROP TABLE IF EXISTS PRODUCTS;
CREATE TABLE PRODUCTS (
                          Id INT PRIMARY KEY NOT NULL,
                          Name VARCHAR(250) NOT NULL
);

ALTER TABLE PRICES ADD FOREIGN KEY (BrandId) REFERENCES BRANDS(Id);
ALTER TABLE PRICES ADD FOREIGN KEY (ProductId) REFERENCES PRODUCTS(Id);

INSERT INTO BRANDS (Name) VALUES ('SuperBrand');
INSERT INTO PRODUCTS (Id, Name) VALUES (35455,'Product 35455');
INSERT INTO PRICES (BrandId, StartDate, EndDate, PriceList, ProductId, Priority, Price, Currency, LastUpdate, LastUpdateBy) select BrandId,convert(parseDateTime(StartDate,'yyyy-MM-dd-hh.mm.ss'), timestamp),convert(parseDateTime(EndDate,'yyyy-MM-dd-hh.mm.ss'), timestamp),PriceList,ProductId,Priority,Price,Currency,convert(parseDateTime(LastUpdate,'yyyy-MM-dd-hh.mm.ss'), timestamp),LastUpdateBy from CSVREAD('classpath:prices.csv');

COMMIT;
