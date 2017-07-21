/*Wei Huang*/

/*2.1 SELECT*/
SELECT * FROM Chinook.Employee;
SELECT * FROM Chinook.Employee WHERE LASTNAME LIKE 'King';
SELECT * FROM Chinook.Employee WHERE FIRSTNAME LIKE 'Andrew' AND REPORTSTO IS NULL;

/*2.2 ORDER BY*/
SELECT * FROM Chinook.Album ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM Chinook.Customer ORDER BY CITY ASC;

/*2.3 INSERT INTO*/
INSERT INTO Chinook.Genre (GenreId, Name) VALUES (88, 'Classical_Jazz');
INSERT INTO Chinook.Genre (GenreId, Name) VALUES (99, 'Soul Rock');
SELECT * FROM Chinook.Genre;

INSERT INTO Chinook.Employee (EmployeeId, FirstName, LastName) VALUES (88, 'Billy', 'Jean');
INSERT INTO Chinook.Employee (EmployeeId, FirstName, LastName) VALUES (99, 'Soul', 'Jazz');
SELECT * FROM Chinook.Employee;

INSERT INTO Chinook.Customer (CustomerId, FirstName, LastName, Email) VALUES (88, 'Bobby', 'Garb', 'BobbyGarb@gmail.com');
INSERT INTO Chinook.Customer (CustomerId, FirstName, LastName, Email) VALUES (99, 'Floozy', 'Joob', 'FloozyJoob213@gmail.com');
SELECT * FROM Chinook.Customer;

/*2.4 UPDATE*/
UPDATE Chinook.Customer SET FirstName = 'Robert', LastName = 'Walter' WHERE FirstName = 'Aaron' AND LastName = 'Mitchell';
UPDATE Chinook.Artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

/*2.5 LIKE*/
SELECT * FROM Chinook.Invoice WHERE BillingAddress LIKE 'T%';

/*2.6 BETWEEN*/
SELECT * FROM Chinook.Invoice WHERE total BETWEEN 15 AND 50;
SELECT * FROM Chinook.Employee WHERE HireDate BETWEEN '01-JUN-03' AND '01-MAR-04';

/*2.7 DELETE*/
ALTER TABLE Chinook.Invoice DROP CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM Chinook.Customer WHERE FirstName = 'Robert' AND LastName = 'Walter';