/* Select all records from the Employee table */
SELECT * FROM Employee;

/*Select all records from the Employee table where last name is King*/
SELECT * FROM Employee WHERE LASTNAME='King';

/*Select all records from the Employee table where firstname is Andrew and REPORTSTO is Null*/
SELECT * FROM Employee WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;

/* --------------  ORDERBY --------------  */

/*Select all ablums in Album Table and and sort result set in descending order by title.*/
SELECT * FROM Album ORDER BY Title DESC;

/*Select first name from Customer and sort result set in ascending order by city*/
SELECT Firstname FROM Customer ORDER BY City ASC;

/* ----------- INSERT INTO --------------  */

/*Insert two new records into Genre Table*/
INSERT INTO Genre (GENREID, NAME) VALUES ( 29 ,'Techno');
INSERT INTO Genre (GENREID, NAME) VALUES ( 28 ,'Screamo');
SELECT * FROM Genre ORDER BY GenreID ASC;

/*Insert two new records into Employee Table*/
INSERT INTO Employee (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL ) VALUES ( 9, 'Kent' ,'Clark', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO Employee (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL ) VALUES ( 10, 'Banner' ,'Bruce', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
SELECT * FROM Employee;

/*Insert two new records into Customer Table */
INSERT INTO Customer (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID ) VALUES ( 60, 'Andrew' , 'Clark', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'andrewclark719@gmail.com', NULL); 
INSERT INTO Customer (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID ) VALUES ( 61, 'Matthew' , 'Clark', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'matthewclark0301@gmail.com', NULL); 
SELECT * FROM Customer;

/* ----------- UPDATE  --------------  */
/* Update Arron Mitchell in Customer table to Robert Walter */
UPDATE Customer SET Firstname='Robert', Lastname='Walter' WHERE CustomerID=32;
SELECT * FROM Customer;

/* Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"*/
UPDATE Artist Set Name='Creedence Clearwater Revival' WHERE Name='CCR'; 
SELECT * FROM Artist ORDER BY Name ASC;

/* ----------- LIKE  --------------  */
/* Select all invoice with a biling address like "T%" */
SELECT * FROM Invoice WHERE BillingAddress LIKE 'T%';



/* ----------- BETWEEN  --------------  */
/* Select all invoives that have a total betweek 15 and 20*/
SELECT * FROM Invoice WHERE Total BETWEEN 15 and 20;

/* Select all employees hired between 1st of June 2003 and 1st of March 2004*/
SELECT * FROM Employee WHERE Hiredate BETWEEN '01-JUN-93' and '01-MAR-04';

/* ----------- DELETE  --------------  */
/* Delete a record in Customer table where the name is Robert Walter*/
ALTER TABLE Invoice DROP CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM Customer WHERE (Firstname='Robert' and Lastname='Walter');

/* ----------- SQL Functions --------------  /*

 /* ----------- System Defined Functions  --------------  */
 /* Create a function that returns the current time. */
 -- 3.1 -- 
 create or replace function getCurrentTime
 return timestamp is
 Begin
    return CURRENT_TIMESTAMP;
 End;
 /
 SELECT getCurrentTime from dual;
 
 /* Create a function that returns the length of a mediatype from the media type table*/
 --3.1-- 
 create or replace function returnLengthMediaType
 (mediatype_id in number)
 return number is
    LengthOfName number;
 Begin
    SELECT LENGTH(Name) into LengthOfName From MediaType where MEDIATYPEID = mediatype_id;
    return LengthOfName;
 End;
 /
SELECT returnLengthMediaType(2) from dual; --SELECT ONE LENGTH

Select Length(Name) from Mediatype; --SELECT ALL LENGTHS

/* ----------- System Defined Functions  --------------  */
-- 3.2 -- 
-- Create a function that returns the average total of all invoices
create or replace function returnMaxInvoice
return number is 
    average number;
Begin
    SELECT AVG(TOTAL) into average FROM INVOICE;
    return average;
End;
/
SELECT returnMaxInvoice FROM dual;


-- Create a function that returns the most expensixe track

create or replace function MostExpensiveTrack
return number is 
    maxval number;
Begin
    SELECT MAX(UNITPRICE) into maxval FROM Track;
    return maxval;
End;
/
SELECT MostExpensiveTrack FROM dual;

/* ----------- System Defined Functions  --------------  */
-- 3.3 --
-- Create a function that returns the average price of invoiceline items in the invoiceline table

create or replace function AverageInvoiceline
return number is
    averageNumber number;
Begin
    SELECT AVG(UnitPrice) INTO averageNumber FROM INVOICELINE;
    return averageNumber;
End;
/
Select AverageInvoiceline from dual;

/* ----------- User Defined Table Functions  --------------  */
-- 3.4 --
-- Create a function that returns all employees who are born after 1968
/*
CREATE OR REPLACE TYPE E_ROW AS OBJECT(
    FNAME VARCHAR(50),
    LNAME VARCHAR(50),
    BDATE DATE);
CREATE OR REPLACE TYPE E_TABLE IS TABLE E_ROW;

CREATE OR REPLACE FUCNTION E_FUNC(E_ROWS IN NUMBER)
    RETURN E_TABLE 

BEGIN
    FOR i IN 1 .. E_ROWS LOOP
        E_ROW.FNAME := EMPLOYEE.FIRSTNAME
        E_ROW.LNAME := EMPLOYEE.LASTNAME
        E_ROW.BDATE := EMPLOYEE.BIRTHDATE 
    END LOOP;
    
    RETURN E_TABLE;
END;/
*/

create or replace function x
return sys_refcursor as 
y sys_refcursor;

begin open y for
select * from employee where employee.birthdate > '01-jan-1968';
return y;
end;
/
select x from dual;



DECLARE
    e_lastname employee.lastname%TYPE;
    e_firstname employee.firstname%TYPE;
    e_birthdate employee.birthdate%TYPE;
BEGIN 
    SELECT lastname INTO (e_lastname),
        firstname INTO (e_firstname),
        birthdate INTO (e_birthdate)
    FROM Employee;
    WHERE bithdate > '01-JAN-1968';
    
END;/


/* ----------- Stored Procedures  --------------  */
--4.1 Basic Stored Procedure
--Create a stored procedure that selects the first and last names of all the employees.

DECLARE 
    LNAME VARCHAR2(50);
    FNAME VARCHAR2(50);
    CURSOR 
        C1 IS
            SELECT LASTNAME, FIRSTNAME FROM EMPLOYEE;

BEGIN 
    OPEN C1;
    LOOP
        FETCH C1 INTO LNAME, FNAME;
        EXIT WHEN C1%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(LNAME);
    END LOOP;
END;
/

EXECUTE; 

/* ----------- Triggers  --------------  */
--6.0 

--6.1 After/For
-- create an after insert trigger on the employee table fired after a new report is inserted into the table.
create or replace trigger EmployeeInsertTrigger
    AFTER INSERT ON Employee
    FOR EACH ROW
    BEGIN
        PRINT 'Insert on Employee';
    END;

-- create an after update trigger on the album table that firs after a row is inserted in the table 
create or replace trigger AlbumUpdateTrigger
    AFTER UPDATE ON Album
    FOR EACH ROW
    BEGIN
        PRINT 'Update on Album';
    END;
    
-- create an after delete trigger on the customer table that fires after a row is deleted from the table.
create or replace trigger CustomerDeleteTrigger
    AFTER DELETE ON Customer
    FOR EACH ROW
    BEGIN
        PRINT 'Delete in Customer';
    END;
    
    







/* ----------- Joins  --------------  */
-- 7.1 INNER JOIN--
/* Create an inner join that joins customers and orders and specifies the name of th customer and invoiceid */
SELECT * FROM CUSTOMER INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID;

-- 7.2 OUTER JOIN--
/* Create an outer join that joins the customer and invoice table,
specifying the CustomerId, firstname,lastname, invoiceid, and total. */
SELECT FIRSTNAME,LASTNAME,INVOICEID,TOTAL FROM CUSTOMER FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID;

-- 7.3 RIGHT JOIN--
/*Create a right join that jois album and artist specifying artist name and title.*/
SELECT ARTIST.NAME,ALBUM.TITLE FROM ARTIST RIGHT JOIN ALBUM ON ARTIST.ARTISTID = ALBUM.ARTISTID;

-- 7.4 CROSS JOIN--
SELECT *  FROM ALBUM,ARTIST ORDER BY ARTIST.NAME ASC;

-- 7.5 SELF JOIN--
SELECT  EMPLOYEE.FIRSTNAME AS WORKER_FIRSTNAME, 
        EMPLOYEE.LASTNAME AS WORKER_LASTNAME, 
        SELF.FIRSTNAME AS SUPERVISOR_FIRSTNAME, 
        SELF.LASTNAME AS SUPERVISOR_LASTNAME FROM EMPLOYEE SELF JOIN EMPLOYEE ON EMPLOYEE.EMPLOYEEID=SELF.REPORTSTO;
        

/* ----------- INDEXES  --------------  */
-- 8.1 
--Create a clustered index on of table of your choice
CREATE CLUSTER emp
    (e_id NUMBER(1),
    SIZE 8);
    

/* ----------- ADMINISTRATION --------------  */
/* BACK UP FILE WAS CREATED, NOT SURE IF I CAN DO IT BY COMMAND...
   TRIED SEARCHING THE WEB BUT COULDN'T FIND ANY SYNTAX OF IDEOLODY.
   INSTEAD I SAVED A 2ND VERSION OF THIS HOMEWORK ASSIGNMENT WITH A 
   .BAK EXTENSION. SO I WAS ABLE TO OBTAIN A .BAK FILE.
   
/* ----------- PART II --------------  */


-- 1.1 
-- create a user and name it office supply
CREATE USER 'OFFICE_SUPPLY' IDENTIFIED BY '12345';
--CREATES A USER OFFICE_SUPPLY WITH PASSWORD 12345

-- DELETE A USER OFFICE_SUPPLY
DROP USER IF EXISTS 'OFFICE_SUPPLY';

--1.2


-- 2.0 CREATING TABLES AND RELATIONSHIPS

--2.1 Create a table named "Employees" with the following attributes and datatypes
    
    CREATE TABLE EMPLOYEES (
        EMPLOYEEID NUMBER NOT NULL,
        USERNAME VARCHAR(20) NOT NULL,
        PASSWORD VARCHAR(20) NOT NULL,
        NAME VARCHAR(25) NOT NULL,
        DEPARTMENT CHAR(2) NOT NULL,
        MANAGER NUMBER NOT NULL)
        CONSTRAINTS PK_EMP PRIMARY KEY (EMPLOYEEID);

-- 2.1  Create a table named "Employees" with the following attributes and datatypes
    CREATE TABLE ORDERS (
        ORDERID NUMBER NOT NULL,
        EMPLOYEEID NUMBER NOT NULL,
        ORDERDATE DATE NOT NULL,
        STATUS CHAR NOT NULL)
        CONSTRAINTS PK_OID PRIMARY KEY (ORDERID),
        CONSTRAINTS EMPLOYEEID FOREIGN KEY (EMPLOYEEID) 
            REFERENCES EMPLOYEE(EMPLOYEEID);
            
-- 2.1  Create a table named "ORDERITEM" with the following attributes and datatypes
    CREATE TABLE ORDERITEM(
        ORDERID NUMBER NOT NULL,
        PRODUCTID NUMBER NOT NULL,
        QUANTITY NUMBER NOT NULL)
        CONSTRAINTS O_PK PRIMARY KEY ORDERID,
        CONSTRAINTS O_FK FOREIGN KEY ORDERID
            REFERENCES ORDERS(ORDERID),
        CONSTRAINTS P_PF PRIMARY KEY PRODUCTID,
        CONSTRAINTS P_FK FOREIGN KEY PRODUCTID
            REFERENCES PRODUCT(PRODUCTID);

-- 2.1  Create a table named "CATEGORY" with the following attributes and datatypes
    CREATE TABLE CATEGORY(
        CATID NUMBER NOT NULL,
        NAME VARCHAR(80) NOT NULL,
        DESCRIPT VARCHAR(255) NOT NULL)
        CONSTRAINTS C_PK PRIMARY KEY CATID;
        
-- 2.1  Create a table named "PRODUCT" with the following attributes and datatypes
    CREATE TABLE PRODUCT(
        PRODUCTID NUMBER NOT NULL,
        CATID NUMBER NOT NULL,
        NAME VARCHAR(80) NULL
        DESCIPT VARCHAR(255) NULL,
        UNITCOST NUMBER NULL,
        SUPPID NUMBER NOT NULL)
        CONSTRAINTS P_PK PRIMARY KEY PRODUCTID,
        CONSTRAINTS P_FKC FOREIGN KEY CATID REFERENCES CATEGORY(CATID),
        CONSTRAINTS P_FKS FOREIGN KEY SUPPID REFERENCES SUPPLIER(SUPPID);
    
-- 2.1  Create a table named "SUPPLIER" with the following attributes and datatypes
    CREATE TABLE SUPPLIER(
        SUPPID NUMBER NOT NULL,
        NAME VARCHAR(80) NULL)
        CONSTRAINTS S_PK PRIMARY KEY SUPPID;
        
    
-- 2.2 CREATING RELATIONSHIPS
    -- CREATE A 1:N RELATIONSHIP BETWEEN EMPLOYEEID(PK) AND ORDERS(FK)
    ALTER TABLE EMPLOYEE
    ADD CONSTRAINT EMPLOYEEID 
    FOREIGN KEY REFERENCES ORDERS(EMPLOYEEID);

    -- CREATE A 1:N RELATIONSHIP BETWEEN ORDERS(PK) AND ORDERID(FK)\
    ALTER TABLE ORDER
    ADD CONSTRAINT ORDERID
    FOREIGN KEY REFERENCES ORDERID(ORDERID);

    -- CREATE A 1:N RELATIONSHIP BETWEEN PRODUCT(PK) AND ORDERITEM(FK)
    ALTER TABLE PRODUCT
    ADD CONSTRAINT PRODUCTID
    FOREIGN KEY REFERENCES ORDERITEM(PRODUCTID);
    
    -- CREATE A 1:N RELATIONSHIP BETWEEN SUPPLIER(PK) AND PRODUCT(FK)
    ALTER TABLE SUPPLIER
    ADD CONSTRAINT SUPPLIERID
    FOREIGN KEY REFERENCES PRODUCT(SUPPLIERID);
    
    -- CREATE A 1:N RELATIONSHIP BETWEEN CATEGORY(PK) AND PRODUCT(FK)
    ALTER TABLE CATEGORY
    ADD CONSTRAINT CATID
    FOREIGN KEY REFERENCES PRODUCT(CATID);
    
    
    -- 3.0 PERFORMING SQL QUERIES
    
    CREATE TABLE EMPLOYEES (
        EMPLOYEEID NUMBER NOT NULL,
        USERNAME VARCHAR(20) NOT NULL,
        PASSWORD VARCHAR(20) NOT NULL,
        NAME VARCHAR(25) NOT NULL,
        DEPARTMENT CHAR(2) NOT NULL,
        MANAGER NUMBER NOT NULL)
        CONSTRAINTS PK_EMP PRIMARY KEY (EMPLOYEEID);
        
            --TO CREATE TABLE FROM PRIOR QUESTION
            
        --POPULATING EMPLOYEES
        
        INSERT INTO EMPLOYEES (EMPLOYEEID, USERNAME, PASSWORD, DEPARTMENT, MANAGER)
        VALUES ( '1' , 'DCLARK' , 'DRC' , 'HR' , FALSE);
        INSERT INTO EMPLOYEES (EMPLOYEEID, USERNAME, PASSWORD, DEPARTMENT, MANAGER)
        VALUES ( '2' , 'JSMITH' , 'JS' , 'IT' , TRUE);
        INSERT INTO EMPLOYEES (EMPLOYEEID, USERNAME, PASSWORD, DEPARTMENT, MANAGER)
        VALUES ( '3' , 'MJONES' , 'MJ' , 'HR' , TRUE);
        INSERT INTO EMPLOYEES (EMPLOYEEID, USERNAME, PASSWORD, DEPARTMENT, MANAGER)
        VALUES ( '4' , 'KLINK' , 'KL' , 'IT' , FALSE);
        INSERT INTO EMPLOYEES (EMPLOYEEID, USERNAME, PASSWORD, DEPARTMENT, MANAGER)
        VALUES ( 'NULL' , 'NULL' , 'NULL' , 'NULL' , NULL);

        --POPULATING PRODUCT 
        INSERT INTO PRODUCT (PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
        VALUES ('ACM-10414','2','RULER','12 INCH STAINLESS STEEL', '3.79' , '2');
        
        INSERT INTO PRODUCT (PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
        VALUES ('APO-CG7070','1','TRANSPARENCY','QUICK DRY INK JET', '24.49' , '1');
        
        INSERT INTO PRODUCT (PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
        VALUES ('APO-FXL','1','OVERHEAD BULB','HIGH INTENSITY REPLACEMENT BULB', '12.00' , '1');
        
        INSERT INTO PRODUCT (PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
        VALUES ('APO-MP1200','1','LASER POINTER','GENERAL PURPOSE LASER POINTER', '29.99' , '2');
        
        INSERT INTO PRODUCT (PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
        VALUES ('BIN-68401','2','COLORED PENCILS','NON TOXIC 12 PACK', '2.84' , '1');
        
        INSERT INTO PRODUCT (PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
        VALUES ('DRA-91249','3','ALL-PURPOSE CLEANER','USE ON ALL WASHABLE SURFACES', '4.29' , '2');
        
        INSERT INTO PRODUCT (PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
        VALUES ('FOH-28124','3','PAPER HAND TOWELS','320 SHEETS PER ROLL', '5.25' , '1');
        
        INSERT INTO PRODUCT (PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
        VALUES ('IMN-41143','4','CD-R','700 MB WITH JEWEL CASE', '1.09' , '1');
        
        INSERT INTO PRODUCT (PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
        VALUES ('IMN-44766','4','3.5 INCH DISKS','HIGH DENSITY FORMATTED BOX OF 10', '5.99' , '1');
        
        INSERT INTO PRODUCT (PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
        VALUES ('KMW-12164','4','MONITOR WIPES','NON ABRASIVE LINT FREE', '6.99' , '2');
        
        INSERT INTO PRODUCT (PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
        VALUES ('KMW-22256','4','DUST BLASTER','OZONE SAFE NO CFCS', '8.99' , '2');
        
        INSERT INTO PRODUCT (PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
        VALUES ('MMM-6200','2','CLEAR TAPE','1 INCH WIDE 6 ROLLS', '3.90' , '1');
        
        INSERT INTO PRODUCT (PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
        VALUES ('MMM-9700P','1','OVERHEAD PROJECTOR','PORTABLE WITH TRAVEL COVER', '759.97' , '1');
        
        INSERT INTO PRODUCT (PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
        VALUES ('OIC-5000','2','GLUE STICK','ODERLESS NON TOXIC', '1.99' , '2');
        
        --POPULATING SUPPLIER
        INSERT INTO SUPPLER (SUPPID, NAME)
        VALUES ('1', 'XYZ OFFICE SUPPLIES');
        
        INSERT INTO SUPPLIER (SUPPID, NAME)
        VALUES ('2', 'ABC OFFICE PRODUCTS');
        
        --POPULATING CATEGORY
        INSERT INTO CATEGORY (CATID, NAME, DESCRIPT)
        VALUES ('1' , 'AUDIO VISUAL');
        
        INSERT INTO CATEGORY (CATID, NAME, DESCRIPT)
        VALUES ('2' , 'ART SUPPLIES');
        
        INSERT INTO CATEGORY (CATID, NAME, DESCRIPT)
        VALUES ('3' , 'CLEANING SUPPLIES');
        
        INSERT INTO CATEGORY (CATID, NAME, DESCRIPT)
        VALUES ('4' , 'COMPUTER SUPPLIES');

        INSERT INTO CATEGORY (CATID, NAME, DESCRIPT)
        VALUES ('5' , 'DESK ACCESORIES');

        INSERT INTO CATEGORY (CATID, NAME, DESCRIPT)
        VALUES ('6' , 'WRITING SUPPLIES');

        INSERT INTO CATEGORY (CATID, NAME, DESCRIPT)
        VALUES ('7' , 'PRINTER SUPPLIES');

-- 3. 1 SELECT
    -- SELECT ALL THE ROWS FROM THE EMPLOYEES TABLE
    SELECT * FROM EMPLOYEES;
    
    -- SELECT ALL THE ROWS FROM THE EMPLOYEES TABLE WHERE DEPARTMENT IS HR
    SELECT * FROM EMPLOYEES WHERE DEPARTMENT='HR';
    
    -- SELECT ALL THE ROWS FROM EMPLOYEES TABLE WHERE USERNAME IS JSMITH AND DEPARTMENT IS HR
    SELECT * FROM EMPLOYEES WHERE USERNAME='JSMITH' AND DEPARTMENT='HR';
    
    -- SELECT ALL THE ROWS FROM THE EMPLOYEES TABE WHERE MANAGER IS TRUE OR DEPARTMENT HR
    SELECT * FROM EMPLOYEES WHERE MANAGER=TRUE AND DEPARTMENT='HR';

-- 3.2 ORDER BY 
    -- SELECT NAME FROM PRODUCT TABLE AND ORDER BY NAME IN ASCENDING ORDER
    SELECT NAME FROM PRODUCT ORDER BY NAME ASC;
    
    -- SELECT NAME FROM PRODUCT TABLE AND OWNER BY NAME IN DESCENDING ORDER
    SELECT NAME FROM PRODUCT ORDER BY NAME DESC;
    
    -- SELECT ALL RECORDS FROM CATEGORY TABEL ORDER BY NAME 
    SELECT * FROM CATEGORY ORDER BY NAME;
    
-- 3.3 INSERT INTO
    -- INSERT A NEW ROW INTO THE EMPOYEES TABEL
    INSERT INTO EMPLOYEE (EMPLOYEEID, USERNAME, PASSWORD, DEPARTMENT, MANAGER)
         VALUES ( '5' , 'ACLARK' , 'AJC' , 'SD' , TRUE);
    -- INSERT A NEW ROW INTO THE CATEGORY TABEL
    INSERT INTO CATEGORY ( CATID, NAME, DESCRIPT)
        VALUES ( '8', 'SKATEBOARD SUPPLIES' , 'NULL');
    -- INSERT THREE RECORDS INTO THE SUPPLIER TABLE
    INSERT INTO SUPPLIER (SUPPID, NAME)
        VALUES ( '3', 'HOMEDEPOT');
    INSERT INTO SUPPLIER (SUPPID, NAME)
        VALUES ( '4', 'LOWES');
    INSERT INTO SUPPLIER (SUPPID, NAME)
        VALUES ( '5', 'COSTCO');
        
--3.4 UPDATE
    --UPDATE UNIT COST IN PRODUCTS TABLE WHERE NAME IS RULER
    UPDATE Customer SET Firstname='Robert', Lastname='Walter' WHERE CustomerID=32;
    
    UPDATE PRODUCT SET UNITCOST='2.79' WHERE NAME='RULER';
    --UPDATE THE DESCRIPTION OF COMPUTER AND CLEANING SUPPLIERS IN THE CATEGORY TABLE
    UPDATE CATEGORY SET DESCRIPT='BULK WINDEX' WHERE NAME='CLEANING SUPPLIES';
    UPDATE CATEGORY SET DESCRIPT='NEW KEYBOARDS' WHERE NAME='COMPUTER SUPPLIES';

--3.5 LIKE
    
    -- SELECT USERNAME FROM EMPLOYE WHERE USERNAME IS LIKE 'J'
    SELECT USERNAME FROM EMPLOYEE WHERE USERNAME LIKE 'J';
    
    -- SELECT NAME FROM PRODUCT TABLE WHERE NAME IS LIKE 'O'
    SELECT NAME FROM PRODUCT WHERE NAME IS LIKE 'O';
    
-- 3.6 BETWEEN 
    --SELECT NAME FROM PRODUCTS TABLE WHERE UNITPRICES IS BETWEEN 3 AND 10
    SELECT NAME FROM PRODUCTS WHERE UNITPRICE BETWEEN 3 AND 10;

    --SELECT NAME FROM PRODUCTS TABLE WHERE UNITPRICE IS BETWEEN 500 AND 800
    SELECT NAME FROM PRODUCTS WHERE UNITPRICE IS BETWEEN 500 AND 800;
    
-- 3.7 DELETE
    --DELETE A RECORD FROM THE CATEGORY WHERE THE VALUE IS AUDIO VISUAL
    DELETE FROM CATEGORY WHERE NAME='VISUAL STUDIO';
    
    --DELETE THE THREE RECORDS YOU PREVIOUSLY INSERTED INTO THE SUPPLIER TABLE
    
    --DELETE FROM SUPPLIER WHERE SUPPID>'3';
    DELETE FROM SUPPLIER WHERE SUPPID=3;
    DELETE FROM SUPPLIER WHERE SUPPID=3;
    DELETE FROM SUPPLIER WHERE SUPPID=3;


/* --------------- FUNCTION ------------------ */

-- 4.1 create a function that returns the length of the string of the description of the laser pointer

CREATE OR REPLACE FUNCTION D_LEN(P_NAME IN VARCHAR2)
    RETURN NUMBER AS
    S_LENGTH NUMBER();
    BEGIN
        SELECT LENGTH(DESCRIPT) INTO S_LENGTH FROM PRODUCT WHERE NAME = 'LASER POINTER';
        RETURN S_LENGTH;
    END;
/
SELECT D_LEN FROM DUAL;
-- 4.1 CREATE A FUNCTION THAT CONVERTS A USERNAME IN THE EMPLOYEES TABLE TO UPPER CASE

CREATE OR REPLACE FUNCTION TO_U_CASE(STR IN VARCHAR2)
    RETURN VARCHAR2 AS
    UCASE VARCHAR2(255);
    BEGIN
        SELECT UPPER(STR) INTO UCASE FROM DUAL;
        RETURN UCASE;
    END;
/

SELECT TO_U_CASE(E.USERNAME) FROM EMPLOYEES E;

