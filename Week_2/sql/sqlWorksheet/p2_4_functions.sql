/* 4.0 Functions */
SET SERVEROUT ON;

/* 4.1 */
CREATE OR REPLACE FUNCTION getLengthOfDescription
RETURN NUMBER AS
    descriptionLength NUMBER;
    
    BEGIN
        SELECT LENGTH(Descript) INTO descriptionLength
        FROM Product
        WHERE Name='Laser Pointer';
        
        RETURN descriptionLength;
    END;
/
DECLARE
    descriptionLength NUMBER;
    BEGIN
        descriptionLength := getLengthOfDescription();
        DBMS_OUTPUT.PUT_LINE('Length of Laser Pointer description: ' || descriptionLength);
    END;
/

CREATE OR REPLACE FUNCTION usernameToUpper(user IN VARCHAR2)
RETURN VARCHAR2 AS
    upperUsername VARCHAR2(20);
    
    BEGIN
        SELECT UPPER(UserName) INTO upperUsername
        FROM Employees
        WHERE UserName=user;
        
        RETURN upperUsername;
    END;
/
DECLARE
    upperUsername VARCHAR2(20);
    BEGIN
        upperUsername := usernameToUpper('dclark');
        DBMS_OUTPUT.PUT_LINE('dclark to: ' || upperUsername);
    END;
/

CREATE OR REPLACE FUNCTION getSumOfUnitPrice
RETURN NUMBER AS
    sumOfUnitPrice NUMBER;
    
    BEGIN
        SELECT SUM(UnitCost) INTO sumOfUnitPrice
        FROM Product;
        
        RETURN sumOfUnitPrice;
    END;
/
DECLARE
    sumOfUnitPrice NUMBER;
    
    BEGIN
        sumOfUnitPrice := getSumOfUnitPrice;
        DBMS_OUTPUT.PUT_LINE('Sum of unit prices: ' || sumOfUnitPrice);
    END;
/

CREATE OR REPLACE FUNCTION getNumProducts
RETURN NUMBER AS
    totalProducts NUMBER;
    
    BEGIN
        SELECT COUNT(ProductID) INTO totalProducts
        FROM Product;
        
        RETURN totalProducts;
    END;
/
DECLARE
    totalProducts NUMBER;
    
    BEGIN
        totalProducts := getNumProducts;
        DBMS_OUTPUT.PUT_LINE('Total number of products: ' || totalProducts);
    END;
/

CREATE OR REPLACE FUNCTION getCost(p1 IN NUMBER, p2 IN NUMBER)
RETURN NUMBER AS
    total NUMBER;
    p1Price NUMBER;
    p2Price NUMBER;
    
    BEGIN
        SELECT (UnitCost) INTO p1Price
        FROM Product
        WHERE ProductID=p1;
        
        SELECT (UnitCost) INTO p2Price
        FROM Product
        WHERE ProductID=p2;
        
        total := p1Price + p2Price;
        
        RETURN total;
           
    END;
/
DECLARE
    total NUMBER;
    
    BEGIN
        total := getCost(1, 2);
        DBMS_OUTPUT.PUT_LINE('Total cost of first 2 products: ' || total);
    END;
/



