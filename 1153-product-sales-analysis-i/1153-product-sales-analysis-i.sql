# Write your MySQL query statement below
select a.product_name, b.year, b.price 
from Sales as b inner join Product as a
on a.product_id = b.product_id;
