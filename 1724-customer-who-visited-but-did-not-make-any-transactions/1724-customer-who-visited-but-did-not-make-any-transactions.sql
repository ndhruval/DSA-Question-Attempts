# Write your MySQL query statement below
select a.customer_id, count(a.visit_id) as count_no_trans
from Visits as a Left join Transactions as b
on a.visit_id = b.visit_id
where transaction_id IS NULL
group by customer_id;