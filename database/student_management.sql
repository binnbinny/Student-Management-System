CREATE DATABASE IF NOT EXISTS student_management;
USE student_management;

CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    course VARCHAR(100) NOT NULL,
    phone VARCHAR(20)
);

-- Optional sample record
INSERT IGNORE INTO students (name, email, course, phone)
VALUES ('Asha Kumar', 'asha@example.com', 'Computer Science', '9876543210');
