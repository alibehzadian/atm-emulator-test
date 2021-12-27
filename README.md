# An Emulator Test Project


This project is implemented as a test project. It is not meant to use it in a production.

## Project Architecture

The project is consists of two main modules:
 - ATM service: This service acts as a gateway for banking services and delegates all services to the banking service.
 - Banking service: It is the actual implementation of the services.
 - Commons java library: This module is a java library module shared between both services and contains DTO classes, Exceptions and all common code shared between services.

 Each module is implemented following "Clean Architecture" pattern.

 * Core module: All entities (domain objects) are defined here. For simplicity, we use JPA/Hibernate entites as domain objects.
 * Infrastructure/Commons: A place for all shared java classes between modules. This type of objects are not part of the business, but are used in different modules. DTOs, Exceptions, Annotations and objects like them.
 * Infrastructure/Persistence: Persistence mechanism is implemented here. JPA/Spring boot repositories are put in this module.
 * Application: It is the main business of the application. Based on "Hexagonal Architecture", all driver/driven or inbound/outbound ports are defined in this module in port package. All implementations to this "ports" are put in "adapter" pachage.
 * API: A gateway for application to access services in web tier.

### Example:

Guess that we are asked to add new service to the application. We need to go through these steps:

1. Create domain/entities (if needed) in `core` module.
2. Create JPA/Spring Data repository interfaces in `infrastructure/persistence` module.
3. Create DTOs and mappers in `infrastructure/commons` module.
4. Create service and persistence interfaces in `application` `inbound` and `outbound` ports.
5. Implement these interfaces in `application` adapter packages.
6. Add controller classes/methods in `API` module.

Voila!

## How to build with Maven

Simply, at the root of the project, run this command:

    mvn clean package

All artifacts are created in `target` directories of the modules.

To run project with maven run these three methods:

```
cd service-discovery
mvn spring-boot:run

cd ../bank-service
mvn spring-boot:run

cd ../atm-service
mvn spring-boot:run
```

## How to start with Docker-Compose

To run this project in `docker-compose`, just run this command at the root of the project (where the `docker-compose.yml` file is located):

    docker-compose up -d

## Documentation

To access json version of the OpenApi 3.0 documentation for `bank-service` open this link:

http://localhost:8080/v3/api-docs/

To access swagger version of documentation for `bank-service` open this link:

http://localhost:8080/swagger-ui/index.html

To access json version of the OpenApi 3.0 documentation for `atm-service` open this link:

http://localhost:9090/v3/api-docs/

To access swagger version of documentation for `atm-service` open this link:

http://localhost:9090/swagger-ui/index.html




