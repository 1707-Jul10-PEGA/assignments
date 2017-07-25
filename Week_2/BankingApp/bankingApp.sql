CREATE OR REPLACE
procedure  DROP_ALL_SCHEMA_OBJECTS AS
PRAGMA AUTONOMOUS_TRANSACTION;
cursor c_get_objects is
  select object_type,'"'||object_name||'"'||decode(object_type,'TABLE' ,' cascade constraints',null) obj_name
  FROM USER_OBJECTS
  where object_type in ('TABLE','VIEW','PACKAGE','SEQUENCE','SYNONYM', 'MATERIALIZED VIEW', 'TYPE')
  order by object_type;
BEGIN
  begin
    for object_rec in c_get_objects loop
      execute immediate ('drop '||object_rec.object_type||' ' ||object_rec.obj_name);
    end loop;
  end;
END DROP_ALL_SCHEMA_OBJECTS;

/

execute DROP_ALL_SCHEMA_OBJECTS;

CREATE OR REPLACE PROCEDURE DROP_KEY
AS
BEGIN
begin
    for r in ( select table_name, constraint_name
               from user_constraints
               where constraint_type = 'R' )
    loop
        execute immediate 'alter table '||r.table_name
                          ||' drop constraint '||r.constraint_name;
    end loop;
    end loop;
    END;
    END;
/