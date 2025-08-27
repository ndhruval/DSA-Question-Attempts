# Write your MySQL query statement below
SELECT
    ROUND(SUM(i1.tiv_2016), 2) AS tiv_2016
FROM
    Insurance i1
WHERE
    -- Condition 1: The tiv_2015 value must be shared with at least one other person.
    i1.tiv_2015 IN (
        SELECT tiv_2015
        FROM Insurance
        WHERE pid != i1.pid
    )
AND
    -- Condition 2: The (lat, lon) pair must be unique.
    (i1.lat, i1.lon) IN (
        SELECT lat, lon
        FROM Insurance
        GROUP BY lat, lon
        HAVING COUNT(*) = 1
    );