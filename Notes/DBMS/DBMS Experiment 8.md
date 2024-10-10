---
title: Experiment 8
---
# Experiment 1

**Name: Kshitij Chandrakar**
**Sap: 500124827**
**Batch: 49**

Q1: Create a sequence by name EMPID_SEQ starting with value 100 with an interval of 1
```SQL
CREATE SEQUENCE EMPID_SEQ
    START WITH 100
    INCREMENT BY 1;
```
![[Pasted image 20240923144939.png]]
Q2: Write a SQL command for finding the current and the next status of EMPID_SEQ.
```SQL
SELECT EMPID_SEQ.CURRVAL AS current_value, EMPID_SEQ.NEXTVAL AS next_value
FROM DUAL;
```
![[Pasted image 20240923143953.png]]

Q3:
```SQL
ALTER SEQUENCE EMPID_SEQ
    CACHE 20
    MAXVALUE 1000;
```
![[Pasted image 20240923145255.png]]
Q4: Insert values in employees table using sequences for employee_id column
```SQL

drop table employees cascade constraints
create table employees (
    employee_id int,
    first_name varchar(20),
    last_name varchar(20),
    hire_date date
)
INSERT INTO employees (employee_id, first_name, last_name, hire_date)
VALUES (EMPID_SEQ.NEXTVAL, 'Yonder', 'Alice', TO_DATE('2023-01-01', 'YYYY-MM-DD'));
```
![[Pasted image 20240923150112.png]]


Q5: Drop sequence EMPID_SEQ
```SQL
DROP SEQUENCE EMPID_SEQ;
describe EMPID_SEQ
```
![[Pasted image 20240923150150.png]]
Q6:
```SQL
CREATE SEQUENCE REVERSE
	START WITH 1000
	INCREMENT BY -5
	MAXVALUE 1000
	MINVALUE 0
	CYCLE;
```
![[Pasted image 20240923151600.png]]
Q7: Apply REVERSE with a custom-made Inventory table.
```SQL
CREATE TABLE inventory (
	quantity NUMBER,
	item_name VARCHAR2(100),
);

INSERT INTO inventory
VALUES(REVERSE.NEXTVAL, 'Bots');
```

![[Pasted image 20240923151405.png]]