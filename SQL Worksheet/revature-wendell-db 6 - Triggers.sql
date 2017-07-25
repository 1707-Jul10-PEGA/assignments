/* 6.1 After/Before */

create or replace trigger say_hi
after insert on employee
for each row
begin
    dbms_output.put_line('hello');
end;
/

insert into employee values(100, 'phipps', 'wendell', null, null, null, null, null, null, null, null, null, null, null, null);

create or replace trigger say_bye
after update on employee
for each row
begin
    dbms_output.put_line('update');
end;
/

update employee
    set firstname = 'bob', lastname = 'tomato'
    where firstname = 'wendell'
    and lastname = 'phipps';

create or replace trigger say_why
    after delete on customer
    begin
       dbms_output.put_line('delete');
end;
/

delete from customer
    where firstname = 'bob' and lastname = 'tomato';
    
    
/* 6.2 instead of */

