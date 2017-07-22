---------------------------- PART 1 ------------------------------
--2.1 SELECT
SELECT * FROM CHINOOK.EMPLOYEE;
SELECT * FROM chinook.employee WHERE LASTNAME = 'King';
SELECT * FROM chinook.employee WHERE FIRSTNAME = 'Andrew' AND REPORTSTO is NULL;

--2.2 ORDER BY
SELECT * FROM chinook.album ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM chinook.customer ORDER BY city ASC;

--2.3 INSERT INTO
INSERT INTO chinook.genre (GenreID, Name) VALUES (500, 'Mine');
INSERT INTO chinook.genre (GENREID, NAME) VALUES (501, 'Mine2');
INSERT INTO chinook.Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Song', 'Tae', 'CEO', TO_DATE('1962-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11 old annapolisroad', 'nowhere', 'MD', 'UnitedStates', '21042', '+1 (410) 123-4567', '+1 (410) 123-4567', 'tae@chinookcorp.com');
INSERT INTO chinook.Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Adams', 'Andrew', 'General Manager', TO_DATE('1962-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (780) 428-3457', 'andrew@chinookcorp.com');
INSERT INTO chinook.Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (200, 'Leonie', 'Köhler', 'Theodor-Heuss-Straße 34', 'Stuttgart', 'Germany', '70174', '+49 0711 2842222', 'leonekohler@surfeu.de', 5);
INSERT INTO chinook.Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (201, 'Leonie', 'Köhler', 'Theodor-Heuss-Straße 34', 'Stuttgart', 'Germany', '70174', '+49 0711 2842222', 'leonekohler@surfeu.de', 5);

--2.4 UPDATE
UPDATE chinook.Customer SET Firstname = 'Robert', Lastname = 'Walter' WHERE Firstname='Aaron' AND Lastname='Mitchell';
UPDATE chinook.artist SET name='CCR' WHERE name='Creedence Clearwater Revival';

--2.5 LIKE
SELECT * FROM chinook.invoice WHERE BillingAddress LIKE 'T%';

--2.6 BETWEEN
SELECT * FROM chinook.invoice WHERE Total BETWEEN 15 AND 50;
SELECT * FROM chinook.employee WHERE HireDate BETWEEN TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');

--2.7 DELETE
ALTER TABLE chinook.Invoice DROP CONSTRAINT FK_InvoiceCustomerId;
DELETE FROM chinook.customer WHERE Firstname='Robert' AND Lastname='Walter';

--3.1 System Defined Functions
--Using system-provided functions...
SELECT CURRENT_TIMESTAMP FROM DUAL;
SELECT LENGTH(Name) FROM chinook.mediatype WHERE mediatypeID=1;

--3.2 System Defined Aggregate Functions
--Using system-provided functions...
SELECT SUM(Total) FROM chinook.Invoice;
SELECT MAX(Unitprice) FROM chinook.invoiceline;

--3.3 User Defined Scalar Functions
CREATE OR REPLACE FUNCTION getSum
RETURN NUMBER IS vreturn NUMBER;
BEGIN
    SELECT AVG(unitprice) INTO vreturn FROM chinook.invoiceline;
    RETURN vreturn;
END;
/
SELECT getSum FROM DUAL;
--3.4 User Defined Table Valued Functions
--CREATE OR REPLACE TYPE isArray IS ARRAY(20) of VARCHAR2(20);
--/
--CAN USE EITHER
CREATE OR REPLACE TYPE isntARRAY IS TABLE OF VARCHAR2(20);
/
CREATE OR REPLACE FUNCTION getEmpAfter
RETURN isntArray IS vuser isntArray;
BEGIN
    SELECT firstname BULK COLLECT INTO vuser FROM chinook.employee WHERE BirthDate >= TO_DATE('1968-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
    RETURN vuser;
END;
/
SELECT getEmpAfter FROM DUAL;

-- 4.1 Basic Stored Procedure
CREATE OR REPLACE PROCEDURE firstAndLast(mycursor OUT SYS_REFCURSOR) AS
BEGIN
OPEN mycursor FOR SELECT DISTINCT firstname, lastname FROM chinook.employee;
END;
/
variable rc refcursor;
EXECUTE firstAndLast(:rc);
print rc;
-- 4.2 Stored Procedure Input Parameters
----This example will only update the first and last name to demonstrate the use of stored procedures using input parameters
Create or Replace PROCEDURE Update_Employee(
    inFirstname in varchar2,
    inLastname in varchar2,
    changedFirstname in varchar2,
    changedLastname in varchar2) as
    BEGIN
        UPDATE chinook.employee SET Firstname=changedFirstname, Lastname=changedLastname WHERE Firstname=inFirstname AND Lastname=inLastname;
    END;
    /
EXECUTE Update_Employee('Andrew','Adams','Tae','Song');
    
Create or Replace PROCEDURE Are_Managers(
    LOOKUPID in number,
    outputInfo out sys_refcursor) as
    BEGIN
        OPEN outputInfo FOR SELECT A.REPORTSTO AS ManagerID, B.FIRSTNAME AS ManagerFirstName, B.LASTNAME AS ManagerLastName
        FROM CHINOOK.EMPLOYEE A JOIN CHINOOK.EMPLOYEE B ON B.EMPLOYEEID = A.REPORTSTO
        WHERE A.EMPLOYEEID = LOOKUPID;
    END;
    /
variable rc refcursor;
EXECUTE Are_Managers(2, :rc);
print rc;

SELECT * FROM employee;
-- 4.3 Stored Procedure Output Parameters
CREATE OR REPLACE PROCEDURE Customer_Info(
    outputInfo OUT sys_refcursor) AS
    BEGIN
        OPEN outputInfo FOR SELECT firstname, lastname, Company FROM chinook.customer;
    END;
    /
variable rc refcursor;
EXECUTE Customer_Info(:rc);
print rc;

-- 5.0 Transactions
commit;
Set Transaction Name '5.0 Delete';
create or replace procedure delete_invoice(
        tempInvoiceid in number
    ) as 
    begin
        DELETE FROM chinook.invoice WHERE Invoiceid=tempInvoiceid;
    end;
    /
commit;

commit;
Set Transaction Name '5.0 Insert';
Create or replace procedure insert_Customer(
        inCustomerId in number,
        inFirstname in varchar2,
        inLastname in varchar2,
        inCompany in varchar2,
        inAddress in varchar2,
        inCity in varchar2,
        inState in varchar2,
        inCountry in varchar2,
        inPostalcode in varchar2,
        inPhone in varchar2,
        inFax in varchar2,
        inEmail in varchar2,
        inSupportrepid in Number
    ) as
    begin
       INSERT INTO chinook.Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (300, 'Leonie', 'Köhler', 'Theodor-Heuss-Straße 34', 'Stuttgart', 'Germany', '70174', '+49 0711 2842222', 'leonekohler@surfeu.de', 5); 
    end;
    /
commit;

-- 6.1 AFTER/FOR
DROP SEQUENCE EMPLOYEE_SEQ;
CREATE SEQUENCE EMPLOYEE_SEQ MINVALUE 1 MAXVALUE 999999
INCREMENT BY 1 START WITH 20;
/
CREATE OR REPLACE TRIGGER NEW_EMPLOYEE_TRIG
    BEFORE INSERT ON chinook.EMPLOYEE
    FOR EACH ROW
    BEGIN
        SELECT EMPLOYEE_SEQ.NEXTVAL INTO :new.employeeid FROM DUAL;
    END;
/
CREATE OR REPLACE TRIGGER UPDATE_EMPLOYEE_TRIG
    BEFORE UPDATE ON chinook.employee
    FOR EACH ROW
    BEGIN
        SELECT :old.employeeid INTO :new.employeeid FROM DUAL;       
    END;
/
CREATE OR REPLACE TRIGGER NEW_EMPLOYEE_TRIG_test
    AFTER INSERT ON chinook.EMPLOYEE
    FOR EACH ROW
    BEGIN
        DBMS_OUTPUT.PUT_LINE('After Insert Trigger Fired');
    END;
/
CREATE OR REPLACE TRIGGER NEW_EMPLOYEE_TRIG_AFTERUPDATE
    AFTER UPDATE ON chinook.EMPLOYEE
    FOR EACH ROW
    BEGIN
        DBMS_OUTPUT.PUT_LINE('After Update Trigger Fired');
    END;
/
CREATE OR REPLACE TRIGGER NEW_EMPLOYEE_TRIG_AFTERDELETE
    AFTER DELETE ON chinook.EMPLOYEE
    FOR EACH ROW
    BEGIN
        DBMS_OUTPUT.PUT_LINE('After Delete Trigger Fired');
    END;
/
--------------- NICK'S EXAMPLE ---------------------------
UPDATE CHINOOK.EMPLOYEE SET EMPLOYEEID = 1, FIRSTNAME ='Waffle', Lastname='Burger' WHERE EMPLOYEEID=3;
SELECT * FROM chinook.employee;
----------------------------------------------------------

INSERT INTO chinook.employee (email, firstname, lastname) VALUES ('myawesomeemail@gmail.com', 'My', 'Awesome');
UPDATE chinook.employee SET Lastname = 'Legitname' WHERE Firstname='My';
DELETE FROM Chinook.employee WHERE firstname='My';
BEGIN
DBMS_OUTPUT.PUT_LINE('TESTING THAT TRIGGERS ARE FIRED');
END;
/

-- 6.2 INSTEAD OF
CREATE OR REPLACE VIEW invoiceView AS SELECT * FROM chinook.invoice;
/
SELECT * FROM invoiceView;
CREATE OR REPLACE TRIGGER NEW_INVOICE_TRIG_INSTEADOF
    INSTEAD OF DELETE ON invoiceView
    FOR EACH ROW
    BEGIN
        IF (To_Number(:old.total, '99.99') < 50.00) THEN
            DELETE FROM invoiceView WHERE invoiceid=:old.invoiceid;
        END IF;
    END;
/
-- 7.1 INNER
SELECT Firstname, Lastname, InvoiceID FROM chinook.customer INNER JOIN chinook.invoice ON chinook.customer.CustomerId=chinook.invoice.CustomerId;

-- 7.2 OUTER
SELECT customer.customerid, firstname, lastname, invoiceid, total FROM chinook.customer FULL OUTER JOIN chinook.invoice ON chinook.customer.CustomerId=chinook.invoice.CustomerId;

-- 7.3 RIGHT
SELECT name, title FROM chinook.album RIGHT JOIN chinook.artist ON chinook.album.artistid=chinook.artist.artistid;

-- 7.4 CROSS
SELECT name FROM chinook.album CROSS JOIN chinook.artist ORDER BY name ASC;

-- 7.5 SELF
SELECT A.firstname, A.lastname, B.firstname, B.lastname, A.reportsto FROM chinook.employee A, chinook.employee B WHERE A.reportsto=B.reportsto AND A.employeeid<>B.employeeid ORDER BY A.reportsto ASC;

-- 8.1 Clustered Indexes
CREATE CLUSTER emp_dept (deptno NUMBER(3))
   SIZE 600
   TABLESPACE users
   STORAGE (INITIAL 200K
      NEXT 300K
      MINEXTENTS 2
      PCTINCREASE 33);
      
CREATE INDEX emp_dept_index
   ON CLUSTER emp_dept
   TABLESPACE users
   STORAGE (INITIAL 50K
      NEXT 50K
      MINEXTENTS 2
      MAXEXTENTS 10
      PCTINCREASE 33);

-- 9.0 Administration
----Successfully created a backup as per requirements

---------------------------- PART 2 ------------------------------
-- 1.1 Create Company Database using SSMS Interface
--I Created the user in the console
CREATE USER OfficeSupply
IDENTIFIED BY mypassword
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;
GRANT connect to OfficeSupply;
GRANT resource to OfficeSupply;
GRANT create session to OfficeSupply;
GRANT create table TO OfficeSupply;
GRANT create view TO OfficeSupply;

DROP USER OfficeSupply;

-- 1.2 Create Company Databsae using DDL
CREATE USER OfficeSupply
IDENTIFIED BY mypassword
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;
GRANT connect to OfficeSupply;
GRANT resource to OfficeSupply;
GRANT create session to OfficeSupply;
GRANT create table TO OfficeSupply;
GRANT create view TO OfficeSupply;