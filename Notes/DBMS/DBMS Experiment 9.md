---
title: Experiment 9
---
**Name: Kshitij Chandrakar**
**Batch: 49**
**SAP: 500124827**
## 1

```SQL
--A
CREATE TABLE Orders (
    Order_ID INT PRIMARY KEY,
    Order_Date DATE,
    Total_Amount DECIMAL(10, 2)
);
desc Orders

--B
CREATE SYNONYM ordersSyn FOR Orders;
select * from ordersSyn

--C
drop table Orders
desc Orders

--D
select * from ordersSyn

```
### A
![[Pasted image 20240925152856.png]]
### B
![[Pasted image 20240925152933.png]]

### C
![[Pasted image 20240925152959.png]]
### D
![[Pasted image 20240925153043.png]]

## 2
```SQL
--A
CREATE TABLE Contracts (
    Contracts_ID INT PRIMARY KEY,
    Contracts_Date DATE,
    Total_Amount DECIMAL(10, 2)
);
desc Contracts

--B
CREATE SYNONYM contractsSyn FOR Contracts;
select * from user_synonyms where synonym_name = 'CONTRACTSSYN'

--C
Alter table contracts add (Name varchar(10))
desc Contracts

--D
desc contractsSyn
```
### A
![[Pasted image 20240925152314.png]]
### B
![[Pasted image 20240925152623.png]]
### C
![[Pasted image 20240925152701.png]]
### D
![[Pasted image 20240925152737.png]]



3.
```SQL
--A
CREATE TABLE Employees (
Employee_ID INT,
Employee_Name VARCHAR(50),
Employee_Salary INT
)

--B
INSERT ALL
INTO Employees (Employee_1D, Employee_Name) VALUES (101, 'HR')
INTO Employees (Employee_ID, Employee_Name) VALUES (102. 'IT')
SELECT * from dual

--C
CREATE VIEW Employee_Summary as
SELECT Employee_ID, Employee_Name,Employee_Salary FROM Employees;

CREATE SYNONYM EmpSummary FOR Employee_Summary;
select * from EmpSummary

```

### A![[Pasted image 20240925152237.png]]
### B
![[Pasted image 20240925152210.png]]
### C
![[Pasted image 20240925152145.png]]
![[Pasted image 20240925152042.png]]

4.
```SQL
--A
CREATE TABLE Invoices (
    InvoiceID NUMBER PRIMARY KEY,
    Amount NUMBER(10, 2) NOT NULL
);
desc Invoices

--B
CREATE SEQUENCE Invoice_Seq
  START WITH 1
  INCREMENT BY 1
  NOCACHE;
select * from user_sequences where sequence_name = 'INVOICE_SEQ'

--C
CREATE SYNONYM InvoicesSyn FOR Invoices;
select * from user_synonyms where synonym_name = 'INVOICESYN'

--D
INSERT INTO InvoicesSyn (InvoiceID, Amount)
VALUES (Invoice_Seq.NEXTVAL, 100);
INSERT INTO InvoicesSyn (InvoiceID, Amount)
VALUES (Invoice_Seq.NEXTVAL, 250);
INSERT INTO InvoicesSyn (InvoiceID, Amount)
VALUES (Invoice_Seq.NEXTVAL, 50);

select * from InvoicesSyn
```
### A
![[Pasted image 20240925151648.png]]
### B
![[Pasted image 20240925151706.png]]
### C
![[Pasted image 20240925151735.png]]
### D
![[Pasted image 20240925151809.png]]

## 5.
```SQL
--A
CREATE TABLE Products (
    ProductID NUMBER PRIMARY KEY,
    ProductName VARCHAR(50) NOT NULL,
    Price NUMBER(10, 2)
);

--B
CREATE SYNONYM ProdSyn FOR Products;

--C
CREATE SYNONYM ChainSyn FOR ProdSyn;

--D
SELECT * FROM ChainSyn;
SELECT * FROM Products;
```
### A
![[Pasted image 20240925150839.png]]
### B
![[Pasted image 20240925151214.png]]
### C
![[Pasted image 20240925151150.png]]
### D
![[Pasted image 20240925151310.png]]
![[Pasted image 20240925151319.png]]
