/* Initialize sequence and triggers */

-- Sequences
CREATE SEQUENCE Users_Seq
    MINVALUE 1
    MAXVALUE 9999
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE ApplicationRequests_Seq
    MINVALUE 1
    MAXVALUE 9999
    START WITH 1
    INCREMENT BY 1;
    
-- Triggers
CREATE OR REPLACE TRIGGER New_Users_Trigger
    BEFORE INSERT ON Users
    FOR EACH ROW
    BEGIN
        SELECT Users_Seq.NEXTVAL INTO :new.U_ID FROM Dual;
    END;
/

CREATE OR REPLACE TRIGGER New_Customers_Trigger
    BEFORE INSERT ON Customers
    FOR EACH ROW
    BEGIN
        SELECT Users_Seq.CURRVAL INTO :new.C_ID FROM Dual;
    END;
/

CREATE OR REPLACE TRIGGER New_Employees_Trigger
    BEFORE INSERT ON Employees
    FOR EACH ROW
    BEGIN
        SELECT Users_Seq.CURRVAL INTO :new.E_ID FROM Dual;   
    END;
/

CREATE OR REPLACE TRIGGER New_ApplicationRequests_Trigger
    BEFORE INSERT ON ApplicationRequests
    FOR EACH ROW
    BEGIN
        SELECT ApplicationRequests_Seq.NEXTVAL INTO :new.A_ID FROM Dual;   
    END;
/