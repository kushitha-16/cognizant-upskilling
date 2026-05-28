CREATE DATABASE cognizant_practice;

USE cognizant_practice;

CREATE TABLE students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(50),
    email VARCHAR(100),
    city VARCHAR(50)
);

CREATE TABLE courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(50),
    fees INT
);

CREATE TABLE enrollments (
    enrollment_id INT PRIMARY KEY,
    student_id INT,
    course_id INT,
    marks INT,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

INSERT INTO students VALUES
(1, 'Kushitha', 'kushitha@gmail.com', 'Bangalore'),
(2, 'Ravi', 'ravi@gmail.com', 'Mysore'),
(3, 'Anu', 'anu@gmail.com', 'Hyderabad');

INSERT INTO courses VALUES
(101, 'HTML', 2000),
(102, 'JavaScript', 3000),
(103, 'SQL', 2500);

INSERT INTO enrollments VALUES
(1, 1, 101, 85),
(2, 1, 103, 90),
(3, 2, 102, 75),
(4, 3, 103, 88);

SELECT * FROM students;

SELECT student_name, city
FROM students
WHERE city = 'Bangalore';

SELECT * FROM courses
ORDER BY fees DESC;

SELECT COUNT(*) AS total_students
FROM students;

SELECT AVG(marks) AS average_marks
FROM enrollments;

SELECT s.student_name, c.course_name, e.marks
FROM students s
INNER JOIN enrollments e ON s.student_id = e.student_id
INNER JOIN courses c ON e.course_id = c.course_id;

SELECT c.course_name, COUNT(e.student_id) AS total_enrolled
FROM courses c
LEFT JOIN enrollments e ON c.course_id = e.course_id
GROUP BY c.course_name;

UPDATE students
SET city = 'Chennai'
WHERE student_id = 2;

DELETE FROM enrollments
WHERE enrollment_id = 4;