**Name: Kshitij Chandrakar**
**Batch: 49**
**SAP: 500124827**

### 1. PL/SQL Block to Check Even or Odd Number
```sql
DECLARE
    num NUMBER;
BEGIN
    num := :num;

    IF MOD(num, 2) = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Even');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Odd');
    END IF;
END;
```
Output with Input 10
![[Pasted image 20241021143355.png]]
Output with Input 9
![[Pasted image 20241021143436.png]]
![[Pasted image 20241021143454.png]]
### 2. PL/SQL Block Using a WHILE Loop to Display First 10 Fibonacci Numbers
```sql
DECLARE
    a NUMBER := 0;
    b NUMBER := 1;
    next NUMBER;
    count1 NUMBER := 1;  -- Initialize counter
BEGIN
    DBMS_OUTPUT.PUT_LINE('First 10 Fibonacci Numbers:');

    WHILE count1 <= 10 LOOP
        DBMS_OUTPUT.PUT_LINE(a);  
        next := a + b;            
        a := b;                   
        b := next;                
        count1 := count1 + 1;
    END LOOP;
END;
```

![[Pasted image 20241021143513.png]]
### 3. PL/SQL Block to Display Employee Names by Department ID
```sql
DECLARE
    dept_id NUMBER;
BEGIN
    dept_id := :dept_id;

    DBMS_OUTPUT.PUT_LINE('Employees in Department ' || dept_id || ':');

    FOR emp_rec IN (SELECT employee_name FROM employees WHERE department_id = dept_id) LOOP
        DBMS_OUTPUT.PUT_LINE(emp_rec.employee_name);
    END LOOP;
END;
/
```
![[Pasted image 20241021144111.png]]
![[Pasted image 20241021144219.png]]

### 4. PL/SQL Block to Display Employee's Salary and Department
```sql
DECLARE
    emp_id NUMBER;
    emp_salary NUMBER;
    emp_dept NUMBER;
BEGIN
    emp_id := :emp_id; 

    SELECT salary, department_id INTO emp_salary, emp_dept
    FROM employees
    WHERE employee_id = emp_id;

    DBMS_OUTPUT.PUT_LINE('Employee Salary: ' || emp_salary);
    DBMS_OUTPUT.PUT_LINE('Department ID: ' || emp_dept);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee not found.');
END;
/
```
![[Pasted image 20241021144306.png]]


### 5. Procedure to Update Employee's Salary
```sql
CREATE OR REPLACE PROCEDURE update_employee_salary (
    p_emp_id IN NUMBER,
    p_increase_percentage IN NUMBER
) AS
    v_new_salary NUMBER;
BEGIN
    UPDATE employees
    SET salary = salary + (salary * p_increase_percentage / 100)
    WHERE employee_id = p_emp_id
    RETURNING salary INTO v_new_salary;

    DBMS_OUTPUT.PUT_LINE('Updated Salary: ' || v_new_salary);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee not found.');
END;
update_employee_salary(2, 10);
```
![[Pasted image 20241021144616.png]]
![[Pasted image 20241021144634.png]]

### 6. Nested PL/SQL Block to Calculate Average, Highest, and Lowest Salaries
```sql
	DECLARE
    avg_salary NUMBER;
    highest_salary NUMBER := 0;
    lowest_salary NUMBER := NULL;  
BEGIN
    SELECT AVG(salary) INTO avg_salary
    FROM employees;

    FOR emp_rec IN (SELECT salary FROM employees) LOOP
        IF lowest_salary IS NULL OR emp_rec.salary < lowest_salary THEN
            lowest_salary := emp_rec.salary; 
        END IF;

        IF emp_rec.salary > highest_salary THEN
            highest_salary := emp_rec.salary;
        END IF;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Average Salary: ' || avg_salary);
    DBMS_OUTPUT.PUT_LINE('Highest Salary: ' || highest_salary);
    DBMS_OUTPUT.PUT_LINE('Lowest Salary: ' || lowest_salary);
END;
```
![[Pasted image 20241021144657.png]]
