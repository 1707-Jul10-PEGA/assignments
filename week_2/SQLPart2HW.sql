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

--4.1 System defined scalar functions
--create a function that returns the length of the string of the description of the laser pointer
CREATE OR REPLACE FUNCTION DESC_LEN(P_NAME IN VARCHAR2)
    RETURN NUMBER AS
    STR_LENGTH NUMBER(10,0);
    BEGIN
        SELECT LENGTH(DESCRIPT) INTO STR_LENGTH FROM PRODUCT WHERE NAME = P_NAME;
        RETURN STR_LENGTH;
    END;
/
--LASER POINTER WAS DELETED IN ONE OF THE PREVIOUS TASK
SELECT DESC_LEN('Ruler') from dual;

--Create a function that converts a username in the employees table to uppercase
CREATE OR REPLACE FUNCTION TO_UPPER_CASE(STR IN VARCHAR2)
    RETURN VARCHAR2 AS
    UPPERCASE VARCHAR2(255);
    BEGIN
    SELECT UPPER(STR) INTO UPPERCASE FROM DUAL;
    RETURN UPPERCASE;
    END;
/

SELECT TO_UPPER_CASE(E.USERNAME) FROM EMPLOYEE E;


--4.2 System defined aggregate functions

--Create a function that gets the sum of the unit price column from the product table
CREATE OR REPLACE FUNCTION TOTAL_PRICE
    RETURN NUMBER AS
    P_TOTAL NUMBER(10,2);
    BEGIN
        SELECT SUM(UNITCOST) INTO P_TOTAL FROM PRODUCT;
        RETURN P_TOTAL;
    END;
/

SELECT TOTAL_PRICE FROM DUAL;

--Create a function that gets the count of all the proucts
CREATE OR REPLACE FUNCTION GET_INVENTORY
    RETURN NUMBER AS
    INVENTORY NUMBER;
    BEGIN
        SELECT COUNT(*) INTO INVENTORY FROM PRODUCT;
        RETURN INVENTORY;
    END;
    /

SELECT GET_INVENTORY FROM DUAL;

--4.3 User defined scalar functions
--create a function that takes two inputs and calculates the cost of the two prduct
CREATE OR REPLACE FUNCTION TOTAL_COST(P1_COST IN NUMBER, P2_COST IN NUMBER)
    RETURN NUMEBR AS
    T_COST NUMBER(10,2);
    BEGIN
        SELECT P1_COST+P2_COST INTO T_COST FROM dual;
        RETURN T_COST;
    END;
/
    
SELECT (P1.UNITCOST+P2.UNITCOST) FROM PRODUCT P1, PRODUCT P2 WHERE P1.PRODUCTID = 10414 AND P2.PRODUCTID = 91249;    

SELECT 8+8 FROM DUAL;

--4.4 User defined table value functions
--Create a function that returns whether or not a username belongs to a manager

--5.0 Stored Procedures
--create a store procedure that returns all the employees with the username, dept, and manager columns from the employee table
CREATE OR REPLACE PROCEDURE PRINT_ALL_EMPLOYEES
(
    E_ROW OUT SYS_REFCURSOR
)AS
BEGIN
    OPEN E_ROW FOR SELECT E.NAME, E.DEPARTMENT, E.MANAGER FROM EMPLOYEE E;
END;
/

--Create a stored procedure  that returns all the products  with the name and unit price column
CREATE OR REPLACE PROCEDURE PODUCT_NAME_PRICE
(
    RESULTS OUT SYS_REFCURSOR 
)AS
BEGIN
    OPEN RESULTS FOR 
    SELECT P.NAME, P.UNITCOST 
    FROM PRODUCT P;
END;
/

--5.2 Stored Procedures with Input Procedures  

--create a stored procedure that takes in a productID and gets the name and description of that product id
CREATE OR REPLACE  PROCEDURE RETURN_ITEM
(
    P_ID NUMBER,
    RESULTS OUT SYS_REFCURSOR
)AS
BEGIN
    OPEN RESULTS FOR
     SELECT P.NAME, P.UNITCOST
      FROM PRODUCT P
        WHERE P.PRODUCTID = P_ID;
END;
/

--Create a procedure that inserts a new manager into the employees table
CREATE OR REPLACE PROCEDURE NEW_MANAGER
(
    E_ID NUMBER,
    UNAME VARCHAR2,
    PASS VARCHAR2,
    NAME VARCHAR2,
    DEPT VARCHAR2
)AS
BEGIN
    INSERT INTO EMPLOYEE VALUES(E_ID,UNAME,PASS,NAME,DEPT,1);
END;
/

--5.3 Stored Procedure Output Parameters

--Create a stored procedure that calculates the value of the unit cost column in the products table and returns the total amount
CREATE OR REPLACE PROCEDURE TOTAL_COST_PROC
(
    TOTAL OUT NUMBER
)AS
BEGIN
    SELECT SUM(UNITCOST) INTO TOTAL
    FROM PRODUCT;
END;
/

--create a procedure that would return username and password based on employeeid
CREATE OR REPLACE PROCEDURE USERINFO
(
    E_ID NUMBER,
    ACCOUNT_INFO OUT SYS_REFCURSOR
)AS
BEGIN
    OPEN ACCOUNT_INFO FOR
    SELECT E.USERNAME AS USERNAME, E.PASSWORD AS PASSWORD
    FROM EMPLOYEE E
    WHERE E.EMPLOYEEID = E_ID;
END;
/

CREATE OR REPLACE PROCEDURE NEW_MANAGER
(
    E_ID NUMBER,
    UNAME VARCHAR2,
    PASS VARCHAR2,
    NAME VARCHAR2,
    DEPT VARCHAR2,
    MANAGER NUMBER --1 FOR TRUE,, 0 FOR FALSE
)AS
BEGIN
    INSERT INTO EMPLOYEE VALUES(E_ID,UNAME,PASS,NAME,DEPT,MANAGER);
END;
/

--6.0 Transactions

--Create a transaction that is nested inside a store procedure that inserts a new into the employee table
CREATE OR REPLACE PROCEDURE NEW_EMPLOYEE
(
    E_ID NUMBER,
    UNAME VARCHAR2,
    PASS VARCHAR2,
    NAME VARCHAR2,
    DEPT VARCHAR2,
    MANAGER NUMBER --1 FOR TRUE,, 0 FOR FALSE
)AS
BEGIN
    INSERT INTO EMPLOYEE VALUES(E_ID,UNAME,PASS,NAME,DEPT,MANAGER);
END;
/

--Create a transaction that is nested inside a stored procedure that updates the unitprice of a product in the products table
CREATE OR REPLACE PROCEDURE UPDATE_PRODUCT
(
    P_ID IN NUMBER,
    NEWCOST IN NUMBER
)AS
BEGIN
    UPDATE PRODUCT P
    SET P.UNITCOST = NEWCOST
    WHERE P.PRODUCTID = P_ID;
END;
/

BEGIN
    UPDATE_PRODUCT(10414,5);
END;
/

--Create a multi-statement transaction nested in a stored procedure that updates at least two products name and description
CREATE OR REPLACE PROCEDURE UPDATE_TWO_ITEMS
(
    P_ID1 IN NUMBER,
    P_ID2 IN NUMBER,
    NEWNAME1 IN VARCHAR2,
    NEWNAME2 IN VARCHAR2,
    NEWDESCRIPT1 IN VARCHAR2,
    NEWDESCRIPT2 IN VARCHAR2
)AS
BEGIN
    UPDATE PRODUCT
    SET NAME = NEWNAME1, DESCRIPT = NEWDESCRIPT1
    WHERE PRODUCTID = P_ID1;
    
    UPDATE PRODUCT
    SET NAME = NEWNAME2, DESCRIPT = NEWDESCRIPT2
    WHERE PRODUCTID = P_ID2;
END;
/

--7.0 TRIGGERS
--7.1 AFTER/FOR TRIGGERS

--Create a after insert trigger on the categories table fired after a new record is inserted into the table
CREATE OR REPLACE TRIGGER AFTER_CAT_INSERT
    AFTER INSERT ON CATEGORY
    FOR EACH ROW
    BEGIN
        DBMS_OUTPUT.PUT_LINE('NEW CATEGORY: ' || :NEW.NAME);
    END;
    /
    
--Create a after update trigger on the categories table fires after a row is updated in the table
CREATE OR REPLACE TRIGGER AFTER_CAT_UPDATE
    AFTER UPDATE ON CATEGORY
    FOR EACH ROW
    BEGIN
        DBMS_OUTPUT.PUT_LINE('NEW DESCRIPTION: ' || :NEW.DESCRIPT);
        DBMS_OUTPUT.PUT_LINE('NEW CATEGORY: ' || :NEW.NAME);
    END;
    /
    
 --Create an after delete trigger on the categories table that fires after a row is deleted
 CREATE OR REPLACE TRIGGER AFTER_CAT_DELETE
    AFTER DELETE ON CATEGORY
    FOR EACH ROW
    BEGIN
        DBMS_OUTPUT.PUT_LINE('DELETED A ROW IN CATEGORY');
    END;
    /
    
--7.2INSTEAD OF TRIGGERS


--8.1 INNER JOINS

--perform an inner join on tables products and categories
SELECT * 
FROM PRODUCT P
INNER JOIN CATEGORY C ON P.CATID = C.CATID;

--perform an inner join on tables employees and orders
SELECT *
FROM EMPLOYEE E
INNER JOIN ORDERS O ON E.EMPLOYEEID = O.EMPLOYEEID;

--8.2 OUTER JOIN

--Perform an outer join on tables products and orderitems
SELECT *
FROM PRODUCT P
FULL OUTER JOIN ORDERITEM O ON P.PRODUCTID = P.PRODUCTID;

--Perform an outer join on employee and order
SELECT *
FROM EMPLOYEE E
FULL OUTER JOIN ORDERS O ON E.EMPLOYEEID = O.EMPLOYEEID;

--8.3 RIGHT JOIN

--Perform a right join on tables orders and orderitems
SELECT * 
FROM ORDERITEM OI
RIGHT JOIN ORDERS O ON OI.ORDERID = O.ORDERID;

--Perform a right join on tables products and orderitems
SELECT *
FROM ORDERITEM O
RIGHT JOIN PRODUCT P ON P.PRODUCTID = O.PRODUCTID;

--8.4 LEFT JOIN

--Perform a left join on tables product and categories
SELECT *
FROM CATEGORY C
LEFT JOIN PRODUCT P ON P.CATID = C.CATID;

--Perform a left join on employees and orders
SELECT *
FROM EMPLOYEE E
LEFT JOIN ORDERS O ON E.EMPLOYEEID = O.EMPLOYEEID;


--8.5 CROSS JOINS
--Perform a cross join on tables products and category
SELECT *
FROM PRODUCT, CATEGORY
ORDER BY PRODUCTID ASC;

--8.6 SELF JOIN

--Perform a self join on employees
SELECT E1.NAME AS EMPLOYEE, E2.NAME AS MANAGER
FROM EMPLOYEE E1, EMPLOYEE E2
WHERE E1.DEPARTMENT = E2.DEPARTMENT AND E2.MANAGER = 1 AND E1.NAME <> E2.NAME AND E1.MANAGER <> E2.MANAGER;

--9.0 VIEWS

--create two new columns named SSN and salary on the employees table. Create a view that displays all columns except SSN and salary
ALTER TABLE EMPLOYEE
ADD SSN VARCHAR2(11);

ALTER TABLE EMPLOYEE
ADD SALARY NUMBER(10,2);

CREATE VIEW EMP_INFO AS
SELECT E.EMPLOYEEID AS ID, E.USERNAME AS USERNAME, E.PASSWORD, E.NAME, E.DEPARTMENT, E.MANAGER
FROM EMPLOYEE E;

SELECT * FROM EMP_INFO;

--Create a view on the products table that only displays the name of the product and the description
CREATE VIEW ITEMS_NAME_DESCRIPT AS
SELECT P.NAME, P.DESCRIPT
FROM PRODUCT P;

SELECT * FROM ITEMS_NAME_DESCRIPT;

--10.0 INDEXES

--Create cluster index on a table of your choice
--Nick said we could do a regular index instead

CREATE INDEX ON PRODUCT
