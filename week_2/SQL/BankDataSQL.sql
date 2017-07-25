CREATE TABLE users
(
	UserID NUMBER NOT NULL,
	UserName VarChar2(32) NOT NULL,
	"PASSWORD" VarChar2(32) NOT NULL,
	UserTypeID number not null,
	Firstname VarChar2(32) Not null,
	LastName varchar2(32) not null,
	CONSTRAINT PK_User PRIMARY KEY (UserID)
); /
CREATE TABLE Account
(
	AccountID Number not null,
	Balance Number(32, 2),
	UserIDHolder Number,
	UserIDManager Number,
	Status Number,
	CONSTRAINT PK_Account PRIMARY KEY (AccountID)
);
/

CREATE TABLE TransactionLogs
(
	LogID Number not null,
	myTime Date not null,
	Logs varchar2,
	CONSTRAINT PK_TransactionLogs PRIMARY KEY (LogID)
);
commit;
CREATE TABLE Status
(
	StatusID Number,
	StatusName VarChar2,
	CONSTRAINT PK_Status PRIMARY KEY (StatusID)
);
/
CREATE TABLE UserType
(
	UserTypeID Number,
	UserTypeName VarChar2,
	CONSTRAINT PK_UserType PRIMARY KEY (UserTypeID)
);
/
commit;
INSERT INTO Users (UserID, UserName, Password, UserTypeID, Firstname, LastName) VALUES (1, 'Bob', 'cm', 2, 'Bob', 'Smith');
INSERT INTO Users (UserID, UserName, Password, UserTypeID, Firstname, LastName) VALUES (2, 'Alice', 'cm', 2, 'Alice', 'Test');
INSERT INTO Users (UserID, UserName, Password, UserTypeID, Firstname, LastName) VALUES (3, 'Employee', 'emp', 1, 'Default', 'Employee');
INSERT INTO Users (UserID, UserName, Password, UserTypeID, Firstname, LastName) VALUES (4, 'Admin', 'adm', 0, 'King', 'OftheDatabase');
INSERT INTO Account (AccountID, Balance, UserIDHolder, UserIDManager, Status) VALUES (1, 100.00, 1, 3, 2);
INSERT INTO Account (AccountID, Balance, UserIDHolder, UserIDManager, Status) VALUES (1, 50.00, 2, 3, 2);
commit;

CREATE OR REPLACE TRIGGER On_Account_Update
	AFTER INSERT OR UPDATE ON Account
	FOR EACH ROW
	BEGIN
		Insert into TransactionLogs (LogID, myTime, mydescript) VALUES (0, CURRENT_TIMESTAMP, 
        :old.AccountID || ' ' ||'Old balance' || :old.Balance || ' new Balance' || :new.Balance || ' Manager' || :new.UserIDManager || ' OwnerID' || :new.UserIDHolder || ' status ' || :new.status );
	END;
/
CREATE OR REPLACE TRIGGER On_User_Update
	AFTER INSERT OR UPDATE ON Users
	FOR EACH ROW
	BEGIN
		Insert into TransactionLogs (LogID, myTime, mydescript) VALUES (0, CURRENT_TIMESTAMP, 
        :new.UserID || ' ' ||'UserName ' || :new.UserName || ' Password ' || :new.Password || ' UserTyp ' || :new.UserTypeID || ' FirstName' || :new.FirstName || ' Lastname ' || :new.LastName );
	END;
/

create sequence log_seq;
create or replace trigger log_pk_trig
before insert or update on TransactionLogs
for each row
begin
    if INSERTING then
        :new.LOGID := log_seq.NEXTVAL;
    elsif UPDATING then
        :new.LOGid := :old.LOGid;
    end if;
end;
/

create sequence User_seq;
create or replace trigger User_pk_trig
before insert or update on Users
for each row
begin
    if INSERTING then
        :new.UserID := User_seq.NEXTVAL;
    elsif UPDATING then
        :new.UserID := :old.UserID;
    end if;
end;
/
commit;