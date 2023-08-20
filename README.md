# Concert Booking API

Welcome to the Concert Booking API documentation! This API allows users to search for available concerts and book tickets for selected concerts.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [Endpoints](#endpoints)
  - [Examples](#examples)
- [Technologies](#technologies)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven
- PostgreSQL Database
- Git

### Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/YOUR_USERNAME/YOUR_PROJECT_NAME.git

2. Navigate to the project directory.
3. Configure the PostgreSQL database settings in `src/main/resources/application.properties`.
4. Build and run the application:
   ```sh
   mvn spring-boot:run

## Usage
### Endpoints

  Search available concerts:
  ```sh
  Endpoint: /api/concerts/available
  Method: GET
  Query Parameter: startTime (e.g., startTime=2023-08-20T10:00:00)
  ```

  Book a ticket:
  ```sh
  Endpoint: /api/tickets/book
  Method: POST
  Request Body: JSON containing concertId and attendeeName
  ```

Examples

  Search available concerts:
  ```sh
  curl -X GET "http://localhost:8090/api/concerts/available?startTime=2023-08-20T10:00:00"
  ```

  Book a ticket:
  ```sh
  curl -X POST "http://localhost:8090/api/tickets/book" -H "Content-Type: application/json" -d '{"concertId": 1, "attendeeName": "John Doe"}'
  ```

## Technologies
    Java Spring Boot
    PostgreSQL Database
    Hibernate JPA
    Maven
    Swagger for API Documentation
