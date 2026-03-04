# 🔖 Library Management System

A RESTful backend application built using **Spring Boot** for managing books, users, and authors in a library.

---
<img width="500" height="500" alt="image" src="https://github.com/user-attachments/assets/1ad91844-e95a-443b-8cf7-6a3df44800f2" />

## 🚀 Features

- Book catalog management (add, update, delete, search)
- Author management (add, update, delete, search)
- Member registration and profile management
- Role-based access control (Admin / Member)
- API documentation via Swagger/OpenAPI

---

## 🛠️ Tech Stack

| Layer        | Technology               |
|--------------|--------------------------|
| Language     | Java 21                 |
| Framework    | Spring Boot 4.0.1         |
| Security     | Spring Security + JWT     |
| Database     | PostgreSQL        |
| ORM          | Spring Data JPA, Hibernate |
| Build Tool   | Maven                     |
| API Docs     | Springdoc OpenAPI (Swagger UI) |
| Testing      | JUnit 5, Mockito         |

---

## 📂 Project Structure

```
library-management/
├── src/
│   ├── main/
│   │   ├── java/com/example/library/
│   │   │   ├── advices/       # REST Controller Advice
│   │   │   ├── aop/       # AOP Logic
│   │   │   ├── config/       # REST Security and JWT Filter Configurations
│   │   │   ├── controller/       # REST Controllers
│   │   │   ├── dtos/              # Data Transfer Objects
│   │   │   ├── entity/              # Entity Classes
│   │   │   ├── customExceptions/              # Custom Exception
│   │   │   ├── interceptor/              # Custom Interceptor Logic
│   │   │   ├── interceptorConfigClass/              # Interceptor
│   │   │   ├── mappers/              # Data Transfer Objects
│   │   │   ├── repository/       # JPA Repositories
│   │   │   ├── service/          # Business Logic
│   │   │   ├── serviceJWT/          # Business Logic For JWT Token Generation and Verification
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

### 1. Clone the Repository

```bash
git clone https://github.com/AshishRepo08/Library-Management-System.git
cd library-management
```

### 2. Configure the Database

Update `src/main/resources/application.yml` with your database credentials(Use yml or xml file.):

### 3. Build and Run

**Using Maven:**
```bash
mvn clean install
mvn spring-boot:run
```

**Using Gradle:**
```bash
./gradlew build
./gradlew bootRun
```

The application will start at `http://localhost:8080`.

---

## 📖 API Endpoints

### Authentication
| Method | Endpoint              | Description          |
|--------|-----------------------|----------------------|
| POST   | `/api/auth/register`  | Register a new user  |
| POST   | `/api/auth/login`     | Login & get JWT token|

### Books
| Method | Endpoint              | Description              |
|--------|-----------------------|--------------------------|
| GET    | `/api/books`          | Get all books (paginated)|
| GET    | `/api/books/{id}`     | Get a book by ID         |
| POST   | `/api/books`          | Add a new book (Admin)   |
| PUT    | `/api/books/{id}`     | Update a book (Admin)    |
| DELETE | `/api/books/{id}`     | Delete a book (Admin)    |

### Members
| Method | Endpoint                | Description              |
|--------|-------------------------|--------------------------|
| GET    | `/api/members`          | Get all members (Admin)  |
| GET    | `/api/members/{id}`     | Get member by ID         |
| PUT    | `/api/members/{id}`     | Update member profile    |
| DELETE | `/api/members/{id}`     | Delete a member (Admin)  |

### Borrowing
| Method | Endpoint                        | Description                |
|--------|---------------------------------|----------------------------|
| POST   | `/api/borrow`                   | Borrow a book              |
| PUT    | `/api/borrow/{id}/return`       | Return a borrowed book     |
| GET    | `/api/borrow/member/{memberId}` | Get borrowing history      |
| GET    | `/api/borrow/overdue`           | List all overdue books     |

> 📘 Full API documentation is available at `http://localhost:8080/swagger-ui.html` after starting the app
> **Swagger Screenshot**:
<img width="200" height="200" alt="image" src="https://github.com/user-attachments/assets/c42255ee-6449-4868-a1b1-c64b7c5d865a" />

---

## 🔐 Authentication

This application uses **JWT (JSON Web Token)** for authentication. Include the token in the request header:

```
Authorization: Bearer <your_token>
```

### Roles
- **ADMIN** — Full access (manage books, members, and reports)
- **MEMBER** — Can browse catalog, borrow/return books, view own history

---

## 🧪 Running Tests

```bash
# Run all tests
mvn test

# Run with coverage report
mvn test jacoco:report
```

---

## 🗄️ Database Schema (Key Entities)

- **Book** — `id`, `title`, `author`, `isbn`, `genre`, `quantity`, `available`
- **Member** — `id`, `name`, `email`, `phone`, `membershipDate`, `role`
- **BorrowRecord** — `id`, `bookId`, `memberId`, `borrowDate`, `dueDate`, `returnDate`, `fine`

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature-name`
3. Commit your changes: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature/your-feature-name`
5. Open a Pull Request

---

## 📬 Contact

**Ashish Kumar** — kumarashish2664@gmail.com
GitHub: https://github.com/AshishRepo08
