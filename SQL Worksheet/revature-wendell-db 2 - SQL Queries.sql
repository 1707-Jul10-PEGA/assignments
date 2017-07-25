/* 2.1 Select */

SELECT * 
    FROM chinook.employee;
    
SELECT *
    FROM chinook.employee 
    WHERE lastname = 'King';
SELECT * 
    FROM chinook.employee
    WHERE firstname = 'Andrew'
    AND reportsto IS NULL;

/* 2.2 Order By */

SELECT *
    FROM chinook.album
    ORDER BY title DESC;
SELECT firstname
    FROM chinook.customer
    ORDER BY city ASC;
    
/* 2.3 Insert Into */

Insert 
    into chinook.genre
    values(
        26, 'Wendell'
        );
Insert 
    into chinook.genre
    values(
        26, 'Wendell'
        );
Insert 
    into chinook.genre
    values(
        30, 'Phipps'
        );
select *
    from chinook.genre;
    
/* 2.4 Update */

update chinook.customer
    set 
        firstname  = 'Robert' , lastname = 'Walter'
    where
        firstname = 'Aaron' 
    and lastname = 'Mitchell';

update chinook.artist
    set
        name = 'CCR'
    where
        name = 'Creedence Clearwater Revival';
    
/* 2.5 Like */

Select *
    from chinook.invoice
    where billingaddress like 'T%';
    
    
/* 2.6 Between*/

Select *
    from chinook.invoice
    where total between 15 and 50;
    
select * from chinook.employee
    where hiredate between '01-June-2003' and '01-March-2004';
    
/* 2.7 Delete */

Delete
    from chinook.customer
    where
        firstname = 'Robert'
    and lastname = 'Walter';