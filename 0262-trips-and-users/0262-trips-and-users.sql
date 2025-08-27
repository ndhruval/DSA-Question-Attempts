# Write your MySQL query statement below
SELECT 
    t.request_at 'Day',
    ROUND(
        SUM(CASE WHEN status = 'completed' THEN 0 ELSE 1 END) / COUNT(*), 2) 'Cancellation Rate'
FROM trips t
JOIN users u1 
    ON u1.users_id = t.client_id 
   AND u1.role = 'client'
JOIN users u2 
    ON u2.users_id = t.driver_id 
   AND u2.role = 'driver'
WHERE u1.banned = 'No' 
  AND u2.banned = 'No' 
  AND request_at BETWEEN "2013-10-01" AND "2013-10-03"
GROUP BY t.request_at;