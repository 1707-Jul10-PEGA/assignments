create user "OfficeSupply" identified by "OfficeSupply";
drop user "OfficeSupply";

create user "OfficeSupply" identified by "OfficeSupply";
commit;

create table Employees (
EmployeeID number not null,
UserName varchar(20) not null,
Password varchar(20) not null,
Name varchar(25) not null,
Department char(2) not null,
Manager number(1) not null,
constraint EMLOYEES_PK primary key (EmployeeID)
);

create table Orders (
OrderID number not null,
EmployeeID number not null,
OrderDate date not null,
Status char not null,
constraint ORDER_PK primary key (OrderID)
);

create table OrderItem (
OrderID number not null,
ProductID varchar(20) not null,
Quantity number not null,

constraint ORDER_ITEM_PK primary key (OrderID, ProductID)
);

create table Category (
CatID number not null,
Name varchar(80),
Descript varchar(255),
constraint CATEGORY_PK primary key (CatID)
);

create table Product (
ProductID varchar(20) not null,
CatID number not null,
Name varchar(80),
Descript varchar(255),
UnitCost number,
SuppID number not null,
constraint PRODUCT_PK primary key (ProductID)
);

create table Supplier (
SuppID number not null,
Name varchar(80),
constraint SUPPLIER_PK primary key (SuppID)
);

alter table Orders add constraint EMPLOYEES_FK foreign key (EmployeeID) references Employees(EmployeeID);
alter table OrderItem add constraint ORDERITEM_ORDER_FK foreign key (OrderID) references Orders(OrderID);
alter table OrderItem add constraint ORDERITEM_PRODUCT_FK foreign key (ProductID) references Product(ProductID);
alter table Product add constraint PRODUCT_SUPPLIER_FK foreign key (SuppID) references Supplier(SuppID);
alter table Product add constraint PRODUCT_CATEGORY_FK foreign key (CatID) references Category(CatID);

insert into Employees (
EmployeeID, UserName, Name, Password, Department, Manager) values (
1, 'dclark', 'clark', 'drc', 'HR', 0);

insert into Employees (
EmployeeID, UserName, Name, Password, Department, Manager) values (
2, 'jsmith', 'smith', 'js', 'IT', 1);

insert into Employees (
EmployeeID, UserName, Name, Password, Department, Manager) values (
3, 'mjones', 'jones', 'mj', 'HR', 1);

insert into Employees (
EmployeeID, UserName, Name, Password, Department, Manager) values (
4, 'klink', 'link', 'kl', 'IT', 0);

insert into Supplier (
SuppID, Name) values (
1, 'XYZ Office Supplies'
);

insert into Supplier (
SuppID, Name) values (
2, 'ABC Office Products'
);

insert into Category (
CatID, Name, Descript) values (
1, 'Audio Visual', '' 
);

insert into Category (
CatID, Name, Descript) values (
2, 'Art Supplies', ''
);

insert into Category (
CatID, Name, Descript) values (
3, 'Cleaning Supplies', ''
);
insert into Category (
CatID, Name, Descript) values (
4, 'Computer Supplies', ''
);

insert into Category (
CatID, Name, Descript) values (
5, 'Desk Accessories', ''
);

insert into Category (
CatID, Name, Descript) values (
6, 'Writing Supplies', ''
);

insert into Category (
CatID, Name, Descript) values (
7, 'Printer Supplies', ''
);

insert into Product (
ProductID, CatID, Name, Descript, UnitCost, SuppID) values (
'ACM-10414',    2,  'Ruler',    '12 inch stainles steel', 3.79, 2);

insert into Product (
ProductID,  CatID,   Name,Descript, UnitCost,SuppID) values (
'APO-CG7070', 1,'Transparency', 'Quick dry ink jet', 24.49, 1);

insert into Product (
ProductID, CatID, Name, Descript, UnitCost, SuppID) values (
'APO-FXL', 1, 'Overhead Bulb', 'High intensity replacement bulb', 12.00, 1);

insert into Product (
ProductID, CatID, Name, Descript, UnitCost, SuppID) values (
'APO-MP1200', 1, 'Laser Pointer', 'General purpose laser pointer', 29.99, 2);

insert into Product (
ProductID, CatID, Name, Descript, UnitCost, SuppID) values (
'BIN68401', 2, 'Colored Pencils', 'Non toxic 12 pack', 2.84, 1);

insert into Product (
ProductID, CatID, Name, Descript, UnitCost, SuppID) values (
'DRA-91249', 3, 'All-Purpose Cleaner', 'Use on all washable surfaces', 4.29, 2);

insert into Product (
ProductID, CatID, Name, Descript, UnitCost, SuppID) values (
'FOH-28124', 3, 'Paper Hand Towels', '320 sheets per roll', 5.25, 1);

insert into Product (
ProductID, CatID, Name, Descript, UnitCost, SuppID) values (
'IMN-41143', 4, 'CD-R', '700 mb with jewel case', 1.09, 1);

insert into Product (
ProductID, CatID, Name, Descript, UnitCost, SuppID) values (
'IMN-44766', 4, '3.5 inch Disks', 'High Density Formatted Box of 10', 5.99, 1);

insert into Product (
ProductID, CatID, Name, Descript, UnitCost, SuppID) values (
'KMW-12164', 4, 'Monitor wipes', 'Non abrasive lint free', 6.99, 2);

insert into Product (
ProductID, CatID, Name, Descript, UnitCost, SuppID) values (
'KMW-22256', 4, 'Dust Blaster', 'Ozone safe no CFCs', 8.99, 2);

insert into Product (
ProductID, CatID, Name, Descript, UnitCost, SuppID) values (
'MMM6200', 2, 'Clear Tape', '1 inch wide 6 rolls', 3.90, 1);

insert into Product (
ProductID, CatID, Name, Descript, UnitCost, SuppID) values (
'MMM9700P', 1, 'Overhead Projector', 'Portable with travel cover', 759.97, 1);

insert into Product (
ProductID, CatID, Name, Descript, UnitCost, SuppID) values (
'OIC-5000', 2, 'Glue Stick', 'Oderless no toxic', 1.99, 2);

select * from Employees;
select * from Employees where Department = 'HR';
select * from Employees where username = 'jsmith' and department = 'hr';
select * from Employees where manager = 1 or department = 'hr';

select name from product order by name asc;
select name from product order by name desc;
select * from category order by name;

insert into Employees (
EmployeeID, UserName, Name, Password, Department, Manager) values (
5, 'newuser', 'user', 'pass', 'HR', 0);

insert into Category (
CatID, Name, Descript) values (
8, 'newCat', 'newCat');

insert into Supplier (
SuppID, Name) values (
3, 'newSupp11');

insert into Supplier (
SuppID, Name) values (
4, 'newSupp2');

insert into Supplier (
SuppID, Name) values (
5, 'newSupp3');

update Product set UnitCost = 2.79 where name = 'Ruler';
update Category set Descript = 'Cleaning supplies' where name = 'Cleaning Supplies';
update Category set Descript = 'Computer supplies' where name = 'Computer Supplies';

select username from employees where username like 'j%';
select name from product where name like 'O%';

select name from product where UnitCost between 3 and 10;
select name from product where unitCost between 500 and 800;

delete from Product where CatID = (select CatID  from Category where name = 'Audio Visual');
delete from Category where name = 'Audio Visual';

delete from Supplier where name  = 'newSupp11';
delete from Supplier where name  = 'newSupp12';
delete from Supplier where name  = 'newSupp13';

/*4.1*/
set serveroutput on;
create or replace function len_des_las return number is
len number;
begin
    select length(descript) into len from product where name = 'Laser Pointer';
    return len;
end;
/
/*
declare
len number;
begin
    select len_des_las() into len from dual;
    dbms_output.put_line(len);
end;
/*/

create or replace function ucase_user (i_username in varchar) return varchar is
ucased varchar(20);
begin
    select upper(username) into ucased from Employees where username = i_username;
    return ucased;
end;
/
/*
declare
ucase varchar(20);
begin
    select ucase_user('dclark') into ucase from dual;
    dbms_output.put_line(ucase);
end;
/*/

/* 4.2 */
create or replace function sum_unit return number is
sum_u number(10,2);
begin
    select sum(unitcost) into sum_u from product;
    return sum_u;
end;
/
/*
declare
sum_u number;
begin
    select sum_unit() into sum_u from dual;
    dbms_output.put_line(sum_u);
end;
/*/

create or replace function count_prod return number is
count_p number(10,2);
begin
    select count(name) into count_p from product;
    return count_p;
end;
/
/*
declare
coun number;
begin
    select count_prod() into coun from dual;
    dbms_output.put_line(coun);
end;
/*/

/* 4.3 */
create or replace function sum_prod (prod_name varchar, prod_name2 varchar) return number is
sum_p number;
temp_p2 number;
begin
    select unitcost into sum_p from product where name = prod_name;
    select unitcost into temp_p2 from product where name = prod_name2;
    sum_p := sum_p + temp_p2;
    return sum_p;
end;
/
/*
declare
sum_p number;
begin
    select sum_prod('CD-R', 'Ruler') into sum_p from dual;
    dbms_output.put_line(sum_p);
end;
/*/

select * from product;
/* 4.4 */
create or replace function isManager (u_username varchar)return varchar is
bool_str varchar(20);
bool_num number(20);
begin
    select manager into bool_num from Employees where username = u_username;
    if bool_num = 0 then
        select 'false' into bool_str from dual;
    else
        select 'true' into bool_str from dual;
    end if;
    return bool_str;
end;
/
/*
set serveroutput on;
declare
man varchar(20);
begin
    select isManager('dclark') into man from dual;
    dbms_output.put_line(man);
end;
/
*/
/* 5.1 */
create or replace procedure employee_info is
cursor em is select username, department, manager from Employees;
em_row em%ROWTYPE;
begin
    open em;
    loop
        fetch em into em_row;
        exit when em%NOTFOUND;
        dbms_output.put_line(
            'Username: ' || em_row.username ||
            ' Department: '||em_row.department  ||
            ' Manager: ' || em_row.manager
        );
        end loop;
    close em;
end;
/
/*exec employee_info();
/*/

create or replace procedure product_info is
cursor pr is select name, unitcost from Product;
pr_row pr%ROWTYPE;
begin
    open pr;
    loop
        fetch pr into pr_row;
        exit when pr%NOTFOUND;
        dbms_output.put_line(
            'Product: ' || pr_row.name ||
            ' Unit Price: '|| pr_row.unitcost
        );
        end loop;
    close pr;
end;
/
/*
exec product_info();
/*/

/* 5.2 */
create or replace procedure prod_id_info (prod_id varchar) is
Cursor prod is select name, descript from Product where productid = prod_id;
prod_row prod%ROWTYPE;
begin
    open prod;
    fetch prod into prod_row;
    dbms_output.put_line('Product Name: ' || prod_row.name ||
    ' Description: ' || prod_row.descript);
    close prod;
end;
/
/*
exec prod_id_info('ACM-10414');
/*/

create or replace procedure insert_manager(id in number, user in varchar, pass in varchar, na in varchar, dep in char) is
begin
    insert into employees (employeeid, username, password, name, department, manager) 
    values (id, user, pass, na, dep, 1);
end;
/
/*
exec insert_manager(6, 'manager', 'man', 'ma', 'HR');
select * from employees;
*/

/* 5.3 */
create or replace procedure calc_unitcost (sum_unit out number) as
begin
    select sum(unitcost) into sum_unit from product;
end;
/
/*
declare
sum_unit number;
begin
    calc_unitcost(sum_unit);
    dbms_output.put_line(sum_unit);
end;
*/

create or replace procedure uandp (id in number, us out varchar, pa out varchar) as
begin
    select username, password into us, pa from Employees where employeeid = id;
end;
/
/*
declare
    us varchar(20);
    pa varchar(20);
begin
    uandp(1, us, pa);
    dbms_output.put_line('Username: ' || us || ' Password: ' || pa);
end;
/*/

/* 6.0 */
create or replace procedure insert_newEmployee as
begin
    insert into employees values(
    (select count(employeeid) from employees) + 1, 
    'newuser', 'newpass','name', 'NA', 0);
end;
/
exec insert_newEmployee();

create or replace procedure update_price as
begin
    update product set unitcost = unitcost+1 where productid = 'ACM-10414';
end;
/
/*
exec update_price();

select * from product;
*/

create or replace procedure cat_update as
begin
    update category set name = name || 's' where catid = 2;
    update category set name = name || 's' where catid = 3;
end;
/
/*
exec cat_update();
select * from category;
*/

/* 6.1 */
create or replace trigger cat_after_insert
after insert on Category
for each row
begin
    dbms_output.put_line('Insert: '||:new.catid||' '||:new.name);
end;
/

create or replace trigger cat_after_update
after update on Category
for each row
begin
    dbms_output.put_line('Update: '||:new.catid||' '||:new.name);
end;
/

create or replace trigger cat_after_delete
after delete on Category
for each row
begin
    dbms_output.put_line('Delete: '||:old.catid||' '||:old.name);
end;
/
/*
select * from Category;
insert into Category values(9, 'newCat', 'newCat');
select * from Category;
update Category set name = 'newCategory' where catid = 9;
select * from Category;
delete from Category where catid = 9;
select * from Category;
*/

/* 7.2 */
create or replace view product_view as
select * from product;

create or replace trigger delete_prod
instead of delete on product_view
for each row
begin
    if :old.unitcost < 500 then
        delete from product_view where productid = :old.productid;
        delete from product where productid = :old.productid;
    end if;
end;
/
select * from product_view;
delete from product_view where productid = 'MMM-9700P';
delete from product_view where productid = 'ACM-10414';

/* 8.1 */
select product.productid as ProductID, product.catid as CatID, product.name as Product, Category.name as Category
from product inner join category on product.catid = category.catid;

select e.employeeid as EmployeeID, o.orderid as OrderID, o.orderdate as OrderDate, o.status as status
from Employees e inner join Orders o on e.employeeid = o.employeeid;

/* 8.2 */
select p.productid as productid, p.name as product, p.unitcost as unitcost, oi.orderid as orderid, oi.quantity as quantity
from Product p full outer join OrderItem oi on p.productid = oi.productid;

select e.employeeid as EmployeeID, o.orderid as OrderID, o.orderdate as OrderDate, o.status as status
from Employees e full outer join Orders o on e.employeeid = o.employeeid;

/* 8.3 */
select oi.productid as productid, o.orderid as OrderID, o.orderdate as OrderDate, oi.quantity as quantity, o.status as status
from Orders o right outer join OrderItem oi on o.orderid = oi.orderid;

select p.productid as productid, p.name as product, p.unitcost as unitcost, oi.orderid as orderid, oi.quantity as quantity
from Product p left outer join OrderItem oi on p.productid = oi.productid;

/* 8.4 */
select product.productid as ProductID, product.catid as CatID, product.name as Product, Category.name as Category
from product left outer join category on product.catid = category.catid;

select e.employeeid as EmployeeID, o.orderid as OrderID, o.orderdate as OrderDate, o.status as status
from Employees e left outer join Orders o on e.employeeid = o.employeeid;

/* 8.5 */
select * from Employees cross join Category;

/* 8.6 */
select * from employees e1, employees e2 where e1.department = e2.department;

/* 9.0 */
alter table employees add SSN varchar(20);
alter table employees add Salary number(10,2);

create or replace view employees_view as
select employeeid, username, password, name, department, manager from employees;

select * from employees_view;

/* 10.1 */
create table index_sample (
    id number,
    name varchar(20),
    primary key (id)
)organization index;

