/* 5.0 Transactions */

CREATE OR REPLACE PROCEDURE deleteInvoiceId 
(
    del_invoiceID IN NUMBER,
    rs_cursor OUT SYS_REFCURSOR
)
    AS
    BEGIN
        DELETE FROM Invoice
        WHERE InvoiceId=del_invoiceID;
        
        OPEN rs_cursor FOR
            SELECT InvoiceId
            FROM Invoice;
    END;
/

CREATE OR REPLACE PROCEDURE insertNewCustomer
(
    new_cId IN NUMBER,
    new_cFirst IN VARCHAR2,
    new_cLast IN VARCHAR2,
    new_cEmail IN VARCHAR2,
    rs_cursor OUT SYS_REFCURSOR
)
    AS
    BEGIN
        INSERT INTO Customer (CustomerId, FirstName, LastName, Email)
        VALUES (new_cId, new_cFirst, new_cLast, new_cEmail);
        
        OPEN rs_cursor FOR
            SELECT CustomerId
            FROM Customer;
        
    END;
/