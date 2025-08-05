# Write your MySQL query statement below
select a.product_id, IFNULL(ROUND(SUM(a.price*b.units)/SUM(b.units),2),0) as average_price
from Prices as a LEFT JOIN UnitsSold as b
on a.product_id = b.product_id
and b.purchase_date between a.start_date and a.end_date
group by product_id;