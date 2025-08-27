With rankedSalaries as(
    select 
        d.name as Department,
        e.name as Employee,
        e.salary as Salary,
        DENSE_RANK() OVER (Partition by d.name order by e.salary desc) as salary_rank
    from Employee as e
         join
         Department as d
         on e.departmentId = d.id
)

select Department,Employee, Salary
from rankedSalaries
where salary_rank =1;