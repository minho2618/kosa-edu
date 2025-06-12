SELECT * FROM reservation;

WITH RECURSIVE calendar AS (
  SELECT MIN(res_cindate) AS res_date
  FROM reservation
  UNION ALL
  SELECT DATE_ADD(res_date, INTERVAL 1 DAY)
  FROM calendar
  WHERE res_date < (SELECT MAX(res_coutdate) FROM reservation)
)
SELECT 
  c.res_date,
  r.gus_num,
  SUM(r.res_tpeople) AS total_people
FROM 
  calendar c
JOIN 
  reservation r
  ON c.res_date >= r.res_cindate AND c.res_date < r.res_coutdate AND gus_num=1
GROUP BY 
  c.res_date, r.gus_num
ORDER BY 
  c.res_date, r.gus_num;
  
  
SELECT * FROM guesthouse;

SELECT gus_num, gus_name FROM guesthouse WHERE gus_num=1;

SELECT gus_capacity FROM guesthouse where gus_num=1;