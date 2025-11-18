
# 📌 **Task Service – Smart Task Automation System**

The **Task Service** is the first microservice in the **Smart Task Automation System**.
It is responsible for creating, updating, retrieving, filtering, and deleting tasks. This service exposes clean REST APIs, uses DTO-based communication, and integrates with MySQL using Spring Data JPA.

---

## 🚀 **Features**

* Create, update, delete tasks
* Fetch all tasks or filter by status
* DTO-based request & response
* Global exception handling
* MySQL + Spring Data JPA persistence
* Lombok for cleaner code
* Restful API structure for microservice communication

---

## 🧱 **Tech Stack**

* **Java 21**
* **Spring Boot 3.x**
* **Spring Web**
* **Spring Data JPA**
* **MySQL 8**
* **Lombok**
* **Postman** (API testing)

---

## 📂 **Project Structure**

```
task-service/
 └── src/main/java/com/smart_task_automation_system/task_service
      ├── controller/
      │     └── TaskController.java
      ├── service/
      │     └── TaskService.java
      ├── repository/
      │     └── TaskRepository.java
      ├── entity/
      │     └── Task.java
      ├── dto/
      │     ├── TaskRequestDTO.java
      │     └── TaskResponseDTO.java
      ├── exception/
      │     ├── TaskNotFoundException.java
      │     └── GlobalExceptionHandler.java
      └── TaskServiceApplication.java
```

---

## 🗄️ **Database Schema**

### **Table: tasks**

| Column      | Type         | Description                   |
| ----------- | ------------ | ----------------------------- |
| id          | BIGINT (PK)  | Unique Task ID                |
| title       | VARCHAR(255) | Task title                    |
| description | TEXT         | Task description              |
| status      | VARCHAR(50)  | NEW / IN_PROGRESS / COMPLETED |
| assignee    | VARCHAR(100) | Assigned person               |
| due_date    | DATETIME     | Deadline                      |
| created_at  | DATETIME     | Auto timestamp                |
| updated_at  | DATETIME     | Auto timestamp                |

---

## ⚙️ **Configuration**

### **application.properties**

```properties
server.port=8081

spring.datasource.url=jdbc:mysql://localhost:3306/task_service?useSSL=false
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

---

## 🌐 **API Endpoints**

### **Base URL**

```
http://localhost:8081/api/tasks
```

---

### **1️⃣ Create Task**

**POST** `/api/tasks`

```json
{
  "title": "Create automation scheduler",
  "description": "Implement rule evaluator",
  "status": "NEW",
  "assignee": "Amit",
  "dueDate": "2025-02-28T10:00:00"
}
```

---

### **2️⃣ Get All Tasks**

**GET** `/api/tasks`

Filter by status:
`/api/tasks?status=NEW`

---

### **3️⃣ Get Task by ID**

**GET** `/api/tasks/{id}`

Error Example (if not found):

```json
{
  "timestamp": "2025-02-17T14:10:30",
  "status": 404,
  "error": "Task Not Found",
  "message": "Task with ID 10 not found"
}
```

---

### **4️⃣ Update Task**

**PUT** `/api/tasks/{id}`

```json
{
  "title": "Update scheduler",
  "description": "Logic updated",
  "status": "IN_PROGRESS",
  "assignee": "Amit Kumar",
  "dueDate": "2025-02-28T09:00:00"
}
```

---

### **5️⃣ Delete Task**

**DELETE** `/api/tasks/{id}`

---

## 🧪 **Postman Testing Guide**

| Operation      | Method | URL                     |
| -------------- | ------ | ----------------------- |
| Create Task    | POST   | `/api/tasks`            |
| Get All Tasks  | GET    | `/api/tasks`            |
| Filter Tasks   | GET    | `/api/tasks?status=NEW` |
| Get Task by ID | GET    | `/api/tasks/{id}`       |
| Update Task    | PUT    | `/api/tasks/{id}`       |
| Delete Task    | DELETE | `/api/tasks/{id}`       |

If you want, I can generate an **import-ready Postman Collection JSON**.

---

## 🛡️ **Error Handling (Global Exception Handler)**

Custom error responses (example):

```json
{
  "timestamp": "2025-02-17T14:45:12",
  "status": 404,
  "error": "Task Not Found",
  "message": "Task with ID 999 not found"
}
```

---

## 🧩 **Interaction with Other Microservices**

The Automation Service will:

* Fetch tasks based on status & due date
* Apply rules from Rule Service
* Trigger actions via Notification Service

This Task Service acts as the **data source**.

---

## 📦 **Run the Service**

### **1. Create Database**

```sql
CREATE DATABASE task_service;
```

### **2. Build & Run**

```
mvn clean install
mvn spring-boot:run
```

Service will start on:

```
http://localhost:8081
```

---

## 🤝 **Contributing**

Feel free to open issues or submit pull requests.

---

## 📄 **License**

This project is part of the **Smart Task Automation System** and is free to extend for personal or educational use.

---

