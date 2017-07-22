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

CREATE TABLE User
(
    UserId NUMBER NOT NULL,
    FirstName VARCHAR2(40) NOT NULL,
    LastName VARCHAR2(20) NOT NULL,
    Age NUMBER,
    Address VARCHAR2(70),
    Phone VARCHAR2(24),
    PID NUMBER NOT NULL,
    FirstName VARCHAR2(40) NOT NULL,
    LastName VARCHAR2(20) NOT NULL,
    CONSTRAINT PK_User PRIMARY KEY  (UId)
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

CREATE TABLE TransactionLog
(
    TranscationID NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
    TransactionDate DATE NOT NULL,
    Activity VARCHAR2(70),
    UserID NUMBER NOT NULL,
    AccID NUMBER NOT NULL,
    Amount NUMBER NOT NULL,
    CONSTRAINT PK_TransactionLog PRIMARY KEY  (AccId)
);

CREATE TABLE Privledge
(
    PId NUMBER NOT NULL,
    PType Varchar(8) NOT NULL,
    CONSTRAINT PK_Privledge PRIMARY KEY  (CId)
);

CREATE TABLE AccType
(
    AccId NUMBER NOT NULL,
    AccType Varchar(8) NOT NULL,
    Interest NUMBER NOT NULL,
    CONSTRAINT PK_Privledge PRIMARY KEY  (CId)
);

/*
*Alter the tables to create FK
*/
ALTER TABLE Customer ADD CONSTRAINT FKCustomerUserId
    FOREIGN KEY (CId) REFERENCES User (UserId)  ;
    
ALTER TABLE Account ADD CONSTRAINT FK_AccountCustomerId
    FOREIGN KEY (AccID) REFERENCES Customer (CId)  ;

ALTER TABLE Privlege ADD CONSTRAINT FK_PrivlegeUserId
    FOREIGN KEY (PId) REFERENCES User (PId)  ;
    
ALTER TABLE AccType ADD CONSTRAINT FK_AccountTypeId
    FOREIGN KEY (AccId) REFERENCES Account (AccId)  ;


/*
*Input values into the Privlege Table - this table is use to look up what type of user the person is
*/
INSERT INTO Privledge values (0, 'admin');
INSERT INTO Privledge values (1, 'employee');
INSERT INTO Privledge values (2, 'customer');