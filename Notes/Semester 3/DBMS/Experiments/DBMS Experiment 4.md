---
title: Experiment 4
---

# DBMS Experiment 4
**Name:** Kshitij Chandrakar
**SAP:** 500124827
**Batch:** 49
**Date:** 4 September 2024
 
## Question 1
### Creating the Table
```SQL
CREATE TABLE SALES (
SaleID number,
SaleAmount number,
SaleDate date
```
![[Pasted image 20240904144527.png]]
![[Pasted image 20240904144716.png]]
### Inserting Values
```SQL
INSERT ALL 
	into Sales values (110, 4234,'12/12/2024')
	into Sales values (221, 3211,'12/14/2024')
	into Sales values (353, 1232,'12/15/2024')
	into Sales values (353, 2222,'12/13/2024')
	into Sales values (3523, 5152,'12/11/2024')
select * from dual
```
![[Pasted image 20240904145223.png]]

### Rounding Values to the Nearest 100
```SQL
Select SaleID, Round(SaleAmount, -2) as Rounded, SaleDate from Sales
```
![[Pasted image 20240904145255.png]]

### Modulus of Each Sale divided By 100
```SQL
select SaleID, Mod(SaleAmount, 100), SaleDate from Sales
```
![[Pasted image 20240904145354.png]]


## Question 2
### Creating Tables
```SQL
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    HireDate DATE
);
```

### Inserting Values
```SQL
INSERT INTO Employees (EmployeeID, Name, HireDate) VALUES
(1, 'John Doe', '2023-01-15'),
(2, 'Jane Smith', '2024-03-20'),
(3, 'Michael Johnson', '2022-11-08'),
(4, 'Emily Davis', '2023-07-12'),
(5, 'David Lee', '2024-05-05');
```

### Showing the Values
```SQL
SELECT EmployeeID, Name, HireDate, TRUNC(SYSDATE - HireDate) AS DaysSinceHire
FROM Employees;
```

## Question 3

### Creating the Tables
```SQL
CREATE TABLE Departments (
DepartmentID number primary key,
DepartmentName varchar2(100),
)
CREATE TABLE Employees (
EmployeeID number,
DepartmentID number,
Salary number,
foreign key (DepartmentID) references Departments(DepartmentID)
)
```
![[Pasted image 20240904150316.png]]
![[Pasted image 20240904150631.png]]


### Inserting Values
```SQL
insert all 
    into Departments Values (1, 'A')
    into Departments Values (2, 'B')
    into Departments Values (3, 'C')
    into Departments Values (4, 'D')
select * from dual
```

![[Pasted image 20240904151748.png]]

```SQL

insert all 
    into employees Values (1, 1, 10000)
    into employees Values (2, 4, 10000)
    into employees Values (3, 1, 20000)
    into employees Values (4, 2, 30000)
    into employees Values (5, 3, 50000)
select * from dual
```

![[Pasted image 20240904151504.png]]

### Total, Minimum, Maximum and Average Salary
```SQL
select SUM(Salary) as Total, AVG(Salary) as Average, Min(Salary) as Lowest, Max(Salary) as Highest from Employees
```

![[Pasted image 20240904152240.png]]
## Question 4

### Creating the Table
```SQL
CREATE TABLE Grades (
    StudentID NUMBER,
    StudentName VARCHAR2(100),
    Grade NUMBER
);
```
![[Pasted image 20240904162013.png]]
### Inserting Values
```SQL
INSERT ALL
	INTO Grades VALUES (1, 'John Doe', 80);
	INTO Grades VALUES (2, 'Jane Smith', 60);
	INTO Grades VALUES (3, 'Alice Johnson', 95);
	INTO Grades VALUES (4, 'Bob Brown', 75);
	INTO Grades VALUES (5, 'Sarah Lee', 85);
select * from dual
```
![[Pasted image 20240904161937.png]]
### Selecting the Relevant Values
```SQL
SELECT 
    StudentID,
    StudentName,
    Grade,
    CASE
        WHEN Grade < 70 THEN 'Low'
        WHEN Grade >= 70 AND Grade < 90 THEN 'Medium'
        ELSE 'High'
    END AS GradeCategory
FROM Grades;
```
![[Pasted image 20240904162101.png]]
## Question 5
### Creating Tables
```SQL
create table Courses (
   CourseID number primary key,
   CourseName varchar(100),
   Credits number
)

create table Enrollments (
    EnrollmentID number primary key,
    StudentID number,
    CourseID number,
    foreign key (CourseID) references Courses(CourseID)   
)
```
![[Pasted image 20240904155005.png]]
![[Pasted image 20240904155057.png]]
### Inserting Values
```SQL
insert all
	into Courses values (1, 'Literature', 4)
	into Courses values (2, 'Physics', 3)
	into Courses values (3, 'Chemistry', 4)
	into Courses values (4, 'Computer Science', 2)
	into Courses values (5, 'Discrete Mathematics', 5)
select * from dual

--INSERTING THE RECORDS IN ENROLMENTS
insert all
	into Enrollments values (1, 101, 1)
	into Enrollments values (2, 102, 3)
	into Enrollments values (3, 103, 2)
	into Enrollments values (4, 104, 5)
	into Enrollments values (5, 105, 4)
select * from dual
```

![[Pasted image 20240904155526.png]]
![[Pasted image 20240904155614.png]]
### Credits More Than 3
```SQL
select StudentID from Enrollments 
where CourseID in (
    select CourseID
    from Courses
    where Credits > 3
)
```
![[Pasted image 20240904155638.png]]

## Question 6
### Creating the Table
```SQL
create table Customers (
    CustomerID number,
    CustomerName Varchar2(100),
    Email Varchar2(100)
)
```
![[Pasted image 20240904155919.png]]

### Inserting The Values
```SQL
insert all
into Customers values (001, 'Naman', 'raghvendra@gmail.com')
into Customers values (002, 'Joshi', 'oof@email.com')
into Customers values (003, 'Dixit', 'lalalaanshu@fmail.com')
into Customers values (004, 'Nidhi', 'rarw@gmail.com')
into Customers values (005, 'Aanchal', 'Aanchal@wmail.com')
select * from dual
```
![[Pasted image 20240904160239.png]]
### Showing the Values where Email is a Gmail.com Domain
```SQL
select CustomerName
from Customers
where Email like '%@gmail.com'
```
![[Pasted image 20240904160316.png]]

## Question 7
### Creating the Tables
```SQL
create table orders
(
    orderid number,
    orderAmount number,
    orderdate date
);
```
![[Pasted image 20240904160455.png]]

### Inserting Values
```SQL
insert all
    into orders values(1,8,to_date('01/8/2024'))
    into orders values(2,6,to_date('02/8/2023'))
    into orders values(3,9,to_date('12/1/2023'))
    into orders values(4,89,to_date('1/2/2024'))
    into orders values(5,44,to_date('2/1/2024'))
select * from dual
```
![[Pasted image 20240904160724.png]]    
### Selecting the Orders which are above average
```SQL
SELECT orderID, orderAmount, orderDate
FROM orders
WHERE orderAmount > (SELECT AVG(orderAmount) FROM orders);
```

![[Pasted image 20240904160828.png]]
## Question 8
### Creating The Tables
```SQL
create table membership
(
    memeberid number,
    memebername varchar2(100),
    joinDate date
);```
![[Pasted image 20240904161155.png]]
### Inserting the Values
```SQL
insert all
    into membership values(1,'Ragav',to_date('01/8/2024'))
    into membership values(2,'Pranjal',to_date('02/8/2023'))
    into membership values(3,'Deepu',to_date('12/1/2023'))
    into membership values(4,'Rishi',to_date('1/2/2024'))
    into membership values(5,'jon',to_date('2/1/2024'))
    select * from dual
select * from membership
```
![[Pasted image 20240904161114.png]]
### Showing the Values
```SQL
select memeberid, memebername, joinDate
from membership
where joinDate >= ADD_MONTHS(SYSDATE, -12);
```
![[Pasted image 20240904161311.png]]
## Question 9
### Creating the Table
```SQL
create table SalesData (
    SaleID Number,
    ProductID Number,
    SaleAmount Number 
)
```
![[Pasted image 20240904161451.png]]
### Inserting The Records
```SQL
insert all
into SalesData values (1, 011, 500)
into SalesData values (2, 022, 600)
into SalesData values (3, 033, 700)
into SalesData values (4, 044, 800)
into SalesData values (5, 055, 1000)
select * from dual
```
![[Pasted image 20240904161413.png]]
### Showing 
```SQL
select ProductID
from SalesData
group by ProductID
having sum(SaleAmount) > (select avg(TotalSales)
    from (
        select ProductID, sum(SaleAmount) as TotalSales
        from SalesData
        group by ProductID
    )
)
```
![[Pasted image 20240904161514.png]]

## Question 10
### Creating The Table
```SQL
create table employeperformance (
    employeeid number primary key,
    employeename varchar2(100),
    performancescore number
);
```
![[Pasted image 20240904162810.png]]

### Inserting Values
```SQL
insert all
	INTO EmployeePerformance VALUES (1, 'Kazuha', 80)
	INTO EmployeePerformance VALUES (2, 'Paimon', 60)
	INTO EmployeePerformance VALUES (3, 'Lisa', 95)
	INTO EmployeePerformance VALUES (4, 'Barbara', 75)
	INTO EmployeePerformance VALUES (5, 'Benett', 85)
select * from dual
```
![[Pasted image 20240904162732.png]]

### Selecting the Relevant Values
```SQL
select employeeid, employeename, performancescore
from employeperformance
where performancescore > (
	select avg(performancescore)
	from employeperformance
);
```
![[Pasted image 20240904162709.png]]
