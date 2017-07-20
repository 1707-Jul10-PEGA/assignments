-- Carson Stephens
SET SERVEROUTPUT ON SIZE 1000000
-- Part I - Working with an existing database

-- 1.0 Setting up Oracle Chinook
-- Open the Chinook_Oracle.sql file and execute the scripts within.

-- 2.0 SQL Queries

-- 2.1 SELECT
-- Select all records from the employee table.
SELECT * FROM CHINOOK.EMPLOYEE;
-- Select all records from the Employee table where last name is King.
SELECT * FROM CHINOOK.EMPLOYEE WHERE LASTNAME = 'King';
-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
SELECT * FROM CHINOOK.EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

-- 2.2 ORDER BY
-- Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM CHINOOK.ALBUM ORDER BY TITLE DESC;
-- Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CHINOOK.CUSTOMER ORDER BY CITY ASC;

-- 2.3 INSERT INTO
-- Insert two new records into Genre table
INSERT INTO CHINOOK.GENRE (GENREID, NAME) VALUES (26, 'Progressive Rock');
INSERT INTO CHINOOK.GENRE (GENREID, NAME) VALUES (27, 'Classic Rock');
-- Insert two new records into Employee table
INSERT INTO CHINOOK.EMPLOYEE (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Stephens', 'Carson', 'IT Staff', 6, TO_DATE('1995-4-26 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '10926 Northstar Way SW', 'Lakewood', 'WA', 'America', '98498', '+1 (253) 777-7215', '+1 (403) 467-8773', 'carsons@chinookcorp.com');
INSERT INTO CHINOOK.EMPLOYEE (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Stephens', 'Cole', 'IT Staff', 6, TO_DATE('1993-3-24 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '10927 Northstar Way SW', 'Lakewood', 'WA', 'America', '98498', '+1 (253) 777-7216', '+1 (403) 467-8774', 'coless@chinookcorp.com');
-- Insert two new records into Customer table
INSERT INTO CHINOOK.CUSTOMER (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (60, 'Stephens', 'Carson', 'Revature, LLC', '10926 Northstar Way SW', 'Lakewood', 'WA', 'America', '98498', '+1 (253) 777-7215', '+1 (403) 467-8773', 'carsons@chinookcorp.com', 3);
INSERT INTO CHINOOK.CUSTOMER (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (61, 'Stephens', 'Cole', 'Revature, LLC', '10927 Northstar Way SW', 'Lakewood', 'WA', 'America', '98498', '+1 (253) 777-7216', '+1 (403) 467-8774', 'coles@chinookcorp.com', 3);

-- 2.4 UPDATE
-- Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CHINOOK.CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
-- Update name of artist in the Arist table "Creedence Clearwater Revival" to "CCR"
UPDATE CHINOOK.ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- Select all invoices with a billing address like "T%"
SELECT * FROM CHINOOK.INVOICE WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN
-- Select all invoices that have a total between 15 and 50
SELECT * FROM CHINOOK.INVOICE WHERE TOTAL BETWEEN 15 AND 50;
-- Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM CHINOOK.EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');

-- 2.7 DELETE
-- Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE CHINOOK.INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM CHINOOK.CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

-- 3.0 SQL Functions

-- 3.1 System Defined Functions
-- Create a function that returns the current time.
CREATE OR REPLACE FUNCTION CHINOOK.GETCURTIME
    RETURN VARCHAR2
        IS
            L_TIME    VARCHAR(10) := TO_CHAR( SYSDATE, 'HH24:MI:SS' );
        BEGIN
            RETURN L_TIME;
        END GETCURTIME;
/
SELECT CHINOOK.GETCURTIME FROM DUAL;

-- Create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION CHINOOK.GETMEDIATYPELENGTH(MTID INT)
    RETURN INT
        IS
            LN INT;
        BEGIN
            SELECT LENGTH(M.NAME) INTO LN FROM CHINOOK.MEDIATYPE M WHERE MTID = M.MEDIATYPEID;
            RETURN LN;
        END GETMEDIATYPELENGTH;
/
SELECT CHINOOK.GETMEDIATYPELENGTH(1) FROM DUAL;
-- 3.2 System Defined Aggregate Functions
-- Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION CHINOOK.INVOICEAVERAGE
    RETURN NUMBER
        IS
            AVERAGE NUMBER(10,2);
        BEGIN
            SELECT AVG(I.TOTAL) INTO AVERAGE FROM CHINOOK.INVOICE I;
            RETURN AVERAGE;
END INVOICEAVERAGE;
/
SELECT CHINOOK.INVOICEAVERAGE FROM DUAL;
-- Create a function that returns the most expensive track
DROP TYPE CHINOOK.T_TABLE_COLL;
DROP TYPE CHINOOK.T_TABLE;

CREATE OR REPLACE TYPE CHINOOK.T_TABLE IS OBJECT
(
    TrackId NUMBER,
    Name VARCHAR2(200),
    AlbumId NUMBER,
    MediaTypeId NUMBER,
    GenreId NUMBER,
    Composer VARCHAR2(220),
    Milliseconds NUMBER,
    Bytes NUMBER,
    UNITPRICE NUMBER(10,2)
);
/
CREATE OR REPLACE TYPE CHINOOK.T_TABLE_COLL IS TABLE OF CHINOOK.T_TABLE;
/
CREATE OR REPLACE FUNCTION CHINOOK.MOSTEXPENSIVETRACKS
RETURN CHINOOK.T_TABLE_COLL
IS
    L_RES_COLL CHINOOK.T_TABLE_COLL;
    L_INDEX NUMBER;
    L_MAX NUMBER;
BEGIN
    L_RES_COLL := CHINOOK.T_TABLE_COLL();
    SELECT MAX(UNITPRICE) INTO L_MAX FROM CHINOOK.TRACK;
    FOR I IN (SELECT TRACKID, NAME, ALBUMID, MEDIATYPEID, GENREID, COMPOSER, MILLISECONDS, BYTES, UNITPRICE FROM CHINOOK.TRACK)
    LOOP
        IF I.UNITPRICE = L_MAX THEN
        L_RES_COLL.EXTEND;
        L_INDEX := L_RES_COLL.COUNT;
        L_RES_COLL(L_INDEX) := T_TABLE(I.TRACKID, I.NAME, I.ALBUMID, I.MEDIATYPEID, I.GENREID, I.COMPOSER, I.MILLISECONDS, I.BYTES, I.UNITPRICE);
        END IF;
    END LOOP;
    RETURN L_RES_COLL;
END MOSTEXPENSIVETRACKS;
/
SELECT * FROM TABLE(CHINOOK.MOSTEXPENSIVETRACKS);

-- 3.3 User Defined Scalar Functions
-- Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION CHINOOK.INVOICELINEITEMAVERAGE
    RETURN NUMBER
        IS
            AVERAGE NUMBER(10,2);
        BEGIN
            SELECT AVG(I.UNITPRICE) INTO AVERAGE FROM CHINOOK.INVOICELINE I;
            RETURN AVERAGE;
END INVOICELINEITEMAVERAGE;
/
SELECT CHINOOK.INVOICELINEITEMAVERAGE FROM DUAL;

-- 3.4 User Defined Table Valued Functions
-- Create a function that returns all employees who are born after 1968.
DROP TYPE CHINOOK.E_TABLE_COLL;
DROP TYPE CHINOOK.E_TABLE;

CREATE OR REPLACE TYPE CHINOOK.E_TABLE IS OBJECT
(
    EmployeeId NUMBER,
    LastName VARCHAR2(20),
    FirstName VARCHAR2(20),
    Title VARCHAR2(30),
    ReportsTo NUMBER,
    BirthDate DATE,
    HireDate DATE,
    Address VARCHAR2(70),
    City VARCHAR2(40),
    State VARCHAR2(40),
    Country VARCHAR2(40),
    PostalCode VARCHAR2(10),
    Phone VARCHAR2(24),
    Fax VARCHAR2(24),
    Email VARCHAR2(60)
);
/
CREATE OR REPLACE TYPE CHINOOK.E_TABLE_COLL IS TABLE OF CHINOOK.E_TABLE;
/
CREATE OR REPLACE FUNCTION CHINOOK.EMPLOYEESAFTER1968
RETURN CHINOOK.E_TABLE_COLL
IS
    L_RES_COLL CHINOOK.E_TABLE_COLL;
    L_INDEX NUMBER;
BEGIN
    L_RES_COLL := CHINOOK.E_TABLE_COLL();
    FOR I IN (SELECT EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL FROM CHINOOK.EMPLOYEE)
    LOOP
        IF I.BIRTHDATE >  TO_DATE('1968-12-31 23:59:59','yyyy-mm-dd hh24:mi:ss') THEN
        L_RES_COLL.EXTEND;
        L_INDEX := L_RES_COLL.COUNT;
        L_RES_COLL(L_INDEX) := E_TABLE(I.EMPLOYEEID, I.LASTNAME, I.FIRSTNAME, I.TITLE, I.REPORTSTO, I.BIRTHDATE, I.HIREDATE, I.ADDRESS, I.CITY, I.STATE, I.COUNTRY, I.POSTALCODE, I.PHONE, I.FAX, I.EMAIL);
        END IF;
    END LOOP;
    RETURN L_RES_COLL;
END EMPLOYEESAFTER1968;
/
SELECT * FROM TABLE(CHINOOK.EMPLOYEESAFTER1968);

-- 4.0 Stored Procedures

-- 4.1 Basic Stored Procedure
-- Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE CHINOOK.EMPLOYEENAMEPROCEDURE (C_RESULT OUT SYS_REFCURSOR)
    AS
    BEGIN
        OPEN C_RESULT FOR SELECT FIRSTNAME, LASTNAME FROM CHINOOK.EMPLOYEE;
END EMPLOYEENAMEPROCEDURE;
/

-- 4.2 Stored Procedure Input Parameters
-- Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE CHINOOK.UPDATEEMPLOYEEPROCEDURE (P_EMPLOYEEID IN CHINOOK.EMPLOYEE.EMPLOYEEID%TYPE, P_FIRSTNAME IN CHINOOK.EMPLOYEE.FIRSTNAME%TYPE, P_LASTNAME IN CHINOOK.EMPLOYEE.LASTNAME%TYPE, P_ADDRESS IN CHINOOK.EMPLOYEE.ADDRESS%TYPE, P_CITY IN CHINOOK.EMPLOYEE.CITY%TYPE, P_STATE IN CHINOOK.EMPLOYEE.STATE%TYPE, P_COUNTRY IN CHINOOK.EMPLOYEE.COUNTRY%TYPE, P_POSTALCODE IN CHINOOK.EMPLOYEE.POSTALCODE%TYPE, P_PHONE IN CHINOOK.EMPLOYEE.PHONE%TYPE, P_FAX IN CHINOOK.EMPLOYEE.FAX%TYPE, P_EMAIL IN CHINOOK.EMPLOYEE.EMAIL%TYPE)
    AS
    BEGIN
        UPDATE CHINOOK.EMPLOYEE
            SET
                FIRSTNAME = P_FIRSTNAME,
                LASTNAME = P_LASTNAME,
                ADDRESS = P_ADDRESS,
                CITY = P_CITY,
                STATE = P_STATE,
                COUNTRY = P_COUNTRY,
                POSTALCODE = P_POSTALCODE,
                PHONE = P_PHONE,
                FAX = P_FAX,
                EMAIL = P_EMAIL
            WHERE EMPLOYEEID = P_EMPLOYEEID;
END UPDATEEMPLOYEEPROCEDURE;
/
-- Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE CHINOOK.MANAGERPROCEDURE (P_EMPLOYEEID IN CHINOOK.EMPLOYEE.EMPLOYEEID%TYPE, C_RESULT OUT SYS_REFCURSOR)
    AS
    BEGIN
        OPEN C_RESULT FOR SELECT M.* FROM CHINOOK.EMPLOYEE M WHERE M.EMPLOYEEID = (SELECT E.REPORTSTO FROM CHINOOK.EMPLOYEE E WHERE E.EMPLOYEEID = P_EMPLOYEEID);
END MANAGERPROCEDURE;
/

-- 4.3 Stored Procedure Output Parameters
-- Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE CHINOOK.CUSTOMERPROCEDURE (P_CUSTOMERID IN CHINOOK.CUSTOMER.CUSTOMERID%TYPE, P_FIRSTNAME OUT CHINOOK.CUSTOMER.FIRSTNAME%TYPE, P_LASTNAME OUT CHINOOK.CUSTOMER.LASTNAME%TYPE, P_COMPANY OUT CHINOOK.CUSTOMER.COMPANY%TYPE)
    AS
    BEGIN
        SELECT FIRSTNAME, LASTNAME, COMPANY INTO P_FIRSTNAME, P_LASTNAME, P_COMPANY FROM CHINOOK.CUSTOMER WHERE CUSTOMERID = P_CUSTOMERID;
END CUSTOMERPROCEDURE;
/

-- 5.0 Transactions
-- Create a transaction that given an invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE CHINOOK.DELETEINVOICEPROCEDURE (P_INVOICEID IN CHINOOK.INVOICE.INVOICEID%TYPE)
    AS
    BEGIN
        DELETE FROM CHINOOK.INVOICE WHERE INVOICEID = P_INVOICEID;
END DELETEINVOICEPROCEDURE;
/
-- Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE CHINOOK.INSERTCUSTOMERPROCEDURE (P_CustomerId IN CHINOOK.CUSTOMER.CUSTOMERID%TYPE, P_FirstName IN CHINOOK.CUSTOMER.FIRSTNAME%TYPE, P_LastName IN CHINOOK.CUSTOMER.LASTNAME%TYPE, P_Company IN CHINOOK.CUSTOMER.COMPANY%TYPE, P_Address IN CHINOOK.CUSTOMER.ADDRESS%TYPE, P_City IN CHINOOK.CUSTOMER.CITY%TYPE, P_State IN CHINOOK.CUSTOMER.STATE%TYPE, P_Country IN CHINOOK.CUSTOMER.COUNTRY%TYPE, P_PostalCode IN CHINOOK.CUSTOMER.POSTALCODE%TYPE, P_Phone IN CHINOOK.CUSTOMER.PHONE%TYPE, P_Fax IN CHINOOK.CUSTOMER.FAX%TYPE, P_Email IN CHINOOK.CUSTOMER.EMAIL%TYPE, P_SupportRepId IN CHINOOK.CUSTOMER.SUPPORTREPID%TYPE)
    AS
    BEGIN
        INSERT INTO CHINOOK.CUSTOMER (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (P_CustomerId, P_FirstName, P_LastName, P_Company, P_Address, P_City, P_State, P_Country, P_PostalCode, P_Phone, P_Fax, P_Email, P_SupportRepId);
END INSERTCUSTOMERPROCEDURE;
/

-- 6.0 Triggers

-- 6.1 AFTER/FOR
-- Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER CHINOOK.AFTERINSERTEMPLOYEE
    AFTER INSERT
        ON CHINOOK.EMPLOYEE
        FOR EACH ROW
    DECLARE
        V_USERNAME VARCHAR2(10);
    BEGIN
        SELECT USER INTO V_USERNAME FROM DUAL;
        DBMS_OUTPUT.PUT('NEW EMPLOYEE ENTERED BY ' || V_USERNAME);
    END AFTERINSERTEMPLOYEE;
/
-- Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER CHINOOK.AFTERUPDATEALBUM
    AFTER UPDATE
        ON CHINOOK.ALBUM
        FOR EACH ROW
    DECLARE
        V_USERNAME VARCHAR2(10);
    BEGIN
        SELECT USER INTO V_USERNAME FROM DUAL;
        DBMS_OUTPUT.PUT('ALBUM UPDATED BY ' || V_USERNAME);
    END AFTERUPDATEALBUM;
/
-- Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER CHINOOK.AFTERDELETECUSTOMER
    AFTER DELETE
        ON CHINOOK.ALBUM
        FOR EACH ROW
    DECLARE
        V_USERNAME VARCHAR2(10);
    BEGIN
        SELECT USER INTO V_USERNAME FROM DUAL;
        DBMS_OUTPUT.PUT('ALBUM UPDATED BY ' || V_USERNAME);
    END AFTERUPDATEALBUM;
/

-- 6.2 INSTEAD OF
-- Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER CHINOOK.INSTEADOFDELETEINVOICE
    BEFORE DELETE ON CHINOOK.INVOICE
    FOR EACH ROW
    BEGIN
        IF (:OLD.TOTAL > 50.00) THEN
            RAISE_APPLICATION_ERROR(-20001, 'Record cannot be deleted');
        END IF;
    END INSTEADOFDELETEINVOICE;
/
-- 7.0 JOINS

-- 7.1 INNER
-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT C.FIRSTNAME, C.LASTNAME, I.INVOICEID FROM CHINOOK.CUSTOMER C INNER JOIN CHINOOK.INVOICE I ON C.CUSTOMERID = I.CUSTOMERID;

-- 7.2 OUTER
-- Create an outer join that joins customers and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, I.INVOICEID, I.TOTAL FROM CHINOOK.CUSTOMER C LEFT OUTER JOIN CHINOOK.INVOICE I ON C.CUSTOMERID = I.CUSTOMERID;

-- 7.3 RIGHT
-- Create a right join that joins album and artist specifying artist name and title.
SELECT AR.NAME, AL.TITLE FROM CHINOOK.ALBUM AL RIGHT JOIN CHINOOK.ARTIST AR ON AL.ARTISTID = AR.ARTISTID;

-- 7.4 CROSS
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT AR.NAME, AR.ARTISTID, AL.ALBUMID, AL.TITLE FROM CHINOOK.ALBUM AL CROSS JOIN CHINOOK.ARTIST AR WHERE AL.ARTISTID = AR.ARTISTID ORDER BY AR.NAME ASC;

-- 7.5 SELF
-- Perform a self-join on the employee table, joining on the reportsto column.
SELECT E1.*, E2.* FROM CHINOOK.EMPLOYEE E1, CHINOOK.EMPLOYEE E2 WHERE E1.REPORTSTO = E2.REPORTSTO;

-- 8.0 Indexes

-- 8.1 Clustered Indexes
-- Create a clustered index on of table of your choice
CREATE CLUSTER CUS_CLUST (CUSTOMERID NUMBER)
    SIZE 600
    TABLESPACE USERS
    STORAGE (INITIAL 200K
        NEXT 300K
        MINEXTENTS 2
        PCTINCREASE 33);
        
CREATE INDEX CUS_INDEX
    ON CLUSTER CUS_CLUST
    TABLESPACE USERS
    STORAGE (INITIAL 50K
        NEXT 50K
        MINEXTENTS 2
        MAXEXTENTS 10
        PCTINCREASE 33);

CREATE TABLE CUS
    CLUSTER CUS_CLUST (CUSTOMERID)
    AS SELECT * FROM CHINOOK.CUSTOMER;

-- 9.0 Administration
-- Create a .bak file for the Chinook database.


-- Part II - Creating and working with your own custom database

-- 1.0 Creating the OfficeSupply Database

-- 1.1 Create Company Database using SSMS Interface
-- Create a user and name it "OfficeSupply" in Oracle Web Console

-- Delete the OfficeSupply user


-- 1.2 Create Company Database using DDL
-- Create a user and name it "OfficeSupply" using DDL (SQL Script in SQL Developer)
DROP USER OfficeSupply CASCADE;


CREATE USER OfficeSupply
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to OfficeSupply;
GRANT resource to OfficeSupply;
GRANT create session TO OfficeSupply;
GRANT create table TO OfficeSupply;
GRANT create view TO OfficeSupply;



conn OfficeSupply/p4ssw0rd

-- 2.0 Creating Tables and Relationships

-- 2.1 Create Tables for OfficeSupply
-- Using the DDL, create a table named "Employees with following attributes and datatypes:
-- EmployeeID(PK number, not null), UserName(varchar(20), not null), Password(varchar(20), not null),
-- Name(varchar(25), not null), Department(char(2), not null), Manager(number, not null).
CREATE TABLE Employees
(
    EmployeeID NUMBER NOT NULL,
    UserName VARCHAR(20) NOT NULL,
    Password VARCHAR(20) NOT NULL,
    -- Name VARCHAR(25) NOT NULL,
    Department CHAR(2) NOT NULL,
    Manager NUMBER(1) NOT NULL,
    CONSTRAINT PK_Employees PRIMARY KEY  (EmployeeID)
);
/
-- Using the DDL, create a table named "Orders" with following attributes and datatypes:
-- OrderID(PK, number, not null), EmployeeID(FK, number, not null), OrderDate(date, not null),
-- Status(char, not null).
CREATE TABLE Orders
(
    OrderID NUMBER NOT NULL,
    EmployeeID NUMBER NOT NULL,
    OrderDate DATE NOT NULL,
    Status CHAR NOT NULL,
    CONSTRAINT PK_Orders PRIMARY KEY  (OrderID)
);
/
-- Using the DDL, create a table named "OrderItem" with the following attributes and datatypes:
-- OrderID(PK, FK, number, not null), ProductID(PK, FK, number, not null), Quantity(number, not null).
CREATE TABLE OrderItem
(
    OrderID NUMBER NOT NULL,
    ProductID VARCHAR(80) NOT NULL,
    Quantity NUMBER NOT NULL,
    CONSTRAINT PK_OrderItem PRIMARY KEY  (OrderID, ProductID)
);
/
-- Using the DDL, create a table named "Category" with the following attributes and datatypes:
-- CatID(PK, number, not null), Name(varchar(80), null), Descript(varchar(255), null)
CREATE TABLE Category
(
    CatID NUMBER NOT NULL,
    Name VARCHAR(80) NULL,
    Descript VARCHAR(255) NULL,
    CONSTRAINT PK_Category PRIMARY KEY  (CatID)
);
/
-- Using the DDL, create a table named "Product" with the following attributes and datatypes:
-- ProductID(PK, number, not null), CatID(FK, number, not null), Name(varchar(80), null),
-- Descript(varchar(255), null),
-- UnitCost(number, null), SuppID(FK, number, not null).
CREATE TABLE Product
(
    ProductID VARCHAR(80) NOT NULL,
    CatID NUMBER NOT NULL,
    Name VARCHAR(80) NULL,
    Descript VARCHAR(255) NULL,
    UnitCost NUMBER NULL,
    SuppID NUMBER NOT NULL,
    CONSTRAINT PK_Product PRIMARY KEY  (ProductID)
);
/
-- Using the DDL, create a table named "Supplier" with the following attributes and datatypes:
-- SuppID(PK, number, not null), Name(varchar(80), null).
CREATE TABLE Supplier
(
    SuppID NUMBER NOT NULL,
    Name VARCHAR(80) NULL,
    CONSTRAINT PK_Supplier PRIMARY KEY  (SuppID)
);
/

-- 2.2 Creating Relationships
-- Create a 1:N relationship between Employees(PK) and Orders(FK)
ALTER TABLE Orders ADD CONSTRAINT FK_OrdersEmployeeID
    FOREIGN KEY (EmployeeId) REFERENCES Employees (EmployeeID)  ;
-- Create a 1:N relationship between Orders(PK) and OrderItem(FK)
ALTER TABLE OrderItem ADD CONSTRAINT FK_OrderItemOrderID
    FOREIGN KEY (OrderID) REFERENCES Orders (OrderID)  ;
-- Create a 1:N relationship between Product(PK) and OrderItem(FK)
ALTER TABLE OrderItem ADD CONSTRAINT FK_OrderItemProductID
    FOREIGN KEY (ProductID) REFERENCES Product (ProductID)  ;
-- Create a 1:N relationship between Supplier(PK) and Product(FK)
ALTER TABLE Product ADD CONSTRAINT FK_ProductSuppID
    FOREIGN KEY (SuppID) REFERENCES Supplier (SuppID)  ;
-- Create a 1:N relationship between Category(PK) and Product(FK)
ALTER TABLE Product ADD CONSTRAINT FK_ProductCatID
    FOREIGN KEY (CatID) REFERENCES Category (CatID)  ;

-- 3.0 Performing SL Queries

INSERT INTO Employees (EmployeeID, UserName, Password, Department, Manager) VALUES (1, 'dclark', 'drc', 'HR', 1);
INSERT INTO Employees (EmployeeID, UserName, Password, Department, Manager) VALUES (2, 'jsmith', 'js', 'IT', 1);
INSERT INTO Employees (EmployeeID, UserName, Password, Department, Manager) VALUES (3, 'mjones', 'mj', 'HR', 1);
INSERT INTO Employees (EmployeeID, UserName, Password, Department, Manager) VALUES (4, 'klink', 'kl', 'IT', 0);

INSERT INTO Supplier (SuppID, Name) VALUES (1, 'XYZ Office Supplies');
INSERT INTO Supplier (SuppID, Name) VALUES (2, 'ABC Office Products');

INSERT INTO Category (CatID, Name) VALUES (1, 'Audio Visual');
INSERT INTO Category (CatID, Name) VALUES (2, 'Art Supplies');
INSERT INTO Category (CatID, Name) VALUES (3, 'Cleaning Supplies');
INSERT INTO Category (CatID, Name) VALUES (4, 'Computer Supplies');
INSERT INTO Category (CatID, Name) VALUES (5, 'Desk Accessories');
INSERT INTO Category (CatID, Name) VALUES (6, 'Writing Supplies');
INSERT INTO Category (CatID, Name) VALUES (7, 'Printer Supplies');

INSERT INTO Product (ProductID, CatID, Name, Descript, UnitCost, SuppID) VALUES ('ACM-10414', 2, 'Ruler', '12 inch stainless steel', 3.79, 2);
INSERT INTO Product (ProductID, CatID, Name, Descript, UnitCost, SuppID) VALUES ('APO-CG7070', 1, 'Transparency', 'Quick dry ink jet', 24.49, 1);
INSERT INTO Product (ProductID, CatID, Name, Descript, UnitCost, SuppID) VALUES ('APO-FXL', 1, 'Overhead Bulb', 'High intensity replacement bulb', 12.00, 1);
INSERT INTO Product (ProductID, CatID, Name, Descript, UnitCost, SuppID) VALUES ('APO-MP1200', 1, 'Laser Pointer', 'General purpose laser pointer', 29.99, 2);
INSERT INTO Product (ProductID, CatID, Name, Descript, UnitCost, SuppID) VALUES ('BIN-68401', 2, 'Colored Pencils', 'Non toxic 12 pack', 2.84, 1);
INSERT INTO Product (ProductID, CatID, Name, Descript, UnitCost, SuppID) VALUES ('DRA-91249', 3, 'All-Purpose Cleaner', 'Use on all washable surfaces', 4.29, 2);
INSERT INTO Product (ProductID, CatID, Name, Descript, UnitCost, SuppID) VALUES ('FOH-28124', 3, 'Paper Hand Towels', '320 sheets per roll', 5.25, 1);
INSERT INTO Product (ProductID, CatID, Name, Descript, UnitCost, SuppID) VALUES ('IMN-41143', 4, 'CD-R', '700 mb with jewel case', 1.09, 1);
INSERT INTO Product (ProductID, CatID, Name, Descript, UnitCost, SuppID) VALUES ('IMN-44766', 4, '3.5 inch Disks', 'High Density Formatted Box of 10', 5.99, 1);
INSERT INTO Product (ProductID, CatID, Name, Descript, UnitCost, SuppID) VALUES ('KMW-12164', 4, 'Monitor Wipes', 'Non abrasive lint free', 6.99, 2);
INSERT INTO Product (ProductID, CatID, Name, Descript, UnitCost, SuppID) VALUES ('KMW-22256', 4, 'Dust Blaster', 'Ozone safe no CFCs', 8.99, 2);
INSERT INTO Product (ProductID, CatID, Name, Descript, UnitCost, SuppID) VALUES ('MMM-6200', 2, 'Clear Tape', '1 inch wide 6 rolls', 3.90, 1);
INSERT INTO Product (ProductID, CatID, Name, Descript, UnitCost, SuppID) VALUES ('MMM-9700P', 1, 'Overhead Projector', 'Portable with travel cover', 759.97, 1);
INSERT INTO Product (ProductID, CatID, Name, Descript, UnitCost, SuppID) VALUES ('OIC-5000', 2, 'Glue Stick', 'Oderless non toxic', 1.99, 2);

-- 3.1 SELECT
-- Select all the rwos from the employees table
SELECT * FROM EMPLOYEES;
-- Select all the rows from the employee table where the Department is HR
SELECT * FROM EMPLOYEES WHERE DEPARTMENT = 'HR';
-- Select all the rows from the employees table where username is jsmith and department is HR
SELECT * FROM EMPLOYEES WHERE USERNAME = 'jsmith' AND DEPARTMENT = 'HR';
-- Select all the rows from the employees table where manager is true or department is HR
SELECT * FROM EMPLOYEES WHERE MANAGER = 1 OR DEPARTMENT = 'HR';

-- 3.2 ORDER BY
-- Select name from product table and order by name in ascending order
SELECT NAME FROM PRODUCT ORDER BY NAME ASC;
-- Select name from product table and order by name in descending order
SELECT NAME FROM PRODUCT ORDER BY NAME DESC;
-- Select all records from category table order by name.
SELECT * FROM CATEGORY ORDER BY NAME;

-- 3.3 INSERT INTO
-- Insert a new row into the employees table.
INSERT INTO Employees (EmployeeID, UserName, Password, Department, Manager) VALUES (5, 'cstephens', 'cs', 'IT', 0);
-- Insert into a new row into the category table
INSERT INTO Category (CatID, Name) VALUES (8, 'Hardware Supplies');
-- Insert three new records into the supplier table.
INSERT INTO Supplier (SuppID, Name) VALUES (3, 'DEF Office Stuff');
INSERT INTO Supplier (SuppID, Name) VALUES (4, 'GHI Office Things');
INSERT INTO Supplier (SuppID, Name) VALUES (5, 'JKL Office Junk');

-- 3.4 UPDATE
-- Update unit cost in products table where name is ruler
UPDATE PRODUCT SET UNITCOST = 2.79 WHERE NAME = 'Ruler';
-- Update the description of computer and cleaning supplies in the Category table.
UPDATE CATEGORY SET DESCRIPT = 'General cleaning supplies' WHERE NAME = 'Cleaning Supplies';
UPDATE CATEGORY SET DESCRIPT = 'General computer supplies' WHERE NAME = 'Computer Supplies';

-- 3.5 LIKE
-- Select username from employees table where username is like "j"
SELECT USERNAME FROM EMPLOYEES WHERE USERNAME LIKE 'j%';
-- Select name from product table where name is like "O";
SELECT NAME FROM PRODUCT WHERE NAME LIKE 'O%';

-- 3.6 BETWEEN
-- Select name from products table where unitprice is between 3 and 10
SELECT NAME FROM PRODUCT WHERE UNITCOST BETWEEN 3 AND 10;
-- SElect name from products table where unit price is between 500 and 800
SELECT NAME FROM PRODUCT WHERE UNITCOST BETWEEN 500 AND 800;

-- 3.7 DELETE
-- Delete a record from the category where the value is audio visual
ALTER TABLE PRODUCT DROP CONSTRAINT FK_PRODUCTCATID;
DELETE FROM CATEGORY WHERE NAME = 'Audio Visual';
-- Delete the three records you previously inserted into the supplier table
DELETE FROM SUPPLIER WHERE SUPPID BETWEEN 3 AND 5;

-- 4.0 SQL Functions

-- 4.1 System Defined Scalar Functions
-- Create a function that returns the length of the string of the description of the laser pointer
CREATE OR REPLACE FUNCTION DESCRIPTLENGTHLASERPOINTER
    RETURN INT
        IS
            LN INT;
        BEGIN
            SELECT LENGTH(DESCRIPT) INTO LN FROM PRODUCT WHERE NAME = 'Laser Pointer';
            RETURN LN;
    END DESCRIPTLENGTHLASERPOINTER;
/
SELECT DESCRIPTLENGTHLASERPOINTER FROM DUAL;
-- Create a function that converts a username in the employees table to upper case.
CREATE OR REPLACE FUNCTION USERNAMETOUPPER(UN VARCHAR)
    RETURN VARCHAR
        IS
           UPPERCASE VARCHAR(20);
        BEGIN
            SELECT UPPER(USERNAME) INTO UPPERCASE FROM EMPLOYEES WHERE UN = USERNAME;
            RETURN UPPERCASE;
    END USERNAMETOUPPER;
/
SELECT USERNAMETOUPPER('dclark') FROM DUAL;

-- 4.2 System Defined Aggregate Function
-- Create a function that gets the sum of the unitprice column from the products table
CREATE OR REPLACE FUNCTION PRODUCTCOSTSUM
    RETURN NUMBER
        IS
            TOTAL NUMBER(10,2);
        BEGIN
            SELECT SUM(UNITCOST) INTO TOTAL FROM PRODUCT;
            RETURN TOTAL;
    END PRODUCTCOSTSUM;
/
SELECT PRODUCTCOSTSUM FROM DUAL;
-- Create a function that gets the count of all the products in the products table
CREATE OR REPLACE FUNCTION PRODUCTCOUNT
    RETURN NUMBER
        IS
            TOTAL NUMBER;
        BEGIN
            SELECT COUNT(DISTINCT PRODUCTID) INTO TOTAL FROM PRODUCT;
            RETURN TOTAL;
    END PRODUCTCOUNT;
/
SELECT PRODUCTCOUNT FROM DUAL;

-- 4.3 User Defined Scalar Functions
-- Create a function that takes two inputs (unit price of products) and calculates the cost of the two products
CREATE OR REPLACE FUNCTION PRODUCTCOSTTWO(COST1 NUMBER, COST2 NUMBER)
    RETURN NUMBER
        IS
            TOTAL NUMBER;
        BEGIN
            SELECT SUM(P1.UNITCOST + P2.UNITCOST) INTO TOTAL FROM PRODUCT P1, PRODUCT P2 WHERE P1.UNITCOST = COST1 AND P2.UNITCOST = COST2;
            RETURN TOTAL;
    END PRODUCTCOSTTWO;
/
SELECT PRODUCTCOSTTWO(12.00, 24.49) FROM DUAL;

-- 4.4 User Defined Table Valued Functions
CREATE OR REPLACE FUNCTION USERNAMEBELONGSTOMANAGER(UN VARCHAR)
    RETURN VARCHAR
        IS 
            BELONGS NUMBER;
        BEGIN
            SELECT E1.MANAGER INTO BELONGS FROM EMPLOYEES E1 WHERE E1.USERNAME = UN AND E1.MANAGER IN (SELECT E2.MANAGER FROM EMPLOYEES E2 WHERE E2.MANAGER = 1);
            IF (BELONGS = 1) THEN
                RETURN 'True';
            ELSE
                RETURN 'False';
            END IF;
    END USERNAMEBELONGSTOMANAGER;
/
SELECT USERNAMEBELONGSTOMANAGER('klink') FROM DUAL;

-- 5.0 Stored Procedures

-- 5.1 Basic Stored Procedure
-- Create a stored procedure that returns all employees with the username, dept, and manager columns from the employees table. Call the procedure to get the result set.
CREATE OR REPLACE PROCEDURE EMPLOYEESPROCEDURE (C_RESULT OUT SYS_REFCURSOR)
    AS
    BEGIN
        OPEN C_RESULT FOR SELECT USERNAME, DEPARTMENT, MANAGER FROM EMPLOYEES;
END EMPLOYEESPROCEDURE;
/
DECLARE
    L_CURSOR SYS_REFCURSOR;
    L_USERNAME EMPLOYEES.USERNAME%TYPE;
    L_DEPARTMENT EMPLOYEES.DEPARTMENT%TYPE;
    L_MANAGER EMPLOYEES.MANAGER%TYPE;
BEGIN
    EMPLOYEESPROCEDURE(C_RESULT => L_CURSOR);
    LOOP
        FETCH L_CURSOR
        INTO L_USERNAME, L_DEPARTMENT, L_MANAGER;
        EXIT WHEN L_CURSOR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(L_USERNAME || ' | ' || L_DEPARTMENT || ' | ' || L_MANAGER);
    END LOOP;
    CLOSE L_CURSOR;
END;
/
-- Create a stored procedure that returns all the products with the name, and unitprice column from the products table.
CREATE OR REPLACE PROCEDURE PRODUCTPROCEDURE (C_RESULT OUT SYS_REFCURSOR)
    AS
    BEGIN
        OPEN C_RESULT FOR SELECT NAME, UNITCOST FROM PRODUCT;
END PRODUCTPROCEDURE;
/

-- 5.2 Stored Procedure Input Parameters
-- Create a stored procedure that takes in a productID and gets the name and description of that productID
CREATE OR REPLACE PROCEDURE IDTODESCRIPTPROCEDURE (P_PRODUCTID IN PRODUCT.PRODUCTID%TYPE, P_NAME OUT PRODUCT.NAME%TYPE, P_DESCRIPT OUT PRODUCT.DESCRIPT%TYPE)
    AS
    BEGIN
        SELECT NAME, DESCRIPT INTO P_NAME, P_DESCRIPT FROM PRODUCT WHERE PRODUCTID = P_PRODUCTID;
END IDTODESCRIPTPROCEDURE;
/
-- Create a stored procedure that insert a new manager into the employees table
CREATE OR REPLACE PROCEDURE INSERTMANAGERPROCEDURE(P_EMPLOYEEID IN EMPLOYEES.EMPLOYEEID%TYPE, P_USERNAME IN EMPLOYEES.USERNAME%TYPE, P_PASSWORD IN EMPLOYEES.USERNAME%TYPE, P_DEPARTMENT IN EMPLOYEES.DEPARTMENT%TYPE)
    AS
    BEGIN
        INSERT INTO EMPLOYEES(EMPLOYEEID, USERNAME, PASSWORD, DEPARTMENT, MANAGER) VALUES (P_EMPLOYEEID, P_USERNAME, P_PASSWORD, P_DEPARTMENT, 1);
END INSERTMANAGERPROCEDURE;
/

-- 5.3 Stored Procedure Output Parameters
-- Create a stored procedure that calculates the value of the unit cost column in the products table and returns the total amount
CREATE OR REPLACE PROCEDURE UNITCOSTPROCEDURE (P_PRODUCTID IN PRODUCT.PRODUCTID%TYPE, P_UNITCOST OUT PRODUCT.UNITCOST%TYPE)
    AS
    BEGIN
        SELECT UNITCOST INTO P_UNITCOST FROM PRODUCT WHERE PRODUCTID = P_PRODUCTID;
END UNITCOSTPROCEDURE;
/
-- Create a stored procedure that would return username and password based on employeeID
CREATE OR REPLACE PROCEDURE GETLOGINPROCEDURE (P_EMPLOYEEID IN EMPLOYEES.EMPLOYEEID%TYPE, P_USERNAME OUT EMPLOYEES.USERNAME%TYPE, P_PASSWORD OUT EMPLOYEES.PASSWORD%TYPE)
    AS
    BEGIN
        SELECT USERNAME, PASSWORD INTO P_USERNAME, P_PASSWORD FROM EMPLOYEES WHERE EMPLOYEEID = P_EMPLOYEEID;
END GETLOGINPROCEDURE;
/

-- 6.0 Transactions
-- Create a transaction that is nested inside a stored procedure that inserts a new record into the employees table.
CREATE OR REPLACE PROCEDURE INSERTEMPLOYEEPROCEDURE (P_EMPLOYEEID IN EMPLOYEES.EMPLOYEEID%TYPE, P_USERNAME IN EMPLOYEES.USERNAME%TYPE, P_PASSWORD IN EMPLOYEES.PASSWORD%TYPE, P_DEPARTMENT IN EMPLOYEES.DEPARTMENT%TYPE, P_MANAGER IN EMPLOYEES.MANAGER%TYPE)
    AS
    BEGIN
        INSERT INTO EMPLOYEES (EMPLOYEEID, USERNAME, PASSWORD, DEPARTMENT, MANAGER) VALUES (P_EMPLOYEEID, P_USERNAME, P_PASSWORD, P_DEPARTMENT, P_MANAGER);
END INSERTEMPLOYEEPROCEDURE;
/
-- Create a transaction that is nested inside a stored procedure that updates the unitprice of a product in the products table.
CREATE OR REPLACE PROCEDURE UPDATEUNITCOSTPROCEDURE (P_PRODUCTID IN PRODUCT.PRODUCTID%TYPE, P_UNITCOST IN PRODUCT.UNITCOST%TYPE)
    AS
    BEGIN
        UPDATE PRODUCT SET UNITCOST = P_UNITCOST WHERE PRODUCTID = P_PRODUCTID;
END UPDATEUNITCOSTPROCEDURE;
/
-- Create a multi-statement transaction nested in a stored procedure that updates at least two records' names and description in the category table
CREATE OR REPLACE PROCEDURE UPDATE2CATEGORY (P_CATID1 IN CATEGORY.CATID%TYPE, P_NAME1 IN CATEGORY.NAME%TYPE, P_DESCRIPT1 IN CATEGORY.DESCRIPT%TYPE, P_CATID2 IN CATEGORY.CATID%TYPE, P_NAME2 IN CATEGORY.NAME%TYPE, P_DESCRIPT2 IN CATEGORY.DESCRIPT%TYPE)
    AS
    BEGIN
        UPDATE CATEGORY SET NAME = P_NAME1, DESCRIPT = P_DESCRIPT1 WHERE CATID = P_CATID1;
        UPDATE CATEGORY SET NAME = P_NAME2, DESCRIPT = P_DESCRIPT2 WHERE CATID = P_CATID2;
END UPDATE2CATEGORY;
/

-- 7.0 Triggers

-- 7.1 AFTER/OR Triggers
-- Create an after insert trigger on the categories table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER AFTERINSERTCATEGORY
    AFTER INSERT ON CATEGORY
    FOR EACH ROW
        DECLARE
        V_USERNAME VARCHAR2(10);
    BEGIN
        SELECT USER INTO V_USERNAME FROM DUAL;
        DBMS_OUTPUT.PUT('NEW CATEGORY ENTERED BY ' || V_USERNAME);
    END AFTERINSERTCATEGORY;
/
-- Create an after update trigger on the categories table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER AFTERUPDATECATEGORY
    AFTER UPDATE ON CATEGORY
    FOR EACH ROW
        DECLARE
        V_USERNAME VARCHAR2(10);
    BEGIN
        SELECT USER INTO V_USERNAME FROM DUAL;
        DBMS_OUTPUT.PUT('CATEGORY UPDATED BY ' || V_USERNAME);
    END AFTERUPDATECATEGORY;
/
-- Create an after delete trigger on the categories table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER AFTERDELETECATEGORY
    AFTER DELETE ON CATEGORY
    FOR EACH ROW
        DECLARE
        V_USERNAME VARCHAR2(10);
    BEGIN
        SELECT USER INTO V_USERNAME FROM DUAL;
        DBMS_OUTPUT.PUT('CATEGORY DELETED BY ' || V_USERNAME);
    END AFTERDELETECATEGORY;
/

-- 7.2 INSTEAD OF Triggers
-- Create an instead of delete trigger on the Products table that restricts the deletion of any records that are priced below 500 dollars.
CREATE OR REPLACE TRIGGER INSTEADOFDELETEPRODUCT
    BEFORE DELETE ON PRODUCT
    FOR EACH ROW
    BEGIN
        IF (:OLD.UNITCOST < 500.00) THEN
            RAISE_APPLICATION_ERROR(-20001, 'Record cannot be deleted');
        END IF;
    END INSTEADOFDELETEPRODUCT;
/

-- 8.0 JOINS

-- 8.1 INNER JOIN
-- Perform an inner join on tables product and category
SELECT * FROM PRODUCT P INNER JOIN CATEGORY C ON C.CATID = P.CATID;
-- Perform an inner join on tables employee and orders
SELECT * FROM ORDERS O INNER JOIN EMPLOYEES E ON E.EMPLOYEEID = O.EMPLOYEEID;

-- 8.2 OUTER JOIN
-- Perform an outer join on tables products and orderitems
SELECT * FROM ORDERITEM OI FULL OUTER JOIN PRODUCT P ON P.PRODUCTID = OI.PRODUCTID;
-- Perform an outer join on tables employee and orders
SELECT * FROM ORDERS O FULL OUTER JOIN EMPLOYEES E ON E.EMPLOYEEID = O.EMPLOYEEID;

-- 8.3 RIGHT JOIN
-- Perform a right join on tables orders and orderitems
SELECT * FROM ORDERS O RIGHT JOIN ORDERITEM OI ON OI.ORDERID = O.ORDERID;
-- Perform a right join on tables product and orderitems
SELECT * FROM ORDERITEM OI RIGHT JOIN PRODUCT P ON P.PRODUCTID = OI.PRODUCTID;

-- 8.4 LEFT JOIN
-- Perform a left join on tables product and category
SELECT * FROM PRODUCT P LEFT JOIN CATEGORY C ON C.CATID = P.CATID;
-- Perform a left join on tables employees and orders
SELECT * FROM ORDERS O LEFT JOIN EMPLOYEES E ON E.EMPLOYEEID = O.EMPLOYEEID;

-- 8.5 CROSS JOIN
-- Perform a cross join on tables product and category
SELECT P.PRODUCTID, P.NAME, P.DESCRIPT, P.UNITCOST, P.SUPPID, C.CATID, C.NAME FROM PRODUCT P CROSS JOIN CATEGORY C WHERE C.CATID = P.CATID;

-- 8.6 SELF JOIN
-- Using the employees table perform a self-join. You can break up the table as needed.
SELECT E1.DEPARTMENT, E1.EMPLOYEEID, E1.USERNAME, E1.PASSWORD, E1.MANAGER, E2.EMPLOYEEID, E2.USERNAME, E2.PASSWORD, E2.MANAGER FROM EMPLOYEES E1, EMPLOYEES E2 WHERE E2.DEPARTMENT = E1.DEPARTMENT AND E2.USERNAME = E1.USERNAME;

-- 9.0 Views
-- Create two new columns named SSN and salary on the employees table. Create a view that displays all columns except SSN and salary
ALTER TABLE EMPLOYEES ADD (SSN NUMBER, SALARY NUMBER);
CREATE OR REPLACE VIEW EMPLOYEESVIEW AS SELECT EMPLOYEEID, USERNAME, PASSWORD, DEPARTMENT, MANAGER FROM EMPLOYEES;
/
-- Create a view on the products table that only displays only the name of the product and the description.
CREATE OR REPLACE VIEW PRODUCTVIEW AS SELECT NAME, DESCRIPT FROM PRODUCT;
/

-- 10.0 Indexes

-- 10.1 Clustered Indexes
-- Create a clustered index on table of your choice
CREATE CLUSTER EMP_CLUST (EMPLOYEEID NUMBER)
    SIZE 600
    TABLESPACE USERS
    STORAGE (INITIAL 200K
        NEXT 300K
        MINEXTENTS 2
        PCTINCREASE 33);
        
CREATE INDEX EMP_INDEX
    ON CLUSTER EMP_CLUST
    TABLESPACE USERS
    STORAGE (INITIAL 50K
        NEXT 50K
        MINEXTENTS 2
        MAXEXTENTS 10
        PCTINCREASE 33);

CREATE TABLE EMP
    CLUSTER EMP_CLUST (EMPLOYEEID)
    AS SELECT * FROM EMPLOYEES;
        
-- 11.0 Administration
-- Create a .bak file for the OfficeSupply database

COMMIT;
EXIT;