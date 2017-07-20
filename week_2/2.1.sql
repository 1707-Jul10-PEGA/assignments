
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
    RETURN NUMBER IS
    str_length number;
    BEGIN
        str_lenght := LENGTH(str);
        RETURN str_length;
    END;
/
    
        
--Create a function that returns the length of a mediatype from the mediatype table


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
FROM artist art CROSS JOIN album alb
WHERE art.artistid = alb.artistid
ORDER BY art.name ASC;

--7.5
--Perform a self join on the employee table, joining the reportso column

--8.0 Indexes
--8.1 Clustered Indexes
--Create a clustered index on  a table og your choice


--9.0 Administration
--Create a bak file for te Chinook database
BACKUP DATABASE chinookDB TO DISK='C:\Users\ejchen\class-examples\SQL\chinook.bak';















