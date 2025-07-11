# Tp_MS_Vivien
# Classroom Microservice

This microservice is part of a distributed system for managing a school environment. It works in coordination with the `student`, `teacher`, and `classroom` services to register students and teachers, and assign them to specific classes.

---

## 🧠 Overview

The `classroom` microservice is responsible for:
- Creating and managing classes.
- Linking students and teachers to those classes.
- Coordinating via Eureka service discovery with the `student` and `teacher` microservices.

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Eureka Discovery Server**
- **Spring Cloud Gateway**
- **Maven**

---

## 🧩 Microservice Architecture

This service is part of a broader microservice system that includes:

| Microservice | Description       | Base Path |
|--------------|-------------------|-----------|
| `student`    | Manages students  | `/student` |
| `teacher`    | Manages teachers  | `/teacher` |
| `classroom`  | Manages classes and links | `/classroom` |

These services register with **Eureka**, and are accessed through a **Spring Cloud Gateway** running on port `8090`.

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven
- MySQL (running on default port or configured)
- Eureka Server
- Spring Cloud Gateway

### Running the Microservice

1. **Start Eureka Server**
2. **Start the Gateway (port: `8090`)**
3. **Start MySQL and ensure the DB is available**
4. **Run the classroom microservice:**

```bash
mvn spring-boot:run

server:
  port: 0 # Let Eureka assign a dynamic port

spring:
  application:
    name: classroom
  datasource:
    url: jdbc:mysql://localhost:3306/school_db
    username: root
    password: password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
GET http://localhost:8090/classroom/1
#   T p _ M i c r o S e r v i c e _ N e l s o n - V i v i e n  
 