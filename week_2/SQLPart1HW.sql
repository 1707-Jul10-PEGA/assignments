
--2.1 SELECT

--Select all the records from the employee tables
SELECT * FROM Employee;

--Select all the records from the employee table where ast name is King
SELECT * 
FROM Employee e1
WHERE e1.lastName = 'King';

--Select all records from the Employee table where first name is Andrew and Reportsto is null
SELECT *
FROM Employee e1
WHERE e1.firstname = 'Andrew' AND e1.reportsto IS NULL;


--2.2 Order By

--Select all albums in Album table and sort result in descending order by title
SELECT *
FROM album a1
ORDER BY a1.title DESC;

--SELECT first name from Customer and sort result set in ascending order
SELECT *
FROM Customer c1
ORDER BY c1.city ASC;

--2.3INSERT INTO

--INSERT two new records into Genre Table
INSERT INTO GENRE (GENREID, NAME) VALUES (26,'Chen Music');
INSERT INTO GENRE (GENREID,NAME) VALUES (27, 'Revature Music');

--Insert two new record into Employee Table
INSERT INTO Employee (EmployeeID,Lastname,FirstName,Title,Reportsto,birthdate,hiredate,address,city,state,country,postalcode,phone,fax,email)
VALUES(9,'Chen','Elliot','Software Associate',null,'13-OCT-94','10-JUL-17','309 Little Ave','Gibsonville','NC','USA',27249,'+1 (403) 262-3443',null,null);

INSERT INTO Employee (EmployeeID,Lastname,FirstName,Title,Reportsto,birthdate,hiredate,address,city,state,country,postalcode,phone,fax,email)
VALUES(9,'Chen','Josh','Senior Associate',null,'13-APR-90','10-JUL-13','309 Little Ave','Gibsonville','NC','USA',27249,'+1 (403) 262-3443',null,null);

--Insert two new record into Customer Table
INSERT INTO Customer(customerid,firstname,lastname,email,SUPPORTREPID)VALUES(60,'Rick','Magee','magee@gmail.com',3);
INSERT INTO Customer(firstname,lastname,email,SUPPORTREPID)VALUES(61,'Rocky','Hoffner','hoffner@gmail.com',4);

--2.4 UPDATE

--Update Aarron Mitchell in Customer table to Robert Walter
UPDATE Customer
SET Firstname = 'Robert',Lastname = 'Walter'
Where firstname = 'Aaron' AND lastname = 'Mitchell';

--Update name of artist in the Artist table 'Credence Clearwater Revival' to CCR
UPDATE Artist
SET name = 'CRR'
WHERE name = 'Creedence Clearwater Revival';

--2.5 LIKE

--Select all invoices with a billing addres like "T%"
SELECT *
FROM Invoice i1
WHERE i1.billingaddress like 'T%';

--2.6 Between

--Select all invoices that have a total between 15 and 50
SELECT *
FROM Invoice i1
WHERE i1.total BETWEEN 15 AND 50;

--SELECT all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM Employee e1
WHERE e1.hiredate between '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE

--Delete a record in customer table where the name is Robert Walter
ALTER TABLE INVOICE DROP
    CONSTRAINT FK_INVOICECUSTOMERID;
--change current constraint 
ALTER TABLE INVOICE ADD
    CONSTRAINT FK_INVOICECUSTOMERID
    FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID)
    ON DELETE CASCADE;
    
DELETE FROM Customer c1
WHERE c1.firstname = 'Robert' AND c1.lastname = 'Walter';



--3.0 SQL FUNCTIONS

--3.1 System

--Create a functoin that returns the current time
CREATE OR REPLACE FUNCTION get_time
    RETURN TIMESTAMP IS
    cur_time timestamp;
    BEGIN
        cur_time := current_timestamp;
        RETURN cur_time;
    END;
/

--Create a function that returns the length of a media from the mediatype table
CREATE OR REPLACE FUNCTION get_length(str varchar2)
    RETURN NUMBER AS
    str_length number;
    BEGIN
       SELECT LENGTH(str) INTO str_length FROM DUAL;
    END;
/
    
        
--3.2 System Defined aggregate
--Create a a function that returns the avg total of all invoices
CREATE OR REPLACE FUNCTION INVOICE_AVG
    RETURN NUMBER AS
    I_AVG NUMBER(10,2);
    BEGIN
        SELECT AVG(TOTAL) INTO I_AVG FROM INVOICE;
        RETURN I_AVG;
    END;
/

SELECT INVOICE_AVG FROM DUAL;

--create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION EXP_TRACK
    RETURN NUMBER AS
    T_MAX NUMBER(10,2);
    BEGIN
        SELECT MAX(TOTAL) INTO T_MAX FROM INVOICE;
        RETURN T_MAX;
    END;
/

SELECT EXP_TRACK FROM DUAL;

--3.3 User Defined Scalar Functions
--Create a function that returns the average price of invoiceline items in the invoiceline table

CREATE OR REPLACE FUNCTION AVG_PRICE(T_COUNT IN NUMBER, T_SUM IN NUMBER)
    RETURN NUMBER AS
    AVERAGE_PRICE NUMBER(10,2);
    BEGIN
    SELECT (T_SUM/T_COUNT) INTO AVERAGE_PRICE FROM DUAL;
    RETURN AVERAGE_PRICE;
    END;
/

--Create a function tha returns all employees who are born after 1968
CREATE OR REPLACE TYPE EMPLOYEE_ROW AS OBJECT (
    EMPLOYEEID NUMBER,
    LASTNAME VARCHAR2(255),
    FIRSTNAME VARCHAR2(255),
    TITLE VARCHAR2(255),
    REPORTSTO VARCHAR2(255),
    BIRTHDATE DATE,
    HIREDATE DATE,
    ADDRESS VARCHAR2(255),
    CITY VARCHAR2(255),
    STATE VARCHAR2(255),
    COUNTRY VARCHAR2(255),
    POSTALCODE VARCHAR2(255),
    PHONE VARCHAR2(255),
    FAX VARCHAR2(255),
    EMAIL VARCHAR2(255)
);
/

CREATE OR REPLACE TYPE EMPLOYEE_TABLE IS TABLE OF EMPLOYEE_ROW;
/

CREATE OR REPLACE FUNCTION AFTER_1969
    RETURN EMPLOYEE_TABLE
AS
COUNTER NUMBER;
MY_TABLE EMPLOYEE_TABLE := EMPLOYEE_TABLE();
BEGIN
    SELECT COUNT(EMPLOYEEID) COUNTER FROM EMPLOYEE WHERE BIRTHDATE > TODATE('12-DEC-1968');
    FOR i IN 1 ..COUNTER LOOP
        MY_TABLE.EXTEND;
        MY_TABLE(MY_TABLE.LAST) := EMPLOYEE_ROW(SELECT * );
    END LOOP;
END;
/

CREATE OR REPLACE FUNCTION AFTER_1969
   RETURN CURSOR 
AS
   E_CURSOR CURSOR;
BEGIN
    OPEN E_CURSOR FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-1968';
    RETURN E_CURSOR;
END;
/

PRINT SELECT AFTER_1969 FROM DUAL;

SELECT * FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-1968';

--4.1 Create a stored procedure that selects the first and last names of all the employees
CREATE OR REPLACE PROCEDURE GET_EMP_FULL_NAME
(
    EMP_NAME OUT SYS_REFCURSOR
)AS
BEGIN
    OPEN EMP_NAME FOR 
        SELECT E.FIRSTNAME AS FIRSTNAME, E.LASTNAME AS LASTNAME
        FROM EMPLOYEE E;
END;
/


--4.2 STORE PROCEDURES INPUT PARAMETERS
--Create a stored procedure that updates personal information of employee
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE_NAME
(
  EMP_ID IN NUMBER,
  LNAME IN VARCHAR2,
  FNAME IN VARCHAR2,
  UPDATED_ROW OUT SYS_REFCURSOR
) AS
BEGIN
    UPDATE EMPLOYEE
    SET LASTNAME = LNAME, FIRSTNAME = FNAME
    WHERE EMPLOYEEID = EMP_ID;
    OPEN UPDATED_ROW FOR SELECT * FROM EMPLOYEE
        WHERE EMPLOYEEID = EMP_ID;
END;
/


--create a store procedure that returns the name and company of a customer
CREATE OR REPLACE PROCEDURE EMPS_MANG
(
  RESULTS OUT SYS_REFCURSOR   
)AS
BEGIN 
    OPEN RESULTS FOR     
        SELECT into employeename, managername E1.FIRSTNAME AS EMPLOYEE, E2.FIRSTNAME AS MANAGER
            FROM EMPLOYEE E1, EMPLOYEE E2
            WHERE E1.REPORTSTO = E2.EMPLOYEEID;
END;
/


    
--4.3 Stored Procedure Input Parameters
--Create a store procedure that returns the name of and company of a customer
CREATE OR REPLACE PROCEDURE NAME_COMPANY
(
    CUSTOMERID IN NUMBER,
    RESULTS OUT SYS_REFCURSOR
)AS
BEGIN
    OPEN RESULTS FOR
        SELECT FIRSTNAME, COMPANY
            FROM CUSTOMER
             WHERE CUSTOMER.CUSTOMERID = CUSTOMERID;
END;
/

--5.0 Transaction

--Create a transaction that given a invoiceId will delete that invoice
ALTER TABLE INVOICELINE DROP
    CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE INVOICELINE ADD
    CONSTRAINT FK_INVOICELINEINVOICEID 
        FOREIGN KEY(INVOICEID) REFERENCES INVOICE(INVOICEID)
        ON DELETE CASCADE;
        
DELETE FROM INVOICE WHERE INVOICEID = 1;

--Create a transaction nested within a stored procedure that inserts a new record in the customer
CREATE OR REPLACE PROCEDURE INSERT_NEW_CUSTOMER(
    FNAME IN VARCHAR2,
    LNAME IN VARCHAR2
)AS
BEGIN
    INSERT INTO CUSTOMER(FIRSTNAME,LASTNAME)VALUES(FNAME,LNAME);
END;
/
 
--6.0 Triggers 
--Create an after insert trigger on the employee table fired after a new record is inserted into the table
CREATE OR REPLACE TRIGGER AFTER_INSERT_ON_EMPLOYEE
    AFTER INSERT ON EMPLOYEE
    FOR EACH ROW
    BEGIN
        DBMS_OUTPUT.PUT_LINE('NEW EMPLOYEE: ' || :NEW.FIRSTNAME || ' ' || :NEW.LASTNAME);
    END;
/

--Create an after update trigger on the album table that fires after a row is updated in the table
CREATE OR REPLACE TRIGGER AFTER_UPDATE_ON_ALBUMM
    AFTER UPDATE OF TITLE ON ALBUM
    FOR EACH ROW
    BEGIN
        DBMS_OUTPUT.PUT_LINE('OLD TITLE: ' || :OLD.TITLE);
        DBMS_OUTPUT.PUT_LINE('NEW TITLE: ' || :NEW.TITLE);
    END;
/
 
 UPDATE ALBUM
    SET TITLE = 'TESTING TRIGGER AFTER UPDATE'
    WHERE ALBUMID = 1;
    
--Create an delete after on the customer table that fires from the table
CREATE OR REPLACE TRIGGER AFTER_DELETE_TRIGGER
    AFTER DELETE ON CUSTOMER
    BEGIN
        DBMS_OUTPUT.PUT_LINE('WE LOSTED A CUSTOMER. CANNOT REFERNCE IT WITH OLD OR NEW KEYWORDS');
    END;
/

DELETE FROM CUSTOMER
    WHERE CUSTOMERID = 2;

--Create an instead of trigger tha restricts the deletion of any invoice that is priced over $50
CREATE OR REPLACE TRIGGER MUST_BE_GREATER_THAN_50
    INSTEAD OF DELETE ON INVOICE AS
    FOR EACH ROW
        BEGIN
            DELETE FROM  
        END;
        /
 
 
--7.0 JOINS

--7.1 INNER
--Create an inner join that joins customers and orders and specifies the name of the customer and invoiceId
SELECT c.firstname, c.lastname, i.invoiceid
FROM Invoice i
INNER JOIN Customer c ON c.CUSTOMERID = i.CUSTOMERID;

--7.2 OUTER JOINS 
--Create an outer join that joins the customer and invoice table , specifying the  the CustomerId, firstname, lastname, invoice id, total
SELECT c.Customerid, c.Firstname, c.lastName, i.InvoiceId, i.total
FROM Invoice i
FULL OUTER JOIN Customer c ON c.Customerid = i.Customerid;

--7.3 Right JOIN
--Create a right join that joins album and artist specifying artist name in ascending order
SELECT art.name, alb.title
FROM Album alb
RIGHT JOIN artist art ON art.artistid= alb.artistid;

--7.4 Cross
--Create a cross join that joins album and artist and sorts by artist name and title
SELECT art.name, alb.title
FROM artist art CROSS JOIN album alb --CAN ALSO JUST USE THE WHERE STATEMENT
WHERE art.artistid = alb.artistid
ORDER BY art.name ASC;

--7.5
--Perform a self join on the employee table, joining the reportso column
SELECT E1.FIRSTNAME AS EMPLOYEE, E2.FIRSTNAME AS MANAGER
FROM EMPLOYEE E1, EMPLOYEE E2
WHERE E1.REPORTSTO = E2.EMPLOYEEID;
--8.0 Indexes
--8.1 Clustered Indexes
--Create a clustered index on  a table og your choice
--Was given permisstion to just do a simple index
CREATE INDEX INDEX_ALBUM_TITLE
ON ALBUM (TITLE);

--9.0 Administration
--create a .bak file for the chinookdatabase
--create a backup file called chinookbackup.sql located in my assignments/week_2 folder


--9.0 Administration
--Create a bak file for te Chinook database
BACKUP DATABASE chinookDB TO DISK='C:\Users\ejchen\class-examples\SQL\chinook.bak';















