/*******************************************************************************
   Create database
*******************************************************************************/
CREATE USER BankInfo
IDENTIFIED BY bankinfopass
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to BankInfo;
GRANT resource to BankInfo;
GRANT create session TO BankInfo;
GRANT create table TO BankInfo;
GRANT create view TO BankInfo;



conn BankInfo/bankinfopass


/*******************************************************************************
   Create Tables
*******************************************************************************/

CREATE TABLE Users
(
  U_ID NUMBER NOT NULL,
  FIRST_NAME VARCHAR2(20),
  LAST_NAME VARCHAR2(20),
  AGE NUMBER,
  USERNAME VARCHAR2(20) NOT NULL,
  PASSWORD VARCHAR2(20) NOT NULL,
  PRIVLIGES NUMBER NOT NULL,
  CONSTRAINT PK_Users PRIMARY KEY (U_ID)
);

CREATE TABLE Privliges
(
  ID Number NOT NULL,
  TYPE VARCHAR(8) NOT NULL,
  CONSTRAINT PK_Privliges PRIMARY KEY (ID)
);

CREATE TABLE Accounts
(
  ACC_ID NUMBER NOT NULL,
  BALANCE NUMBER(10,2) NOT NULL,
  U_ID NUMBER NOT NULL,
  TYPE NUMBER NOT NULL,
  STATUS NUMBER NOT NULL,
  LAST_ACCESSED DATE,
  CONSTRAINT PK_Accounts PRIMARY KEY (ACC_ID)
);

CREATE TABLE AccountType
(
  TYPE_ID NUMBER NOT NULL,
  TYPE VARCHAR(8),
  INTEREST NUMBER(1,2) NOT NULL,
  CONSTRAINT PK_AccountType PRIMARY KEY (TYPE_ID)
);

CREATE TABLE CUSTOMER_EMPLOYEE_TABLE
(
  Customer_ID NUMBER NOT NULL,
  Employee_ID NUMBER NOT NULL,
  CONSTRAINT PK_CUST_EMP_TABLE PRIMARY KEY (Customer_ID, Employee_ID)
);

CREATE TABLE TransactionLog
(
  TIMESTAMP DATE NOT NULL,
  ACTIVITY VARCHAR(10) NOT NULL,
  U_ID NUMBER NOT NULL,
  ACCOUNT NUMBER NOT NULL,
  AMOUNT NUMBER
);

/*******************************************************************************
   Create Foreign Keys
*******************************************************************************/

ALTER TABLE Users ADD CONSTRAINT FK_UserTypeID
    FOREIGN KEY (PRIVLIGES) REFERENCES PRIVLIGES (ID);

ALTER TABLE Accounts ADD CONSTRAINT FK_UserID
    FOREIGN KEY (U_ID) REFERENCES Users (U_ID);

ALTER TABLE Accounts ADD CONSTRAINT FK_AccountTypeID
    FOREIGN KEY (TYPE) REFERENCES AccountType (TYPE_ID);

ALTER TABLE CUSTOMER_EMPLOYEE_TABLE ADD CONSTRAINT FK_CustomerID
    FOREIGN KEY (Customer_ID) REFERENCES Users (U_ID);

ALTER TABLE CUSTOMER_EMPLOYEE_TABLE ADD CONSTRAINT FK_EmployeeID
    FOREIGN KEY (Employee_ID) REFERENCES Users (U_ID);

ALTER TABLE TransactionLog ADD CONSTRAINT FK_TransactionUser
    FOREIGN KEY (U_ID) REFERENCES Users (U_ID);

/*******************************************************************************
   Populate lookup tables
*******************************************************************************/

INSERT INTO AccountType (TYPE_ID, TYPE, INTEREST) VALUES (0, 'Savings', 0.05);
INSERT INTO AccountType (TYPE_ID, TYPE, INTEREST) VALUES (1, 'Checking', 0.01);

INSERT INTO Privliges (ID, TYPE) VALUES (0, 'Admin');
INSERT INTO Privliges (ID, TYPE) VALUES (1, 'Employee');
INSERT INTO Privliges (ID, TYPE) VALUES (2, 'Customer');

/*******************************************************************************
   Create sequences
*******************************************************************************/

CREATE SEQUENCE USER_ID
  START WITH    1
  INCREMENT BY  1;

CREATE SEQUENCE ACCOUNT_ID
  START WITH    1
  INCREMENT BY  1;

/*******************************************************************************
   Create triggers
*******************************************************************************/

create or replace TRIGGER NEW_USER_TRIG
  BEFORE INSERT ON Users
  FOR EACH ROW
  BEGIN
    SELECT USER_ID.NEXTVAL INTO :new.U_ID FROM DUAL;
  END;
  /

create or replace TRIGGER NEW_ACCOUNT_TRIG
  BEFORE INSERT ON Accounts
  FOR EACH ROW
  BEGIN
    SELECT ACCOUNT_ID.NEXTVAL INTO :new.ACC_ID FROM DUAL;
  END;
  /

create or replace trigger NEW_LOG_ENTRY
  BEFORE INSERT ON TRANSACTION_LOG
  FOR EACH ROW
  BEGIN
    SELECT Current_Timestamp INTO :new.TIMESTAMP FROM DUAL;
  END;
  /

commit;