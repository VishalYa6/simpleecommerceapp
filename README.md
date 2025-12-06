# Simple Ecommerce App

A simple ecommerce application built with Java and Spring Boot.

## Features
- User, Admin, Product, and Order management
- RESTful API structure
- Modular code with entities, repositories, and services

## Project Structure
```
src/
  main/
    java/com/example/simpleecommerceapp/
      entity/      # JPA entities (Admin, User, Product, Order)
      repo/        # Spring Data JPA repositories
      service/     # Business logic services
    resources/
      application.properties  # App configuration
      static/      # Static web resources
      templates/   # Thymeleaf templates (if used)
  test/
    java/com/example/simpleecommerceapp/  # Unit tests
```

## Prerequisites
- Java 21 LTS (or higher)
- Maven 3.8+

## Setup & Run
1. Clone the repository:
   ```sh
   git clone <repo-url>
   cd simpleecommerceapp
   ```
2. Build the project:
   ```sh
   ./mvnw clean install
   ```
3. Run the application:
   ```sh
   ./mvnw spring-boot:run
   ```
4. Access the app at `http://localhost:8080`

## Configuration
Edit `src/main/resources/application.properties` to set up database and other properties.

## Testing
Run all tests with:
```sh
./mvnw test
```

## License
This project is licensed under the MIT License.