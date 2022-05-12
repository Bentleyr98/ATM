use mydb;

SELECT 'INSERT INTO person' AS "Statement";
INSERT INTO person
( first_name
, last_name
, Customer_customer_id)
VALUES
('Jane'
,'Doe'
, (select customer_id from customer where customer_id = 1));

SELECT 'INSERT INTO person' AS "Statement";
INSERT INTO person
( first_name
, last_name
, Customer_customer_id)
VALUES
('John'
,'Smith'
, (select customer_id from customer where customer_id = 2));

SELECT 'INSERT INTO person' AS "Statement";
INSERT INTO person
( first_name
, last_name
, Customer_customer_id)
VALUES
('Josh'
,'Turner'
, (select customer_id from customer where customer_id = 3));

select * from person;

select c.pin, p.first_name 
from customer c inner join  person p 
on p.customer.customer_id = c.customer_id;

SELECT 'INSERT INTO customer' AS "Statement";
INSERT INTO customer
( saving
, checking
, pin)
VALUES
(1500.67, 450.36, 321);


SELECT 'INSERT INTO customer' AS "Statement";
INSERT INTO customer
( saving
, checking
, pin)
VALUES
(500.75, 50.98, 654);


SELECT 'INSERT INTO customer' AS "Statement";
INSERT INTO customer
( saving
, checking
, pin)
VALUES
(1.25, 1450.36, 987);


select * from customer;

select c.saving, c.checking ,p.first_name from 
customer c inner join 
person p on c.customer_id = p.Customer_customer_id;