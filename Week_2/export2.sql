--------------------------------------------------------
--  File created - Saturday-July-22-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CATEGOR
--------------------------------------------------------

  CREATE TABLE "MSEIF2015"."CATEGOR" 
   (	"CATID" NUMBER, 
	"NAME" VARCHAR2(80 BYTE), 
	"DESCRIPT" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CATEGORY
--------------------------------------------------------

  CREATE TABLE "MSEIF2015"."CATEGORY" 
   (	"CATID" NUMBER, 
	"NAME" VARCHAR2(80 BYTE), 
	"DESCRIPT" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table EMPLOYEES
--------------------------------------------------------

  CREATE TABLE "MSEIF2015"."EMPLOYEES" 
   (	"EMPLOYEEID" NUMBER, 
	"USERNAME" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE), 
	"NAME" VARCHAR2(25 BYTE), 
	"DEPARTMENT" CHAR(2 BYTE), 
	"MANAGER" NUMBER, 
	"SSN" NUMBER, 
	"SALARY" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table FLASH_CARDS
--------------------------------------------------------

  CREATE TABLE "MSEIF2015"."FLASH_CARDS" 
   (	"FC_ID" NUMBER(38,0), 
	"FC_QUESTION" VARCHAR2(4000 BYTE), 
	"FC_ANSWER" VARCHAR2(4000 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MYTABLE
--------------------------------------------------------

  CREATE TABLE "MSEIF2015"."MYTABLE" 
   (	"MYID" NUMBER(*,0), 
	"MYVALUE" VARCHAR2(255 BYTE), 
	 CONSTRAINT "MYPK" PRIMARY KEY ("MYID") ENABLE
   ) ORGANIZATION INDEX NOCOMPRESS PCTFREE 10 INITRANS 2 MAXTRANS 255 LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
 PCTTHRESHOLD 50;
--------------------------------------------------------
--  DDL for Table ORDERITEM
--------------------------------------------------------

  CREATE TABLE "MSEIF2015"."ORDERITEM" 
   (	"ORDERID" NUMBER, 
	"PRODUCTID" NUMBER, 
	"QUANTITY" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ORDERS
--------------------------------------------------------

  CREATE TABLE "MSEIF2015"."ORDERS" 
   (	"ORDERID" NUMBER, 
	"EMPLOYEEID" NUMBER, 
	"ORDERDATE" DATE, 
	"STATUS" CHAR(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PRODUCT
--------------------------------------------------------

  CREATE TABLE "MSEIF2015"."PRODUCT" 
   (	"PRODUCTID" NUMBER, 
	"CATID" NUMBER, 
	"NAME" VARCHAR2(80 BYTE), 
	"DESCRIPT" VARCHAR2(255 BYTE), 
	"UNITCOST" NUMBER, 
	"SUPPID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SUPPLIER
--------------------------------------------------------

  CREATE TABLE "MSEIF2015"."SUPPLIER" 
   (	"SUPPID" NUMBER, 
	"NAME" VARCHAR2(80 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into MSEIF2015.CATEGOR
SET DEFINE OFF;
Insert into MSEIF2015.CATEGOR (CATID,NAME,DESCRIPT) values (2,'Art Supplies',null);
Insert into MSEIF2015.CATEGOR (CATID,NAME,DESCRIPT) values (3,'Cleaning Supplies','Do not swallow');
Insert into MSEIF2015.CATEGOR (CATID,NAME,DESCRIPT) values (4,'Computer Supplies','Do not swallow');
Insert into MSEIF2015.CATEGOR (CATID,NAME,DESCRIPT) values (5,'Desk Accessories',null);
Insert into MSEIF2015.CATEGOR (CATID,NAME,DESCRIPT) values (6,'Writing Supplies',null);
Insert into MSEIF2015.CATEGOR (CATID,NAME,DESCRIPT) values (7,'Printer Supplies',null);
Insert into MSEIF2015.CATEGOR (CATID,NAME,DESCRIPT) values (8,'Swarms of Angry Bees',null);
REM INSERTING into MSEIF2015.CATEGORY
SET DEFINE OFF;
REM INSERTING into MSEIF2015.EMPLOYEES
SET DEFINE OFF;
Insert into MSEIF2015.EMPLOYEES (EMPLOYEEID,USERNAME,PASSWORD,NAME,DEPARTMENT,MANAGER,SSN,SALARY) values (1,'dclark','drc','Dave','HR',1,null,null);
Insert into MSEIF2015.EMPLOYEES (EMPLOYEEID,USERNAME,PASSWORD,NAME,DEPARTMENT,MANAGER,SSN,SALARY) values (2,'jsmith','js','John','IT',2,null,null);
Insert into MSEIF2015.EMPLOYEES (EMPLOYEEID,USERNAME,PASSWORD,NAME,DEPARTMENT,MANAGER,SSN,SALARY) values (3,'mjones','mj','Mike','HR',2,null,null);
Insert into MSEIF2015.EMPLOYEES (EMPLOYEEID,USERNAME,PASSWORD,NAME,DEPARTMENT,MANAGER,SSN,SALARY) values (4,'klink','kl','Kara','IT',1,null,null);
Insert into MSEIF2015.EMPLOYEES (EMPLOYEEID,USERNAME,PASSWORD,NAME,DEPARTMENT,MANAGER,SSN,SALARY) values (14,'JWAFFLE','JW','WAFFLES','HR',1,null,null);
Insert into MSEIF2015.EMPLOYEES (EMPLOYEEID,USERNAME,PASSWORD,NAME,DEPARTMENT,MANAGER,SSN,SALARY) values (15,'BMAN','HONEY','BEES','SA',2,null,null);
REM INSERTING into MSEIF2015.FLASH_CARDS
SET DEFINE OFF;
Insert into MSEIF2015.FLASH_CARDS (FC_ID,FC_QUESTION,FC_ANSWER) values (1,'Who are you?','Who who who who');
Insert into MSEIF2015.FLASH_CARDS (FC_ID,FC_QUESTION,FC_ANSWER) values (2,'Why am I sticky?','Honey');
REM INSERTING into MSEIF2015.MYTABLE
SET DEFINE OFF;
REM INSERTING into MSEIF2015.ORDERITEM
SET DEFINE OFF;
Insert into MSEIF2015.ORDERITEM (ORDERID,PRODUCTID,QUANTITY) values (1111,13,1);
Insert into MSEIF2015.ORDERITEM (ORDERID,PRODUCTID,QUANTITY) values (1111,6,3);
Insert into MSEIF2015.ORDERITEM (ORDERID,PRODUCTID,QUANTITY) values (1111,3,1);
Insert into MSEIF2015.ORDERITEM (ORDERID,PRODUCTID,QUANTITY) values (1111,2,10);
Insert into MSEIF2015.ORDERITEM (ORDERID,PRODUCTID,QUANTITY) values (1112,13,1);
REM INSERTING into MSEIF2015.ORDERS
SET DEFINE OFF;
Insert into MSEIF2015.ORDERS (ORDERID,EMPLOYEEID,ORDERDATE,STATUS) values (1111,1,to_date('11-MAR-99','DD-MON-RR'),'A');
Insert into MSEIF2015.ORDERS (ORDERID,EMPLOYEEID,ORDERDATE,STATUS) values (1112,1,to_date('11-JUN-00','DD-MON-RR'),'A');
REM INSERTING into MSEIF2015.PRODUCT
SET DEFINE OFF;
Insert into MSEIF2015.PRODUCT (PRODUCTID,CATID,NAME,DESCRIPT,UNITCOST,SUPPID) values (1,2,'Ruler','12 inch stainless steel',0.5,2);
Insert into MSEIF2015.PRODUCT (PRODUCTID,CATID,NAME,DESCRIPT,UNITCOST,SUPPID) values (2,1,'Transparency','Quick dry ink jet',24.49,1);
Insert into MSEIF2015.PRODUCT (PRODUCTID,CATID,NAME,DESCRIPT,UNITCOST,SUPPID) values (3,1,'Overhead Bulb','High intensity replacement bulb',12,1);
Insert into MSEIF2015.PRODUCT (PRODUCTID,CATID,NAME,DESCRIPT,UNITCOST,SUPPID) values (4,1,'Laser Pointer','General purpose laser pointer',29.99,2);
Insert into MSEIF2015.PRODUCT (PRODUCTID,CATID,NAME,DESCRIPT,UNITCOST,SUPPID) values (5,2,'Colored pencils','Non toxic 12 pack',2.84,1);
Insert into MSEIF2015.PRODUCT (PRODUCTID,CATID,NAME,DESCRIPT,UNITCOST,SUPPID) values (6,3,'All purpose cleaner','Use on all washable surfaces',4.29,2);
Insert into MSEIF2015.PRODUCT (PRODUCTID,CATID,NAME,DESCRIPT,UNITCOST,SUPPID) values (7,3,'Paper hand towels','320 sheets per roll',5.25,1);
Insert into MSEIF2015.PRODUCT (PRODUCTID,CATID,NAME,DESCRIPT,UNITCOST,SUPPID) values (8,4,'CD-R','700 mb with jewel case',1.09,1);
Insert into MSEIF2015.PRODUCT (PRODUCTID,CATID,NAME,DESCRIPT,UNITCOST,SUPPID) values (9,4,'3.5 inch disks','High density formatted box of 10',5.99,1);
Insert into MSEIF2015.PRODUCT (PRODUCTID,CATID,NAME,DESCRIPT,UNITCOST,SUPPID) values (10,4,'Monitor wipes','Non abrasive lint free',6.99,2);
Insert into MSEIF2015.PRODUCT (PRODUCTID,CATID,NAME,DESCRIPT,UNITCOST,SUPPID) values (11,4,'Dust blaster','Ozone safe no CFSs',8.99,2);
Insert into MSEIF2015.PRODUCT (PRODUCTID,CATID,NAME,DESCRIPT,UNITCOST,SUPPID) values (12,2,'Clear tape','1 inch wide 6 rolls',3.9,1);
Insert into MSEIF2015.PRODUCT (PRODUCTID,CATID,NAME,DESCRIPT,UNITCOST,SUPPID) values (13,1,'Overhead projector','Portable with travel cover',759.97,1);
Insert into MSEIF2015.PRODUCT (PRODUCTID,CATID,NAME,DESCRIPT,UNITCOST,SUPPID) values (14,2,'Glue stick','Odorless non toxic',1.99,2);
REM INSERTING into MSEIF2015.SUPPLIER
SET DEFINE OFF;
Insert into MSEIF2015.SUPPLIER (SUPPID,NAME) values (1,'XYZ Office supplies');
Insert into MSEIF2015.SUPPLIER (SUPPID,NAME) values (2,'ABC Office products');
--------------------------------------------------------
--  DDL for Index CATEGOR
--------------------------------------------------------

  CREATE UNIQUE INDEX "MSEIF2015"."CATEGOR" ON "MSEIF2015"."CATEGOR" ("CATID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index EMPLOYEES
--------------------------------------------------------

  CREATE UNIQUE INDEX "MSEIF2015"."EMPLOYEES" ON "MSEIF2015"."EMPLOYEES" ("EMPLOYEEID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index FLASH_CARDS
--------------------------------------------------------

  CREATE UNIQUE INDEX "MSEIF2015"."FLASH_CARDS" ON "MSEIF2015"."FLASH_CARDS" ("FC_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C004107
--------------------------------------------------------

  CREATE UNIQUE INDEX "MSEIF2015"."SYS_C004107" ON "MSEIF2015"."FLASH_CARDS" ("FC_QUESTION") 
  PCTFREE 10 INITRANS 2 MAXTRANS 167 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MYPK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MSEIF2015"."MYPK" ON "MSEIF2015"."MYTABLE" ("MYID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index ORDERITEM
--------------------------------------------------------

  CREATE UNIQUE INDEX "MSEIF2015"."ORDERITEM" ON "MSEIF2015"."ORDERITEM" ("ORDERID", "PRODUCTID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index ORDERS
--------------------------------------------------------

  CREATE UNIQUE INDEX "MSEIF2015"."ORDERS" ON "MSEIF2015"."ORDERS" ("ORDERID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PRODUCT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MSEIF2015"."PRODUCT_PK" ON "MSEIF2015"."PRODUCT" ("PRODUCTID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SUPPLIER
--------------------------------------------------------

  CREATE UNIQUE INDEX "MSEIF2015"."SUPPLIER" ON "MSEIF2015"."SUPPLIER" ("SUPPID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger T3
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "MSEIF2015"."T3" 
    AFTER DELETE ON CATEGOR
    FOR EACH ROW
    BEGIN
        SELECT 2*2 FROM DUAL;
    END;

/
ALTER TRIGGER "MSEIF2015"."T3" ENABLE;
--------------------------------------------------------
--  DDL for Trigger T2
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "MSEIF2015"."T2" 
    AFTER UPDATE ON CATEGOR
    FOR EACH ROW
    BEGIN
        SELECT 2*2 FROM DUAL;
    END;

/
ALTER TRIGGER "MSEIF2015"."T2" ENABLE;
--------------------------------------------------------
--  DDL for Trigger NEW_FC_TRIG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "MSEIF2015"."NEW_FC_TRIG" 
    BEFORE INSERT ON FLASH_CARDS
    FOR EACH ROW
    BEGIN
        SELECT FC_SEQ.NEXTVAL INTO    :NEW.FC_ID FROM DUAL;
    END;

/
ALTER TRIGGER "MSEIF2015"."NEW_FC_TRIG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger T4
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "MSEIF2015"."T4" 
    BEFORE DELETE ON PRODUCT
    FOR EACH ROW
    BEGIN
        IF :OLD.UNITCOST < 500 THEN
            RAISE_APPLICATION_ERROR(-20001,'Record cannot be deleted.');
        END IF;
    END;

/
ALTER TRIGGER "MSEIF2015"."T4" ENABLE;
--------------------------------------------------------
--  Constraints for Table CATEGOR
--------------------------------------------------------

  ALTER TABLE "MSEIF2015"."CATEGOR" ADD CONSTRAINT "CATEGOR" PRIMARY KEY ("CATID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "MSEIF2015"."CATEGOR" MODIFY ("CATID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CATEGORY
--------------------------------------------------------

  ALTER TABLE "MSEIF2015"."CATEGORY" MODIFY ("CATID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EMPLOYEES
--------------------------------------------------------

  ALTER TABLE "MSEIF2015"."EMPLOYEES" ADD CONSTRAINT "EMPLOYEES" PRIMARY KEY ("EMPLOYEEID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "MSEIF2015"."EMPLOYEES" MODIFY ("MANAGER" NOT NULL ENABLE);
  ALTER TABLE "MSEIF2015"."EMPLOYEES" MODIFY ("DEPARTMENT" NOT NULL ENABLE);
  ALTER TABLE "MSEIF2015"."EMPLOYEES" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "MSEIF2015"."EMPLOYEES" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "MSEIF2015"."EMPLOYEES" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "MSEIF2015"."EMPLOYEES" MODIFY ("EMPLOYEEID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table FLASH_CARDS
--------------------------------------------------------

  ALTER TABLE "MSEIF2015"."FLASH_CARDS" ADD UNIQUE ("FC_QUESTION")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 167 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "MSEIF2015"."FLASH_CARDS" ADD CONSTRAINT "FLASH_CARDS" PRIMARY KEY ("FC_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "MSEIF2015"."FLASH_CARDS" MODIFY ("FC_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MYTABLE
--------------------------------------------------------

  ALTER TABLE "MSEIF2015"."MYTABLE" ADD CONSTRAINT "MYPK" PRIMARY KEY ("MYID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ORDERITEM
--------------------------------------------------------

  ALTER TABLE "MSEIF2015"."ORDERITEM" ADD CONSTRAINT "ORDERITEM" PRIMARY KEY ("ORDERID", "PRODUCTID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "MSEIF2015"."ORDERITEM" MODIFY ("QUANTITY" NOT NULL ENABLE);
  ALTER TABLE "MSEIF2015"."ORDERITEM" MODIFY ("PRODUCTID" NOT NULL ENABLE);
  ALTER TABLE "MSEIF2015"."ORDERITEM" MODIFY ("ORDERID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ORDERS
--------------------------------------------------------

  ALTER TABLE "MSEIF2015"."ORDERS" ADD CONSTRAINT "ORDERS" PRIMARY KEY ("ORDERID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "MSEIF2015"."ORDERS" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "MSEIF2015"."ORDERS" MODIFY ("ORDERDATE" NOT NULL ENABLE);
  ALTER TABLE "MSEIF2015"."ORDERS" MODIFY ("EMPLOYEEID" NOT NULL ENABLE);
  ALTER TABLE "MSEIF2015"."ORDERS" MODIFY ("ORDERID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PRODUCT
--------------------------------------------------------

  ALTER TABLE "MSEIF2015"."PRODUCT" ADD CONSTRAINT "PRODUCT_PK" PRIMARY KEY ("PRODUCTID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "MSEIF2015"."PRODUCT" MODIFY ("SUPPID" NOT NULL ENABLE);
  ALTER TABLE "MSEIF2015"."PRODUCT" MODIFY ("CATID" NOT NULL ENABLE);
  ALTER TABLE "MSEIF2015"."PRODUCT" MODIFY ("PRODUCTID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SUPPLIER
--------------------------------------------------------

  ALTER TABLE "MSEIF2015"."SUPPLIER" ADD CONSTRAINT "SUPPLIER" PRIMARY KEY ("SUPPID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "MSEIF2015"."SUPPLIER" MODIFY ("SUPPID" NOT NULL ENABLE);
