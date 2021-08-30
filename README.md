# Spring Boot Microservice Prices Grid Project

This is an application based on the premise that in a company there's a _PRICES_ table that shows the final price (PVP) and the rate applied to a product in a brand between certain dates. So it offers you a service that accepts as input parameters: a date, product identifier, brand identifier and returns as output data: product identifier, brand identifier, rate to apply, dates and final price to apply.

Is developed using Java, Spring Boot and Maven.

## About the Service

The service is just a simple prices grid REST service.

The application performs the creation of the H2 database and an initial loading of data by reading [_prices.csv_](https://github.com/arienza/prices/blob/main/src/main/resources/prices.csv) file.

Here is the endpoint you can call:

### Get information about price of a product on a brand at a datetime.

#### GET /price/{brand}/{product}/{date}

URL Parameters:
- _{brand}_: Brand identifier, number format
- _{product}_: Product identifier, number format
- _{date}_: Date and time for the requested price, format to use is [ISO_LOCAL_DATE_TIME](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_LOCAL_DATE_TIME): _yyyy-MM-ddTHH:mm_

Example:
```
curl --location --request GET 'http://localhost:8080/price/1/35455/2020-06-14T10:00'

Response: HTTP 200
Content: 
{
    "product": 35455,
    "brand": 1,
    "priceList": 1,
    "startDate": "2020-06-14T00:00:00",
    "endDate": "2020-12-31T23:59:59",
    "price": 35.50
}
```

## How to Run

### Manually

This application is packaged as a jar which has a server and it uses an in-memory database (H2) to store the data. You run it using the following instructions:

1. Clone this repository
2. Make sure you are using Java 11 and Maven 3.x
3. You can build the project and run the tests by running ```mvn clean package```
4. Once successfully built, you can run the service by:
```
mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"
```

### Using Docker
You run it using Docker with the following instructions:

1. Clone this repository
2. Make sure you have Docker installed
3. Build the image using the [Dockerfile](https://github.com/arienza/prices/blob/main/Dockerfile) present on the project
```
 docker build -t prices/pricesgrid .
```
4. Run it using the built docker image (take into account that this instruction will run it in your port 8080):
```
docker run -p 8080:8080 prices/pricesgrid
```


### Swagger
The API is implemented with Swagger. Once started, it can be accessed through this link: _http://localhost:8080/swagger-ui/_

If you have any questions or comments, feel free to reach me out at: [pablo.arienza@kairosds.com](mailto:pablo.arienza@kairosds.com)