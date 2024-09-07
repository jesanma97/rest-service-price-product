# RestServicePriceProduct

This project is a REST service for querying product price data based on a date range.

## Prerequisites

- **Java 17**: Ensure you have Java 17 installed on your machine.
- **Maven**: Required to build the JAR file.
- **Docker**: Required to build and run the Docker image.

## Architecture Overview

This project uses Hexagonal Architecture (Ports and Adapters) to organize the code.

### Key Points:
- **Domain Layer**: Contains core business logic and domain models (e.g., `Price`).
- **Application Layer**: Manages use cases and interacts with domain models through defined interfaces (ports).
- **Infrastructure Layer**: Handles communication with external systems like APIs and databases through adapters.

### Example: Get Product Price Information

1. **Client Request**:
   - The client sends a request to the API to get a product price information.

2. **Controller**:
   - The API controller receives the request and calls a service method to process it.

3. **Application Layer**:
   - The service method in the Application Layer requests data from the `PriceProductPersistenceAdapter`.

4. **Persistence Adapter**:
   - The adapter gets data from `PriceProductDao` and converts into the domain object (`Price`).

5. **Application Layer**:
   - The internal model is processed and converted into a `PriceResponseDTO`.

6. **Client Response**:
   - The controller sends the `PriceResponseDTO` back to the client.

## Resources

In the `src/main/resources` directory, you will find:

1. **Postman Collection**: A Postman collection is included with all the tests for the API endpoints. This collection can be imported into Postman to easily test the API.

    - **File**: `RestServicePriceProduct.postman_collection.json`
    - **Usage**: Import the file into Postman by selecting `Import` in Postman and choosing the `RestServicePriceProduct.postman_collection.json` file from the `resources` directory.

2. **Swagger Documentation**: The API is fully documented using Swagger. The Swagger YAML file provides a detailed description of each endpoint, including request parameters, response formats, and error codes.

    - **File**: `rest-service-price-product.yaml`
    - **Usage**: The Swagger documentation can be viewed by importing the `rest-service-price-product.yaml` file into a Swagger UI tool or by using online Swagger editors such as [Swagger Editor](https://editor.swagger.io/).

   
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