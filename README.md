# Getting Started

### About "articles" microservice
This is a microservice project with one endpoint: Get articles from GNews API.

The port dedicated to this service is 9090.

To call the endpoints, set both "Accept" and "Content-type" headers to "application/json".

### Areas to improve
This project lacks unit and functional tests.

The caching could be improved by more advaced strategies like using an in-memory cache like Redis.

The endpoint lacks pagination since the third party REST API only provides paid pagination.

This project lacks a Fault Tolerance strategy such as Resilience4J as well as Distributed tracing Pattern. 

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web)
* [Spring REST Docs](https://docs.spring.io/spring-restdocs/docs/current/reference/html5/)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#actuator)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

