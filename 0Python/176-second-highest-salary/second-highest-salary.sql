# Write your MySQL query statement below
SELECT DISTINCT MAX(salary) as SecondHighestSalary
FROM employee where salary < (SELECT MAX(salary) from employee );