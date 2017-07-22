/* 5.0 Stored Procedures */

SET SERVEROUT ON;

CREATE OR REPLACE PROCEDURE getEmployees
(
    rs_cursor OUT SYS_REFCURSOR
)
    AS
    BEGIN
        OPEN rs_cursor FOR
        SELECT Username, Department, Manager
        FROM Employees;
    END;
/

CREATE OR REPLACE PROCEDURE getProducts
(
    rs_cursor OUT SYS_REFCURSOR
)
    AS
    BEGIN
        OPEN rs_cursor FOR
        SELECT Name, UnitCost
        FROM Product;
    END;
/

CREATE OR REPLACE PROCEDURE getInfoFromProduct
(
    v_pid IN NUMBER,
    rs_cursor OUT SYS_REFCURSOR
)
    AS
    BEGIN
        OPEN rs_cursor FOR
            SELECT Name, Descript
            FROM Product
            WHERE ProductId = v_pid;
    END;
/

CREATE OR REPLACE PROCEDURE insertNewManager
(
    v_eid IN NUMBER,
    v_username IN VARCHAR2,
    v_password IN VARCHAR2,
    v_name IN VARCHAR2,
    v_dept IN VARCHAR2
)
    AS
    BEGIN
        INSERT INTO Employees 
        (EmployeeID, UserName, Password, Name, Department, Manager)
        VALUES
        (v_eid, v_username, v_password, v_name, v_dept, 1);
    END;
/

CREATE OR REPLACE PROCEDURE getTotalUnitCost
(
    rs_cursor OUT SYS_REFCURSOR
)
    AS
    BEGIN
        OPEN rs_cursor FOR
            SELECT SUM(UnitCost)
            FROM Product;
    END;
/

CREATE OR REPLACE PROCEDURE getEInfo
(
    v_eid IN NUMBER,
    rs_cursor OUT SYS_REFCURSOR
)
    AS
    BEGIN
        OPEN rs_cursor FOR
            SELECT Username, Password
            FROM Employees
            WHERE EmployeeId=v_eid;
    END;
/