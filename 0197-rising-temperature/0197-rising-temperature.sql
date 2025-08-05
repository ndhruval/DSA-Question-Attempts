# Write your MySQL query statement below
select today.id
from Weather as today CROSS JOIN Weather as yesterday
where DATEDIFF(today.recordDate, yesterday.recordDate) = 1
and today.temperature > yesterday.temperature;