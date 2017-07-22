-- 2.1 Create Tables for Office Supply
CREATE TABLE Employees(
    EmployeeID NUMBER NOT NULL,
    UserName VARCHAR(20) NOT NULL,
    Password VARCHAR(20) NOT NULL,
    Name VARCHAR(25) NOT NULL,
    Department CHAR(2) NOT NULL,
    Manager NUMBER NOT NULL,
    CONSTRAINT PK_EmployeeID PRIMARY KEY  (EmployeeId)
    );
    
CREATE TABLE Orders(
    OrderID NUMBER NOT NULL,
    EmployeeID NUMBER NOT NULL ,
    OrderDate DATE NOT NULL,
    Status CHAR NOT NULL,
    CONSTRAINT PK_OrderID PRIMARY KEY (OrderID)
    );
    
CREATE TABLE OrderItem(
    OrderID NUMBER NOT NULL,
    ProductID NUMBER NOT NULL,
    Quantity NUMBER NOT NULL
    );

CREATE TABLE Category(
    CatID NUMBER NOT NULL,
    Name VARCHAR(80) NULL,
    Descript VARCHAR(255) NULL,
    CONSTRAINT PK_CatID PRIMARY KEY (CatID)
    );
    
CREATE TABLE Product(
    ProductID NUMBER NOT NULL,
    CatID NUMBER NOT NULL,
    Name VARCHAR(80) NULL,
    Descript VARCHAR(255) NULL,
    UnitCost NUMBER NULL,
    SuppID NUMBER NULL,
    CONSTRAINT PK_ProductID PRIMARY KEY (ProductID)
    );
    
CREATE TABLE Supplier(
    SuppID NUMBER NOT NULL,
    Name VARCHAR(80) NULL,
    CONSTRAINT PK_SuppID PRIMARY KEY (SuppID)
    );

--2.2 Creating relationships
--ALTER TABLE Orders
ALTER TABLE Orders ADD CONSTRAINT FK_EmployeeID FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID);

--ALTER TABLE OrderItem
ALTER TABLE OrderItem ADD CONSTRAINT FK_OrderID FOREIGN KEY (OrderID) REFERENCES Orders(OrderID);
ALTER TABLE OrderItem ADD CONSTRAINT FK_ProductID FOREIGN KEY (ProductID) REFERENCES Product(ProductID);

--ALTER TABLE PRODUCT
ALTER TABLE Product ADD CONSTRAINT FK_CatID FOREIGN KEY (CatID) REFERENCES Category(CatID);
ALTER TABLE Product ADD CONSTRAINT FK_SuppID FOREIGN KEY (SuppID) REFERENCES Supplier(SuppID);

-- 3.0 Performing SQL Queries (INSERTING THE TABLES)
--Employee table
INSERT INTO EMPLOYEES(EMPLOYEEID, USERNAME, PASSWORD, NAME, DEPARTMENT, MANAGER)
VALUES(1, 'dclark', 'drc', 'Dave', 'HR', 1);
INSERT INTO EMPLOYEES(EMPLOYEEID, USERNAME, PASSWORD, NAME, DEPARTMENT, MANAGER)
VALUES(2, 'jsmith', 'js', 'John', 'IT', 2);
INSERT INTO EMPLOYEES(EMPLOYEEID, USERNAME, PASSWORD, NAME, DEPARTMENT, MANAGER)
VALUES(3, 'mjones', 'mj', 'Mike', 'HR', 2);
INSERT INTO EMPLOYEES(EMPLOYEEID, USERNAME, PASSWORD, NAME, DEPARTMENT, MANAGER)
VALUES(4, 'klink', 'kl', 'Kara', 'IT', 1);
--Supplier table
INSERT INTO SUPPLIER(SUPPID, NAME)
VALUES (1, 'XYZ Office supplies');
INSERT INTO SUPPLIER(SUPPID, NAME)
VALUES(2, 'ABC Office products');
--Category table
INSERT INTO CATEGORY(CATID, NAME)
VALUES(1, 'Audio Visual');
INSERT INTO CATEGORY(CATID, NAME)
VALUES(2, 'Art Supplies');
INSERT INTO CATEGORY(CATID, NAME)
VALUES(3, 'Cleaning Supplies');
INSERT INTO CATEGORY(CATID, NAME)
VALUES(4, 'Computer Supplies');
INSERT INTO CATEGORY(CATID, NAME)
VALUES(5, 'Desk Accessories');
INSERT INTO CATEGORY(CATID, NAME)
VALUES(6, 'Writing Supplies');
INSERT INTO CATEGORY(CATID, NAME)
VALUES(7, 'Printer Supplies');
--Product table
INSERT INTO PRODUCT(PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
VALUES(1, 2, 'Ruler', '12 inch stainless steel', 3.79, 2);
INSERT INTO PRODUCT(PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
VALUES(2, 1, 'Transparency', 'Quick dry ink jet', 24.49, 1);
INSERT INTO PRODUCT(PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
VALUES(3, 1, 'Overhead Bulb', 'High intensity replacement bulb', 12.00, 1);
INSERT INTO PRODUCT(PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
VALUES(4, 1, 'Laser Pointer', 'General purpose laser pointer', 29.99, 2);
INSERT INTO PRODUCT(PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
VALUES(5, 2, 'Colored pencils', 'Non toxic 12 pack', 2.84, 1);
INSERT INTO PRODUCT(PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
VALUES(6, 3, 'All purpose cleaner', 'Use on all washable surfaces', 4.29, 2);
INSERT INTO PRODUCT(PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
VALUES(7, 3, 'Paper hand towels', '320 sheets per roll', 5.25, 1);
INSERT INTO PRODUCT(PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
VALUES(8, 4, 'CD-R', '700 mb with jewel case', 1.09, 1);
INSERT INTO PRODUCT(PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
VALUES(9, 4, '3.5 inch disks', 'High density formatted box of 10', 5.99, 1);
INSERT INTO PRODUCT(PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
VALUES(10, 4, 'Monitor wipes', 'Non abrasive lint free', 6.99, 2);
INSERT INTO PRODUCT(PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
VALUES(11, 4, 'Dust blaster', 'Ozone safe no CFSs', 8.99, 2);
INSERT INTO PRODUCT(PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
VALUES(12, 2, 'Clear tape', '1 inch wide 6 rolls', 3.90, 1);
INSERT INTO PRODUCT(PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
VALUES(13, 1, 'Overhead projector', 'Portable with travel cover', 759.97, 1);
INSERT INTO PRODUCT(PRODUCTID, CATID, NAME, DESCRIPT, UNITCOST, SUPPID)
VALUES(14, 2, 'Glue stick', 'Odorless non toxic', 1.99, 2);

-- 3.1 SELECT
SELECT * FROM employees;
SELECT * FROM employees WHERE department='HR';
SELECT * FROM employees WHERE username='jsmith' AND department='HR';
SELECT * FROM employees WHERE manager=1 OR department='HR';

-- 3.2 ORDER BY
SELECT name FROM product ORDER BY name ASC;
SELECT name FROM product ORDER BY name DESC;
SELECT * FROM Category ORDER BY name;

-- 3.3 INSERT INTO
INSERT INTO Employees(EmployeeID, Username, Password, Name, Department, Manager)
    VALUES(5, 'TSong', 'password', 'Tae', 'HR', 2);
INSERT INTO Category(CatID, Name)
    VALUES(8, 'Dogfood');
INSERT INTO Supplier(SuppID, Name)
    VALUES(3, 'Petsmart');
INSERT INTO Supplier(SuppID, Name)
    VALUES(4, 'Petsdumb');
INSERT INTO Supplier(SuppID, Name)
    VALUES(5, 'Petco');

-- 3.4 Update
UPDATE Product SET UnitCost=3.44 WHERE name='Ruler';
UPDATE Category SET Descript='Supplies for Computers' WHERE name='Computer Supplies';
UPDATE Category SET Descript='Supplies for Cleaning' WHERE name ='Cleaning Supplies';

-- 3.5 Like
SELECT username FROM Employees WHERE username LIKE 'j%';
SELECT name FROM product WHERE name LIKE 'O%';

-- 3.6 Between
SELECT name from Product WHERE UnitCost BETWEEN 3 AND 10;
SELECT name from Product WHERE UnitCost BETWEEN 500 AND 800;

-- 3.7 Delete
UPDATE Product SET CatID=6 WHERE CatID=1; --This update needed for bypassing constraint
DELETE FROM Category WHERE name='Audio Visual';
DELETE FROM Supplier WHERE SuppID=3 OR SuppID=4 OR SuppID=5;

-- 4.1 System Defined Scalar Functions
--Using system-provided functions..
SELECT LENGTH(Descript) FROM Product WHERE name='Laser Pointer';
SELECT UPPER(username) FROM Employees WHERE username='jsmith';

-- 4.2 System Defnied Aggregate Functions
--Using system-provided functions..
SELECT SUM(UnitCost) FROM Product;
SELECT COUNT(*) "Count of all products" FROM Product;

-- 4.3 User Defined Scalar Functions
CREATE OR REPLACE Function sumProducts(val1 IN NUMBER, val2 IN NUMBER)
    RETURN NUMBER IS vreturn NUMBER;
    BEGIN
        SELECT val1 + val2 INTO vreturn FROM DUAL;
        RETURN vreturn;
        --SELECT INTO SUM(UnitCost) FROM Product WHERE UnitCost=val1 OR UnitCost=val2;
    END;
/
SELECT sumProducts(A.UnitCost, B.UnitCost) FROM Product A, Product B WHERE A.UnitCost=24.49 AND B.UnitCost=29.99;

-- 4.4 User Defined Table Valued Functions
CREATE OR REPLACE FUNCTION isManager(f_username IN VARCHAR)
    RETURN VARCHAR IS vreturn VARCHAR(255);
    tester NUMBER;
    BEGIN
        SELECT Manager INTO tester FROM Employees WHERE username=f_username; 
        IF tester = 2 THEN
            SELECT 'This username belong to a Manager' INTO vreturn FROM DUAL;
        ELSE
            SELECT 'This username does not belong to a Manager' INTO vreturn FROM DUAL;
        END IF;
        RETURN vreturn;
    END;
/
SELECT isManager(username) FROM Employees WHERE username='jsmith';

-- 5.1 Basic Stored Procedure
CREATE OR REPLACE PROCEDURE getEmployeeInfo (mycursor OUT SYS_REFCURSOR) AS
BEGIN
    OPEN mycursor FOR SELECT username, department, manager FROM Employees;
END;
/
variable rc refcursor;
EXECUTE getEmployeeInfo(:rc);
print rc;

CREATE OR REPLACE PROCEDURE getProductInfo(mycursor OUT SYS_REFCURSOR) AS
BEGIN
    OPEN mycursor FOR SELECT name, UnitCost manager FROM Product;
END;
/
variable rc refcursor;
EXECUTE getProductInfo(:rc);
print rc;

-- 5.2 Stored Procedure Input Parameters
set Serveroutput on

CREATE OR REPLACE PROCEDURE getProduct(p_productid IN NUMBER, p_productname OUT VARCHAR, p_productdescription OUT VARCHAR) AS
BEGIN
    SELECT name INTO p_productname FROM Product WHERE ProductID=p_productid;
    SELECT Descript INTO p_productdescription FROM Product WHERE ProductID=p_productid;
END;
/
DECLARE
    outputName VARCHAR(255);
    outputDescription VARCHAR(255);
BEGIN
    getProduct(2, outputName, outputDescription);
    DBMS_OUTPUT.PUT_LINE('Name              ' || 'Description');
    DBMS_OUTPUT.PUT_LINE('-----------------------------------');
    DBMS_OUTPUT.PUT_LINE(outputName || '      ' || outputDescription);
END;
/

CREATE OR REPLACE PROCEDURE insertManager(p_employeeid IN NUMBER, p_username IN VARCHAR, p_password IN VARCHAR, p_name IN VARCHAR, p_department IN CHAR) AS
BEGIN
    INSERT INTO Employees(EmployeeID, Username, Password, Name, Department, Manager) VALUES (p_employeeid, p_username, p_password, p_name, p_department, 2);
END;
/
EXECUTE insertManager(6, 'TSong1', 'password1', 'TaeS', 'HR');

-- 5.3 Stored Procedure Output Parameters
Set Serveroutput On

CREATE OR REPLACE PROCEDURE calculateProductSum(outSum OUT NUMBER) AS
BEGIN
    SELECT SUM(UnitCost) INTO outSum FROM Product;
END;
/

DECLARE
    sumNumber NUMBER;
BEGIN
    calculateProductSum(sumNumber);
    DBMS_OUTPUT.PUT_LINE(sumNumber);
END;
/

-- 6.0 Transactions
--Use Any Example of my procedure to make the nested transactions
CREATE OR REPLACE PROCEDURE insertEmployee(p_employeeid IN NUMBER, p_username IN VARCHAR, p_password IN VARCHAR, p_name IN VARCHAR, p_department IN CHAR) AS
BEGIN
    commit;
    Set Transaction Name 'Part2 6.0 insert employee';
    INSERT INTO Employees(EmployeeID, Username, Password, Name, Department, Manager) VALUES (p_employeeid, p_username, p_password, p_name, p_department, 1);
    commit;
END;
/

--Use Any Example of my procedure to make the nested transactions
CREATE OR REPLACE PROCEDURE updateUnitPrice(p_productid IN NUMBER, p_unitcost IN NUMBER) AS
BEGIN
    commit;
    SET TRANSACTION NAME 'PART2 6.0 update product';
    UPDATE Product SET UnitCost='p_unitcost' WHERE ProductID=p_productid;
    commit;
END;
/

--Use Any Example of my procedure to make the nested transactions
CREATE OR REPLACE PROCEDURE updateTwoCategory(p_catid IN NUMBER, p_name IN VARCHAR, p_descript IN VARCHAR, p_catid1 IN NUMBER, p_name1 IN VARCHAR, p_descript1 IN VARCHAR) AS
BEGIN
    commit;
    SET TRANSACTION NAME 'PART2 6.0 update 2 records in 1 transaction';
    UPDATE Category SET Name=p_name, Descript=p_descript WHERE CatID=p_catid;
    UPDATE Category SET Name=p_name1, Descript=p_descript1 WHERE CatID=p_catid1;
    commit;
END;
/

-- 7.1 After/For Triggers
set serveroutput on

CREATE OR REPLACE TRIGGER OfficeAfterInsert
    AFTER INSERT ON Category
    FOR EACH ROW
    BEGIN
        DBMS_OUTPUT.PUT_LINE('After Insert Trigger Fired');
    END;
/
CREATE OR REPLACE TRIGGER OfficeAfterUpdate
    AFTER UPDATE ON Category
    FOR EACH ROW
    BEGIN
        DBMS_OUTPUT.PUT_LINE('After Update Trigger Fired');
    END;
/
CREATE OR REPLACE TRIGGER OfficeAfterDelete
    AFTER DELETE ON Category
    FOR EACH ROW
    BEGIN
        DBMS_OUTPUT.PUT_LINE('After Delete Trigger Fired');
    END;
/
BEGIN
    INSERT INTO Category(CatID, Name) VALUES(9, 'Catfood');
    UPDATE Category SET Name='Fishfood' WHERE Name='Catfood';
    DELETE FROM Category WHERE CatID=9;
    DBMS_OUTPUT.PUT_LINE('TESTING AFTER TRIGGERS ON CATEGORY TABLE');
END;
/

-- 7.2 Instead of Triggers
CREATE OR REPLACE VIEW productVIEW AS SELECT * FROM Product;
/
CREATE OR REPLACE TRIGGER InsteadOfDeleteProduct
    INSTEAD OF DELETE ON productView
    FOR EACH ROW
    BEGIN
        IF (To_Number(:old.UnitCost, '99.99') < 500.00) THEN
            DELETE FROM productView WHERE ProductID=:old.ProductID;
        END IF;
    END;
/

-- 8.1 Inner Join
--This example shows a customized join query, rest of the querys will simply join on all columns
SELECT A.productid, A.catid, A.name AS PRODUCTNAME, A.descript, A.unitcost, A.suppid, B.name AS CATEGORYNAME, B.descript FROM Product A INNER JOIN Category B ON A.CatID=B.CatID;
SELECT * FROM Employees INNER JOIN Orders ON Orders.EmployeeID=Employees.EmployeeID; --The packet has the orders table as empty so no results are shown

-- 8.2 Outer Join
SELECT * FROM Product FULL OUTER JOIN OrderItem ON OrderItem.ProductID=Product.ProductID;
SELECT * FROM Employees FULL OUTER JOIN Orders ON Orders.EmployeeID=Employees.EmployeeID;

-- 8.3 Right Join
SELECT * FROM OrderItem RIGHT JOIN Orders ON OrderItem.ORDERID=Orders.ORDERID; -- doesn't return any rows because both tables are empty as per sql packet
SELECT * FROM Orders RIGHT JOIN Employees ON Orders.EMPLOYEEID=Employees.EMPLOYEEID;

-- 8.4 Left Join
SELECT * FROM Product LEFT JOIN Category ON Product.CATID=Category.CATID;
SELECT * FROM Employees RIGHT JOIN Orders ON Orders.EMPLOYEEID=Employees.EMPLOYEEID; -- doesn't  return any rows because orders table is empty as per sql packet

-- 8.5 Cross Join
SELECT * FROM Product CROSS JOIN Category;

-- 8.6 Self Join
SELECT * FROM Product A, Product B WHERE A.Name<>B.Name AND A.catid = B.catid ORDER BY A.catid;

-- 9.0 Views
ALTER TABLE Employees ADD SSN NUMBER;
ALTER TABLE Employees ADD Salary NUMBER;
CREATE OR REPLACE VIEW NoSSNSalary AS SELECT employeeid, username, password, name, department, manager FROM Employees;

CREATE OR REPLACE VIEW OnlyProductNameDescription AS SELECT Name, Descript FROM Product;

-- 10.1 Clustered Indexes
CREATE CLUSTER empOffice (deptno NUMBER(3))
   SIZE 600
   TABLESPACE users
   STORAGE (INITIAL 200K
      NEXT 300K
      MINEXTENTS 2
      PCTINCREASE 33);
      
CREATE INDEX emp_Office_index
   ON CLUSTER empOffice
   TABLESPACE users
   STORAGE (INITIAL 50K
      NEXT 50K
      MINEXTENTS 2
      MAXEXTENTS 10
      PCTINCREASE 33);

-- 11.0 Administration
--Created a back up file of the OfficeSupply Database and submitted the back up file