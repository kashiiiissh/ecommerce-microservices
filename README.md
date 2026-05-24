E-Commerce Microservices Platform

A production-ready E-Commerce Microservices Architecture built using Spring Boot, Spring Cloud, and Microservices Design Patterns.
This project demonstrates scalable backend development with service discovery, centralized configuration, API gateway routing, inter-service communication, inventory validation, and notification handling.

🚀 Tech Stack
Backend
Java 17
Spring Boot
Spring Cloud
Spring Data JPA
Spring Web
OpenFeign
Resilience4j
Database
MySQL
Microservices Tools
Eureka Server
API Gateway
Config Server
Documentation
Swagger / OpenAPI
Build Tool
Maven

📌 Microservices Included
Service
Port
Description
Eureka Server
8761
Service Discovery
Config Server
8888
Centralized Configuration
API Gateway
8080
Single Entry Point
Product Service
8081
Product Management
Order Service
8082
Order Processing
Inventory Service
8083
Stock Validation
Notification Service
8084
Notification Handling

✨ Features
Microservices Architecture
API Gateway Routing
Service Discovery using Eureka
Centralized Configuration using Config Server
REST APIs
OpenFeign Communication
Inventory Validation before Order Placement
Notification Service Integration
Swagger API Documentation
MySQL Database Integration
Layered Architecture
Exception Handling
Scalable Service Design

📂 Project Structure
Bash
ecommerce-microservices/
│
├── eureka-server
├── config-server
├── api-gateway
├── product-service
├── order-service
├── inventory-service
├── notification-service
└── README.md
⚙️ Setup Instructions

1️⃣ Clone Repository
Bash
```
git clone https://github.com/your-username/ecommerce-microservices.git
cd ecommerce-microservices
```
🛠️ Configure MySQL
Create database:
SQL
```
CREATE DATABASE productdb;
```
Update database credentials inside configuration files:
Properties
```
spring.datasource.username=root
spring.datasource.password=your_password
```
▶️ Run Services
Run services in the following order:
1. Eureka Server
Bash
```
cd eureka-server
mvn spring-boot:run
```
Open:
Bash
```
http://localhost:8761
```
3. Config Server
Bash
```
cd config-server
mvn spring-boot:run
```
5. Product Service
Bash
```
cd product-service
mvn spring-boot:run
```
7. Inventory Service
Bash
```
cd inventory-service
mvn spring-boot:run
```
9. Order Service
Bash
```
cd order-service
mvn spring-boot:run
```
11. Notification Service
```
cd notification-service
mvn spring-boot:run
```
11. API Gateway
Bash
```
cd api-gateway
mvn spring-boot:run
```
🌐 API Endpoints
Product APIs
Create Product
Http
```
POST /product
```
Get All Products
Http
```
GET /product
```
Order APIs
Place Order
Http
```
POST /orders
```
Get Orders
Http
```
GET /orders
```
Inventory APIs
Check Inventory
Http
```
GET /inventory/check/{productId}/{quantity}
```
🔄 Inter-Service Communication
Order Service communicates with Product Service using Feign Client
Order Service validates stock through Inventory Service
Notification Service handles order-related notifications
API Gateway routes all requests
Eureka Server manages service registration and discovery

📘 Swagger Documentation
Swagger UI:
Bash
```
http://localhost:8081/swagger-ui.html
```
Change port according to service.

🧠 Architecture Flow
Plain text
Client
   ↓
API Gateway
   ↓
Microservices
   ├── Product Service
   ├── Order Service
   ├── Inventory Service
   └── Notification Service
   ↓
MySQL Database

