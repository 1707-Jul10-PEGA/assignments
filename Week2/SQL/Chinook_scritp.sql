SET SERVEROUT ON

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

/* 3.2 Create a function that returns the average total of all invoices */
CREATE OR REPLACE FUNCTION AVGTOTAL
RETURN NUMBER AS
avgTotalInv NUMBER(10,2);
I_TOTAL NUMBER(10,2); 
NROW NUMBER;
CURSOR NUMBER_ROW IS SELECT TOTAL FROM INVOICE;
BEGIN
    avgTotalInv := 0;
    
    OPEN NUMBER_ROW;
    
    SELECT COUNT(TOTAL) into NROW FROM INVOICE;

    LOOP
        FETCH NUMBER_ROW INTO I_TOTAL;
    EXIT WHEN NUMBER_ROW%NOTFOUND;
    avgTotalInv := avgTotalInv + I_TOTAL;
    END LOOP;

    CLOSE NUMBER_ROW;
    RETURN avgTotalInv/NROW;
END;
/

SELECT AVGTOTAL FROM DUAL;

/* 3.2 Create a function that returns the most expensive track*/
CREATE OR REPLACE FUNCTION CHECK_EXPENSIVE_TRACK
RETURN VARCHAR2 AS
PRICE NUMBER;
TRACK_NAME VARCHAR2(200);
CURSOR NUMBER_OF_TRACKS IS SELECT UNITPRICE,NAME FROM TRACK;
BEGIN
    PRICE := 0;

    FOR I IN NUMBER_OF_TRACKS LOOP
        
            IF I.UNITPRICE > PRICE THEN
                PRICE := I.UNITPRICE;
                TRACK_NAME := I.NAME;
            END IF;
        
        EXIT WHEN NUMBER_OF_TRACKS%NOTFOUND;
    END LOOP;
    RETURN TRACK_NAME;
END;
/

SELECT CHECK_EXPENSIVE_TRACK FROM DUAL;
       

/* 3.3 Create a function that returns the average price of invoiceline items in the invoiceline table*/
CREATE OR REPLACE FUNCTION AVG_PRICE
RETURN NUMBER AS
avgPrice NUMBER;
NROW NUMBER;
CURSOR PRICE IS SELECT UNITPRICE FROM INVOICELINE;
BEGIN
    avgPrice := 0;
    SELECT COUNT(UNITPRICE) into NROW FROM INVOICELINE;
    FOR I IN PRICE LOOP
        avgPrice := avgPrice + I.UNITPRICE;
        
        EXIT WHEN PRICE%NOTFOUND;
    END LOOP;

    RETURN avgPrice/NROW;
END;
/

SELECT AVG_PRICE FROM DUAL;

/* 3.4 Create a function that returns all employees who are born after 1968*/
CREATE OR REPLACE FUNCTION EMPLOYEES_BIRTHDATE
RETURN SYS_REFCURSOR IS
EMPLOYEE_CURSOR SYS_REFCURSOR;
BEGIN
     OPEN EMPLOYEE_CURSOR FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE >= '01-JAN-68' AND BIRTHDATE <= '31-DEC-68';
     RETURN EMPLOYEE_CURSOR;
END;
/

SELECT EMPLOYEES_BIRTHDATE FROM DUAL;
/* 4.1 Create a stored procedure that selects the first and last names of all the emplyees*/ 
CREATE OR REPLACE PROCEDURE N_EMPLOYEES
IS
CURSOR EMPLOYEES_NAME IS SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE;
BEGIN
    FOR I IN EMPLOYEES_NAME LOOP
    DBMS_OUTPUT.PUT_LINE('FIRST NAME: ' || I.FIRSTNAME || ' LAST NAME: ' || I.LASTNAME);
    END LOOP;
END;
/


BEGIN
    N_EMPLOYEES;
END;
/

/* 4.2 Create a stored procedure that updates the personal information of an employee*/
/* TAKES EMPLOYEE ID AND UPDATES ALL OF THE INFORMANTION OF AN EMPLOYEE*/
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE
(EID IN NUMBER,LNAME IN VARCHAR2, FNAME IN VARCHAR2, 
ETITLE IN VARCHAR2,RSTO IN NUMBER, BDATE IN DATE,
HDATE IN DATE, ADDR IN VARCHAR2, E_CITY IN VARCHAR2, 
E_STATE IN VARCHAR2,E_COUNTRY IN VARCHAR2,ZIP IN VARCHAR2,
TEL IN VARCHAR2, E_FAX IN VARCHAR2, E_EMAIL IN VARCHAR2)
AS
BEGIN
    IF EID IS NOT NULL THEN
        UPDATE EMPLOYEE SET LASTNAME=LNAME, FIRSTNAME=FNAME, TITLE=ETITLE, 
                            REPORTSTO=RSTO,BIRTHDATE=BDATE, HIREDATE=HDATE, 
                            ADDRESS=ADDR,CITY=E_CITY,EMPLOYEE.STATE=E_STATE,COUNTRY=E_COUNTRY,
                            POSTALCODE=ZIP,PHONE=TEL,FAX=E_FAX, EMAIL=E_EMAIL WHERE EMPLOYEEID=EID;
    END IF;
END;
/

BEGIN
    UPDATE_EMPLOYEE(9,'Carlos','gastelum',null,null,null,null,null,null,null,null,null,null,null,null);
END;
/

/* 4.2 Create a stored procedure that returns the managers of an employee*/
/* INPUTS EMPLOYEE ID */
CREATE OR REPLACE PROCEDURE EMPLOYEE_MANAGER
(EID IN NUMBER)
AS
RTO NUMBER;
FNAME VARCHAR(20);
LNAME VARCHAR(20);
MFNAME VARCHAR(20);
MLNAME VARCHAR(20);
BEGIN
    SELECT FIRSTNAME,LASTNAME,REPORTSTO INTO FNAME,LNAME,RTO FROM EMPLOYEE WHERE EMPLOYEEID=EID;
    SELECT FIRSTNAME,LASTNAME INTO MFNAME,MLNAME FROM EMPLOYEE WHERE EMPLOYEEID=RTO;
    DBMS_OUTPUT.PUT_LINE('NAME: ' || FNAME || ' ' || LNAME || ' REPORTS TO: ' || MFNAME || ' ' || MLNAME );
END;
/

BEGIN
    EMPLOYEE_MANAGER(5);
END;
/

/* 4.3 Create a stored procedure that returns the name and company of a customer*/
CREATE OR REPLACE PROCEDURE CUSTOMER_INFO
(CID IN NUMBER)
AS
FNAME VARCHAR(20);
LNAME VARCHAR(20);
C_COMPANY VARCHAR(80);
BEGIN
    SELECT FIRSTNAME,LASTNAME,COMPANY INTO FNAME,LNAME,C_COMPANY FROM CUSTOMER WHERE CUSTOMERID=CID;
    DBMS_OUTPUT.PUT_LINE('NAME: ' || FNAME || ' ' || LNAME || ' COMPANY: ' || C_COMPANY);
END;
/

BEGIN
    CUSTOMER_INFO(5);
END;
/

/* 5.0 Create a transaction that given a invoiceid will delete that invoice */

/* 6.1 Create an after insert trigger on the employee table fired after a new record is inserted into the table*/

CREATE OR REPLACE TRIGGER NEW_EMPLOYEE
AFTER INSERT ON EMPLOYEE FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE( 'NEW EMPLOYEE ID: ' || :NEW.EMPLOYEEID || ' NAME: ' || :NEW.FIRSTNAME || ' ' || :NEW.LASTNAME || ' TITLE');
END;
/


INSERT INTO EMPLOYEE VALUES(14,'PEDRO','GONZALEZ','IT STAFF',6,'5-AUG-94','19-JUL-17','Revature Dr','PHOENIX','AZ','United States', null, null,null,null);

/* 6.1 Create an after update trigger on the album table that fires after a row is inserted in the table*/
CREATE OR REPLACE TRIGGER UPDATE_ALBUM
AFTER UPDATE ON ALBUM FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE( 'OLD VALUES ALBUM ID: ' || :OLD.ALBUMID || ' TITLE: ' || :OLD.TITLE || ' ARTISTID:' || :OLD.ARTISTID);
    DBMS_OUTPUT.PUT_LINE( 'NEW VALUES ALBUM ID: ' || :NEW.ALBUMID || ' TITLE: ' || :NEW.TITLE || ' ARTISTID:' || :NEW.ARTISTID);
END;
/

UPDATE ALBUM SET TITLE='For Those About To Rock We Salute You' WHERE ALBUMID=2;

/* 6.1 Create an after delete trigger on the customer table that fires after a row is deleted from the table */
CREATE OR REPLACE TRIGGER DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE( 'CUSTOMER ' || :OLD.FIRSTNAME || ' ' || :OLD.LASTNAME || ' WAS SUCCESSFULLY DELETED.');
END;
/

DELETE FROM CUSTOMER WHERE CUSTOMERID=60;
/* 6.2 Create an instead of trigger that restricts the deletion of any invoice that is price over 50 dollars */
/* INSTEAD OF ARE ONLY ALLOWED ON VIEWS*/
CREATE OR REPLACE VIEW INVOICE_VIEW AS SELECT * FROM INVOICE;

CREATE OR REPLACE TRIGGER DELETE_INVOICE
INSTEAD OF DELETE ON INVOICE_VIEW 
BEGIN
    IF :OLD.TOTAL > 50 THEN
        DBMS_OUTPUT.PUT_LINE( 'UNABLE TO DELETE INVOICE ' || :OLD.INVOICEID || ' TOTAL IS GREATER THAN 50');
    END IF;
END;
/
INSERT INTO INVOICE_VIEW VALUES(455,4,'21-JUL-17',NULL,NULL,NULL,NULL,NULL,51);
DELETE FROM INVOICE_VIEW WHERE TOTAL>50;
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
        SELF.LASTNAME AS SUPERVISOR_LASTNAME FROM EMPLOYEE SELF JOIN EMPLOYEE ON SELF.EMPLOYEEID=EMPLOYEE.REPORTSTO;
SELECT  E1.FIRSTNAME AS WORKER_FIRSTNAME, 
        E1.LASTNAME AS WORKER_LASTNAME, 
        E2.FIRSTNAME AS SUPERVISOR_FIRSTNAME, 
        E2.LASTNAME AS SUPERVISOR_LASTNAME FROM EMPLOYEE E1, EMPLOYEE E2 WHERE E2.EMPLOYEEID=E1.REPORTSTO;
        
/* 8.0 Create a clustered index on of table of your choice(A clustered index can only be created when you create the table) */
DROP INDEX PK_CUSTOMER;
CREATE UNIQUE INDEX PK_CUSTOMER ON CUSTOMER (CUSTOMERID);


