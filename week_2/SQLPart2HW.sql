--2.0 Creating Tables and Relationships

CREATE TABLE EMPLOYEE(
    EMPLOYEEID INT NOT NULL,
    USERNAME VARCHAR(20) NOT NULL,
    PASSWORD VARCHAR(20) NOT NULL,
    NAME VARCHAR(20) NOT NULL,
    DEPARTMENT VARCHAR(2) NOT NULL,
    MANAGER INT NOT NULL,
    PRIMARY KEY(EMPLOYEEID)
);

CREATE TABLE ORDERS(
    ORDERID INT NOT NULL,
    EMPLOYEEID INT NOT NULL,
    ORDERDATE DATE NOT NULL,
    STATUS CHAR NOT NULL,
    PRIMARY KEY(ORDERID)
);


CREATE TABLE ORDERITEM(
    ORDERID INT NOT NULL,
    PRODUCTID INT NOT NULL,
    QUANTITY INT NOT NULL,
    PRIMARY KEY(ORDERID,PRODUCTID)
);

CREATE TABLE CATEGORY(
    CATID INT NOT NULL,
    NAME VARCHAR(80) NOT NULL,
    DESCRIPT VARCHAR(255) NOT NULL,
    PRIMARY KEY(CATID)
);


CREATE TABLE SUPPLIER(
    SUPPID INT NOT NULL,
    NAME VARCHAR(80) NOT NULL, 
    PRIMARY KEY(SUPPID)
);

CREATE TABLE PRODUCT(
    PRODUCTID INT NOT NULL,
    CATID INT NOT NULL,
    NAME VARCHAR(80) NOT NULL,
    DESCRIPT VARCHAR(255) NOT NULL,
    UNITCOST NUMBER(10,2) NOT NULL,
    SUPPID INT NOT NULL,
    PRIMARY KEY(PRODUCTID)
);

--2.2 Creating Relationships
--Create a 1:N relationship between Employees(PK) and Orders(FK)
ALTER TABLE ORDERS ADD 
    CONSTRAINT FK_EMPLOYEEID
    FOREIGN KEY(EMPLOYEEID) REFERENCES EMPLOYEE(EMPLOYEEID)
    ON DELETE CASCADE;
    
--Create a 1:N relationship between Orders(PK) and OrderItem(FK)
ALTER TABLE ORDERITEM ADD
    CONSTRAINT FK_ORDERS
    FOREIGN KEY (ORDERID) REFERENCES ORDERS(ORDERID)
    ON DELETE CASCADE;

--Create a 1:N rrelationship between Product(PK) nad OrderItem(FK)
ALTER TABLE ORDERITEM ADD
    CONSTRAINT FK_PRODUCTID
    FOREIGN KEY(PRODUCTID) REFERENCES PRODUCT(PRODUCTID)
    ON DELETE CASCADE;
    
--Create a 1:N to relationship between Product(PK) and OrderItem(FK)
ALTER TABLE PRODUCT ADD
    CONSTRAINT FK_SUPPLIERID
    FOREIGN KEY(SUPPID) REFERENCES SUPPLIER(SUPPID)
    ON DELETE CASCADE;
    
--Create a 1:N relationship between Category(PK) and Product(FK)
ALTER TABLE PRODUCT ADD
    CONSTRAINT FK_CATEGORYID
    FOREIGN KEY(CATID) REFERENCES CATEGORY(CATID)
    ON DELETE CASCADE;
    
--3.0 Performing SQL Queries
--Inserts for Employee
INSERT ALL
    INTO EMPLOYEE VALUES(1,'dclark','drc','Clark D','HR',0)
    INTO EMPLOYEE VALUES(2,'jsmith','js','Jones S','IT',1)
    INTO EMPLOYEE VALUES(3,'mjones','mj','Michael J','HR',1)
    INTO EMPLOYEE VALUES(4,'klink','kl','Kyle','IT',0)
SELECT * FROM dual;

commit;

--Insert for supplier
INSERT ALL
    INTO SUPPLIER VALUES(1,'XYZ Office Supplies')
    INTO SUPPLIER VALUES(2,'ABC Office Products')
SELECT * FROM dual
commit;

--Insert for categories
--SHOULD ALLOW NULL
ALTER TABLE CATEGORY MODIFY (DESCRIPT NULL);
INSERT ALL 
    INTO CATEGORY VALUES(1,'Audio Visual',null)
    INTO  CATEGORY VALUES(2,'Art Supplies',null)
    INTO CATEGORY VALUES(3,'Cleaning Supplies',null)
    INTO CATEGORY VALUES(4,'Computer Supplies',null)
    INTO CATEGORY VALUES(5,'Desk Acessories',null)
    INTO CATEGORY VALUES(6,'Writing Supplies',null)
    INTO CATEGORY VALUES(7,'Printer Supplies',null)
SELECT * FROM dual;

commit;


ALTER TABLE PRODUCT MODIFY(UNITCOST NUMBER(10,2));

--Inserts for Products
INSERT ALL
    INTO PRODUCT VALUES(10414,2,'Ruler','12 inch stainless steel',3.79,2)
    INTO PRODUCT VALUES(70704,1,'Transparency','Quick dry ink jet',24.29,1)
    INTO PRODUCT VALUES(23494,1,'Overhead Bulb', 'High Intensity replacement bulb',12.00,1)
    INTO PRODUCT VALUES(12003,1,'Laser Pointer', 'General purpose laser pointer',29.99,2)
    INTO PRODUCT VALUES(69401,2,'Colored Pencils','Non toxic 12 pack',2.84,1)
    INTO PRODUCT VALUES(91249,3,'All-Purpose Cleaner','Use on all washable surfaces',4.29,2)
    INTO PRODUCT VALUES(28124,3,'Paper Hand Towels','320 sheets per roll',5.25,1)
    INTO PRODUCT VALUES(41143,4,'CD-R','700 mb with jewel case',1.09,1)
    INTO PRODUCT VALUES(44766,4,'3.5 inch disks','high density formatted box of 10',5.99,1)
    INTO PRODUCT VALUES(12164,4,'Monitor wipes','Non abrasive lint free',6.99,2)
    INTO PRODUCT VALUES(22256,4,'Dust Blaster','Ozone safe no CFCs',8.99,2)
    INTO PRODUCT VALUES(62003,2,'Clear Tape','1 inch wide 6 rolls',3.90,1)
    INTO PRODUCT VALUES(97004,1,'Overhead Projector','Portable with travel cover',759.97,1)
    INTO PRODUCT VALUES(50003,2,'Glue Stick','Odorless non toxic',1.99,2)
SELECT * FROM dual;
    
commit;

--3.1 SELECT STATEMENTS

--Select all the rows from the employee tables
SELECT * FROM EMPLOYEE;

--Select all the rows from the employees table where the Department is HR
--TRUE = 1 AND FALSE = 0. Instructions said to make the column an int not a boolean
SELECT * 
FROM EMPLOYEE e
WHERE e.MANAGER = 1;

--Select all the rows from the table where username is jsmith and department is HR
SELECT *
FROM EMPLOYEE e
WHERE e.name = 'jsmith' AND e.department = 'HR';

--Select all the rows from the employees table where manager is true or department is HR
SELECT  *
FROM EMPLOYEE e
WHERE e.manager = 1 OR e.Department = 'HR';

--3.2 ORDER BY

--Select name from product table and order by name in ascending order
SELECT P.NAME
FROM PRODUCT P
ORDER BY P.NAME ASC;

--Select name from the product table and order by name in descending order
SELECT P.NAME
FROM PRODUCT P
ORDER BY P.NAME DESC;

--Select all records from category table order by name
SELECT *
FROM CATEGORY
ORDER BY NAME;

--3.3 Insert into
    --insert a new row into the employees table
    --insert into a new row in the category table
    --insert three records into the supplier
INSERT ALL
    INTO EMPLOYEE VALUES(5,'ejchen','pass','Elliot C','IT',1)
    INTO CATEGORY VALUES(8,'Food',null)
    INTO SUPPLIER VALUES(3,'CHENS TECH SUPPLIES')
    INTO SUPPLIER VALUES(4,'Revature Software Store')
    INTO SUPPLIER VALUES(6,'MJ''s WHERE IS THE GOAT')
SELECT * FROM dual;

commit;

UPDATE PRODUCT
SET UNITCOST = 4.00
WHERE NAME = 'Ruler';

commit;

UPDATE CATEGORY
SET DESCRIPT = 'USED FOR AROUND THE HOUSE CLEANING'
WHERE CATID = 3;

UPDATE CATEGORY
SET DESCRIPT = 'USED FOR CLEANING YOUR COMPUTER SCREEN'
WHERE CATID = 4;

COMMIT;
     
--3.5 LIKE

--Select username from employees table where usernames is like "j"
SELECT E.USERNAME
FROM EMPLOYEE E
WHERE E.USERNAME LIKE '%j%';

--Select name from product table where name is like "O"
SELECT P.NAME
FROM PRODUCT P
WHERE P.NAME LIKE 'O%';

--3.6 BETWEEN

--Select name from products table where unitprice is between 3 and 10
SELECT P.NAME, P.UNITCOST
FROM PRODUCT P
WHERE P.UNITCOST BETWEEN 3 AND 10;

--Select name from product table where unit price is between 500 and 800
SELECT P.NAME, P.UNITCOST
FROM PRODUCT P
WHERE P.UNITCOST BETWEEN 500 AND 800;


--3.7 DELETE

--Delete a record from the category where the value is audio visual
--enabled on delete cascade to delete references
DELETE FROM CATEGORY C WHERE C.NAME = 'Audio Visual';
commit;
--Delete the three recrords you previously inserted into the supplier table
DELETE FROM SUPPLIER S WHERE S.SUPPID IN (4,3,6);
COMMIT;

--4.0 SQL FUNCTIONS

--create a function that returns the length of the string of the description of the laser pointer





















