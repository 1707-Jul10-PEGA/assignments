/* 3.0 Performing SQL Queries */

/* Employee Table */
INSERT INTO Employees VALUES(1, 'dclark', 'drc', 'clark', 'HR', 0);
INSERT INTO Employees VALUES(2, 'jsmith', 'js', 'smith', 'IT', 1);
INSERT INTO Employees VALUES(3, 'mjones', 'mj', 'jones', 'HR', 1);
INSERT INTO Employees VALUES(4, 'klink', 'kl', 'link', 'IT', 0);

/* Supplier Table */
INSERT INTO Supplier VALUES(1, 'XYZ Office Supplies');
INSERT INTO Supplier VALUES(2, 'ABC Office Supplies');

/* Category Table */
INSERT INTO Category VALUES(1, 'Audio Visual', NULL);
INSERT INTO Category VALUES(2, 'Art Supplies', NULL);
INSERT INTO Category VALUES(3, 'Cleaning Supplies', NULL);
INSERT INTO Category VALUES(4, 'Computer Supplies', NULL);
INSERT INTO Category VALUES(5, 'Desk Accessories', NULL);
INSERT INTO Category VALUES(6, 'Writing Supplies', NULL);
INSERT INTO Category VALUES(7, 'Printer Supplies', NULL);


/* Product Table*/
INSERT INTO Product VALUES(1, 2, 'Ruler', '12 inch stainless steel', 3.79, 2);
INSERT INTO Product VALUES(2, 1, 'Transparency', 'Quick dry ink jet', 24.49, 1);
INSERT INTO Product VALUES(3, 1, 'Overhead Bulb', 'High intensity replacement bulb', 12.00, 1);
INSERT INTO Product VALUES(4, 1, 'Laser Pointer', 'General purpose laster pointer', 29.99, 2);
INSERT INTO Product VALUES(5, 2, 'Colored Pencils', 'Non toxic 12 pack', 2.84, 1);
INSERT INTO Product VALUES(6, 3, 'All-Purpose Cleaner', 'Use on all washable surfaces', 4.29, 2);
INSERT INTO Product VALUES(7, 3, 'Paper Hand Towels', '320 sheets per roll', 5.25, 1);
INSERT INTO Product VALUES(8, 4, 'CD-R', '700 mb with jewel case', 1.09, 1);
INSERT INTO Product VALUES(9, 4, '3.5 Inch Disks', 'High desity formatted box of 10', 5.99, 1);
INSERT INTO Product VALUES(10, 4, 'Monitor Wipes', 'Non abrasive lint free', 6.99, 2);
INSERT INTO Product VALUES(11, 4, 'Dust Blaster', 'Ozone safe no CFCs', 8.99, 2);
INSERT INTO Product VALUES(12, 2, 'Clear Tape', '1 inch wide 6 rolls', 3.90, 1);
INSERT INTO Product VALUES(13, 1, 'Overhead Projector', 'Portable with travel cover', 759.97, 1);
INSERT INTO Product VALUES(14, 2, 'Glue Stick', 'Odorless non toxic', 1.99, 2);

/* 3.1 Select */
SELECT *
FROM Employees;

SELECT *
FROM Employees
WHERE Department='HR';

SELECT *
FROM Employees
WHERE Username='jsmith' AND Department='HR';

SELECT *
FROM Employees
WHERE Manager=1 OR Department='HR';

/* 3.2 Order By */
SELECT Name
FROM Product
ORDER BY Name asc;

SELECT Name
FROM Product
ORDER BY Name desc;

SELECT *
FROM Category
ORDER BY Name;

/* 3.3 Insert Into */
INSERT INTO Employees VALUES(5, 'irashad', 'zayw', 'isaiah', 'IT', 0);
INSERT INTO Category VALUES(8, 'Food', NULL);
INSERT INTO Supplier VALUES(3, 'DEF Supplies');
INSERT INTO Supplier VALUES(4, 'GHI Supplies');
INSERT INTO Supplier VALUES(5, 'JKL Supplies');

/* 3.4 Update */
UPDATE Product
SET UnitCost=4.56
WHERE Name='Ruler';

UPDATE Category
SET Descript='Household cleaning supplies'
WHERE CatId=3;

UPDATE Category
SET Descript='Keyboards, monitors, other accessories'
WHERE CatId=4;

/* 3.5 Like */
SELECT Username
FROM Employees
WHERE Username LIKE 'j%';

SELECT Name
FROM Product
WHERE Name LIKE 'O%';

/* 3.6 Between */
SELECT Name AS "Item", UnitCost AS "Price"
FROM Product
WHERE UnitCost BETWEEN 3 AND 10;

SELECT Name AS "Item", UnitCost AS "Price"
FROM Product
WHERE UnitCost BETWEEN 500 AND 800;

/* 3.7 Delete */
DELETE FROM Category
WHERE Name='Audio Visual';

DELETE FROM Category
WHERE CatId=3;

DELETE FROM Category
WHERE CatId=4;

DELETE FROM Category
WHERE CatId=5;

COMMIT;