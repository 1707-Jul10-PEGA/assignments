--2.1
SELECT *                                                                        --2.1.1
FROM EMPLOYEE;

SELECT *                                                                         --2.1.2
FROM EMPLOYEE
WHERE LASTNAME = 'King';

SELECT *                                                                        --2.1.3
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS null;

--2.2
SELECT *                                                                        --2.2.1
FROM ALBUM
ORDER BY TITLE;

SELECT FIRSTNAME                                                                --2.2.2
FROM CUSTOMER
ORDER BY CITY;

--2.3
INSERT INTO GENRE(GENREID,NAME)                                                 --2.3.1
VALUES (26, 'Trip Hop');
INSERT INTO GENRE(GENREID,NAME)
VALUES (27, 'Gothic Death Metal');

INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME)                           --2.3.2
VALUES (9, 'Kruppa', 'Blake');
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME)
VALUES (10, 'Nick', 'Jurczak');

INSERT INTO CUSTOMER(CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL)                    --2.3.3
VALUES (60, 'Bond', 'James', 'ladykiller69@hotmail.com');
INSERT INTO CUSTOMER(CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL)
VALUES (61, 'Shepard', 'Commander', 'reapersarereal@yahoo.com');

--2.4
UPDATE CUSTOMER                                                                 --2.4.1
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

UPDATE ARTIST                                                                   --2.4.2
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5
SELECT * FROM INVOICE                                                           --2.5.1
WHERE BILLINGADDRESS LIKE 'T%';

--2.6
SELECT * FROM INVOICE                                                           --2.6.1
WHERE TOTAL BETWEEN 15 AND 50;

SELECT * FROM EMPLOYEE                                                          --2.6.2
WHERE HIREDATE BETWEEN TO_DATE ('06/01/2003', 'MM-DD-YYYY')
AND TO_DATE ('03/01/2004', 'MM-DD-YYYY');

--2.7
DELETE FROM INVOICELINE WHERE INVOICEID  IN                                     --2.7.1 Instread of working around the constraint I satisfied it by deleting the child records
(SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID IN
(SELECT CUSTOMERID FROM CUSTOMER 
WHERE LASTNAME = 'Walter' AND FIRSTNAME = 'Robert'));
DELETE FROM INVOICE WHERE CUSTOMERID IN
(SELECT CUSTOMERID FROM CUSTOMER 
WHERE LASTNAME = 'Walter' AND FIRSTNAME = 'Robert');
DELETE FROM CUSTOMER WHERE (LASTNAME = 'Walter' AND FIRSTNAME = 'Robert');

--3.1
CREATE OR REPLACE FUNCTION currentTime                                          --3.1.1
RETURN TIMESTAMP IS
BEGIN
 RETURN CURRENT_TIMESTAMP;
END;
/

CREATE OR REPLACE FUNCTION mTLength                                             --3.1.2
(MEDIATYPE_ID IN NUMBER)
RETURN NUMBER IS
 MTLength NUMBER;
BEGIN
 SELECT LENGTH(Name) INTO MTLength FROM MEDIATYPE
 WHERE MEDIATYPEID = MEDIATYPE_ID;
 RETURN MTLength;
END;
/
 
--3.2                             
CREATE OR REPLACE FUNCTION totalAverage                                         --3.2.1
RETURN NUMBER IS
 Average NUMBER;
BEGIN
 SELECT AVG(total) INTO Average FROM invoice;
 RETURN Average;
END;
/

CREATE OR REPLACE FUNCTION topShelfTrack                                        --3.2.2
RETURN NUMBER IS
 TSTPrice NUMBER;
BEGIN
 SELECT MAX(unitprice) INTO TSTPrice FROM track;
 RETURN TSTPrice;
END;
/

--3.3
CREATE OR REPLACE FUNCTION totalILAverage                                         --3.3.1
RETURN NUMBER IS
 Average NUMBER;
BEGIN
 SELECT AVG(unitprice) INTO Average FROM invoiceline;
 RETURN Average;
END;
/

--3.4
CREATE OR REPLACE FUNCTION mustBeThisOld                                        --3.4.1 in progress, not functional
RETURN employee IS
 Veteran employee;
BEGIN
 SELECT * INTO Veteran FROM employees WHERE birthdate > '01-jan-1968';
 RETURN Veteran;
END;
/

--4.1
DECLARE                                                                         --4.1.1
 last_name VARCHAR2(50);
 first_name VARCHAR2(50);
 CURSOR
  curse IS
   SELECT lastname, firstname FROM employee;
BEGIN
 OPEN curse;
 LOOP
  FETCH curse INTO last_name, first_name;
  EXIT WHEN curse%NOTFOUND;
  DBMS_OUTPUT.PUT_LINE(last_name);
 END LOOP;
END;
/

--4.2


--6.1
CREATE OR REPLACE TRIGGER TRG_SelectAfterInsert                                 --6.1.1
AFTER INSERT ON EMPLOYEE 
BEGIN SELECT * FROM INSERTED;
END;
/

CREATE OR REPLACE TRIGGER TRG_AlbumSelectAfterUpdate                            --6.1.2 Bugged
AFTER UPDATE ON ALBUM 
BEGIN SELECT TITLE FROM ALBUM;
END;
/

--7.1
SELECT FIRSTNAME, LASTNAME, INVOICEID                                           --7.1.1
FROM CUSTOMER INNER JOIN INVOICE
ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;

SELECT CUSTOMERID, FIRSTNAME, LASTNAME, INVOICEID, TOTAL
FROM CUSTOMER FULL OUTER JOIN INVOICE
ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;