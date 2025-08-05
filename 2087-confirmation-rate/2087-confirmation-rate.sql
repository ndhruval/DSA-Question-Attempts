# Write your MySQL query statement below
select a.user_id, ROUND(AVG(if(c.action = 'confirmed',1,0)),2) as confirmation_rate
from Signups as a LEFT JOIN Confirmations as c
on a.user_id = c.user_id
group by a.user_id;