/* 3.1 System Defined Functions */

create or replace function get_time
return timestamp is
Begin
    return current_timestamp;
end;
/


select get_time from dual;

create or replace function returnlength(str in varchar2)
    return number is
    myin number;
    begin
        select length(str) into myin from dual;
        return myin;
    end;
/

select returnlength((select name from mediatype where mediatypeid = '1')) as "Length of String" from dual;

/* 3.2 System Defined Aggregate Functions */

create or replace function getavg(
    afteradd number,
    incount number)
    return number is
    avgout number;
    begin
        avgout := (afteradd / incount);
        return avgout;
    end;
/
select getavg((select sum(total) from invoice), (select count(total) from invoice)) from dual;


select max(unitprice) from track;

create or replace function getmax
    return number is
        this_max number;
    begin
        select max(unitprice) into this_max from track;
        return this_max;
    end;
/  
select getmax from dual;

/* 3.3 User Defind Scalar Functions */


create or replace function getavg(
    afteradd number,
    incount number)
    return number is
    avgout number;
    begin
        avgout := (afteradd / incount);
        return avgout;
    end;
/
select getavg((select sum(unitprice) from invoiceline), (select count(unitprice) from invoiceline))as Average_Invoice_Price from dual;


/* 3.4 Tabe Valued */
select firstname, lastname, birthdate from employee where birthdate > to_date('12/31/1967', 'mm-dd-yyyy');


--or

--create or replace type birth_row as object (
--    firstname varchar(255),
--    lastname varchar(255),
--    birthdate date);
--/

create or replace type birth_table as table of birth_row;
/

create or replace function birth_func
 return birth_table
 as
 counter number;
 my_tab birth_table := birth_table();
 f_name varchar(255);
 l_name varchar(255);
 dater date;
begin
    select count(employeeid) into counter from employee where birthdate > '01-jan-1968'; --todate('12-dec'1968)
    
    for i in 1 .. counter loop
        my_tab.extend;
        select firstname into f_name from employee where rownum = i;
        select lastname into l_name from employee where rownum = i;
        select birthdate into dater from employee where rownum = i;
        my_tab(my_tab.last) := birth_row(f_name, l_name, dater);        
    end loop;
    
    return my_tab;
end;
/

set serveroutput on

DECLARE

    results BIRTH_TABLE;
    res_cur sys_refcursor;
     f_name varchar2(255);
     l_name varchar2(255);
     b_day date;
BEGIN
    results := birth_func();
    
    open res_cur for select * from table(results);
    
    LOOP
    FETCH res_cur into f_name, l_name, b_day;
    exit when res_cur%notfound;
    dbms_output.put_line(f_name || l_name || b_day);
    end loop;
    
    close res_cur;
    
    end;
    
    /
