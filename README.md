# Dissertation Management System API

A secure and robust backend API built with **Java and Spring Boot** to modernise and streamline the process of managing university dissertations. This system provides role-based access for students and administrators, JWT-based security, and a full suite of CRUD operations for academic works.

---

## ✨ Key Features

* **Secure Authentication:** Utilises **Spring Security** with **JSON Web Tokens (JWT)** to secure all API endpoints, ensuring that only authenticated and authorised users can access protected resources.
* **Role-Based Access Control (RBAC):** Implements a clear distinction between `STUDENT` and `ADMIN` roles, restricting access to sensitive operations like approving or rejecting dissertations.
* **Full Dissertation Lifecycle Management:** Complete **CRUD (Create, Read, Update, Delete)** functionality for dissertation records.
* **Powerful Search Capability:** An endpoint to search for dissertations by keywords in their title, powered by Spring Data JPA-derived queries.
* **Modern Cloud Database Integration:** Connects to a **PostgreSQL** database hosted on **Supabase**, demonstrating experience with modern cloud database providers.

---

## 🛠️ Tech Stack

* **Backend:**
    * **Java 17**
    * **Spring Boot 3**
    * **Spring Security** (for JWT Authentication & RBAC)
    * **Spring Data JPA** (Hibernate)
* **Database:**
    * **PostgreSQL** (hosted on Supabase)
* **Build & Dependency Management:**
    * **Apache Maven**
* **Utilities:**
    * **Lombok**

---

## 🔌 API Endpoints

The API provides the following RESTful endpoints. Access is restricted by role.

| HTTP Method | Endpoint                       | Description                               | Access Role |
| :---------- | :----------------------------- | :---------------------------------------- | :---------- |
| `POST`      | `/api/auth/register`           | Register a new user (student or admin).   | Public      |
| `POST`      | `/api/auth/login`              | Authenticate a user and receive a JWT.    | Public      |
| `GET`       | `/api/dissertations`           | Get a list of all dissertations.          | STUDENT, ADMIN |
| `GET`       | `/api/dissertations/{id}`      | Get a single dissertation by its ID.      | STUDENT, ADMIN |
| `GET`       | `/api/dissertations/search?q=` | Search dissertations by title keyword.    | STUDENT, ADMIN |
| `POST`      | `/api/dissertations`           | Submit a new dissertation.                | STUDENT     |
| `PUT`       | `/api/dissertations/{id}`      | Update a dissertation (e.g., title, file).| STUDENT (Owner) |
| `DELETE`    | `/api/dissertations/{id}`      | Delete a dissertation.                    | STUDENT (Owner), ADMIN |
| `PATCH`     | `/api/admin/dissertations/{id}`| Change dissertation status (approve/reject). | ADMIN       |
| `GET`       | `/api/admin/users`             | Get a list of all users.                  | ADMIN       |

---

## ⚙️ Setup and Installation

To get a local copy up and running, follow these simple steps.

### Prerequisites

* JDK 17 or later
* Apache Maven
* A PostgreSQL database (you can create a free one on [Supabase](https://supabase.com/))

### Installation

1.  **Clone the repository:**
    ```sh
    git clone [https://github.com/Anas-16/dms.git](https://github.com/Anas-16/dms.git)
    cd dms
    ```

2.  **Configure your database:**
    * Navigate to `src/main/resources/application.properties`.
    * Update the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` properties with your own PostgreSQL database credentials.
    * It's highly recommended to use environment variables for these secrets in a production environment.

3.  **Run the application:**
    ```sh
    mvn spring-boot:run
    ```
    The application will start on `http://localhost:8080`. You can test the connection by navigating to `http://localhost:8080/ping`.
