# Task Manager REST API

A REST API built with **Spring Boot** for managing tasks, following **Clean Architecture** principles with a clear separation of concerns across three layers.

## Architecture

The project is organized into three layers:

| Layer | Responsibility |
|---|---|
| **Controller** | Handles HTTP requests/responses only. Contains no business logic. |
| **Service** | Contains all business logic and orchestrates operations between the Controller and Repository. |
| **Repository** | Handles communication with the database. |

Communication between layers is done through **DTOs (Data Transfer Objects)**:
- **RequestDTO** — used to carry data *into* the application (client → server).
- **ResponseDTO** — used to carry data *out* of the application (server → client).

This separation keeps each layer independent and easier to test, maintain, and extend.

## Tech Stack

- Java
- Spring Boot
- Maven

## Getting Started

### Prerequisites

- JDK 21+ (adjust to your project's version)
- Maven 3.9+

### Run the application

```bash
mvn spring-boot:run
```

The API will start on:

```
http://localhost:8081
```

## API Endpoints

You can test these endpoints using Postman or any HTTP client.

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/task/create` | Create a new task |
| `GET` | `/task/getalltasks` | Retrieve all tasks |
| `GET` | `/task/getbyid?id={id}` | Retrieve a task by its ID |
| `PUT` | `/task/{id}` | Update a task by its ID |
| `DELETE` | `/task/{id}` | Delete a task by its ID |

> ⚠️ **Note:** The HTTP methods and path formats for update/delete above are assumptions based on REST conventions — adjust them to match your actual controller mappings if they differ.

### Example requests

**Create a task**
```bash
curl -X POST http://localhost:8081/task/create \
  -H "Content-Type: application/json" \
  -d '{"title": "Buy groceries", "description": "Milk, eggs, bread"}'
```

**Get all tasks**
```bash
curl http://localhost:8081/task/getalltasks
```

**Get a task by ID**
```bash
curl http://localhost:8081/task/getbyid?id=1
```

## Project Structure

```
src/main/java/.../
├── controller/   # REST controllers (HTTP layer)
├── service/      # Business logic
├── repository/   # Database access
└── dto/          # Request and Response DTOs
```

## License

This project is open for educational and personal use.