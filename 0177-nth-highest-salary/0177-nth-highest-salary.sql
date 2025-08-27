CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  -- Declare a variable to hold the offset value.
  -- This is necessary because some MySQL versions don't allow
  -- calculations directly in the OFFSET clause within a function.
  DECLARE M INT;
  SET M = N - 1;
  
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT salary
      FROM Employee
      ORDER BY salary DESC
      LIMIT 1 OFFSET M
  );
END
