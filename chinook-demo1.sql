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

CREATE OR REPLACE TYPE E_ROW AS OBJECT(
    FNAME VARCHAR(50),
    LNAME VARCHAR(50),
    BDATE DATE);
CREATE OR REPLACE TYPE E_TABLE IS OBJECT E_ROW;

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

/*
DECLARE
    e_lastname employee.lastname%TYPE;
    e_firstname employee.firstname%TYPE;
    e_birthdate employee.birthdate%TYPE;
BEGIN 
    SELECT lastname INTO e_lastname,
        firstname INTO e_firstname,
        birthdate INTO e_birthdate
    FROM Employee;
    WHERE bithdate > '01-JAN-1968';
    
    DBMS_OUTPUT.put_line (
        lastname || ', '
        firstname || ' - '
        birthdate );
END;/
*/

/* ----------- Stored Procedures  --------------  */
--4.1 Basic Stored Procedure
--Create a stored procedure that selects the first and last names of all the employees.


    
    
    



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
