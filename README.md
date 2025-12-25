# 🔐 Spring Security JWT Example (Spring Boot)

A complete **Spring Boot + Spring Security** example project demonstrating **JWT-based authentication**, **role-based authorization**, and **modern Spring Security configuration** using best practices.

This project is built for **learning, reference, and interview preparation**, and follows a clean **MVC architecture** with a proper **Git structure**.

---

## 🚀 Features

- ✅ Spring Boot (Latest version)
- ✅ Spring Security (New `SecurityFilterChain` approach)
- ✅ JWT Authentication & Authorization
- ✅ Role-based access control (ADMIN / USER)
- ✅ RESTful APIs
- ✅ MVC Architecture
- ✅ Custom JWT Filter
- ✅ Secure endpoints
- ✅ Postman tested APIs
- ✅ Maven project structure
- ✅ Git branching & clean commits
- ✅ IntelliJ IDEA compatible

---

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Maven
- Postman
- IntelliJ IDEA
- Git & GitHub
- MySQL

---

## 📂 Project Structure




##📂 Project Structure

src/main/java/com/securityexample
│
├── config
│   ├── SecurityConfig.java
│   └── JWTFilter.java
│
├── controller
│   ├── AuthController.java
│   └── WelcomeController.java
│
├── dto
├── entity
├── repository
├── service
│
└── SecurityexampleApplication.java


---

## 🧠 Learning Outcomes

1. Modern Spring Security configuration
2. JWT token lifecycle
3. Authentication vs Authorization
4. Secure REST API design
5. Clean project structure
6. Real-world backend security flow

---

## 🧑‍💻 IDE & Tools Used

- IntelliJ IDEA
- Postman
- Git & GitHub
- Maven Wrapper
- MySQL

---

## 🔑 Authentication Flow (JWT)

1. User sends credentials to the login API
2. Spring Security authenticates the user
3. JWT token is generated
4. Client sends the token in the `Authorization` header
5. JWT filter validates the token
6. Access is granted based on user role

---

## 📌 API Endpoints

### 🔓 Public API

| Method | Endpoint | Description |
|------|--------|------------|
| POST | `/api/v1/auth/login` | Login and get JWT token |

---

### 🔐 Secured API

| Method | Endpoint | Role Required |
|------|--------|---------------|
| GET | `/api/v1/admin/welcome` | ADMIN |





