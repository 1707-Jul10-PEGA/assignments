/* 2.1 Select */
/* Select all records from the Employee table */
SELECT *
FROM Employee;

/* Select all records from Employee where last name is King */
SELECT *
FROM Employee
WHERE LASTNAME='King';

/* Select all records from emplyee where first name is andrew and REPORTSTO is null */
SELECT *
FROM Employee
WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;

/* 2.2 Order By */
/* Select all columns from album and sort the titles in descending order */
SELECT *
FROM Album
ORDER BY TITLE desc;

/* Select first name from Customer and sort result set in ascending order by city */
SELECT Firstname, City
FROM Customer
ORDER BY City asc;

/* 2.3 Insert Into */
/* Insert two new records into genre */
INSERT INTO Genre
VALUES (26, 'Progressive Rock');
INSERT INTO Genre
VALUES (27, 'Post-Punk');

/* Insert two new records into the employee table*/
INSERT INTO Employee
VALUES(9, 'Waters', 'Rogers', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO Employee
VALUES(10, 'Curtis', 'Ian', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

/* Insert two new records into the Customer table */
INSERT INTO Customer
VALUES (60, 'Lamar', 'Kendrick', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'kdot@gmail.com', NULL);
INSERT INTO Customer
VALUES(61, 'West', 'Kanye', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'late2class@gmail.com', NULL);

/* 2.4 Update */
/* Update Aaron Mitchell to Robert Walter*/
UPDATE Customer
SET Firstname='Robert', Lastname='Walter'
WHERE Customerid=32;

/* Update name of artist in Artist table "Creedence Cleatwater Revival" to "CCR"*/
UPDATE Artist
SET Name='CCR'
WHERE Name='Creedence Clearwater Revival';

/* 2.5 Like */
/* Select all invoices with billing address like "T%" */
SELECT *
FROM Invoice
WHERE BillingAddress LIKE 'T%';

/* 2.6 Between */
/* Select all invoices that have a total between 15 and 50 */
SELECT *
FROM Invoice
WHERE Total BETWEEN 15 AND 50;

/* Select all employees hired between 06-JUN-03 and 01-MAR-04*/
SELECT *
From Employee
WHERE HireDate BETWEEN '06-JUN-03' AND '01-MAR-04';

/* 2.7 Delete */
/* Delete a record in Custmer table where name is Robert Walter; may have contraints */
/* Delete Invoice/CusomerId constraint first, then remove Robert Walter*/
ALTER TABLE Invoice
DROP CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM Customer
WHERE FirstName='Robert' AND LastName='Walter';

/* 3.1 System Defined Functions */
/* Create a function that returns the current time */
CREATE OR REPLACE FUNCTION getCurrentTime RETURN TIMESTAMP AS
BEGIN
    RETURN CURRENT_TIMESTAMP;
END getCurrentTime;
/
SELECT getCurrentTime FROM dual;

/* Create a function that returns the length of a mediatype from the mediatype table */
CREATE OR REPLACE FUNCTION getMediaTypeLength() RETURN INT AS
BEGIN
    RETURN NULL;
END getMediaTypeLength;
/

/* 7.0 Joins */
/* Inner join customers and orders and specifies name of customer and invoiceid */
SELECT FirstName, LastName, InvoiceId
FROM Customer
INNER JOIN Invoice ON Customer.CustomerId=Invoice.CustomerId;

/* Outer join customer and invoice, specifying CustomerId, first, ast, invoiceid, and total */
SELECT Customer.CustomerId, FirstName, LastName, InvoiceId, Total
FROM Customer
FULL OUTER JOIN Invoice ON Customer.CustomerId=Invoice.CustomerId;

/* Right join album and artist specifying name and title */
SELECT Artist.Name AS "Artist", Album.Title as "Album Name"
FROM Album
RIGHT JOIN Artist ON Album.ArtistId=Artist.ArtistId;

/* Cross join album and artist; sort by artist name in ascending order */
SELECT Album.Title AS "Album Name", Artist.Name AS "Artist"
FROM Album
CROSS JOIN Artist WHERE Artist.ArtistId=Album.ArtistId
ORDER BY Artist.Name asc;

/* Self join employee table, joining on the reportsTo column */
SELECT E1.FirstName, E1.LastName, E2.ReportsTo
FROM Employee E1
LEFT JOIN Employee E2 ON E1.EmployeeID=E2.ReportsTo;




