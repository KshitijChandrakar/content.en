
### Creating The Tables

```SQL
CREATE TABLE Students (
  student_id INT PRIMARY KEY,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  email VARCHAR(100),
  major VARCHAR(50)
);

CREATE TABLE Courses (
  course_id INT PRIMARY KEY,
  course_name VARCHAR(100),
  instructor VARCHAR(50),
  credits INT
);

CREATE TABLE Enrollments (
  enrollment_id INT PRIMARY KEY,
  student_id INT,
  course_id INT,
  grade DECIMAL(4,2),
  FOREIGN KEY (student_id) REFERENCES Students(student_id),
  FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);
```

### Inserting Values
```SQL
INSERT ALL
INTO Students VALUES (1, 'Traveler', 'Aether', 'aether@genshin.com', 'Adventurer')
INTO Students VALUES (2, 'Paimon', 'Paimon', 'paimon@genshin.com', 'Companion')
INTO Students VALUES (3, 'Amber', 'Amber', 'amber@genshin.com', 'Knight of Favonius')
INTO Students VALUES (4, 'Kaeya', 'Alberich', 'kaeya@genshin.com', 'Knight of Favonius')
INTO Students VALUES (5, 'Lisa', 'Minci', 'lisa@genshin.com', 'Librarian')
INTO Courses VALUES (101, 'Database Systems', 'Dr. Smith', 3)
INTO Courses VALUES (102, 'Data Structures', 'Prof. Johnson', 4)
INTO Courses VALUES (103, 'Calculus', 'Mr. Williams', 3)
INTO Courses VALUES (104, 'Music Theory', 'Ms. Brown', 2)
select * from dual

INSERT ALL
INTO Enrollments VALUES (1, 1, 101, 3.5)
INTO Enrollments VALUES (2, 1, 102, 3.8)
INTO Enrollments VALUES (3, 2, 103, 2.7) 
INTO Enrollments VALUES (4, 3, 101, 4.0)
INTO Enrollments VALUES (5, 4, 104, 3.2)
select * from dual
```

### Creating The Views
#### View 1: Student_Info

```sql
CREATE VIEW Student_Info AS
SELECT student_id, first_name, last_name, email
FROM Students;
```

#### View 2: Course_Info#

```sql
CREATE VIEW Course_Info AS
SELECT course_id, course_name, instructor
FROM Courses;
```

#### View 3: Enrollment_Details

```sql
CREATE VIEW Enrollment_Details AS
SELECT student_id, course_id, grade
FROM Enrollments;
```

#### View 4: Student_GPA

```sql
CREATE VIEW Student_GPA AS
SELECT s.first_name, s.last_name, s.email, AVG(e.grade) AS gpa
FROM Students s
JOIN Enrollments e ON s.student_id = e.student_id
GROUP BY s.student_id, s.first_name, s.last_name, s.email;
```

#### View 5: Course_Enrollment_Count

```sql
CREATE VIEW Course_Enrollment_Count AS
SELECT c.course_name, COUNT(*) AS enrollment_count
FROM Courses c
JOIN Enrollments e ON c.course_id = e.course_id
GROUP BY c.course_name;
```

#### View 6: Top_Performers

```sql
CREATE VIEW Top_Performers AS
SELECT c.course_name, s.first_name, s.last_name, MAX(e.grade) AS highest_gpa
FROM Courses c
JOIN Enrollments e ON c.course_id = e.course_id
JOIN Students s ON e.student_id = s.student_id
GROUP BY c.course_name;
```

#### View 7: Top_Enrolled_Courses

```sql
CREATE VIEW Top_Enrolled_Courses AS
SELECT c.course_name, COUNT(*) AS enrollment_count
FROM Courses c
JOIN Enrollments e ON c.course_id = e.course_id
GROUP BY c.course_name
ORDER BY enrollment_count DESC
FETCH FIRST 5 ROWS ONLY;
```

#### View 8: Students_In_Multiple_Courses

```sql
CREATE VIEW Students_In_Multiple_Courses AS
SELECT student_id, first_name, last_name
FROM Students
WHERE student_id IN (
    SELECT student_id
    FROM Enrollments
    GROUP BY student_id
    HAVING COUNT(*) > 1
);
```

#### View 9: Courses_Taught_By_Same_Instructor

```sql
CREATE VIEW Courses_Taught_By_Same_Instructor AS
SELECT c.instructor, c.course_name
FROM Courses c
GROUP BY c.instructor, c.course_name
HAVING COUNT(*) > 1;
```

#### View 10: Student_Course_Grade_Details

```sql
CREATE VIEW Student_Course_Grade_Details AS
SELECT s.first_name, s.last_name, s.email, c.course_name, e.grade
FROM Students s
JOIN Enrollments e ON s.student_id = e.student_id
JOIN Courses c ON e.course_id = c.course_id;
```
## Selecting Data from the Created Views

#### View 1: Student_Info 

```sql
SELECT * FROM Student_Info;
```

#### View 2: Course_Info

```sql
SELECT * FROM Course_Info;
```

#### View 3: Enrollment_Details

```sql
SELECT * FROM Enrollment_Details;
```

#### View 4: Student_GPA

```sql
SELECT * FROM Student_GPA;
```

#### View 5: Course_Enrollment_Count

```sql
SELECT * FROM Course_Enrollment_Count;
```

#### View 6: Top_Performers

```sql
SELECT * FROM Top_Performers;
```

#### View 7: Top_Enrolled_Courses

```sql
SELECT * FROM Top_Enrolled_Courses;
```

#### View 8: Students_In_Multiple_Courses

```sql
SELECT * FROM Students_In_Multiple_Courses;
```

#### View 9: Courses_Taught_By_Same_Instructor

```sql
SELECT * FROM Courses_Taught_By_Same_Instructor;
```

####  View 10: Student_Course_Grade_Details

```sql
SELECT * FROM Student_Course_Grade_Details;
```
