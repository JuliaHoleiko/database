OutcomeUSE labor_sql;
-- task 1

SELECT trip_no, plane, town_from, town_to
FROM Trip
WHERE plane != 'IL-86'
ORDER BY plane;

-- task2

SELECT name
FROM Ships
WHERE name LIKE 'W%n';

-- task3

SELECT distinct maker, product.type, pc.model, speed
FROM  pc JOIN product ON pc.model = product.model
WHERE  speed <= 600;

-- task4
SELECT  maker, count(*)
FROM  pc JOIN product ON pc.model = product.model
GROUP BY maker
HAVING maker = 'A';

-- task5

/*SELECT  maker, max(speed) as max_speed
FROM  pc JOIN product ON pc.model = product.model
GROUP BY maker;*/

SELECT maker, product.model, type, price
FROM product  JOIN pc  ON pc.model = product.model
where maker IN (SELECT maker FROM Product WHERE type = 'printer') AND type = 'PC'
and price = (SELECT max(price) FROM PC );

-- task6
SELECT substring(replace(date, '-','.'),1, 11)
FROM income;

-- task7
Select model, price FROM pc
WHERE price >= (SELECT min(price) as min_price FROM Laptop);


-- task8

SELECT class, country, numGuns,count_battle FROM Classes
Join
(SELECT ship, count(battle) as count_battle
FROM outcomes
WHERE result IN( 'damaged','sunk')
group by ship) damaged ON ship = class
;





-- task 9.1

SELECT name, numGuns, bore, displacement, type,
country, launched, classes.class FROM ships
JOIN classes on ships.class = classes.class
WHERE
CASE WHEN numGuns = 9 THEN 1 ELSE 0 END +
CASE WHEN bore = 16 THEN 1 ELSE 0 END +
CASE WHEN displacement = 46000 THEN 1 ELSE 0 END +
CASE WHEN type = 'bb' THEN 1 ELSE 0 END +
CASE WHEN country = 'Japan' THEN 1 ELSE 0 END +
CASE WHEN launched = 1916 THEN 1 ELSE 0 END +
CASE WHEN ships.class = 'Revenge' THEN 1 ELSE 0 END
>=3;



-- task10 

SELECT  ships.class,count(ship_name) as count_ship from(
SELECT distinct name as ship_name from ships
UNION
SELECT ship FROM outcomes
order by ship_name) dd 
JOIN ships on ship_name = ships.name
group by ships.class;


-- task10
SELECT ship_name FROM(
SELECT ship_name, sum(count_in_table) as count FROM(
SELECT name as ship_name, 't1' as col, count(*) as count_in_table from ships Group by name
UNION
SELECT ship , 't2' as col, count(*) as count_in_table FROM outcomes Group by ship) tab1

Group by ship_name)tab2
WHERE count = 1
order by ship_name ;















