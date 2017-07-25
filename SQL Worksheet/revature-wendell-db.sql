create or replace function get_date
return date is
    this_date date;
Begin
    this_date := current_date;
end;
/

select get_date from dual;