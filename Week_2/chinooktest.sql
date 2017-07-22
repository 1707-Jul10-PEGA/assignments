CREATE USER chinook
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to chinook;
GRANT resource to chinook;
GRANT create session TO chinook;
GRANT create table TO chinook;
GRANT create view TO chinook;



conn chinook/p4ssw0rd

--Task 2.1 SELECT
select * from chinook.employee;
select * from chinook.employee where LastName='King';

SELECT *
FROM chinook.employee
where FIRSTNAME='Andrew' 
AND REPORTSTO IS NULL;

--Task 2.2 ORDER BY
SELECT *
FROM chinook.album
ORDER BY TITLE DESC;

SELECT *
FROM chinook.customer
ORDER BY City ASC;

--TASK 2.3 INSERT INTO
SELECT *
FROM chinook.genre;

INSERT INTO chinook.genre
VALUES ('26', 'Waffle');

INSERT INTO chinook.genre
VALUES ('27', 'Taco');

INSERT INTO chinook.employee (EmployeeID, FirstName, LastName)
VALUES ('666', 'Flare', 'Cynn');

INSERT INTO chinook.employee (EmployeeID, FirstName, LastName)
VALUES ('254', 'Nachos', 'Tacos');

SELECT *
FROM chinook.employee;

INSERT INTO chinook.customer (CustomerID, FirstName, LastName, email)
VALUES ('100', 'MOREBEES', 'BEES', 'bees247@dead.com');

INSERT INTO chinook.customer (CustomerID, FirstName, LastName, email)
VALUES('111', 'Dubber', 'Rick', 'spoonerisms@haha.com');

--Task 2.4 UPDATE
SELECT *
FROM chinook.customer;

UPDATE chinook.customer
SET LastName = 'Walter', FirstName = 'Robert'
WHERE LastName = 'Mitchell' AND FirstName = 'Aaron';

UPDATE chinook.artist
SET Name = 'CCR'
WHERE Name = 'Creedence Clearwater Revival';

--Task 2.5 LIKE
SELECT *
FROM chinook.Invoice
WHERE BillingAddress LIKE 'T%';

--Task 2.6 BETWEEN
SELECT *
FROM chinook.Invoice
WHERE Total BETWEEN 15 AND 50;

SELECT *
FROM chinook.employee
WHERE HireDate BETWEEN '01-JUN-03' AND '01-MAR-04';

--Task 2.7 DELETE
SELECT * FROM chinook.Invoice WHERE CustomerID = '32';

--make an orphan customerID
UPDATE chinook.Invoice
SET CustomerID = '99'
WHERE CustomerID = '32';

DELETE FROM chinook.customer
WHERE FirstName = 'Robert' AND LastName = 'Walter';


--Task 3.1 System Defined Functions
SELECT SYSTIMESTAMP FROM DUAL;

SELECT LENGTH(name) FROM chinook.mediatype WHERE MediatypeID = 1;

--Task 3.2 System Defined Aggregate Functions
SELECT AVG(Total) FROM chinook.Invoice;
SELECT MAX(UnitPrice) FROM chinook.Track;

--Task 3.3 User Defined Scalar Functions

SELECT AVG(UnitPrice) FROM chinook.InvoiceLine;

--Task 3.4 User Defined Table Valued Functions
CREATE OR REPLACE FUNCTION MYFUNC
RETURN SYS_REFCURSOR
AS REF_TEST SYS_REFCURSOR;
BEGIN
    OPEN REF_TEST FOR 
    SELECT * FROM chinook.employee
    WHERE BirthDate >= '31-DEC-68';
    RETURN(REF_TEST);
END;
/

VARIABLE FT REFCURSOR;
EXEC :FT := MYFUNC;
PRINT FT





--Task 4.1 Basic Stored Procedure
CREATE OR REPLACE PROCEDURE myprocedure(
    mycursor OUT SYS_REFCURSOR )
AS
BEGIN
  OPEN mycursor FOR SELECT DISTINCT FirstName, LastName 
  FROM chinook.employee;
END;
/

variable rc refcursor;
exec MYPROCEDURE( :rc );
print rc

--Task 4.2 Stored Procedure Input Parameters
SELECT *
FROM chinook.employee;

CREATE OR REPLACE PROCEDURE empUpdate (OldFN IN VARCHAR2,
                                    OldLN IN VARCHAR2, 
                                    NewFN IN VARCHAR2, 
                                    NewLN IN VARCHAR2)
AS

BEGIN
    UPDATE chinook.employee
    SET FirstName = NewFN
    WHERE FirstName = OldFN;
    UPDATE chinook.employee
    SET LastName = NewLN
    WHERE LastName = OldLN;
END;
/

exec empUpdate('Flare', 'Cynn', 'Cynn', 'Flare');

SELECT * FROM chinook.employee;

CREATE OR REPLACE PROCEDURE empMan(LOOKUPID IN NUMBER,
                                    MYCURSOR OUT SYS_REFCURSOR)
AS 
BEGIN
OPEN mycursor FOR SELECT A.FIRSTNAME AS EMFN, A.LASTNAME AS EMPLN, A.REPORTSTO AS MANID, B.FIRSTNAME AS MANFN, B.LASTNAME AS MANLN
    FROM CHINOOK.EMPLOYEE A JOIN CHINOOK.EMPLOYEE B ON B.EMPLOYEEID = A.REPORTSTO
    WHERE A.EMPLOYEEID = LOOKUPID;
END;
/
variable rc refcursor;
exec EMPMAN(3, :rc );
print rc;

--Task 4.3 Stored Procedure Output Parameters

create or replace PROCEDURE NAMCUS(CUSTOMERIN IN NUMBER,
    mycursor OUT SYS_REFCURSOR )
AS
BEGIN
  OPEN mycursor FOR SELECT FirstName, LastName, COMPANY
  FROM CHINOOK.CUSTOMER
  WHERE CUSTOMERIN = CUSTOMER.CUSTOMERID;
END;
/

EXEC NAMCUS (1, :RC);
PRINT RC

--Task 5.0 Transactions
ALTER TABLE INVOICELINE DISABLE CONSTRAINT FK_INVOICELINEINVOICEID;
BEGIN
    SAVEPOINT TRAN;
    DELETE FROM CHINOOK.INVOICE WHERE INVOICEID = 190;
END;
/

SELECT * FROM CHINOOK.INVOICE;

create or replace PROCEDURE INSREC(CID IN NUMBER, FN IN VARCHAR2, LN IN VARCHAR2, EMA IN VARCHAR2)
AS
BEGIN
    BEGIN
        SAVEPOINT SLAV;
        INSERT INTO CUSTOMER (CustomerID, FirstName, LastName, email)
        VALUES (CID, FN, LN, EMA);
    END;
END;
/

EXEC INSREC(66, 'Itchy', 'Nose', 'itchy@scratch.com');
SELECT * FROM CUSTOMER WHERE CUSTOMERID = 66;

--Task 6.1 BEFORE/AFTER

CREATE OR REPLACE TRIGGER TE1
    AFTER INSERT ON EMPLOYEE
    FOR EACH ROW
    BEGIN
        --NOTHING SPECIFIED
        INSERT INTO EMPLOYEE (EmployeeID, FirstName, LastName, email)
        VALUES (95, 'Turnip', 'Harvester', 'Turnip@turnip.turnip');
    END;
/

CREATE OR REPLACE  TRIGGER TE2
    AFTER INSERT ON ALBUM
    FOR EACH ROW
    BEGIN
        --NOTHING SPECIFIED
        INSERT INTO ALBUM (AlbumID, Title, ArtistID)
        VALUES (350, 'A Swarm of Bees', 100);
    END;
/

CREATE OR REPLACE TRIGGER TE3
    AFTER DELETE ON CUSTOMER
    FOR EACH ROW
    BEGIN
        --NOTHING SPECIFIED
        INSERT INTO CUSTOMER(CustomerID, FirstName, LastName, email)
        VALUES(1000, 'Fred', 'Fredburger', 'fredfred@burger.yes');
    END;
/

--Task 6.2 Instead Of

CREATE OR REPLACE TRIGGER TE4
BEFORE DELETE ON INVOICE FOR EACH ROW
BEGIN
  IF :OLD.TOTAL >= 50 THEN
    RAISE_APPLICATION_ERROR(-20001,'Record cannot be deleted.');
  END IF;
END;
/

--Task 7.1 Inner Joins
SELECT chinook.customer.FirstName, chinook.customer.LastName, chinook.invoice.InvoiceID FROM chinook.customer
INNER JOIN chinook.invoice ON chinook.customer.customerID=chinook.invoice.customerID;

--Task 7.2 Outer Joins
SELECT chinook.customer.customerID, chinook.customer.FirstName, chinook.customer.LastName, chinook.invoice.invoiceID,chinook.invoice.total FROM chinook.customer
FULL OUTER JOIN chinook.invoice ON chinook.customer.customerID=chinook.invoice.customerID;

--Task 7.3 Right Joins
SELECT CHINOOK.ARTIST.NAME, chinook.album.title FROM chinook.artist
RIGHT JOIN chinook.album ON chinook.album.artistid=chinook.artist.artistid;

--Task 7.4 Cross Joins

SELECT * FROM chinook.album
CROSS JOIN chinook.artist
ORDER BY chinook.artist.Name ASC;

--Task 7.5 Self Joins

SELECT * FROM chinook.employee A, chinook.employee B
WHERE A.ReportsTo = B.ReportsTo
AND A.EmployeeID <> B.EmployeeID
ORDER BY A.ReportsTo ASC;

--Task 8.1 Clustered Indexes

CREATE TABLE MYTABLE(
MYID INT,
MYVALUE VARCHAR(255),
CONSTRAINT MYPK PRIMARY KEY (MYID))
ORGANIZATION INDEX;

--Task 9.0 Administration

--See C:/Users/Matthew Seifert for export.sql file

--Task 1.1 Create Company Database using SSMS Interface

--CREATE USER OfficeSupply
--IDENTIFIED BY p4ssw0rd;

--DROP USER OfficeSupply;

