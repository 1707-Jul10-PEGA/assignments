/* 8.0 Joins */

/* 8.1 Inner Join */
SELECT *
FROM Product
INNER JOIN Category ON Product.CatId=Category.CatId;

SELECT *
FROM Employees
INNER JOIN Orders ON Employees.EmployeeId=Orders.EmployeeId;

/* 8.2 Outer Join */
SELECT *
FROM Product
FULL OUTER JOIN OrderItem ON Product.ProductId=OrderItem.ProductId;

SELECT *
FROM Employees
FULL OUTER JOIN Orders ON Employees.EmployeeId=Orders.EmployeeId;

/* 8.3 Right Join */
SELECT *
FROM Orders
RIGHT JOIN OrderItem ON Orders.OrderId=OrderItem.OrderId;

SELECT *
FROM Product
LEFT JOIN OrderItem ON OrderItem.ProductId=Product.ProductId;

/* 8.4 Left Join */
SELECT *
FROM Product
LEFT JOIN Category ON Product.CatId=Category.CatId;

SELECT *
FROM Orders
LEFT JOIN Employees ON Orders.EmployeeId=Employees.EmployeeId;

SELECT *
FROM Orders;

/* 8.5 Cross Join */
SELECT *
FROM Product
CROSS JOIN Category;

/* 8.6 Self Join */
SELECT A.Name, B.Username
FROM Employees A, Employees B
WHERE A.Name=B.Name;