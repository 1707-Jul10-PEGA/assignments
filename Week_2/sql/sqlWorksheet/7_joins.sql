/* 7.0 Joins */

/* 7.1 Inner */
/* Inner join customers and orders and specifies name of customer and invoiceid */
SELECT FirstName, LastName, InvoiceId
FROM Customer
INNER JOIN Invoice ON Customer.CustomerId=Invoice.CustomerId;

/* 7.2 Outer */
/* Outer join customer and invoice, specifying CustomerId, first, ast, invoiceid, and total */
SELECT Customer.CustomerId, FirstName, LastName, InvoiceId, Total
FROM Customer
FULL OUTER JOIN Invoice ON Customer.CustomerId=Invoice.CustomerId;

/* 7.3 Right */
/* Right join album and artist specifying name and title */
SELECT Artist.Name AS "Artist", Album.Title as "Album Name"
FROM Album
RIGHT JOIN Artist ON Album.ArtistId=Artist.ArtistId;

/* 7.4 Cross */
/* Cross join album and artist; sort by artist name in ascending order */
SELECT Album.Title AS "Album Name", Artist.Name AS "Artist"
FROM Album
CROSS JOIN Artist WHERE Artist.ArtistId=Album.ArtistId
ORDER BY Artist.Name asc;

/* 7.5 Self */
/* Self join employee table, joining on the reportsTo column */
SELECT E1.FirstName, E1.LastName, E2.FirstName, E2.LastName
FROM Employee E1
LEFT JOIN Employee E2 ON E1.EmployeeID=E2.ReportsTo;