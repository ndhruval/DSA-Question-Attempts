# Write your MySQL query statement below
select id, movie, description, rating
from Cinema
where id MOD 2 =1 and description != "boring"
order by rating DESC;