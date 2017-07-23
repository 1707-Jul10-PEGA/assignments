------------------------------------------------------------------------------
------------------------------------------------------------------------------
---------------PART I WORKING WITH AN EXISTING DATABASE-----------------------
------------------------------------------------------------------------------
------------------------------------------------------------------------------


--2.0 SQL Queries
    --2.1 SELECT
    --SELECT * FROM Employees; 
    --SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
    --SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
    
    --2.2 ORDER BY
    --SELECT * FROM ALBUM ORDER BY TITLE DESC;
    --SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;
    
    --2.3 INSERT INTO
        --2.3.1
        --INSERT INTO Genre (GenreId, Name) VALUES (101, 'Epic Music');
        --INSERT INTO Genre (GenreId, Name) VALUES (102, 'Programming Music');
        
        --2.3.2
        --INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (200, 'Delira', 'Martin', 'General Manager', TO_DATE('1990-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2015-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '7123 7th st', 'El Paso', 'TX', 'United States', 'T5K 2N1', '+1 (575) 428-9482', '+1 (915) 428-3457', 'martindelira@revature.com'); 
        --INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (200, 'Garcia', 'Xaviere', 'Manager', TO_DATE('1994-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2015-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '7123 7th st', 'Cd. Juarez', 'CH', 'Mexico', '2RF 2FF', '+1 (575) 656-9222', '+1 (915) 42-2337', 'xaviergarcia@revature.com'); 
    
        --2.3.3
        --INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (1001, 'Martin', 'Delira', 'Hardcore Coders Inc.', '12202 Railroad Dr.', 'El Paso', 'TX', 'United States', '79990', '+1 (575) 997-9483', '+1 (993) 112-3444', 'martindelira@hardcorecoder.com.br', 4); 
        --INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (1000, 'Jose', 'Delira', 'Softcore Coders Inc.', '890 Westwind Dr.', 'El Paso', 'TX', 'United States', '79920', '+1 (575) 127-1233', '+1 (223) 221-4444', 'josedelira@softcorecoder.com.br', 2); 
        
    --2.4 UPDATE
        --2.4.1
        --UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME='Mitchell';
        --UPDATE ARTIST SET NAME='CCR' WHERE NAME='Creedence Clearwater Revival';
    
    --2.5 LIKE
    --SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
    
    
    --2.6 BETWEEN
    --SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
    --SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('01-06-2003','dd-MM-YYYY') AND TO_DATE('01-03-2004','dd-MM-YYYY');
    
    --2.7 DELETE
    --HAD TO DROP THE FOREIGN KEY, RE-ADD THE CONSTRAINT WITH A DELETE CASCADE AND THEN DELETE THE RECORD.
    --ALTER TABLE CUSTOMER DROP CONSTRAINT FK_CUSTOMERSUPPORTREPID;
    --
    --ALTER TABLE CUSTOMER ADD 
    --   CONSTRAINT FK_CUSTOMERSUPPORTREPID 
    --      FOREIGN KEY (SupportRepId)
    --      REFERENCES Employee (EmployeeId)
    --      ON DELETE CASCADE;
    --      
    --DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--3.0 SQL FUNCTIONS
    --3.1 SYSTEM DEFINED FUNCTIONS
        --3.1.1 
        --CREATE OR REPLACE FUNCTION currentTime 
        --RETURN DATE
        --IS currentDate DATE;
        --BEGIN
        --currentDate := CURRENT_DATE;
        --RETURN currentDate;
        --END;
        
        --3.1.2
        --CREATE OR REPLACE FUNCTION lengthMediaType
        --RETURN NUMBER
        --IS NAMELENGTH NUMBER;
        --BEGIN
        --SELECT LENGTH(NAME) INTO NAMELENGTH FROM MEDIATYPE;
        --RETURN NAMELENGTH;
        --END;

    --3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
        --3.2.1
        --CREATE OR REPLACE FUNCTION getAvgTotalInvoices
        --return NUMBER
        --is average NUMBER;
        --BEGIN
        --SELECT AVG(TOTAL)INTO average FROM INVOICE;
        --return average;
        --END;

        --3.2.2
        --CREATE OR REPLACE FUNCTION getMostExpensiveTrack
        --return NUMBER
        --is maxPrice NUMBER;
        --BEGIN
        --SELECT MAX(UNITPRICE) INTO maxPrice FROM TRACK;
        --RETURN maxPrice;
        --END;


    --3.3 USER DEFINED SCALAR FUNCTIONS
        --3.3.1
        --CREATE OR REPLACE FUNCTION avgPriceInvoiceLineItems
        --RETURN NUMBER
        --IS avgPrice NUMBER;
        --BEGIN
        --SELECT AVG(UNITPRICE) INTO avgPrice FROM INVOICELINE;
        --RETURN avgPrice;
        --END;
    
    --3.4 USER DEFINED TABLE VALUED FUNCTIONS
        --3.4.1
        --COULD NOT FIGURE OUT




    

