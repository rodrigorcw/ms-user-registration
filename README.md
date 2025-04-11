# Spring Boot Project: User & Address Microservices

This is a simple Spring Boot project demonstrating:

- Spring Data JPA
- PostgreSQL (production)
- H2 (test profile)
- OpenFeign (for inter-service communication)
- Configuration via `application.yml`
- Two entities: `User` and `Address`

---

## 🏗️ Project Structure

- `user-service/` — Handles user data
- `address-service/` — Handles address data

---

## 🧰 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- H2 (for testing)
- OpenFeign
- Lombok

---

## ⚙️ Configuration

### `application.yml` (example for `user-service`)

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/userdb
    username: postgres
    password: postgres
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
  profiles:
    active: dev

feign:
  client:
    config:
      default:
        connectTimeout: 5000
        readTimeout: 5000

