/* 3.0 SQL Functions */

/* 3.1 System Defined Functions */
/* Create a function that returns the current time */
CREATE OR REPLACE FUNCTION getCurrentTime RETURN TIMESTAMP AS
BEGIN
    RETURN CURRENT_TIMESTAMP;
END getCurrentTime;
/
SELECT getCurrentTime FROM Dual;

/* Create a function that returns the length of a mediatype from the mediatype table */
CREATE OR REPLACE FUNCTION getMediaTypeLength(mt_id IN NUMBER)
    RETURN NUMBER AS
    mt_len NUMBER;
    BEGIN
        SELECT LENGTH(Name) INTO mt_len
        FROM MediaType
        WHERE MediaTypeId=mt_id;
        
        return mt_len;
    END getMediaTypeLength;
/
SELECT getMediaTypeLength(1) AS "Media Type Length" FROM Dual;

/* 3.2 System Defined Aggregate Functions */
/* Create a function that returns the average total of all invoices */
CREATE OR REPLACE FUNCTION getAverageTotal
    RETURN NUMBER AS
    invoice_avg NUMBER;
    BEGIN
        SELECT AVG(Total) INTO invoice_avg
        FROM Invoice;
        
        RETURN invoice_avg;
    END;
/
SELECT getAverageTotal AS "Average Total" FROM Dual;

/* Create a function that returns the most expensive track */
CREATE OR REPLACE FUNCTION getMostExpensiveTrack
    RETURN NUMBER AS
    highest_price NUMBER(10, 2);
    BEGIN
        SELECT MAX(UnitPrice) AS "Most Expensive Track" INTO highest_price
        FROM Track;
        
        RETURN highest_price;
    END;
/
SELECT NAME AS "Most Expensive Tracks", UnitPrice AS "Price"
FROM Track
WHERE UnitPrice=getMostExpensiveTrack;

/* 3.3 User Defined Scalar Functions */
/* Create function that returns average price of invoiceline items from invoiceline table */
CREATE OR REPLACE FUNCTION getAverageInvoiceLine
    RETURN NUMBER AS
    avg_invoice_line_price NUMBER;
    BEGIN
        SELECT AVG(UnitPrice) as "Average Invoice Line Price" INTO avg_invoice_line_price
        FROM InvoiceLine;
        
        RETURN avg_invoice_line_price;
    END;
/
SELECT getAverageInvoiceLine FROM Dual;

/* 3.4 User Defined Table Valued Functions */
/* Create function that returns all employees born after 1968 */
CREATE OR REPLACE FUNCTION getEmployeesBornAfter1968
    RETURN TABLE AS
    BEGIN
        SELECT FirstName AS "FirstName", LastName AS "LastName", BirthDate AS "Birth Date"
        FROM Employee
        WHERE BirthDate > '30-DEC-1967';
    END;
/
SELECT getEmployeesBornAfter1968 FROM Dual;