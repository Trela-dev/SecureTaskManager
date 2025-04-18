# 🛡️ Spring Security Secure Task Manager (WIP)


The Secure Task Manager is a Spring Boot application that provides a RESTful API for managing tasks. It implements secure authentication and authorization using Spring Security with role-based access control.


---

## 🔐 Access Requirements

- All endpoints require authentication.
- Endpoints annotated with `@PreAuthorize("hasRole('ADMIN')")` are restricted to users with the `ROLE_ADMIN` role.

---

## 📦 Features

- ✅ **Task Management**: Create, read, update tasks with status tracking
- ✅ **Role-Based Access Control**: Different permissions based on user roles
- ✅ **Authentication**: Secure user authentication with Spring Security
- ✅ **Validation**: Comprehensive input validation
- ✅ **Exception Handling**: Global exception handling for consistent error responses


---
## 🏁 Setup Instructions

### 🏗 Step 1: Clone the Repository
```bash
git clone https://github.com/Trela-dev/SecureTaskManager.git
cd SecureTaskManager
```

### 🐳 Step 2: Start PostgreSQL Database in Docker
Navigate to project folder(where the pom.xml file is) and run following commadns
Run the following command in the project directory to start the database container:

```bash
docker-compose up -d
```

### 🔨 Step 3: Build and Run the Application

```bash
mvn clean install
java -jar target/SecureTaskManager-0.0.1-SNAPSHOT.jar
```

The application should now be running on [http://localhost:8080](http://localhost:8080).

### 📡 Step 4: Test the API with Postman
Use Postman to test endpoints:



| Method | Endpoint | Description | Required Role |
|--------|----------|-------------|--------------|
| GET    | /tasks/{id} | Get a specific task by ID | Task owner or ADMIN |
| GET    | /tasks | Get all tasks | ADMIN |
| POST   | /tasks | Create a new task | ADMIN |
| PUT    | /tasks/{id} | Update an existing task | ADMIN |

### 🔐 Authentication Required for All Endpoints

All secured API endpoints require **Basic Authentication**.

Use one of the predefined users to access the endpoints.  
Example credentials: `john` / `12345` (role: `ADMIN`)

You must include the Basic Auth credentials **in every request**.

![image](https://github.com/user-attachments/assets/fab8fa84-d5fc-45b8-a0ef-643b5bd8100f)


### 📥 POST `/tasks` – Add a New Task
**Required Role:** `ADMIN`  
**Request Body (JSON):**
```json
{
  "ownerUsername": "bob",
  "description": "Design mockups for the new dashboard",
  "deadline": "2025-04-28T16:00:00"
}
```
**Response Status:** `201 Created`  
Tasks are created with status `STARTED` by default.

---

### 🔄 PUT `/tasks/{id}` – Update an Existing Task
**Required Role:** `ADMIN`  
**Request Body (JSON):**
```json
{
  "ownerUsername": "jane",
  "description": "Fix CSS issues in dark mode layout",
  "deadline": "2025-04-28T16:00:00",
  "status": "IN_PROGRESS"
}
```
**Response Status:** `200 OK`

---

### 📄 GET `/tasks` – Retrieve All Tasks
**Required Role:** `ADMIN`  
**Response Status:** `200 OK`  
**Sample Response:**
```json
[
  {
    "id": 1,
    "ownerUsername": "john",
    "description": "Fix bug in login authentication module",
    "deadline": "2025-04-18T00:00:00",
    "status": "STARTED"
  }
]
```

---

### 📄 GET `/tasks/{id}` – Retrieve Task by ID
**Required Role:** `ADMIN` or the task owner  
**Sample Response:**
```json
{
  "id": 5,
  "ownerUsername": "alice",
  "description": "Update documentation for API endpoints",
  "deadline": "2025-04-25T00:00:00",
  "status": "STARTED"
}
```
---

## 📦 Task Statuses (`TaskStatus`)

- `STARTED`
- `IN_PROGRESS`
- `FINISHED`
- `CANCELLED`

---
## 👥 Sample Users

The following pre-defined users are available with the password `12345` for all users:

| Username | Role       | Password |
| :------- | :--------- | :------- |
| john     | ROLE_ADMIN | 12345    |
| jane     | ROLE_USER  | 12345    |
| alice    | ROLE_USER  | 12345    |
| bob      | ROLE_USER  | 12345    |
| charlie  | ROLE_USER  | 12345    |
| diana    | ROLE_USER  | 12345    |
| eric     | ROLE_USER  | 12345    |
---

## ⚠️ Error Handling

- `404 Not Found` – User or task not found.
- `400 Bad Request` – Invalid input data.
- `401 Unauthorized` / `403 Forbidden` – Unauthorized or insufficient permissions.


## 🛠️ Technologies Used

This project utilizes the following technologies:

* ✅   **Java 21+**
* ✅   **Spring Boot**
* ✅   **Spring Security**
* ✅   **Spring Data JPA**
* ✅   **MapStruct**
* ✅   **Jakarta Validation**
* ✅   **Lombok**
* ✅   **PostgreSQL**
* ✅   **Flyway** (for database migrations)
* ✅   **Maven**
* ✅   **BCrypt** (for password encoding)
---

## 🚀 Future Enhancements

The Secure Task Manager is a work-in-progress (WIP) project, and several features are planned for future development, including:

- 📝 **User Registration Endpoint**  
  Allow new users to register themselves with customizable roles (with restrictions to prevent privilege escalation).

- 🔄 **User Task Status Updates**  
  Allow regular users (task owners) to update the status of their own tasks (e.g., from `STARTED` to `IN_PROGRESS` or `FINISHED`), while keeping sensitive fields restricted to admins.

- 🧪 **Unit and Integration Tests**  
  Expand test coverage using tools like JUnit and Testcontainers for reliable CI/CD.

- 📱 **Frontend Integration**  
  Build a web-based frontend (e.g., React or Angular) to interact with the backend visually.

  

