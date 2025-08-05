# Write your MySQL query statement below
select contest_id, ROUND( COUNT(DISTINCT user_id)*100 /
(select COUNT(user_id) from Users),2) as percentage
from Register
GROUP BY contest_id
ORDER BY 
percentage DESC,
contest_id;