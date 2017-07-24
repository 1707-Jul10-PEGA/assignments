/* 2.1 */
select * from EMPLOYEE;
select * from EMPLOYEE where LASTNAME = 'King';
select * from EMPLOYEE where FIRSTNAME = 'Andrew' and REPORTSTO is null;

/* 2.2 */
select * from ALBUM order by TITLE desc;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;

/* 2.3 */
insert into GENRE (GENREID, NAME) VALUES (26, 'HUNG11');
insert into GENRE (GENREID, NAME) VALUES (27, 'HUNG12');

insert into EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (9, 'LE1', 'HUNG1');
insert into EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (10, 'LE2', 'HUNG2');

INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (60, 'HUNG3', 'LE3', 'ABC@GMAIL.COM');
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (61, 'HUNG4', 'LE4', 'DEF@GMAIL.COM');

/* 2.4 */
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' where FIRSTNAME = 'Aaron' and LASTNAME = 'Mitchell';
update ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';

/* 2.5 */
select * FROM INVOICE WHERE BILLINGADDRESS LIKE '%T'; 

/* 2.6 */
select * from INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '1-JUN-2003' AND '1-MAR-2004';

/* 2.7 */
DELETE FROM CUSTOMER WHERE FIRSTNAME='Robert' and LASTNAME='Walter';

/* 3.1 */
SET SERVEROUTPUT ON
CREATE OR REPLACE FUNCTION CURRENTTIME
    RETURN TIMESTAMP 
    IS  
    BEGIN
        RETURN CURRENT_TIMESTAMP;
    END;
    /
DECLARE
    d TIMESTAMP;
    BEGIN
        d := CURRENTTIME();
        DBMS_OUTPUT.PUT_LINE('CURRENT TIME: ' || d);
    END;
    /
    
CREATE OR REPLACE FUNCTION MEDIATYPE_LENGTH(THIS_ID NUMBER)
    RETURN NUMBER
    IS  
        name_len NUMBER := 0;
    BEGIN
        SELECT LENGTH(M.NAME) INTO name_len FROM MEDIATYPE M WHERE M.MEDIATYPEID = THIS_ID ;
        RETURN name_len;
    END;
    /
DECLARE
    d NUMBER;
    BEGIN
        d := MEDIATYPE_LENGTH(1);
        DBMS_OUTPUT.PUT_LINE('MEDIATYPE_LENGTH: ' || d);
    END;
    /
    
/* 3.2 */
CREATE OR REPLACE FUNCTION INVOICE_AVGTOTAL
    RETURN NUMBER
    IS  
        avg_total NUMBER := 0;
    BEGIN
        SELECT AVG(I.TOTAL) INTO avg_total FROM INVOICE I;
        RETURN avg_total;
    END;
    /
DECLARE
    d NUMBER;
    BEGIN
        d :=INVOICE_AVGTOTAL();
        DBMS_OUTPUT.PUT_LINE('INVOICE AVERAGE TOTAL: ' || d);
    END;
    /
    
SET SERVEROUTPUT ON 
CREATE OR REPLACE FUNCTION MaxTrackPrice
    return NUMBER
    AS
    max_price NUMBER;
    BEGIN
        SELECT MAX(Unitprice) into max_price FROM invoiceline;
        return max_price;

    END;
    /
    
DECLARE
    maxprice NUMBER;
    
    BEGIN
        maxprice := MaxTrackPrice();
        DBMS_OUTPUT.PUT_LINE('MAX Price: ' || maxprice);
    END;
    /
    
/* 3.3 */
SET SERVEROUTPUT ON 
CREATE OR REPLACE FUNCTION avg_invoiceline
    return NUMBER
    AS
    avg_price NUMBER;
    BEGIN
        SELECT avg(Unitprice) into avg_price FROM invoiceline;
        return avg_price;

    END;
    /
    
DECLARE
    avgprice NUMBER;
    BEGIN
        avgprice := avg_invoiceline();
        DBMS_OUTPUT.PUT_LINE('AVG Price: ' || avgprice);
    END;
    /
    
/* 3.4 */
create type employee_table as object (
    FIRSTNAME	VARCHAR2(20),
    LASTNAME	VARCHAR2(20),
    BIRTHDATE	DATE
);
/   
create type employee_table_type is table of employee_table;
/

create or replace function born_after_1968 return employee_table_type pipelined is
begin 
    for i in (select FIRSTNAME, LASTNAME, BIRTHDATE from EMPLOYEE where BIRTHDATE > TO_DATE('31-DEC-1968', 'DD-MON-YYYY'))
    loop
        pipe row(employee_table(i.FIRSTNAME, i.LASTNAME, i.BIRTHDATE));
    end loop;
    return;
end;
/

select * from table(born_after_1968());

/* 4.1 */
set serveroutput on;
create or replace procedure first_lastname is
cursor f_l is select firstname, lastname from employee;
f_l_row f_l%ROWTYPE;
begin
open f_l;
    loop
    fetch f_l into f_l_row;
    exit when f_l%NOTFOUND;
    dbms_output.put_line(f_l_row.firstname || ' ' || f_l_row.lastname);
    end loop;
close f_l;
end;
/
exec first_lastname();

/* 4.2 */
create or replace procedure newdata (p_id in Employee.employeeid%type)
as begin
update employee set lastname = 'updated' where employeeid = p_id;
end;
/
exec newdata(1);
select * from Employee;

create or replace procedure managers (p_id in Employee.employeeid%type, p_Firstname out Employee.Firstname%type, p_Lastname out Employee.Lastname%type) as
temptitle varchar(20);
begin

    select title into temptitle from Employee where employeeID = p_id;
    select (regexp_substr(temptitle, '^[a-zA-Z]+\s') || 'Manager') into temptitle from dual;
    
    select Firstname, Lastname into
        p_Firstname, p_Lastname
        from Employee
        where title = temptitle;

end;
/

select * from employee;

declare
    manager_first varchar(20);
    manager_last varchar(20);
begin
    managers(4, manager_first, manager_last);
    dbms_output.put_line(manager_first || ' ' || manager_last);
end;
/

/* 4.3 */
create or replace procedure customerInfo (p_id in Customer.Customerid%type, p_first out Customer.Firstname%type, p_last out Customer.Lastname%type, p_company out Customer.Company%type)
as begin 
select Firstname, Lastname, Company
into
p_first, p_last, p_company
from Customer
where CustomerID = p_id;
end;
/

/* 5.0 */
Declare id Number;
Begin 
    id := 1;
    Delete from invoiceline where invoiceid = id;
    Delete from invoice where invoiceid = id;
End;
/

create or replace procedure insertCustomer (
    p_id in CUSTOMER.CustomerId%type,
    p_first in CUSTOMER.FIRSTNAME%type,
    p_last in CUSTOMER.LASTNAME%type,
    p_email in CUSTOMER.EMAIL%type
)
as
begin
insert
into CUSTOMER ( CustomerId, FIRSTNAME, LASTNAME, EMAIL)
values
(p_id, p_first, p_last, p_email);
end;
/
exec insertCustomer(62, 'Charlie', 'Charlie', 'example@example.com');

/* 6.1 */
create or replace trigger trigger1
    after insert on Employee
    for each row
begin
    dbms_output.put_line(:new.lastname || ' ' || :new.firstname
    || ' inserted into Employee');
end;
/

insert into Employee (employeeid, lastname, firstname, email) values
(24, 'lastname', 'firstname', 'some@email.com');
commit;

/* 6.2 */
CREATE VIEW vw_INVOICE AS SELECT * FROM INVOICE;

CREATE OR REPLACE TRIGGER INVOICE_ONDELETE
    INSTEAD OF DELETE ON vw_INVOICE
    FOR EACH ROW
    BEGIN
        IF (:old.TOTAL > 50) THEN
            DELETE FROM vw_INVOICE WHERE INVOICEID = :old.INVOICEID;
            DBMS_OUTPUT.PUT_LINE('INVOICE ON DELETE');
        END IF;
    END;
    /

/* 7.1 */
select Customer.Firstname as First, Customer.Lastname as Last, Invoice.InvoiceID as ID from Customer inner join Invoice on Customer.CustomerID = INVOICE.CustomerID;

/* 7.2 */
select
Customer.CustomerID as CID,
Customer.Firstname as First,
Customer.Lastname as Last,
Invoice.InvoiceID as IID,
Invoice.Total as Total
from Customer left outer join Invoice on Customer.CustomerID = INVOICE.CustomerID;

/* 7.3 */
select
Artist.name as name,
Album.title as title
from Album right outer join Artist on Album.ArtistID = Artist.ArtistID;

/* 7.4 */
select
Artist.name as name,
Album.title as title
from Album cross join Artist order by name;

/* 7.5 */
select
A.Firstname as Employee1,
B.Firstname as Employee2,
A.Reportsto as Reportsto
from Employee A, Employee B
where (A.EMPLOYEEID <> B.EMPLOYEEID
and A.Reportsto = B.Reportsto);

/* 8.1 */
create table students (
    student_id number not null,
    firstname varchar2(256),
    lastname varchar2(256),
    constraint STUDENT_ID_CONSTRAINT primary key(student_id)
)
organization Index;
