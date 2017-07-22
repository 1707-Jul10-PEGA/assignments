/* 6.0 Transactions */

CREATE OR REPLACE PROCEDURE insertNewEmployee
(
    v_eid IN NUMBER,
    v_user IN VARCHAR2,
    v_pass IN VARCHAR2,
    v_name IN VARCHAR2,
    v_dept IN VARCHAR2,
    v_man IN NUMBER,
    rs_cursor OUT SYS_REFCURSOR
)
    AS
    BEGIN
        INSERT INTO Employees
        (Employeeid, Username, Password, Name, Department, Manager)
        VALUES(v_eid, v_user, v_pass, v_name, v_dept, v_man);
        
        OPEN rs_cursor FOR
            SELECT *
            FROM Employees;
    END;
/

CREATE OR REPLACE PROCEDURE updateUnitCost
(
    v_cost IN NUMBER,
    rs_cursor OUT SYS_REFCURSOR
)
    AS
    BEGIN
        UPDATE Product
        SET UnitCost = v_cost;
        
        OPEN rs_cursor FOR
            SELECT *
            FROM Product;
    END;
/

CREATE OR REPLACE PROCEDURE updateTwoCats
(
    v_cat1 IN NUMBER,
    v_cat2 IN NUMBER,
    rs_cursor OUT SYS_REFCURSOR
)
    AS
    BEGIN
        UPDATE Category
        SET Descript='changed first'
        WHERE CatId=v_cat1;
        
        UPDATE Category
        SET Descript='changed second'
        WHERE CatId=v_cat2;
        
        OPEN rs_cursor FOR
            SELECT *
            FROM Category;
    END;
/