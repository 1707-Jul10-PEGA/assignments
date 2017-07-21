/*2.1 SELECT all records from the Employee table*/
SELECT ALL * FROM EMPLOYEE;

/*2.1 SELECT all records from the Employee table where the last name is King*/
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';

/*2.1 SELECT all records from the Employee table where first name is Andrew and REPORTSTO is null*/
SELECT * FROM EMPLOYEE WHERE (FIRSTNAME = 'Andrew') AND REPORTSTO IS NULL;

/*2.2 SELECT all albums in Album table and sort result set in descending order by title*/
SELECT * FROM ALBUM ORDER BY TITLE DESC;

/*2.2 SELECT first name from Customer  and sort result set in ascending order by title*/
SELECT FIRSTNAME FROM CUSTOMER ORDER BY FIRSTNAME ASC;

/*2.3 Inser two new rods into Genre table*/
INSERT INTO GENRE VALUES(26,'Country');
INSERT INTO GENRE VALUES(27,'Old school');

/*2.3 Insert two new rods into Employee table*/
INSERT INTO EMPLOYEE VALUES(9,'Carlos','Gastelum','IT Staff',6,'17-JUL-92','18-JUL-17','101 E Washington','El Paso','TX','United States', null, null,null,null);
INSERT INTO EMPLOYEE VALUES(10,'Wei','Wong','General Manager',null,'5-AUG-94','18-JUL-17','Revature Dr','Denver','NV','United States', null, null,null,null);

/*2.3 Insert two new rods into Customer table*/
INSERT INTO CUSTOMER VALUES(60,'Carlos','Gastelum','Revature','101 E Washington','El Paso','TX','United States',null,null, null,'carlos@carlos.com',2);
INSERT INTO CUSTOMER VALUES(61,'Wei','Wong','Revature Dr','Denver','NV','United States', null,null, null,null,'wei@wei.com',2);

/*2.4 Update Aaron Mitchell in Customer table to Robert Walter*/
UPDATE CUSTOMER SET FIRSTNAME = 'Robert',LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';  

/*2.4 Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"*/
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';

/* 2.5 Select all invoices with a billing address that start with T */
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

/* 2.6 Select all invoices that have total between 15 and 50*/
SELECT * FROM INVOICE WHERE TOTAL >= 15 AND TOTAL <= 50;

/* 2.6 Select all employees hired between 1st of June 2003 and 1st of March 2004*/
SELECT * FROM EMPLOYEE WHERE HIREDATE >= '01-JUN-03' AND HIREDATE <= '01-MAR-04';   

/* 2.7 Delete a record in Customer table where the name is Rober Walter */
ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

/* 3.1 Create a function that returns the average total of all invoices */
create or replace function currentTime 
    RETURN TIMESTAMP AS
    BEGIN
        RETURN systimestamp;
    END;
    /
    select currentTime from dual;

(SELECT NAME FROM MEDIATYPE);

/* 3.1 Create a function that returns the length of a mediatype from the mediatype table */
CREATE OR REPLACE FUNCTION lengthOfMediatype(M_ID IN NUMBER)
    RETURN NUMBER AS
    mediaLength NUMBER;
    BEGIN
        SELECT LENGTH(NAME) INTO mediaLength FROM MEDIATYPE WHERE MEDIATYPEID = M_ID;
        return mediaLength;
    END;
/
select lengthOfMediatype(2) from dual;

/* Create a function that returns the average total of all invoices */
SELECT TOTAL FROM INVOICE;

CREATE OR REPLACE FUNCTION AVGTOTAL
RETURN NUMBER AS
avgTotalInv NUMBER(10,2);
T_TOTAL NUMBER(10,2); 
DECLARE
 NUMBER_ROW CURSOR;
BEGIN
    LOOP
        SELECT TOTAL INTO T_TOTAL FROM INVOICE WHERE INVOICEID = i;
    EXIT WHEN NUMBER_ROW%NOTFOUND;
        avgTotalInv := avgTotalInv + T_TOTAL;
    END LOOP;
    RETURN avgTotalInv / numberOfRows;
END;
/
/* 4.1 Create a stored procedure that selects the first and last names of all the emplyees 
CREATE OR REPLACE PROCEDURE NAME_EMPLOYEES

IS
BEGIN
    SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE;
    RETURN 
END;
/
    
select NAME_EMPLOYEES from dual;*/

/* 7.0 Joins */
/*INNER JOIN*/
SELECT * FROM CUSTOMER INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID;
/*FULL OUTER JOIN*/
SELECT FIRSTNAME,LASTNAME,INVOICEID,TOTAL FROM CUSTOMER FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID;
/*RIGHT JOIN*/
SELECT ARTIST.NAME,ALBUM.TITLE FROM ARTIST RIGHT JOIN ALBUM ON ARTIST.ARTISTID = ALBUM.ARTISTID;
/*CROSS JOIN*/
SELECT *  FROM ALBUM,ARTIST ORDER BY ARTIST.NAME ASC;
/* SELF JOIN */
SELECT  EMPLOYEE.FIRSTNAME AS WORKER_FIRSTNAME, 
        EMPLOYEE.LASTNAME AS WORKER_LASTNAME, 
        SELF.FIRSTNAME AS SUPERVISOR_FIRSTNAME, 
        SELF.LASTNAME AS SUPERVISOR_LASTNAME FROM EMPLOYEE SELF JOIN EMPLOYEE ON EMPLOYEE.EMPLOYEEID=SELF.REPORTSTO;
