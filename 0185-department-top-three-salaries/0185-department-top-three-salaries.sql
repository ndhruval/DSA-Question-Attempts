# Write your MySQL query statement below
With ranked_salaries as (
    select d.name as Department,
           e.name as Employee,
           e.salary as Salary,
           DENSE_RANK() OVER(Partition by d.name Order by e.salary desc) as salary_rank
    from Employee as e join Department as d
    on e.departmentId = d.id
)
select Department, Employee, Salary
from ranked_salaries
where salary_rank = 1 or salary_rank = 2 or salary_rank = 3;