# Cloud Native Ecommerce V1

A cloud-native e-commerce microservices project built with Spring Boot, PostgreSQL, Redis, RabbitMQ, Docker and Nginx.

## Architecture

```text
                +----------------+
                |     Client     |
                +--------+-------+
                         |
                         v
                +----------------+
                |  Nginx Gateway |
                +--------+-------+
                         |
          +--------------+--------------+
          |                             |
          v                             v
+-------------------+      +-------------------+
| Product Service   |      | Basket Service    |
| Spring Boot       |      | Spring Boot       |
+---------+---------+      +---------+---------+
          |                          |
          v                          v
+-------------------+      +-------------------+
| PostgreSQL        |      | Redis             |
+-------------------+      +-------------------+

                     |
                     v

             +-------------------+
             | RabbitMQ Broker   |
             +-------------------+
```

## Technology Stack

- Java 21
- Spring Boot 3.5
- PostgreSQL 16
- Redis 7
- RabbitMQ 3 Management
- Docker
- Docker Compose
- Nginx Reverse Proxy
- Maven

## Services

### Product Service

Provides product catalog operations.

Endpoint:

```http
GET /api/products
```

### Basket Service

Stores basket items in Redis and publishes events to RabbitMQ.

Endpoint:

```http
POST /api/basket
```

Example:

```bash
curl -X POST http://localhost:8080/api/basket \
-H "Content-Type: application/json" \
-d '{"productName":"TV","quantity":2}'
```

Response:

```json
{
  "productName":"TV",
  "quantity":2
}
```

## Infrastructure

### PostgreSQL

```text
localhost:5432
```

### Redis

```text
localhost:6379
```

### RabbitMQ

Broker:

```text
localhost:5672
```

Management UI:

```text
http://localhost:15672
```

### Adminer

```text
http://localhost:8082
```

### Nginx Gateway

```text
http://localhost:8080
```

## Run

Build and start all services:

```bash
docker compose up -d --build
```

Stop:

```bash
docker compose down
```

## Current Features (V1)

- Reverse Proxy with Nginx
- Product Microservice
- Basket Microservice
- PostgreSQL Integration
- Redis Integration
- RabbitMQ Integration
- Dockerized Services
- Docker Compose Orchestration

## Next Versions

### V2

- Order Service
- RabbitMQ Consumers
- Event-driven communication

### V3

- Spring Cloud Gateway
- Eureka Discovery
- JWT Authentication

### V4

- Config Server
- Distributed Tracing
- Resilience4j

### V5

- Kubernetes Deployment
- Production Monitoring
- CI/CD Pipeline
