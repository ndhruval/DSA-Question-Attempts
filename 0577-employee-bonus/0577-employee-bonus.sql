# Write your MySQL query statement below
select name, bonus
from Employee LEFT JOIN Bonus
on Employee.empId = Bonus.empId
where bonus<1000 or bonus IS NULL;