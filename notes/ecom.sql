use ecom_incedojuly24;

show tables; 

describe product;

INSERT INTO address (id, pnum, street, city, pincode) VALUES
(1, '12345', 'Elm Street', 'Springfield', '12345'),
(2, '23456', 'Oak Street', 'Shelbyville', '23456'),
(3, '34567', 'Maple Avenue', 'Capital City', '34567'),
(4, '45678', 'Pine Lane', 'Ogdenville', '45678'),
(5, '56789', 'Cedar Road', 'North Haverbrook', '56789'),
(6, '67890', 'Birch Boulevard', 'Brockway', '67890'),
(7, '78901', 'Walnut Way', 'Cypress Creek', '78901'),
(8, '89012', 'Ash Alley', 'Waverly Hills', '89012'),
(9, '90123', 'Cherry Court', 'Springfield', '90123'),
(10, '01234', 'Willow Walk', 'Shelbyville', '01234');

INSERT INTO stock (id, count) VALUES
(1, 100),
(2, 200),
(3, 150),
(4, 300),
(5, 250),
(6, 180),
(7, 220),
(8, 160),
(9, 140),
(10, 110),
(11, 90),
(12, 130),
(13, 170),
(14, 190),
(15, 210),
(16, 230),
(17, 240),
(18, 260),
(19, 270),
(20, 280);

describe customer;
INSERT INTO customer (id, name, email, address_id) VALUES
(1, 'John Doe', 'john.doe@example.com', 1),
(2, 'Jane Smith', 'jane.smith@example.com', 2),
(3, 'Alice Johnson', 'alice.johnson@example.com', 3),
(4, 'Bob Brown', 'bob.brown@example.com', 4),
(5, 'Charlie Davis', 'charlie.davis@example.com', 5),
(6, 'Emily Evans', 'emily.evans@example.com', 6),
(7, 'Frank Green', 'frank.green@example.com', 7),
(8, 'Grace Hall', 'grace.hall@example.com', 8),
(9, 'Henry Adams', 'henry.adams@example.com', 9),
(10, 'Ivy Baker', 'ivy.baker@example.com', 10);

delete from customer;

INSERT INTO vendor (id, name, city) VALUES
(1, 'Vendor A', 'City X'),
(2, 'Vendor B', 'City Y'),
(3, 'Vendor C', 'City Z'),
(4, 'Vendor D', 'City W'),
(5, 'Vendor E', 'City V');

 
INSERT INTO category (id,name) values 
(1,'category 1'),
(2,'category 2'),
(3,'category 3'),
(4,'category 4'),
(5,'category 5');


INSERT INTO product (id, title, description, price, isFeatured, category_id, vendor_id, stock_id) VALUES
(1, 'Product 1', 'Description 1', 10.99, 1, 1, 1, 1),
(2, 'Product 2', 'Description 2', 12.99, 0, 2, 2, 2),
(3, 'Product 3', 'Description 3', 15.99, 1, 3, 3, 3),
(4, 'Product 4', 'Description 4', 8.99, 0, 4, 4, 4),
(5, 'Product 5', 'Description 5', 6.99, 1, 5, 5, 5),
(6, 'Product 6', 'Description 6', 7.99, 0, 1, 1, 6),
(7, 'Product 7', 'Description 7', 9.99, 1, 2, 2, 7),
(8, 'Product 8', 'Description 8', 11.99, 0, 3, 3, 8),
(9, 'Product 9', 'Description 9', 13.99, 1, 4, 4, 9),
(10, 'Product 10', 'Description 10', 14.99, 0, 5, 5, 10),
(11, 'Product 11', 'Description 11', 16.99, 1, 1, 1, 11),
(12, 'Product 12', 'Description 12', 18.99, 0, 2, 2, 12),
(13, 'Product 13', 'Description 13', 19.99, 1, 3, 3, 13),
(14, 'Product 14', 'Description 14', 20.99, 0, 4, 4, 14),
(15, 'Product 15', 'Description 15', 22.99, 1, 5, 5, 15),
(16, 'Product 16', 'Description 16', 23.99, 0, 1, 1, 16),
(17, 'Product 17', 'Description 17', 24.99, 1, 2, 2, 17),
(18, 'Product 18', 'Description 18', 25.99, 0, 3, 3, 18),
(19, 'Product 19', 'Description 19', 26.99, 1, 4, 4, 19),
(20, 'Product 20', 'Description 20', 27.99, 0, 5, 5, 20);


INSERT INTO customer_product (customer_id, product_id, date_of_purchase, coupon, quantity) VALUES
(1, 1, '2023-07-01', 'SAVE10', 2),
(1, 2, '2023-07-02', 'SAVE20', 1),
(2, 3, '2023-07-03', 'SAVE10', 3),
(2, 4, '2023-07-04', 'SAVE20', 1),
(3, 5, '2023-07-05', 'SAVE10', 2),
(3, 6, '2023-07-06', 'SAVE20', 1),
(4, 7, '2023-07-07', 'SAVE10', 3),
(4, 8, '2023-07-08', 'SAVE20', 1),
(5, 9, '2023-07-09', 'SAVE10', 2),
(5, 10, '2023-07-10', 'SAVE20', 1),
(6, 11, '2023-07-11', 'SAVE10', 3),
(6, 12, '2023-07-12', 'SAVE20', 1),
(7, 13, '2023-07-13', 'SAVE10', 2),
(7, 14, '2023-07-14', 'SAVE20', 1),
(8, 15, '2023-07-15', 'SAVE10', 3),
(8, 16, '2023-07-16', 'SAVE20', 1),
(9, 17, '2023-07-17', 'SAVE10', 2),
(9, 18, '2023-07-18', 'SAVE20', 1),
(10, 19, '2023-07-19', 'SAVE10', 3),
(10, 20, '2023-07-20', 'SAVE20', 1),
(1, 3, '2023-07-21', 'SAVE10', 2),
(1, 4, '2023-07-22', 'SAVE20', 1),
(2, 5, '2023-07-23', 'SAVE10', 3),
(2, 6, '2023-07-24', 'SAVE20', 1),
(3, 7, '2023-07-25', 'SAVE10', 2),
(3, 8, '2023-07-26', 'SAVE20', 1),
(4, 9, '2023-07-27', 'SAVE10', 3),
(4, 10, '2023-07-28', 'SAVE20', 1),
(5, 11, '2023-07-29', 'SAVE10', 2),
(5, 12, '2023-07-30', 'SAVE20', 1),
(6, 13, '2023-07-31', 'SAVE10', 3),
(6, 14, '2023-08-01', 'SAVE20', 1),
(7, 15, '2023-08-02', 'SAVE10', 2),
(7, 16, '2023-08-03', 'SAVE20', 1),
(8, 17, '2023-08-04', 'SAVE10', 3),
(8, 18, '2023-08-05', 'SAVE20', 1),
(9, 19, '2023-08-06', 'SAVE10', 2),
(9, 20, '2023-08-07', 'SAVE20', 1),
(10, 1, '2023-08-08', 'SAVE10', 3),
(10, 2, '2023-08-09', 'SAVE20', 1),
(1, 5, '2023-08-10', 'SAVE10', 2),
(1, 6, '2023-08-11', 'SAVE20', 1),
(2, 7, '2023-08-12', 'SAVE10', 3),
(2, 8, '2023-08-13', 'SAVE20', 1),
(3, 9, '2023-08-14', 'SAVE10', 2),
(3, 10, '2023-08-15', 'SAVE20', 1);



INSERT INTO review (id, message, rating, customer_id, product_id) VALUES
(1, 'Great product!', 5, 1, 1),
(2, 'Not bad', 4, 2, 2),
(3, 'Could be better', 3, 3, 3),
(4, 'Excellent quality', 5, 4, 4),
(5, 'Very satisfied', 4, 5, 5),
(6, 'Highly recommend', 5, 6, 6),
(7, 'Not what I expected', 2, 7, 7),
(8, 'Worth the price', 4, 8, 8),
(9, 'Just okay', 3, 9, 9),
(10, 'Fantastic!', 5, 10, 10),
(11, 'Great value', 4, 1, 11),
(12, 'Will buy again', 5, 2, 12),
(13, 'Disappointed', 2, 3, 13),
(14, 'Very good', 4, 4, 14),
(15, 'Love it', 5, 5, 15),
(16, 'Not worth it', 2, 6, 16),
(17, 'Average', 3, 7, 17),
(18, 'Exceeded expectations', 5, 8, 18),
(19, 'Terrible', 1, 9, 19),
(20, 'Pretty good', 4, 10, 20),
(21, 'Amazing product', 5, 1, 1),
(22, 'Not my favorite', 3, 2, 2),
(23, 'I like it', 4, 3, 3),
(24, 'Very happy', 5, 4, 4),
(25, 'Nice quality', 4, 5, 5),
(26, 'Best purchase', 5, 6, 6),
(27, 'Okay product', 3, 7, 7),
(28, 'Good value', 4, 8, 8),
(29, 'Satisfied', 4, 9, 9),
(30, 'Excellent', 5, 10, 10),
(31, 'Superb', 5, 1, 11),
(32, 'Not bad at all', 4, 2, 12),
(33, 'Good but not great', 3, 3, 13),
(34, 'Very pleased', 5, 4, 14),
(35, 'Perfect', 5, 5, 15),
(36, 'Mediocre', 3, 6, 16),
(37, 'Quite good', 4, 7, 17),
(38, 'Love this product', 5, 8, 18),
(39, 'Wouldn\'t buy again', 2, 9, 19),
(40, 'Impressed', 4, 10, 20),
(41, 'Top-notch', 5, 1, 1),
(42, 'Decent', 3, 2, 2),
(43, 'It\'s okay', 3, 3, 3),
(44, 'Very nice', 5, 4, 4),
(45, 'Pretty good buy', 4, 5, 5),
(46, 'Absolutely love it', 5, 6, 6),
(47, 'Expected more', 2, 7, 7),
(48, 'Reasonable quality', 4, 8, 8),
(49, 'Fairly good', 4, 9, 9),
(50, 'Just fine', 3, 10, 10);
 

-- display products bought by customer having id=2. 

select p.title,p.price,cp.quantity 
from customer c 
JOIN customer_product cp ON c.id = cp.customer_id 
JOIN product p ON cp.product_id = p.id 
where c.id=2 
order by cp.quantity DESC;


-- display products bought by customers living in city 'Springfield' that have rating above 4. 

select distinct  c.id,c.name 
from customer c 
JOIN customer_product cp ON c.id = cp.customer_id 
JOIN product p ON cp.product_id = p.id 
JOIN review r ON p.id = r.product_id 
JOIN address a ON c.address_id = a.id
where a.city='Springfield' AND r.rating > 4;

-- display products that satisfy following criteria 

/*
1. Must be featured 
2. Must be sold by atleast 1 vendor 
3. must have atleast 2 reviews 
4. stock count must be atleast 200 
5. must be bought by atleast 1 customer living in city 'springfield'
*/

-- final solution 
select  id, title 
from product 
where id IN (select p.id   
			 from product p JOIN vendor v ON p.vendor_id = v.id 
			 where p.isfeatured = true ) 
AND id IN (select p.id 
			from product p JOIN vendor v ON p.vendor_id = v.id
			group by p.id 
			having count(*) >=1)
AND id IN (select p.id 
			from product p JOIN stock s ON p.stock_id = s.id
			where s.count > 200)
AND id IN (select p.id 
			from product p JOIN review r ON p.id = r.product_id 
			group by p.id
			having count(*)>2)
AND id IN (select cp.product_id
			from customer_product cp 
			where cp.customer_id IN (select c.id
									 from customer c JOIN address a ON c.address_id = a.id 
									where a.city="springfield"));

 
-- display vendors that have products satisfying following criteria: 
/* 
1. product must belong to one of following categories 'category 2','category 4','category 5' 
2. product must have avg review rating more than 4.5 
3. must be bought by atleast 2 customers 
*/
/* product must belong to one of following categories 'category 2','category 4','category 5'  */

select DISTINCT v.id, v.name
from product p 
	JOIN category c ON p.category_id = c.id 
    JOIN vendor v ON p.vendor_id = v.id
	where c.name IN ('category 2','category 4','category 5');

-- 2 4 5 
/* product must have avg review rating more than 4.5  */

select DISTINCT v.id 
from product p 
		JOIN review r ON p.id = r.product_id 
        JOIN vendor v ON p.vendor_id = v.id
group by p.id
having avg(r.rating) > 4.5;

 -- 1 4 5 3 
/* must be bought by atleast 3 customers  */

select distinct v.id 
from product p 
JOIN customer_product cp ON p.id = cp.product_id 
JOIN customer c ON cp.customer_id = c.id
JOIN vendor v ON p.vendor_id = v.id
group by p.id 
having count(*) >=3;
 -- 5 6 7 8 9 10 :  products 
 -- 5 1 2 3 4 : vendors 
 
 -- integrated final query 
select v.id,v.name 
from vendor v 
where id IN (select DISTINCT v.id   
			from product p 
			JOIN category c ON p.category_id = c.id 
			JOIN vendor v ON p.vendor_id = v.id
			where c.name IN ('category 2','category 4','category 5')) 
AND id IN (select DISTINCT v.id 
			from product p 
					JOIN review r ON p.id = r.product_id 
					JOIN vendor v ON p.vendor_id = v.id
			group by p.id
			having avg(r.rating) > 4.5) 
AND id IN (select distinct v.id 
			from product p 
				JOIN customer_product cp ON p.id = cp.product_id 
				JOIN customer c ON cp.customer_id = c.id
				JOIN vendor v ON p.vendor_id = v.id
			group by p.id 
			having count(*) >=3); 

/* 
Ouput: 
	4	Vendor D
	5	Vendor E
*/


/* 
JOINS: inner join (join), left join / left outer join, right outer join, [full join ]
*/