# Java Microservice Framework

[![CircleCI](https://circleci.com/gh/lucksolutions/spring-boot-microservice.svg?style=svg)](https://circleci.com/gh/lucksolutions/spring-boot-microservice)

## Setup
1. Build the microservice app
```bash
./gradlew build
```
2. Start the application
```bash
docker-compose up --build
```

## Documentation
* [Spring Boot + Kafka](http://docs.spring.io/spring-boot/docs/1.5.2.RELEASE/reference/htmlsingle/#boot-features-kafka)

## Endpoints

### Public
* API Documentation - [/swagger-ui.html](http://localhost/swagger-ui.html)

### Admin
* Log Configuration - /loggers
* Audit Events - /auditevents