-- 2.0 Creating Tables and Relationships

create table employees (
    employee_id number not null,   --pk
    username varchar(20) not null,
    password varchar(20) not null,
    name varchar(25) not null,
    departnemt char(2) not null,
    manager number not null,
    constraint employee_pk
        primary key (employee_id)
);

create table orders (
    order_id number not null, --pk
    employee_id number not null, --fk
    orderdate date not null,
    status char not null,
    constraint order_pk
        primary key (order_id),
    constraint employee_fk
        foreign key (employee_id)
        references employees(employee_id)
);

create table supplier (
    supp_id number not null, --pk
    name varchar(80) null,
    constraint supp_pk
        primary key (supp_id)
); 

create table category (
    cat_id number not null, -- pk
    name varchar(80) null,
    descript varchar(255) null,
    constraint cat_pk
        primary key (cat_id)
);        
create table product (
    product_id number not null, --pk
    cat_id number not null, --fk
    name varchar(80) null,
    descript varchar(255) null,
    unitcost number null,
    supp_id number not null, --fk
    constraint product_pk
        primary key (product_id),
    constraint cat_fk
        foreign key (cat_id)
        references category (cat_id),
    constraint supp_fk
        foreign key (supp_id)
        references supplier(supp_id)   
);        
        
create table orderitem (
    order_id number not null, --pk and fk
    product_id number not null, --pk and fk
    quantity number not null,
    constraint orderid_pk
        primary key (order_id, product_id),
    constraint order_fk
        foreign key (order_id)
        references orders(order_id),
    constraint product_fk
        foreign key (product_id)
        references product (product_id)
);        