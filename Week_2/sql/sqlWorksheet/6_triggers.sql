/* 6.0 Triggers */

SELECT Employee_Seq.NEXTVAL FROM Dual;
--SELECT Employee_Seq.CURRVAL FROM Dual;

CREATE OR REPLACE TRIGGER newEmployeeTrigger
    AFTER INSERT ON Employee
    FOR EACH ROW
    
    DECLARE
        v_eid NUMBER;
    
    BEGIN
        -- after a new employee is inserted in the table,
        -- get each employee Id
        SELECT EmployeeID INTO v_eid FROM Employee;
    END;
/

CREATE OR REPLACE TRIGGER newAlbumTrigger
    AFTER UPDATE ON Album
    FOR EACH ROW
    
    DECLARE
        v_albumId NUMBER;
    
    BEGIN
        -- after there is an update to the album table,
        -- get an album id
        SELECT AlbumID INTO v_albumId FROM Album;
    END;
/

CREATE OR REPLACE TRIGGER deletedCustomerTrigger
    AFTER DELETE ON Customer
    FOR EACH ROW
    
    DECLARE
        v_customerId NUMBER;
    
    BEGIN
        -- after a customer has been deleted,
        -- view the remaining customers
        SELECT CustomerId INTO v_customerId FROM Customer;
        
    END;
/

/* Create a view to be used in restricting deletion of invoices */
CREATE VIEW InvoiceTotals AS
SELECT Total
FROM Invoice;

CREATE OR REPLACE TRIGGER restrictInvoiceDelete
    INSTEAD OF DELETE ON InvoiceTotals
    FOR EACH ROW
    
    DECLARE
        v_total NUMBER(10,2);
    
    BEGIN
        -- instead of deleting an invoice,
        -- first check if the total is priced under 50.
        -- if it is, delete it

        SELECT Total INTO v_total FROM InvoiceTotals;
        
        IF (v_total < 50) THEN
            DELETE FROM InvoiceTotals
            WHERE v_total < 50;
        END IF;
    END;
/