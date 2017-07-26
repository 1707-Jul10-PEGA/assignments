--populating privilege/user type lookup table
INSERT INTO PRIVILEGE (PID, PLEVEL) VALUES (0, 'Admin');
INSERT INTO PRIVILEGE (PID, PLEVEL) VALUES (1, 'Employee');
INSERT INTO PRIVILEGE (PID, PLEVEL) VALUES (2, 'Customer');

--populating account_type lookup table
INSERT INTO ACCOUNT_TYPE (TID, TYPE) VALUES (0, 'Savings');
INSERT INTO ACCOUNT_TYPE (TID, TYPE) VALUES (1, 'Checking');

--populating users with single required employee to approve requests
INSERT INTO USERS (USERID, USERNAME, PASSWORD, PRIVILEGE) 
    VALUES (1, 'blakethemagnificent', 'blakeboss', 1);
    
--logging triggers
CREATE OR REPLACE TRIGGER log_account_update
    AFTER INSERT OR UPDATE ON accounts
    FOR EACH ROW
        BEGIN
            INSERT INTO transaction_log (TIMESTAMP, ACCOUNT, ACTIVITY, AMOUNT) 
            VALUES (CURRENT_TIMESTAMP, :old.ACID, 'Account Edited', (0 - (:old.BALANCE - :new.BALANCE)));
        END;
        /
        
--triggers for proper pk assignment
CREATE SEQUENCE user_sequence;
CREATE OR REPLACE TRIGGER userid_assingment
    BEFORE INSERT ON USERS
    FOR EACH ROW
        BEGIN
            :new.userid := user_sequence.NEXTVAL;
        END;
        /

CREATE SEQUENCE account_sequence;
CREATE OR REPLACE TRIGGER acid_assingment
    BEFORE INSERT ON ACCOUNTS
    FOR EACH ROW
        BEGIN
            :new.acid := account_sequence.NEXTVAL;
        END;
        /
