# Student Management System (Java + MySQL)

A menu-driven console application demonstrating student record management with JDBC and MySQL.

## Features
- Add a student
- View all students
- Search by student ID
- Update student details
- Delete a student

## Tech stack
- Java 17+
- MySQL 8+
- JDBC
- Maven

## Database setup
1. Start your MySQL server.
2. Open MySQL Workbench or the MySQL command line.
3. Run `database/student_management.sql`.

## Configure database credentials
Open `src/main/java/com/studentmanagement/DBConnection.java` and set:
- `USER` to your MySQL username
- `PASSWORD` to your local MySQL password

Do not commit real passwords to a public GitHub repository. For a public repository, use environment variables or a local configuration file excluded by `.gitignore`.

## Run
From the project root:
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.studentmanagement.Main"
```

If you use an IDE, import the folder as a Maven project and run `Main.java`.

## Database design
`students` table:
- `id`: auto-increment primary key
- `name`: student name
- `email`: unique email
- `course`: course name
- `phone`: contact number

## Learning notes
This is a learning project. Run and test each CRUD operation before describing it in an interview. Be prepared to explain the code you personally understand and have verified.
