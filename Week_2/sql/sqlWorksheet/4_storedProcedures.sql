/* 4.0 Stored Procedures */
SET SERVEROUTPUT ON;

/* 4.1 Basic Stored Procedure */
/* Create stored procedure that selects first and last names of all employees */
CREATE OR REPLACE PROCEDURE getNamesOfEmployees
(
    res_cursor OUT SYS_REFCURSOR
)
    AS
    BEGIN
        OPEN res_cursor FOR
        SELECT FirstName, LastName
        FROM Employee;
    END;
/

/* 4.2 */
CREATE OR REPLACE PROCEDURE updateEmployeeInfo
(
    e_id IN NUMBER,
    new_firstName IN VARCHAR2,
    new_lastName IN VARCHAR2,
    res_cursor OUT SYS_REFCURSOR
)
    AS
    BEGIN
        UPDATE Employee
        SET FirstName=new_firstname,
            LastName=new_lastname
        WHERE employeeID=e_id;
        
        OPEN res_cursor FOR
            SELECT FirstName, LastName
            FROM Employee
            WHERE employeeID=e_id;
    END;
/

CREATE OR REPLACE PROCEDURE getManagersOfEmployee
(
    e_id IN NUMBER,
    res_cursor OUT SYS_REFCURSOR
)
    AS
    BEGIN
        OPEN res_cursor FOR
            SELECT A.FirstName, A.LastName, B.FirstName, B.LastName
            FROM Employee A
            LEFT JOIN Employee B ON A.EmployeeID=B.ReportsTo;
    END;
/

CREATE OR REPLACE PROCEDURE getCompanyNameOfCustomer
(
    c_id IN NUMBER,
    res_cursor OUT SYS_REFCURSOR
)
    AS
    BEGIN
        OPEN res_cursor FOR
            SELECT Company
            FROM Customer
            WHERE CustomerId=c_id;
    END;
/