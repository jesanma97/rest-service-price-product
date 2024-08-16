# RestServicePriceProduct

This project is a REST service for querying product price data based on a date range.

## Prerequisites

- **Java 17**: Ensure you have Java 17 installed on your machine.
- **Maven**: Required to build the JAR file.
- **Docker**: Required to build and run the Docker image.

## Project Setup

### Spring Boot Configuration

Make sure your Spring Boot application is configured to run on port 8080 (or your preferred port). You can set this in the `application.properties` or `application.yml` file:

**`application.properties`**:
```properties
server.port=8080
```

### Building the JAR FILE
Build the **JAR** file of your application using Maven:
```bash
maven clean package
```
This command will generate a JAR file in the **target** directory.

### Build the Docker Image
Build the Docker image with the following command:
```bash
docker build -t rest-service-price-product .
```
Here, *rest-service-price-product* is the name of the Docker image you are creating.

### Run the Docker Image
To run your application in a Docker container, use the following command:
```bash
docker run -p 8081:8080 rest-service-price-product
```