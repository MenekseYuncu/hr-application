# Human Resources Application

This is a Human Resources (HR) application developed using Spring Boot.

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

4. **Run the Application:**
  ```bash
   ./mvnw spring-boot:run
```
- The application will start on http://localhost:8080.

## POSTMAN COLLECTİON 
https://documenter.getpostman.com/view/24190370/2s9YkrcL2h
