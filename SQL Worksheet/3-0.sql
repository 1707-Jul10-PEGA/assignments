/* Performing 3.0 SQL Queries */

insert into employees (employee_id, username, password, department, name, manager) values(
    1, 'dclark', 'drc', 'hr', 'derrick clark', 0);

insert into employees (employee_id, username, password, department, name, manager) values(
    2, 'jsmith', 'js', 'it', 'john smith', 1);
    
insert into employees (employee_id, username, password, department, name, manager) values(
    3, 'mjones', 'mj', 'hr', 'mike jones', 1);
    
insert into employees (employee_id, username, password, department, name, manager) values(
    4, 'klink', 'kl', 'it', 'kim link', 1);
    
insert into product (product_id, cat_id, name, descript, unitcost, supp_id) values (
    'acm-10414', 2, 'ruler', '12 inch stainless steel', 3.79, 2);

insert into product (product_id, cat_id, name, descript, unitcost, supp_id) values (
    'apo-cg7070', 1, 'transparency', 'quick dry ink jet', 24.49, 1);
    
insert into product (product_id, cat_id, name, descript, unitcost, supp_id) values (
    'apo-fxl', 1, 'overhead bulb', 'high intensity replacement bulb', 12.00, 1);
    
insert into product (product_id, cat_id, name, descript, unitcost, supp_id) values (
    'apo-mp1200', 1, 'laser pointer', 'general purpose laser pointer', 29.99, 2);

insert into product (product_id, cat_id, name, descript, unitcost, supp_id) values (
    'bin-68401', 2, 'colored pencils', 'non toxic 12 pack', 2.84, 1);

insert into product (product_id, cat_id, name, descript, unitcost, supp_id) values (
    'dra-91249', 3, 'all purpose cleaner', 'use on all washable surfaces', 4.29, 2);
    
insert into product (product_id, cat_id, name, descript, unitcost, supp_id) values (
    'foh-28124', 3, 'paper hand towels', '320 sheets per roll', 5.25, 1);

insert into product (product_id, cat_id, name, descript, unitcost, supp_id) values (
    'imn-41143', 4, 'cd-r', '700 mb with jewel case', 1.09, 1);
    
insert into product (product_id, cat_id, name, descript, unitcost, supp_id) values (
    'kmw-12164', 4, 'monitor wipes', 'non abrasive lint free', 6.99, 2);

insert into product (product_id, cat_id, name, descript, unitcost, supp_id) values (
    'kmw-22256', 4, 'dust blaster', 'ozone safe no cfcs', 8.99, 2);
    
insert into product (product_id, cat_id, name, descript, unitcost, supp_id) values (
    'mmm-6200', 2, 'clear tape', '1 inch wide 6 rolls', 3.90, 1);

insert into product (product_id, cat_id, name, descript, unitcost, supp_id) values (
    'mmm-9700p', 1, 'overhead projector', 'portable with travel cover', 759.97, 1);

insert into product (product_id, cat_id, name, descript, unitcost, supp_id) values (
    'oic-5000', 2, 'glue stick', 'oderless non toxic', 1.99, 2);
    
insert into supplier (supp_id, name) values(
    1, 'audio visual');
insert into supplier (supp_id, name) values(
    2, 'art supplies');

insert into supplier (supp_id, name) values(3, 'cleaning supplies');

insert into supplier (supp_id, name) values(4, 'computer supplies');

insert into supplier (supp_id, name) values(5, 'desk accessories');

insert into supplier (supp_id, name) values(6, 'writing supplies');

insert into supplier (supp_id, name) values(7, 'printer supplies');