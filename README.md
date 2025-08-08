# Expense Tracker

A simple expense tracking web application built with Spring Boot and MySQL.

## Features

- Add, edit, delete, and view expenses
- Filter expenses by category and date
- Real-time expense statistics
- Responsive web interface

## Tech Stack

- **Backend**: Spring Boot 3.5.4, Java 17+
- **Database**: MySQL 8.0+
- **Frontend**: HTML, CSS, JavaScript
- **Build Tool**: Maven

## Setup

### 1. Clone Repository
```bash
git clone https://github.com/your-username/expence-tracker.git
cd expence-tracker
```

### 2. Setup MySQL Database
```sql
CREATE DATABASE expense_tracker;
USE expense_tracker;

CREATE TABLE expenses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    category VARCHAR(100) NOT NULL,
    expense_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

### 3. Configure Database
Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

### 4. Run Application
```bash
mvn clean compile
mvn spring-boot:run
```

### 5. Access Application
Open browser: `http://localhost:8080`

## Project Structure
```
src/main/java/com/sits/
├── ExpenceTrackerApplication.java
├── controller/ExpenseController.java
├── model/Expense.java
└── repository/ExpenseRepository.java

src/main/resources/
├── static/index.html
└── application.properties
```

## API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/expenses` | Get all expenses |
| POST | `/api/expenses` | Create expense |
| PUT | `/api/expenses/{id}` | Update expense |
| DELETE | `/api/expenses/{id}` | Delete expense |
| GET | `/api/expenses/total` | Get total amount |

## Requirements

- Java 17+
- Maven 3.6+
- MySQL 8.0+

## Demo Application 
<img width="957" height="443" alt="image" src="https://github.com/user-attachments/assets/2d5f4aba-ced4-4472-b269-be0ecc54716d" />
