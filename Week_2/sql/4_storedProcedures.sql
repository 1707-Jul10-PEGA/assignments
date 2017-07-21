/* 4.0 Stored Procedures */

/* 4.1 Basic Stored Procedure */
/* Create stored procedure that selects first and last names of all employees */
CREATE OR REPLACE PROCEDURE getNamesOfEmployees ()
    AS
        
    BEGIN
        SELECT FirstName AS "First Name", LastName AS "Last Name"
        FROM Employee;
        into 
    END getNamesOfEmployees;
/

SELECT FirstName AS "First Name"
        FROM Employee;