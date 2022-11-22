-- скільки кожен клієнт має територій
USE laba1;
SELECT clients.name,surname, count(id), sum(square)
from areas 
JOIN clients  ON clients.client_id = owner_client
group by  clients.name,surname;



-- на кожен час результат усіх датчиків
SELECT moisture_sensor_work.time, avg(moisture),
(SELECT avg(temperature)
FROM temperature_sensor_work WHERE temperature_sensor_work.time = moisture_sensor_work.time ) as temp,
(SELECT avg(light)
FROM light_sensor_work WHERE light_sensor_work.time = moisture_sensor_work.time ) as light
FROM moisture_sensor_work 
group by time;

-- дані з датчиків в один і той самий час

SELECT mois.sensor_id, moisture, mois.time, temp.temperature
FROM moisture_sensor_work mois
JOIN temperature_sensor_work temp 
ON temp.time = mois.time AND temp.sensor_id = mois.sensor_id;

-- різниця дати - косокриво але живо
SELECT *, DATEDIFF(turn_of_time, turn_on_time) as full_time FROM motors_work;



-- кожна система має к-сть соплів - порахувати чи всі сопла присутні в таблиці сопел

SELECT id, count_of_nozzles, 
CASE WHEN count_of_nozzles-cou = 0 THEN 'all present'
WHEN count_of_nozzles-cou >0 THEN 'not all nozzle are in base'
when count_of_nozzles-cou <0 THEN 'too many nozzle'
END as absent 
FROM water_system
JOIN
(SELECT system_id, count(id) as cou
FROm nozzle
group by system_id) t ON water_system.id = system_id;

-- показати який насос споживає найбільше води, де він знаходить і хто власник


SELECT * FROM pumps_info
JOIN 
(SELECT id, owner_client, clients.surname, square FROM areas
JOIN clients ON owner_client = client_id
) tab on tab.id = pumps_info.area
WHERE water_consumtion IN (select max(water_consumtion) FROM pumps_info)
;


-- макс темп для кожного датчика

SELECT sensor_id, max(temperature) from Temperature_sensor_work
group by sensor_id;

SELECT sensor_id, max(moisture) from moisture_sensor_work
group by sensor_id;

SELECT sensor_id, max(light) from light_sensor_work
group by sensor_id;


-- просто виведені всі клієнти і їхні території
SELECT id, owner_client, clients.surname, square FROM areas
JOIN clients ON owner_client = client_id;

-- к-сть датчиків на території

SELECT area, moi + temp as sensors FROM
(SELECT area, count(sensor_id) as moi
from moisture_sensor_info
group by area) tab1
join
(SELECT areas_id, count(sensor_id) as temp
from temperature_sensor_info
group by areas_id ) tab2 on area = areas_id
;


-- переведення температури в текст
SELECT *, (CASE WHEN temperature <5 THEN 'cold'
when temperature < 20 THEN 'normal'
else 'hot'
end) as temp FROM Temperature_sensor_work
