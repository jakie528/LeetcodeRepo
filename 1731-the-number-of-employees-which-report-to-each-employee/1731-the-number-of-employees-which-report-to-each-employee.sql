# Write your MySQL query statement below
SELECT reports_to AS  employee_id,
(SELECT name FROM Employees e1
WHERE e1.employee_id = e.reports_to) AS name,
COUNT(reports_to) AS reports_count,
ROUND(AVG(age)) AS average_age
FROM Employees e
GROUP BY reports_to
HAVING 
  reports_count > 0
  ORDER BY 
  employee_id 



