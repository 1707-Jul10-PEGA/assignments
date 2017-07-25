/*
* Create database
*/
CREATE USER yangh1
IDENTIFIED BY pass
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to yangh1;
GRANT resource to yangh1;
GRANT create session TO yangh1;
GRANT create table TO yangh1;
GRANT create view TO yangh1;



conn yangh1/pass

/*
* Create Table
*/

CREATE TABLE BANK_USER
(
    UserId NUMBER NOT NULL,
    FirstName VARCHAR2(40) NOT NULL,
    LastName VARCHAR2(20) NOT NULL,
    Age NUMBER,
    Address VARCHAR2(70),
    Phone VARCHAR2(24),
    PID NUMBER NOT NULL,
    USERName VARCHAR2(40) NOT NULL,
    PASSWORD VARCHAR2(20) NOT NULL,
    CONSTRAINT PK_User PRIMARY KEY  (UserId)
);

CREATE TABLE Account
(
    AccID NUMBER NOT NULL,
    Balance NUMBER NOT NULL,
    CID NUMBER NOT NULL,
    AccType NUMBER NOT NULL,
    Status VARCHAR2(70),
    AccState NUMBER NOT NULL,
    CONSTRAINT PK_Account PRIMARY KEY  (AccId)
);

CREATE TABLE Customer
(
    CId NUMBER NOT NULL,
    UserId NUMBER NOT NULL,
    CONSTRAINT PK_Customer PRIMARY KEY  (CId)
);

CREATE TABLE Customer_Account
(
    CId NUMBER NOT NULL,
    AId NUMBER NOT NULL,
    CONSTRAINT PK_CUSTOMER_ACCOUNT PRIMARY KEY  (AId)
);

CREATE TABLE TransactionLog
(
    TranscationID NUMBER,
    TransactionDate DATE NOT NULL,
    Activity VARCHAR2(70),
    UserID NUMBER NOT NULL,
    AccID NUMBER NOT NULL,
    Amount NUMBER NOT NULL,
    CONSTRAINT PK_TransactionLog PRIMARY KEY  (TranscationID)
);

CREATE TABLE Privledge
(
    PId NUMBER NOT NULL,
    PType Varchar(8) NOT NULL,
    CONSTRAINT PK_Privledge PRIMARY KEY  (PId)
);

CREATE TABLE AccType
(
    AccId NUMBER NOT NULL,
    AccType Varchar(8) NOT NULL,
    Interest NUMBER NOT NULL,
    CONSTRAINT PK_acctype PRIMARY KEY  (AccId)
);

CREATE TABLE APPLICATION(
    APP_ID NUMBER NOT NULL,
    U_ID NUMBER NOT NULL,
    ACC_TYPE VARCHAR(255),
    BALANCE NUMBER,
    CONSTRAINT PK_APP PRIMARY KEY (APP_ID)
);

/*
*Alter the tables to create FK
*/
ALTER TABLE Customer ADD CONSTRAINT FKCustomerUserId
    FOREIGN KEY (CId) REFERENCES BANK_User (UserId)  ;
    
ALTER TABLE Account ADD CONSTRAINT FK_AccountCustomerId
    FOREIGN KEY (AccID) REFERENCES Customer (CId)  ;

ALTER TABLE Privlege ADD CONSTRAINT FK_PrivlegeUserId
    FOREIGN KEY (PId) REFERENCES User (PId)  ;
    
ALTER TABLE AccType ADD CONSTRAINT FK_AccountTypeId
    FOREIGN KEY (AccId) REFERENCES Account (AccId)  ;

ALTER TABLE APPLICATION ADD CONSTRAINT FK_ACCOUNTUSER
    FOREIGN KEY (UId) REFERENCES Account (UId)  ;
ALTER TABLE CUSTOMER_ACCOUNT ADD CONSTRAINT FKCustomerACCOUNT
    FOREIGN KEY (CId) REFERENCES BANK_User (USER_ID)  ;
ALTER TABLE CUSTOMER_ACCOUNT ADD CONSTRAINT FKCustomerACCOUNT_ACCOUNT
    FOREIGN KEY (aId) REFERENCES ACCOUNT (aCCID)  ;
/*
*Input values into the Privlege Table - this table is use to look up what type of user the person is
*/
INSERT INTO Privledge values (0, 'admin');
INSERT INTO Privledge values (1, 'employee');
INSERT INTO Privledge values (2, 'customer');

