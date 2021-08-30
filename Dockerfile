# the first stage of our build use maven 3.8
FROM maven:3.8-openjdk-11 AS MAVEN_BUILD

COPY . /usr/src/app

WORKDIR /usr/src/app

RUN mvn clean package

# the second stage of our build will use open jdk 11
FROM openjdk:11.0.7-jre-slim

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD /usr/src/app/target/pricesgrid-0.0.1-SNAPSHOT.jar /pricesgrid-0.0.1-SNAPSHOT.jar

# tell the port number the container should expose
EXPOSE 8080

# run the application
CMD ["java", "-jar", "/pricesgrid-0.0.1-SNAPSHOT.jar"]

