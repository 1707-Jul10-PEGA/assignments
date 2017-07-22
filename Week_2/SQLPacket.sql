/*2.1 select */
select * from Employee;
select * from Employee where LastName = 'King';
select * from Employee where FirstName = 'Andrew' AND REPORTSTO is NULL;

/*2.2 Order by */
select  * from ALBUM Order BY Title DESC;
select * from Customer ORDER BY City ASC;
/*2.3 Insert into*/
Insert into Genre values (26,'KPOP');
Insert into Genre values (27, 'JRock');
describe Employee;
INSERT INTO Employee (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, ADDRESS, CITY, STATE, COUNTRY, EMAIL) VALUES (9, 'Smith', 'Sam', 'General Manager', '1110 Some Street', 'Charlotte', 'NC', 'USA', 'samsmith@chinookcorp.com');
INSERT INTO Employee (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, ADDRESS, CITY, STATE, COUNTRY, EMAIL) VALUES (10, 'Panther', 'Pink', 'General Manager', '2200 That Street', 'Charlotte', 'NC', 'USA', 'pinkpanther@chinookcorp.com');
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Phone, Email) VALUES (60, 'Twain', 'Mark', 'Apple', '+1 703 855 3089', 'eduardo@woodstock.com.br');
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Phone, Email) VALUES (61, 'Panther', 'Pink', 'Pink Inc.', '+1 703 855 5555', 'pinkpanther@live.com');

/*2.4 UPDATE */
UPDATE CUSTOMER c set c.FirstName = 'Robert', c.LastName= 'Walter' where c.FirstName = 'Aaron' AND c.LastName = 'Mitchell';
UPDATE ARTIST A SET A.NAME = 'CCR' WHERE A.NAME='Creedence Clearwater Revival';

/*2.5 Like*/
select * from INVOICE I where I.BillingAddress like 'T%';

/*2.6 BETWEEN*/
select * from INVOICE I where I.TOTAL BETWEEN 15 AND 50;
select * from EMPLOYEE E where E.HIREDATE BETWEEN TO_DATE ('2003/06/01','yyyy/mm/dd') AND TO_DATE('2004/03/01','yyyy/mm/dd');

/*2.7 DELETE*/
ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
ALTER TABLE INVOICE ADD CONSTRAINT fk_CustomerInvoice FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID) ON DELETE CASCADE;
ALTER TABLE INVOICEline DROP CONSTRAINT FK_InvoiceLineInvoiceId;
ALTER TABLE INVOICELINE ADD CONSTRAINT fk_INVOICEINVOICELINE FOREIGN KEY (INVOICEID) REFERENCES INVOICE(INVOICEID) ON DELETE CASCADE;
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

/*3.1 SYSTEM DEFINED FUNCTIONS */
SET SERVEROUTPUT ON
CREATE OR REPLACE FUNCTION CURRENTTIME
    RETURN TIMESTAMP 
    IS  
    BEGIN
        RETURN CURRENT_TIMESTAMP;
    END;
    /
DECLARE
    d TIMESTAMP;
    BEGIN
        d := CURRENTTIME();
        DBMS_OUTPUT.PUT_LINE('CURRENT TIME: ' || d);
    END;
    /
    
CREATE OR REPLACE FUNCTION MEDIATYPE_LENGTH(THIS_ID NUMBER)
    RETURN NUMBER
    IS  
        name_len NUMBER := 0;
    BEGIN
        SELECT LENGTH(M.NAME) INTO name_len FROM MEDIATYPE M WHERE M.MEDIATYPEID = THIS_ID ;
        RETURN name_len;
    END;
    /
DECLARE
    d NUMBER;
    BEGIN
        d := MEDIATYPE_LENGTH(1);
        DBMS_OUTPUT.PUT_LINE('MEDIATYPE_LENGTH: ' || d);
    END;
    /

/* 3.2 */
CREATE OR REPLACE FUNCTION INVOICE_AVGTOTAL
    RETURN NUMBER
    IS  
        avg_total NUMBER := 0;
    BEGIN
        SELECT AVG(I.TOTAL) INTO avg_total FROM INVOICE I;
        RETURN avg_total;
    END;
    /
DECLARE
    d NUMBER;
    BEGIN
        d :=INVOICE_AVGTOTAL();
        DBMS_OUTPUT.PUT_LINE('INVOICE AVERAGE TOTAL: ' || d);
    END;
    /
SET SERVEROUTPUT ON 
drop function MaxTrackPrice;
CREATE OR REPLACE PROCEDURE MaxTrackPrice(row_ref OUT SYS_REFCURSOR) 
    AS
    BEGIN
        OPEN row_ref for 
        SELECT name, max(UNITPRICE) FROM TRACK T GROUP BY (T.NAME, UNITPRICE);

    END;
    /
    
    select MaxTrackPrice from dual;
DECLARE
    row_ref SYS_REFCURSOR;
    tname varchar(255);
    maxprice NUMBER;
    
    BEGIN
        MaxTrackPrice(row_ref);
        LOOP
            FETCH row_ref into name := tname, maxprice;
            EXIT WHEN row_ref%NOTFOUND;
            DBMS_OUTPUT.PUT_LINE('TRACK WITH THE MAX PRICE: ' || tname || ' Unit Price: ' || maxprice);
        END LOOP;
        CLOSE row_ref;
    END;
    /
    