
------------------------------------------------------------------------------
------------------------------------------------------------------------------
--------PART II: CREATING AND WORKING WITH YOUR OWN CUSTOM DATABASE-----------
------------------------------------------------------------------------------
------------------------------------------------------------------------------

--1.0 CREATING THE OFFICESUPPLY DATABASE
    --1.1 Create a company database using SSMS Interface
        --1.1.1 /*******************************************************************************
    
        --1.1.2
        --DROP USER OfficeSupply CASCADE;
        --commit;
        
    --1.2 CREATE COMPANY DATABASE USING DDL
--        CREATE USER OfficeSupply
--        IDENTIFIED BY officepassword
--        DEFAULT TABLESPACE users
--        TEMPORARY TABLESPACE temp
--        QUOTA 10M ON users;
--        
--        GRANT connect to OfficeSupply;
--        GRANT resource to OfficeSupply;
--        GRANT create session TO OfficeSupply;
--        GRANT create table TO OfficeSupply;
--        GRANT create view TO OfficeSupply;
--        
--        conn OfficeSupply/officepassword
--        
--        commit;

--2.0 CREATING TABLES AND RELATIONSHIPS
    --2.1 CREATES TABLES FOR OFFICESUPPLY
        --2.1.1
        --CREATE TABLE Employees
        --(
        --EmployeeId NUMBER NOT NULL,
        --UserName VARCHAR(20) NOT NULL,
        --Password VARCHAR(20) NOT NULL,
        --Name VARCHAR(25) NOT NULL,
        --Department CHAR(2) NOT NULL,
        --Manager NUMBER NOT NULL,
        --CONSTRAINT PK PRIMARY KEY (EmployeeId)
        --);
        -- commit;
        
        --2.1.2
        --CREATE TABLE ORDERS
        --(
        --OrderID NUMBER NOT NULL,
        --EmployeeID NUMBER NOT NULL,
        --OrderDate DATE NOT NULL,
        --Status CHAR NOT NULL,
        --CONSTRAINT PK_ORDERID PRIMARY KEY (OrderID),
        --CONSTRAINT FK_ORDERID_EMPLOYEEID FOREIGN KEY (EmployeeID)
        --REFERENCES employees (Employeeid) ON DELETE CASCADE
        --);
        
        --2.1.3
--        CREATE TABLE ORDER_ITEM
--        (
--        ORDERID NUMBER NOT NULL,
--        PRODUCTID NUMBER NOT NULL,
--        QUANTITY NUMBER NOT NULL,
--        CONSTRAINT PK_ORDERID_ORDERITEM PRIMARY KEY (PRODUCTID, ORDERID),
--        CONSTRAINT FK_ORDERID_ORDERITEM FOREIGN KEY (ORDERID) REFERENCES ORDERS (ORDERID),
--        CONSTRAINT FK_PRODUCTID_ORDERITEM FOREIGN KEY (PRODUCTID)REFERENCES PRODUCT (PRODUCTID)
--        );

        --2.1.4
        --CREATE TABLE CATEGORY 
        --(
        --CATID NUMBER NOT NULL,
        --NAME VARCHAR(80) NULL,
        --DESCRIPT VARCHAR(255) NULL,
        --CONSTRAINT PK_CATEGORY_TABLE PRIMARY KEY(CATID)
        --);

        --2.1.5
        
        --DROP TABLE PRODUCT; COMMIT;
        --CREATE TABLE PRODUCT 
        --(
        --PRODUCTID NUMBER NOT NULL,
        --CATID NUMBER NOT NULL,
        --P_NAME VARCHAR (80) NULL,
        --DESCRIPT VARCHAR(225) NULL,
        --UNITCOST NUMBER NULL,
        --SUPPID NUMBER NOT NULL,
        --CONSTRAINT PK_PRODUCTID_CONSTRAINT PRIMARY KEY (PRODUCTID),
        --CONSTRAINT FK_CATID_CONSTRAINT FOREIGN KEY (CATID) REFERENCES CATEGORY (CATID) ON DELETE CASCADE,
        --CONSTRAINT FK_SUPPID_CONSTRAINT FOREIGN KEY (SUPPID) REFERENCES SUPPLIER (SUPPID)ON DELETE CASCADE
        --);


        --2.1.6
        --CREATE TABLE SUPPLIER 
        --(
        --SUPPID NUMBER NOT NULL,
        --NAME VARCHAR(80) NULL,
        --CONSTRAINT PK_SUPPID PRIMARY KEY (SUPPID)
        --);
        


--3.0 Performing SQL Queries
    --3.1 Select
        --3.1.1
        --SELECT * FROM EMPLOYEES;
        
        --3.1.2
        --SELECT * FROM EMPLOYEES WHERE DEPARTMENT='HR';
        
        --3.1.3
        --SELECT * FROM EMPLOYEES WHERE USERNAME = 'jsmith' AND DEPARTMENT = 'HR';
      
        --3.1.4
        --SELECT * FROM EMPLOYEES WHERE MANAGER = 1 OR DEPARTMENT = 'HR';

    --3.2 ORDER BY
        --3.2.1
        --SELECT P_NAME FROM PRODUCT ORDER BY P_NAME ASC;
        
        --3.2.2
        --SELECT P_NAME FROM PRODUCT ORDER BY P_NAME DESC;
        
        --3.2.3
        --SELECT * FROM CATEGORY ORDER BY NAME;
        
    --3.3 INSERT INTO
        --3.3.1
        --INSERT INTO EMPLOYEES VALUES(5,'mdelira','md','Martin Delira','IT',0);
        
        --3.3.2
        --INSERT INTO CATEGORY VALUES(8,'Computer Parts',null);
        
        --3.3.3
        --INSERT INTO SUPPLIER VALUES(3,'BB Wholesale');
        --INSERT INTO SUPPLIER VALUES(4,'Border Cheap Items');
        --INSERT INTO SUPPLIER VALUES(5,'Texas Repurposed Electronics');
    --3.4 UPDATE
        --3.4.1
        --UPDATE PRODUCT SET UNITCOST = 3.78 WHERE P_NAME = 'Ruler';
        --UPDATE CATEGORY SET DESCRIPT = 'General cleaning supplies' WHERE NAME = 'Cleaning Supplies';
    --3.5 LIKE
        --3.5.1
        --SELECT USERNAME FROM EMPLOYEES WHERE USERNAME LIKE 'j%';
        
        --3.5.2
        --SELECT P_NAME FROM PRODUCT WHERE P_NAME LIKE 'O%';        
        
    --3.6 BETWEEN
        --3.6.1
        --SELECT P_NAME FROM PRODUCT WHERE UNITCOST BETWEEN 3 AND 10;
        
        --3.6.2
        --SELECT P_NAME FROM PRODUCT WHERE UNITCOST BETWEEN 500 AND 800;
        
    --3.7 DELETE
        --3.7.1
        --DELETE FROM CATEGORY WHERE NAME = 'Audio Visual';
        
        --3.7.2
        --DELETE FROM SUPPLIER WHERE NAME = 'BB Wholesale';
        --DELETE FROM SUPPLIER WHERE NAME = 'Border Cheap Items';
        --DELETE FROM SUPPLIER WHERE NAME = 'Texas Repurposed Electronics';
        
    --4.0 SQL FUNCTIONS
    
    --5.0 STORED PROCEDURES
    
    --6.0 TRANSACTIONS
    
    --7.0 TRIGGERS
        --7.1 AFTER/FOR TRIGGERS
            --7.1.1
            --CREATE OR REPLACE TRIGGER new_category_inserted 
            --AFTER INSERT
            --    ON CATEGORY
            --    FOR EACH ROW
            --DECLARE
            --    t_categorname number;
            --
            --BEGIN   
            --    SELECT 1*1 INTO t_categorname
            --    FROM dual;
            --END;
            --/

            --7.1.2
            --CREATE OR REPLACE TRIGGER new_category_updated
            --AFTER UPDATE
            --    ON CATEGORY
            --    FOR EACH ROW
            --DECLARE
            --    t_categorname number;
            --          
            --BEGIN   
            --    SELECT 1*1 INTO t_categorname
            --    FROM dual;
            --END;
            --/           
            
            --7.1.3
            --CREATE OR REPLACE TRIGGER on_category_deleted
            --AFTER DELETE
            --      ON CATEGORY
            --      FOR EACH ROW
            --DECLARE
            --      t_categorname number;
            --BEGIN   
            --      SELECT 1*1 INTO t_categorname
            --      FROM dual;
            --END;
            --/
            
        --7.2 INSTEAD OF TRIGGERS
            --7.2.1
            -- Triggers cannot be used in Tables, only in Views. However this would
            -- be the syntax for a view Instead of Trigger:
            
            --CREATE OR REPLACE TRIGGER restrict_record_deletion
            --INSTEAD OF DELETE
            --ON PRODUCT_VIEW
            --FOR EACH ROW
            --DECLARE
            --    PRODUCT_PRICE NUMBER;
            --BEGIN
            --    IF :OLD.UNITCOST < 500 THEN
            --       RAISE_APPLICATION_ERROR(-20001,'Products priced under $500 cannot be deleted.');
            --    END IF;
            --END;
            --/

    
    
        
    --8.0 JOINS
        --8.1 INNER JOINS
            --8.1.1
            --SELECT * FROM PRODUCT
            --INNER JOIN CATEGORY
            --ON PRODUCT.CATID = CATEGORY.CATID;
            
            --8.1.2
            --SELECT * FROM EMPLOYEES
            --INNER JOIN ORDERS
            --ON EMPLOYEES.EMPLOYEEID = ORDERS.EMPLOYEEID;
            
        --8.2 (FULL) OUTER JOIN
            --8.2.1
            --SELECT * 
            --FROM PRODUCT
            --FULL OUTER JOIN ORDER_ITEM
            --ON PRODUCT.PRODUCTID = ORDER_ITEM.PRODUCTID;
            
            --8.2.2
            --SELECT * 
            --FROM EMPLOYEES
            --FULL OUTER JOIN ORDERS
            --ON EMPLOYEES.EMPLOYEEID = ORDERS.EMPLOYEEID;


            
        --8.3 RIGHT JOIN
            --8.3.1
            --SELECT * 
            --FROM ORDERS
            --RIGHT OUTER JOIN ORDER_ITEM
            --ON ORDERS.ORDERID = ORDER_ITEM.ORDERID;
        
            --8.3.2
            --SELECT * 
            --FROM PRODUCT
            --RIGHT OUTER JOIN ORDER_ITEM
            --ON PRODUCT.PRODUCTID = ORDER_ITEM.PRODUCTID;
            
        --8.4 LEFT JOIN
            --8.4.1
            --SELECT * 
            --FROM PRODUCT
            --LEFT OUTER JOIN CATEGORY
            --ON PRODUCT.CATID = CATEGORY.CATID;

            --8.4.2
            --SELECT * 
            --FROM EMPLOYEES
            --LEFT OUTER JOIN ORDERS
            --ON EMPLOYEES.EMPLOYEEID = ORDERS.EMPLOYEEID;
    
        --8.5 CROSS JOIN
            --8.5.1
            --SELECT * FROM PRODUCT CROSS JOIN CATEGORY;
            
        --8.6 SELF JOIN
            --8.6.1
            --SELECT A.NAME AS EMPLOYEENAME1, B.NAME AS EMPLOYEENAME2
            --FROM EMPLOYEES A, EMPLOYEES B
            --WHERE A.DEPARTMENT = B.DEPARTMENT;
            

    --9.0 VIEWS
        --9.1
        --ALTER TABLE EMPLOYEES ADD (SSN NUMBER NULL, SALARY NUMBER NULL);
        --CREATE VIEW view_employees AS SELECT EMPLOYEEID, USERNAME, PASSWORD, NAME, DEPARTMENT, MANAGER FROM EMPLOYEES;
               
        --9.2
        --CREATE VIEW view_product_desc AS SELECT DESCRIPT FROM PRODUCT;

    
    --10.0 INDEXES
        --10.1
        --CREATE UNIQUE INDEX product_index
        --ON PRODUCT (UNITCOST);

    
    --11.0 ADMINISTRATION
