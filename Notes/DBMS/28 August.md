---
title: August 28
---
### Circular Dependency
```SQL
create table employee_table (
    NAME varchar(20),
    ssn int not null,
    super_ssn int,
    DNO int not null,
    Primary key (ssn),
    foreign key (super_ssn) references employee_table(ssn) deferrable initially deferred,
    foreign key (DNO) references dept_table(DNUMBER) deferrable initially deferred
)
-------------------------
create table dept_table (
    dname varchar(20),
    DNUMBER int,
    mgr_ssn int not null,
    primary key (DNUMBER)
)
-------------------------
alter table dept_table add constraint fkdepttable
foreign key (mgr_ssn) references employee_table(ssn) 
deferrable initially deferred
-------------------------
```

### Dropping Circular Dependency
```SQL
drop table dept_table cascade constraints
```

### Using Transactions
```SQL
BEGIN -- To Start Transaction

insert into dept_table (name, dnumber, Mgr_ssn) values ('Reserache', 1, '100')
insert into employee (name, ssn, super_ssn, dno) values ('Gatito', 12, 12, 1)
COMMIT; -- To End Transaction
EXCEPTION
 with others then
 rollback;
 raise;
```
