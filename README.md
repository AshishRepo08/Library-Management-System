# 🔖 Library Management System

A RESTful backend application built using **Spring Boot** for managing books, users, and authors in a library environment.

---

## 🚀 Features

- 📖 Book catalog management (add, update, delete, search)
- ✍️ Author management (add, update, delete, search)
- 👤 Member registration and profile management
- 🔐 Role-based access control (Admin / Member)
- 📘 API documentation via Swagger / OpenAPI

---

##  🪛 Tech Stack

| Layer        | Technology                          |
|--------------|-------------------------------------|
| Language     | Java 21                             |
| Framework    | Spring Boot 4.0.1                   |
| Security     | Spring Security + JWT               |
| Database     | PostgreSQL                          |
| ORM          | Spring Data JPA, Hibernate          |
| Build Tool   | Maven                               |
| API Docs     | Springdoc OpenAPI (Swagger UI)      |
| Testing      | JUnit 5, Mockito                    |

---

## 📂 Project Structure

```text
library-management/
├── src/
│   ├── main/
│   │   ├── java/com/example/library/
│   │   │   ├── advices/                 # REST Controller Advice
│   │   │   ├── aop/                     # AOP Logic
│   │   │   ├── config/                  # Security & JWT Configuration
│   │   │   ├── controller/              # REST Controllers
│   │   │   ├── dtos/                    # Data Transfer Objects
│   │   │   ├── entity/                  # Entity Classes
│   │   │   ├── customExceptions/        # Custom Exceptions
│   │   │   ├── interceptor/             # Custom Interceptors
│   │   │   ├── interceptorConfigClass/  # Interceptor Configuration
│   │   │   ├── mappers/                 # Entity ↔ DTO Mappers
│   │   │   ├── repository/              # JPA Repositories
│   │   │   ├── service/                 # Business Logic
│   │   │   ├── serviceJWT/              # JWT Generation & Validation
│   │   │   └── MyLibraryManagementPlatformApplication.java
│   │   └── resources/
│   │       ├── application.yml
│   │       └── application-dev.yml
│   └── test/
│       └── java/com/example/library/
├── pom.xml
└── README.md
```

---

## ⚙️ Prerequisites

- Java 17+
- Maven 3.8+
- PostgreSQL 14+
- Git

---

## 🔧 Getting Started

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/AshishRepo08/Library-Management-System.git
cd library-management
```

---

### 2️⃣ Configure the Database

Update the database credentials inside:

```
src/main/resources/application.yml
```

---

### 3️⃣ Build and Run the Application

#### Using Maven

```bash
mvn clean install
mvn spring-boot:run
```

> The application will start at:  
> **http://localhost:8080**

---

## 📖 API Endpoints

### 📘 Books

| Method | Endpoint                          | Description              |
|--------|-----------------------------------|--------------------------|
| GET    | `/v2/books/book/{book_id}`        | Get book by ID           |
| PUT    | `/v2/books/book/{book_id}`        | Update book by ID        |
| DELETE | `/v2/books/book/{book_id}`        | Delete book by ID        |
| GET    | `/v2/books`                       | Get all books            |
| POST   | `/v2/books`                       | Create a new book        |

---

### ✍️ Authors

| Method | Endpoint                               | Description              |
|--------|----------------------------------------|--------------------------|
| GET    | `/v2/authors/author/{author_id}`       | Get author by ID         |
| PUT    | `/v2/authors/author/{author_id}`       | Update author by ID      |
| GET    | `/v2/authors`                          | Get all authors          |

---

### 👤 Library Users

| Method | Endpoint                      | Description              |
|--------|-------------------------------|--------------------------|
| GET    | `/v2/user`                    | Get user details         |
| POST   | `/v2/user`                    | Create a new user        |
| GET    | `/v2/user/getAllUsers`        | Get all users            |

---

### 🔐 Authentication

| Method | Endpoint      | Description                          |
|--------|--------------|--------------------------------------|
| POST   | `/jwt/login` | Authenticate user & generate JWT     |

---

📘 Full API documentation is available at:

```
http://localhost:8080/swagger-ui.html
```

(after starting the application)

---

## 🔐 Authentication & Authorization

This application uses **JWT (JSON Web Token)** for authentication.

Include the token in the request header:

```
Authorization: Bearer <your_token>
```

### 👥 Roles

- **ADMIN** — Full access (manage books, users)
- **MEMBER** — Browse catalog and manage personal records

---

## 🧪 Running Tests

```bash
# Run all tests
mvn test

# Generate coverage report
mvn test jacoco:report
```

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch  
   `git checkout -b feature/your-feature-name`
3. Commit changes  
   `git commit -m "Add new feature"`
4. Push to your branch  
   `git push origin feature/your-feature-name`
5. Open a Pull Request

---

## 📬 Contact

**Ashish Kumar**  
📧 kumarashish2664@gmail.com  
🔗 GitHub: https://github.com/AshishRepo08

---
