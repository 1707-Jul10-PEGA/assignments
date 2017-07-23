/* 2.1 */
select * from Employee;
select * from Employee where LASTNAME = 'King';
select * from Employee where FIRSTNAME = 'Andrew' and REPORTSTO is null;


/* 2.2 */
select * from ALBUM order by Title desc;
select FIRSTNAME from Customer order by city asc;


/* 2.3 */
insert into Genre (GENREID, NAME) VALUES (27, 'NEW GENRE');
insert into Genre (GENREID, NAME) values (26, 'NEW GAME');

insert into Employee (EMPLOYEEID, LASTNAME, FIRSTNAME, BIRTHDATE) values (9, 'Alice', 'Alice', '1-Jan-99');
insert into Employee (EMPLOYEEID, LASTNAME, FIRSTNAME, BIRTHDATE) values (10, 'Bob', 'Bob', '2-Jan-99');
insert into Customer (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) values (60, 'Alice', 'Alice', 'Alice@Alice.com');
insert into Customer (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) values (61, 'Bob', 'Bob', 'Bob@Alice.com');


/* 2.4 */
update Customer set FIRSTNAME = 'Robert', LASTNAME='Walter' where FIRSTNAME = 'Aaron' and LASTNAME = 'Mitchell';
update Artist set NAME = 'CCR' where NAME = 'Creedence Clearwater Revival';

/* 2.5 */
select * from Invoice where BILLINGADDRESS like 'T%';

/* 2.6 */
select * from Invoice where TOTAL between 15 and 50;
select * from Employee where HIREDATE between '1-JUN-2003' and '1-MAR-2004';


/* 2.7 */
delete from INVOICELINE where InvoiceId = (
select INVOICEID from Invoice where CUSTOMERID = (
select CUSTOMERID from Customer where FIRSTNAME = 'Robert' and LASTNAME = 'Walter'));

delete Invoice where CUSTOMERID = (
select CUSTOMERID from Customer where FIRSTNAME = 'Robert' and LASTNAME = 'Walter');

delete from Customer where FIRSTNAME = 'Robert' and LASTNAME = 'Walter';


/* 3.1 */

create or replace function get_date return varchar is adate varchar(20);
Begin
select TO_CHAR (SYSDATE, 'MM-DD-YYYY HH24:MI:SS') "Current Date" into adate from DUAL;
return adate;
end;
/

Declare
adate varchar(20);
begin
    select get_date() into adate from dual;
    DBMS_OUTPUT.PUT_LINE(adate);
end;
/

create or replace function length_mediaType (media_index in number) return number is
alength number;

begin
    select length(NAME) into alength from MEDIATYPE where MEDIATYPE.MEDIATYPEID = media_index;
    return (alength);
end;
/

declare
alength number;
begin
    select length_mediaType(1) into alength from dual;
    DBMS_OUTPUT.PUT_LINE(alength);
end;
/
/* 3.2.1 */
create or replace function avg_total return number is anavg number(3,2);
begin
select avg(TOTAL) into anavg from Invoice; return (anavg);
end;
/

declare
avgTotal number(3,2);
begin
    select avg_total() into avgTotal from dual;
    DBMS_OUTPUT.PUT_LINE(avg_total);
end;
/
/* 3.2.2 */
create or replace function exp_track return number is aexp number;
begin
select max(UNITPRICE) into aexp from Track; return (aexp);
end;
/

declare
maxPrice number(4,2);
begin
    select exp_track() into maxPrice from dual;
    DBMS_OUTPUT.PUT_LINE(maxPrice);
end;
/
create or replace function avg_invoiceLine return number is anavg number;
begin
select avg(UNITPRICE * QUANTITY) INTO anavg from InvoiceLine; return (anavg);
end;
/

declare
avgInvoiceLine number(4,2);
begin
    select avg_invoiceLine() into avgInvoiceLine from dual;
    DBMS_OUTPUT.PUT_LINE(avgInvoiceLine);
end;
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

/* 4.2.1 */

create or replace procedure newdata (p_id in Employee.employeeid%type)
as begin
update employee set lastname = 'updated' where employeeid = p_id;
end;
/
exec newdata(1);
select * from Employee;


/* 4.2.2 */
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
/*
declare
firstname varchar2(40);
lastname varchar2(20);
company varchar2(80);
begin
    customerInfo(1, firstname, lastname, company);
    dbms_output.put_line(firstname || ' ' || lastname || ' ' || company);
end;
*//
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
create or replace trigger trigger2
after update on Album
for each row
begin
    dbms_output.put_line(:new.title || ' updated');
end;
/
update Album set title = 'FOR THOSE ABOUT TO ROCK WE SALUTE YOU' where albumid = 1;
commit;

create or replace trigger trigger3
after delete on Customer
for each row
begin
     dbms_output.put_line(:old.firstname || ' ' || :old.lastname || ' deleted');
end;
/
delete from Customer where email = 'example@example.com';
commit;

/* 6.2 */
create or replace view invoice_and_invoiceline as
select i.invoiceid, t.name as track, c.firstname, c.lastname, il.unitprice, il.quantity, i.total
from invoice i, Track t, Customer c, Invoiceline il where
i.invoiceid = il.invoiceid and i.customerid = c.customerid and il.trackid = t.trackid;

create or replace trigger trigger4 
instead of delete on invoice_and_invoiceline
for each row
declare
 t_total number;
begin
    select distinct total into t_total from invoice_and_invoiceline where Invoiceid = :Old.Invoiceid;
    
    if t_total < 4 then
        delete from InvoiceLine where Invoiceid = :Old.Invoiceid;
        delete from Invoice where Invoiceid = :Old.Invoiceid;
    end if;
end;
/

select * from invoice_and_invoiceline order by invoiceid;

delete from invoice_and_invoiceline where invoiceID = 3;
commit;

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