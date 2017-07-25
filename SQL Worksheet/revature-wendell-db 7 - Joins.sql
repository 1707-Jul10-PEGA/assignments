/* 7.1 Inner */

select customer.firstname, customer.lastname, invoice.invoiceid
    from customer
    inner join invoice
    on customer.customerid = invoice.customerid;
    
/* 7.2 Outer */

select customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
    from customer
    full outer join invoice
    on customer.customerid = invoice.customerid;

/* 7.3 Right */

select artist.name, album.title
    from album
    right join artist
    on artist.artistid = album.artistid;

/* 7.4 Cross */

select *
    from album
    cross join artist
    order by artist.name asc;

select * 
    from album, artist
    order by artist.name asc;

/* 7.5 Self */

select * --E1.firstname as fname, E2.lastname as lname if you want to select specific columns
    from employee E1
    join employee E2
    on E1.reportsto = E2.reportsto
    order by E1.reportsto asc;