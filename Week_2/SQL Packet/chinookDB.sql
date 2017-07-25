--Select
Select * from chinook.employee;
Select * from chinook.employee
where LastName='King';
Select * from chinook.Employee
where FirstName='Andrew' AND Reportsto is Null;

--Order By
Select * from chinook.album
order by TITLE DESC;
Select FirstName from chinook.Customer
Order by City ASC;

--Insert Into 
INSERT INTO chinook.Genre (GenreId, Name) VALUES (26, 'Bad Music');
INSERT INTO chinook.Genre (GenreId, Name) VALUES (27, 'Breakcore');

INSERT INTO chinook.Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Adams', 'Ansel', 'General Manager', TO_DATE('1962-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (780) 428-3457', 'andrew@chinookcorp.com');
INSERT INTO chinook.Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Burgerking', 'Mcdonalds', 'General Manager', TO_DATE('1962-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (780) 428-3457', 'andrew@chinookcorp.com');

INSERT INTO chinook.Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (60, 'joe', 'applepie', 'NASA', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);
INSERT INTO chinook.Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (61, 'america', 'chocolate', 'Amazon', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);
   
--Update
UPDATE CHINOOK.CUSTOMER
SET FirstName = 'Robert', LastName ='Walter'
where Firstname='Aaron' AND lastname='Mitchell';

Update chinook.artist
set NAME='CCR'
where NAME='Creedence Clearwater Revival';

--Like
Select * from chinook.invoice
Where billingaddress LIKE 'T%';

--Between
Select * from chinook.invoice
where total between 15 and 50;

Select * from chinook.employee
where HireDate between TO_DATE('2003-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss') and TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');

--Delete
Update chinook.invoice set Customerid=1 where CUSTOMERID=32;
Delete from Chinook.customer where firstname='Robert' and lastname='Walter';

--System defined functions
Select CURRENT_TIMESTAMP from dual;
Select LENGTH(name), name from CHINOOK.MEDIATYPE;

--System defined aggregate functions
Select AVG(total) from chinook.invoice;
Select MAX(unitprice) from chinook.track;

--User defined scalar functions 3.3
create or replace function aveInvoice
return varchar as vreturn varchar(50);
Begin
Select AVG(unitprice)into vreturn from chinook.invoiceline;
return vreturn;
end;
/
Set serveroutput on
declare
vreturn number;
begin 
vreturn :=aveInvoice;
dbms_output.put_line(vreturn);
end;
/

--User defined table value functions 3.4
create or replace type emparray is table of varchar2(20);
/
create or replace function births68
return emparray as emps emparray;
begin
    select firstname bulk collect into emps from chinook.employee
    where birthdate >= TO_DATE('1968-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
    return emps;
end;
/
select births68 from dual;

--Basic stored procedure 4.1
create or replace procedure names(mycursor out sys_refcursor)
as
begin 
      open mycursor for select distinct firstname, lastname from CHINOOK.EMPLOYEE;
end;
/
variable rc refcursor;
execute names(:rc);
print rc;


--4.2 Create SP to update employee
create or replace procedure updateemp(
e_id in number,
fname in varchar2,
lname in varchar2
)
as
begin
update employee set firstname=fname, lastname=lname where employeeid=e_id;
end;
/

declare
e_id number;
fname varchar(20);
lname varchar(20);
begin
    e_id:= 1;
    fname:= 'Nuevo';
    lname:= 'Gert';
    updateemp(e_id, fname, lname);
end;
/

create or replace procedure getmanagers(
eid in number,
c out sys_refcursor
)
as begin
    open c for select b.firstname, b.lastname
    from employee a
    join employee b
    on b.employeeid = a.reportsto
    where a.employeeid = eid;
end;
/

variable rc refcursor;
execute getmanagers(4, :rc);
print rc;


--4.3 Stored Procedure Output Parameters 
create or replace procedure getNameAndComp(
cid in number,
curs out sys_refcursor
)as 
begin
 open curs for 
 select firstname, lastname, company from customer
 where customerid = cid;
end;
/

variable rc refcursor;
execute getNameAndComp(4, :rc);
print rc;





