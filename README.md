# Simple Item API (Spring Boot)

This project is a minimal Spring Boot REST API that manages an in-memory collection of items.

## Run the application

```bash
./mvnw spring-boot:run
```

The server starts on `http://localhost:8080`.

## Swagger UI

Once the app is running, open `http://localhost:8080/swagger-ui.html` to view the API documentation.

## API endpoints

### Add a new item

`POST /items`

Request body (JSON):

```json
{
  "name": "Wireless Mouse",
  "description": "Ergonomic mouse with USB receiver"
}
```

Response: `201 Created` with the stored item including its generated `id`.

### Get a single item by ID

`GET /items/{id}`

Response: `200 OK` with the item or `404 Not Found` if the ID does not exist.

## Validation

`name` and `description` are required fields. If they are missing or blank, the API returns `400 Bad Request`
with validation error details.

## Implementation notes

- Items are stored in-memory using an `ArrayList`.
- IDs are generated with an `AtomicLong`.
