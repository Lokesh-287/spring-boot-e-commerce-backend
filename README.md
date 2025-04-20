# spring-boot-e-commerce-backend
# Course Registration System

This project is a simple Course Registration System that allows users to register for courses, view available courses, and see the list of students who have enrolled in each course. Built with **Spring Boot** for the backend, **HTML**, **CSS**, and **JavaScript** for the frontend, and **MySQL** as the database.

## Features

- **User Registration**: Users can register for available courses by providing their name, email, and course selection.
- **View Courses**: Users can see a list of available courses with details such as course name, trainer, and duration.
- **Enrolled Students**: View a list of students enrolled in courses.

## Technologies Used

- **Backend**: Spring Boot
- **Frontend**: HTML, CSS, JavaScript
- **Database**: MySQL
- **Java**: Java 17
- **Version Control**: Git, GitHub

## Setup

### Prerequisites

Before you can run this application, ensure you have the following installed:

1. **Java 17** or above
2. **Maven**
3. **MySQL Database**
4. **IDE** (e.g., IntelliJ IDEA or VS Code)

### Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/Course-Registration-System.git
    cd Course-Registration-System
    ```

2. **Setup MySQL Database**:
   - Create a database in MySQL (e.g., `course_registration_system`).
   - Configure your `application.properties` file in the `src/main/resources` directory:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/course_registration_system
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Build and run the project**:
    ```bash
    ./mvnw spring-boot:run
    ```

### Usage

- **Access the API**:
    - To view all available courses:
      ```
      GET http://localhost:8080/courses
      ```
    - To view all enrolled students:
      ```
      GET http://localhost:8080/courses/enrolled
      ```
    - To register a student for a course:
      ```
      POST http://localhost:8080/courses/register
      Parameters:
        name=John Doe
        emailId=john@example.com
        courseName=Java Programming
      ```

### Folder Structure

```plaintext
Course-Registration-System/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── course/
│   │   │   │           ├── CourseApplication.java
│   │   │   │           ├── controller/
│   │   │   │           │   └── CourseController.java
│   │   │   │           ├── model/
│   │   │   │           │   └── Course.java
│   │   │   │           ├── repository/
│   │   │   │           │   └── CourseRepository.java
│   │   │   │           └── service/
│   │   │   │               └── CourseService.java
│   │   │   └── resources/
│   │   │       ├── application.properties
│   │   │       └── static/
│   │   │           └── index.html
│   │   └── test/
│   │       └── java/
│   │           └── com/
│   │               └── course/
│   │                   └── CourseApplicationTests.java
├── frontend/
│   ├── index.html
│   ├── css/
│   │   └── style.css
│   └── js/
│       └── app.js
└── README.md
