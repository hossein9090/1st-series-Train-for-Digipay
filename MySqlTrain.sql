create schema dbTrain;

use dbTrain;

create table salesman(
	salesman_id int not null primary key,
    name varchar(25),
    city varchar(25),
    commision double
);

insert into salesman value(1,'David Brown','New York',0.15);
insert into salesman value(2,'Paul Adam','London',0.12);
insert into salesman value(3,'Jimmy walker','Paris',0.18);
insert into salesman value(4,'James Hen','Paris',0.15);

create table customer(
	customer_id int not null primary key,
    cust_name varchar(25),
    city varchar(25),
    grade int,
    salesman_id int,
    constraint fk_salesman foreign key(salesman_id)
    references salesman(salesman_id)
);


insert into customer value(5001,'Sara','London','120',2);
insert into customer value(5002,'Tony','Paris','200',1);
insert into customer value(5003,'Jason','Tehran','90',3);
insert into customer value(5004,'Creistian','London','110',4);


create table orders(
	ord_no int not null primary key,
    purch_amt double,
    customer_id int,
    constraint fk_customer foreign key(customer_id)
    references customer(customer_id),
    salesman_id int,
    constraint fk_salesmanOrd foreign key(salesman_id)
    references salesman(salesman_id)
);



insert into orders value(3001,120.5,5003,1);
insert into orders value(3002,95.62,5001,4);
insert into orders value(3003,130.0,5004,3);
insert into orders value(3004,230.5,5002,2);


--  Train :

-- 1)From the following tables write a SQL query to find the salesperson and 
-- customer who reside in the same city. Return Salesman, cust_name and city.

SELECT salesman.name AS "Salesman",
customer.cust_name, customer.city 
FROM salesman,customer 
WHERE salesman.city=customer.city;

-- 2)From the following tables write a SQL query to find those orders where the order amount
--  exists between 500 and 2000. Return ord_no, purch_amt, cust_name, city.

SELECT  a.ord_no,a.purch_amt,
b.cust_name,b.city 
FROM orders a,customer b 
WHERE a.customer_id=b.customer_id 
AND a.purch_amt BETWEEN 100 AND 140;

-- 3)From the following tables write a SQL query to find the salesperson(s) and 
-- the customer(s) he represents. Return Customer Name, city, Salesman, commission.

SELECT a.cust_name AS "Customer Name", 
a.city, b.name AS "Salesman", b.commision 
FROM customer a 
INNER JOIN salesman b 
ON a.salesman_id=b.salesman_id;

-- 4)From the following tables write a SQL query to find salespeople who received commissions
--  of more than 12 percent from the company. Return Customer Name,
--  customer city, Salesman, commission.

SELECT a.cust_name AS "Customer Name", 
a.city, b.name AS "Salesman", b.commision 
FROM customer a 
INNER JOIN salesman b 
ON a.salesman_id=b.salesman_id 
WHERE b.commision>.12;

-- 5)From the following tables write a SQL query to locate those salespeople who do not live in the
--  same city where their customers live and have received a commission of morethan 12% from the 
--  company. Return Customer Name, customer city, Salesman, salesman city, commission.

SELECT a.cust_name AS "Customer Name", 
a.city, b.name AS "Salesman", b.city,b.commision  
FROM customer a  
INNER JOIN salesman b  
ON a.salesman_id=b.salesman_id 
WHERE b.commision>.12 
AND a.city<>b.city;

-- 6)From the following tables write a SQL query to find the details of an order. Return ord_no,
--  ord_date, purch_amt, Customer Name, grade, Salesman, commission.

SELECT a.ord_no,a.purch_amt,
b.cust_name AS "Customer Name", b.grade, 
c.name AS "Salesman", c.commision 
FROM orders a 
INNER JOIN customer b 
ON a.customer_id=b.customer_id 
INNER JOIN salesman c 
ON a.salesman_id=c.salesman_id;

-- 7)Write a SQL statement to join the tables salesman, customer and orders so that the same
--  column of each table appears once and only the relational rows are returned.

SELECT * 
FROM orders 
NATURAL JOIN customer  
NATURAL JOIN salesman;

-- 8)From the following tables write a SQL query to display the customer name, customer city, grade,
--  salesman, salesman city. The results should be sorted by ascending customer_id.

SELECT a.cust_name,a.city,a.grade, 
b.name AS "Salesman",b.city 
FROM customer a 
LEFT JOIN salesman b 
ON a.salesman_id=b.salesman_id 
order by a.customer_id;

-- 9)From the following tables write a SQL query to find those customers with a grade less than 300.
--  Return cust_name, customer city, grade, Salesman, salesmancity. The result should be ordered
--  by ascending customer_id.

SELECT a.cust_name,a.city,a.grade, 
b.name AS "Salesman", b.city 
FROM customer a 
LEFT OUTER JOIN salesman b 
ON a.salesman_id=b.salesman_id 
WHERE a.grade<300 
ORDER BY a.customer_id;

-- 10)Write a SQL statement to make a report with customer name, city, order number, order date,
--  and order amount in ascending order according to the cust_name to determine whether any of
--  the existing customers have placed an order or not.

SELECT a.cust_name,a.city, b.ord_no,
b.purch_amt AS "Order Amount" 
FROM customer a 
LEFT OUTER JOIN orders b 
ON a.customer_id=b.customer_id 
order by a.cust_name;

-- 11)SQL statement to generate a report with customer name, city, order number, order date,
--  order amount, salesperson name, and commission to determine if any of the existing customers
--  have not placed orders or if they have placed orders through their salesman or by themselves.

SELECT a.cust_name,a.city, b.ord_no,
b.purch_amt AS "Order Amount", 
c.name,c.commision 
FROM customer a 
LEFT OUTER JOIN orders b 
ON a.customer_id=b.customer_id 
LEFT OUTER JOIN salesman c 
ON c.salesman_id=b.salesman_id;

-- 12)Write a SQL statement to generate a list in ascending order of salespersons who work either
--  for one or more customers or have not yet joined any of the customers.

SELECT a.cust_name,a.city,a.grade, 
b.name AS "Salesman", b.city 
FROM customer a 
RIGHT OUTER JOIN salesman b 
ON b.salesman_id=a.salesman_id 
ORDER BY b.salesman_id;

-- 13)From the following tables write a SQL query to list all salespersons along with customer name,
--  city, grade, order number, date, and amount. Condition for selecting list of salesmen :
--  1. Salesmen who works for one or more customer or, 2. Salesmen who not yet join under any
--  customer, Condition for selecting list of customer : 3. placed one or more orders, or
--  4. no order placed to their salesman.

SELECT a.cust_name,a.city,a.grade, 
b.name AS "Salesman", 
c.ord_no, c.purch_amt 
FROM customer a 
RIGHT OUTER JOIN salesman b 
ON b.salesman_id=a.salesman_id 
RIGHT OUTER JOIN orders c 
ON c.customer_id=a.customer_id;

-- 14)Write a SQL statement to make a list for the salesmen who either work for one or more customers
--  or yet to join any of the customer. The customer, may have placed, either one or more orders
--  on or above order amount 2000 and must have a grade, or he may not have placed any order to
--  the associated supplier.

SELECT a.cust_name,a.city,a.grade, 
b.name AS "Salesman", 
c.ord_no, c.purch_amt 
FROM customer a 
RIGHT OUTER JOIN salesman b 
ON b.salesman_id=a.salesman_id 
LEFT OUTER JOIN orders c 
ON c.customer_id=a.customer_id 
WHERE c.purch_amt>=125 
AND a.grade IS NOT NULL;

-- 15)Write a SQL statement to generate a list of all the salesmen who either work for one or more
--  customers or have yet to join any of them. The customer may have placed one or more orders at or
--  above order amount 2000, and must have a grade, or he may not have placed any orders to the
--  associated supplier.

SELECT a.cust_name,a.city, b.ord_no,
b.purch_amt AS "Order Amount" 
FROM customer a 
LEFT OUTER JOIN orders b 
ON a.customer_id=b.customer_id;

-- 16)Write a SQL statement to generate a report with the customer name, city, order no. order date,
--  purchase amount for only those customers on the list who must have a grade and placed one or more
--  orders or which order(s) have been placed by the customer who neither is on the list nor has
--  a grade.

SELECT a.cust_name,a.city, b.ord_no,
b.purch_amt AS "Order Amount" 
FROM customer a 
join orders b 
ON a.customer_id=b.customer_id 
WHERE a.grade IS NOT NULL;


-- 17)Write a SQL query to combine each row of the salesman table with each row of the customer table.
-- Sample table: salesman

SELECT * 
FROM salesman a 
CROSS JOIN customer b;

-- 18)Write a SQL statement to create a Cartesian product between salesperson and customer,
--  i.e. each salesperson will appear for all customers and vice versa for that salesperson
--  who belongs to that city.

SELECT * 
FROM salesman a 
CROSS JOIN customer b 
WHERE a.city IS NOT NULL;

-- 19)Write a SQL statement to create a Cartesian product between salesperson and customer,
--  i.e. each salesperson will appear for every customer and vice versa for those salesmen who
--  belong to a city and customers who require a grade.

SELECT * 
FROM salesman a 
CROSS JOIN  customer b 
WHERE a.city IS NOT NULL 
AND b.grade IS NOT NULL;

-- 20)Write a SQL statement to make a Cartesian product between salesman and customer i.e. each 
-- salesman will appear for all customers and vice versa for those salesmen who must belong to a city
--  which is not the same as his customer and the customers should have their own grade.

SELECT * 
FROM salesman a 
CROSS JOIN customer b 
WHERE a.city IS NOT NULL 
AND b.grade IS NOT NULL 
AND  a.city<>b.city;



