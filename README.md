# Human Resources Application

This project is an application developed to effectively manage human resources processes. With its user-friendly interface, it aims to facilitate the management of essential functions such as employee records, leave requests, and performance evaluations, along with reporting and analytics features. By automating these processes, the application seeks to save time and resources while enhancing overall work efficiency.

## Features

- **Employee Management**
    - Add, update, and delete employee, leave-type and leave-rquest information.
    - Send username and password information to employees via email.
    - Send message for administrators approval.
    - Sending congratulatory messages to employees on their birthdays.

## Technologies Used

- **Spring Boot**
- **Spring Mail** for email functionality
- **SQL2o** for database interaction
- **MySQL database**
- **Apache Commons DBCP2** for database connection pooling
- **Apache Commons Lang3** for utility classes
- Validation using **Spring Boot Starter Validation**

## Prerequisites

- **Java 17**
- **MySQL Database**

## Getting Started

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/MenekseYuncu/hr-application.git
   cd hr-application

2. **Build and Install the Project:**
   ```bash
     ./mvnw clean install

3. **Configure Database:**

  - Create a MySQL database.
  - Update application.yml with your database configuration.

1. **Run the Application:**

  ```bash
   ./mvnw spring-boot:run
```

- The application will start on http://localhost:8080.

## POSTMAN COLLECTION

https://documenter.getpostman.com/view/24190370/2s9YkrcL2h
