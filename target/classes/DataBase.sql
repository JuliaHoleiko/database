DROP DATABASE IF EXISTS  holeiko_db;
CREATE DATABASE IF NOT EXISTS holeiko_db;
USE holeiko_db;

DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS areas;
DROP TABLE IF EXISTS light_sensor_info;
DROP TABLE IF EXISTS light_sensor_work;
DROP TABLE IF EXISTS moisture_sensor_info;
DROP TABLE IF EXISTS moisture_sensor_work;
DROP TABLE IF EXISTS temperature_sensor_info;
DROP TABLE IF EXISTS temperature_sensor_work;
DROP TABLE IF EXISTS pumps_info;
DROP TABLE IF EXISTS motors;
DROP TABLE IF EXISTS motors_work;
DROP TABLE IF EXISTS water_system;
DROP TABLE IF EXISTS nozzle;




CREATE TABLE if not exists `clients` (
  `client_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `phone_number` varchar(12) NOT NULL,
  `email` varchar(60) NOT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB;




CREATE TABLE `areas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `square` int NOT NULL,
  `owner_client` int NOT NULL,
  `latitude` decimal(8,5) NOT NULL,
  `longitude` decimal(8,5) NOT NULL,
  PRIMARY KEY (`id`,`owner_client`),
  KEY `areas_clients` (`owner_client`),
  CONSTRAINT `areas_clients` FOREIGN KEY (`owner_client`) REFERENCES `clients` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;
;


CREATE TABLE `light_sensor_info` (
  `sensor_id` int NOT NULL ,
  `areas_id` int NOT NULL,
  `latitude` decimal(8,5) NOT NULL,
  `longitude` decimal(8,5) NOT NULL,
  PRIMARY KEY (`sensor_id`),
  KEY `light_sensor_info_areas` (`areas_id`),
  CONSTRAINT `light_sensor_info_areas` FOREIGN KEY (`areas_id`) REFERENCES `areas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE `light_sensor_work` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sensor_id` int NOT NULL,
  `light` int NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `light_sensor_work_light_sensor_info` (`sensor_id`),
  CONSTRAINT `light_sensor_work_light_sensor_info` FOREIGN KEY (`sensor_id`) REFERENCES `light_sensor_info` (`sensor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE `moisture_sensor_info` (
  `sensor_id` int NOT NULL,
  `areas_id` int NOT NULL,
  `longitude` decimal(8,5) NOT NULL,
  `latitude` decimal(8,5) NOT NULL,
  PRIMARY KEY (`sensor_id`),
  KEY `areas_moisture_sensor_info` (`areas_id`),
  CONSTRAINT `areas_moisture_sensor_info` FOREIGN KEY (`areas_id`) REFERENCES `areas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;
CREATE TABLE `moisture_sensor_work` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sensor_id` int NOT NULL,
  `moisture` int NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `moisture_sensor_work_moisture_sensor_info` (`sensor_id`),
  CONSTRAINT `moisture_sensor_work_moisture_sensor_info` FOREIGN KEY (`sensor_id`) REFERENCES `moisture_sensor_info` (`sensor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE `pumps_info` (
  `id` int NOT NULL,
  `area` int NOT NULL,
  `count_of_motors` int NOT NULL,
  `water_consume` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `areas_pumps_info` (`area`),
  CONSTRAINT `areas_pumps_info` FOREIGN KEY (`area`) REFERENCES `areas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;



CREATE TABLE `motors` (
  `id` int NOT NULL,
  `pumps_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `motors_pumps_info` (`pumps_id`),
  CONSTRAINT `motors_pumps_info` FOREIGN KEY (`pumps_id`) REFERENCES `pumps_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB ;


CREATE TABLE `motors_work` (
  `id` int NOT NULL AUTO_INCREMENT,
  `motor_id` int NOT NULL,
  `turn_on_time` datetime NOT NULL,
  `turn_of_time` datetime NOT NULL,
  `water_consume` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `motors_work_motors` (`motor_id`),
  CONSTRAINT `motors_work_motors` FOREIGN KEY (`motor_id`) REFERENCES `motors` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE `temperature_sensor_info` (
  `sensor_id` int NOT NULL,
  `areas_id` int NOT NULL,
  `longitude` decimal(8,5) NOT NULL,
  `latitude` decimal(8,5) NOT NULL,
  PRIMARY KEY (`sensor_id`),
  KEY `temperature_sensor_info_areas` (`areas_id`),
  CONSTRAINT `temperature_sensor_info_areas` FOREIGN KEY (`areas_id`) REFERENCES `areas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;
CREATE TABLE `temperature_sensor_work` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sensor_id` int NOT NULL,
  `temperature` int NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `temperature_sensor_work_temperature_sensor_info` (`sensor_id`),
  CONSTRAINT `temperature_sensor_work_temperature_sensor_info` FOREIGN KEY (`sensor_id`) REFERENCES `temperature_sensor_info` (`sensor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;
CREATE TABLE `water_system` (
  `id` int NOT NULL,
  `area` int NOT NULL,
  `count_of_nozzles` int NOT NULL,
  `pump` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `areas_water_system` (`area`),
  KEY `fk_water_system_pumps_info1_idx` (`pump`),
  CONSTRAINT `areas_water_system` FOREIGN KEY (`area`) REFERENCES `areas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_water_system_pumps_info1` FOREIGN KEY (`pump`) REFERENCES `pumps_info` (`id`)
) ENGINE=InnoDB ;

CREATE TABLE `nozzle` (
  `id` int NOT NULL,
  `system_id` int NOT NULL,
  `max_water_consume` int NOT NULL,
  `longitude` decimal(8,5) DEFAULT NULL,
  `latitude` decimal(8,5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `nozzle_water_system` (`system_id`),
  CONSTRAINT `nozzle_water_system` FOREIGN KEY (`system_id`) REFERENCES `water_system` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB ;
USE holeiko_db;


INSERT INTO `clients` (`name`,`surname`, `phone_number`,`email`) VALUES
('Yuliia', 'Holeiko', '0505992828', 'julia_hol@gmail.com'),
('Tania', 'Chuyko', '0505991212', 'chuyko@gmail.com'),
('Marta', 'Prokopiv', '0676785432', 'prokopiv@gmail.com'),
('Oksana', 'Kysla', '0505992811', 'kysla@gmail.com'),
('Andrii', 'Garoon', '0505992828', 'garoon@gmail.com'),
('Oleh', 'Kolomiets', '0671234333', 'kolomiets@gmail.com'),
('Petro', 'Kravchuk', '0987651212', 'kolomiets@gmail.com'),
('Igor', 'Stepanets', '0975321617', 'stepanets@gmail.com'),
('Vasyl', 'Petsoliak', '0661229988', 'petsoliak@gmail.com'),
('Olga', 'Petsoliak', '0661229912', 'petsoliak_plga@gmail.com'),
('Yuliia', 'Rogan', '0502345544', 'rogan11@gmail.com');



INSERT INTO `areas` ( `square`,`owner_client`,`latitude`,`longitude`) VALUES
 ('122', 1, '34.2345', '45.54332'),
 ('1098', '2', '12.1234', '47.54332'),
 ('5033', '3', '24.3455', '34.54332'),
 ('1234', '4', '56.2666', '66.54332'),
 ('555', '5', '45.7653', '67.4323'),
 ('5009', '6', '34.3453', '33.2345'),
 ('2500', '7', '36.6765', '35.4555'),
 ('5800', '7', '37.7676', '55.8977'),
 ('6000', '8', '56.6655', '25.6333'),
 ('1700', '9', '77.5555', '27.8998'),
 ('1300', '10', '23.4562', '54.7765');


 INSERT INTO `light_sensor_info` VALUES
 ('1', '1', '34.2345', '45.54332'),
 ('2', '2', '12.1234', '47.54332'),
 ('3', '3', '24.3455', '34.54332'),
 ('4', '4', '56.2666', '66.54332'),
 ('5', '5', '45.7653', '67.4323'),
 ('6', '6', '34.3453', '33.2345'),
 ('7', '7', '36.6765', '35.4555'),
 ('8', '7', '37.7676', '55.8977'),
 ('9', '8', '56.6655', '25.6333'),
 ('10', '9', '77.5555', '27.8998'),
 ('12', '9', '77.5555', '27.8998'),
 ('11', '10', '23.4562', '54.7765');

INSERT INTO `light_sensor_work` (`sensor_id`, `light`, `time`) VALUES
('1', '23', '2022-10-22 15:34:45'),
('1', '12', '2022-10-22 16:34:45'),
('1', '43', '2022-10-22 17:34:45'),
('2', '22', '2022-10-22 12:34:45'),
('2', '33', '2022-10-22 13:34:45'),
('2', '33', '2022-10-22 14:34:45'),
('3', '43', '2022-10-22 15:34:45'),
('3', '40', '2022-10-22 16:34:45'),
('4', '22', '2022-10-22 11:34:45'),
('4', '27', '2022-10-22 12:34:45'),
('4', '29', '2022-10-22 14:34:45'),
('4', '20', '2022-10-22 15:34:45');

 INSERT INTO `moisture_sensor_info` VALUES
 ('1', '1', '34.2345', '45.54332'),
 ('2', '2', '12.1234', '47.54332'),
 ('3', '3', '24.3455', '34.54332'),
 ('4', '4', '56.2666', '66.54332'),
 ('5', '5', '45.7653', '67.4323'),
 ('6', '6', '34.3453', '33.2345'),
 ('7', '7', '36.6765', '35.4555'),
 ('8', '7', '37.7676', '55.8977'),
 ('9', '8', '56.6655', '25.6333'),
 ('10', '9', '77.5555', '27.8998'),
 ('12', '9', '77.5555', '27.8998'),
 ('11', '10', '23.4562', '54.7765');

INSERT INTO `moisture_sensor_work` (`sensor_id`, `moisture`, `time`) VALUES
('1', '23', '2022-10-22 15:34:45'),
('1', '12', '2022-10-22 16:34:45'),
('1', '43', '2022-10-22 17:34:45'),
('2', '22', '2022-10-22 12:34:45'),
('2', '33', '2022-10-22 13:34:45'),
('2', '33', '2022-10-22 14:34:45'),
('3', '43', '2022-10-22 15:34:45'),
('3', '40', '2022-10-22 16:34:45'),
('4', '22', '2022-10-22 11:34:45'),
('4', '27', '2022-10-22 12:34:45'),
('4', '29', '2022-10-22 14:34:45'),
('4', '20', '2022-10-22 15:34:45');


 INSERT INTO `temperature_sensor_info` VALUES
 ('1', '1', '34.2345', '45.54332'),
 ('2', '2', '12.1234', '47.54332'),
 ('3', '3', '24.3455', '34.54332'),
 ('4', '4', '56.2666', '66.54332'),
 ('5', '5', '45.7653', '67.4323'),
 ('6', '6', '34.3453', '33.2345'),
 ('7', '7', '36.6765', '35.4555'),
 ('8', '7', '37.7676', '55.8977'),
 ('9', '8', '56.6655', '25.6333'),
 ('10', '9', '77.5555', '27.8998'),
 ('12', '9', '77.5555', '27.8998'),
 ('11', '10', '23.4562', '54.7765');

INSERT INTO `temperature_sensor_work` (`sensor_id`, `temperature`, `time`) VALUES
('1', '23', '2022-10-22 15:34:45'),
('1', '12', '2022-10-22 16:34:45'),
('1', '43', '2022-10-22 17:34:45'),
('2', '22', '2022-10-22 12:34:45'),
('2', '33', '2022-10-22 13:34:45'),
('2', '33', '2022-10-22 14:34:45'),
('3', '43', '2022-10-22 15:34:45'),
('3', '40', '2022-10-22 16:34:45'),
('4', '22', '2022-10-22 11:34:45'),
('4', '27', '2022-10-22 12:34:45'),
('4', '29', '2022-10-22 14:34:45'),
('4', '20', '2022-10-22 15:34:45');

INSERT INTO `pumps_info` VALUES
('1', '1', '3', '32'),
('2', '2', '4', '12'),
('3', '3', '5', '33'),
('4', '4', '7', '45'),
('5', '4', '2', '44'),
('6', '5', '4', '22'),
('7', '6', '1', '12'),
('8', '7', '6', '54'),
('9', '8', '7', '44'),
('10', '9', '7', '255'),
('11', '10', '8', '23'),
('12', '10', '4', '21')
;
INSERT INTO `motors`  VALUES
 ('1', '1'),
 ('2', '2'),
 ('3', '3'),
 ('4', '4'),
 ('5', '5'),
 ('6', '6'),
 ('7', '7'),
 ('8', '8'),
 ('9', '9'),
 ('10', '10');


 INSERT INTO `motors_work` (`motor_id`, `turn_on_time`, `turn_of_time`, `water_consume`) VALUES
('1', '2022-11-22 10:34:45', '2022-11-22 18:34:45', '12'),
('2', '2022-11-22 10:34:45', '2022-11-22 18:34:45', '23'),
('3', '2022-11-22 10:34:45', '2022-11-22 18:34:45', '14'),
('3', '2022-11-22 10:34:45', '2022-11-22 18:34:45', '66'),
('4', '2022-11-22 10:34:45', '2022-11-22 18:34:45', '45'),
('5', '2022-11-22 10:34:45', '2022-11-22 18:34:45', '19'),
('6', '2022-11-22 10:34:45', '2022-11-22 18:34:45', '34'),
('7', '2022-11-22 10:34:45', '2022-11-22 18:34:45', '12'),
('8', '2022-11-22 10:34:45', '2022-11-22 18:34:45', '19'),
('1', '2022-11-23 10:34:45', '2022-11-22 18:34:45', '23'),
('1', '2022-11-24 10:34:45', '2022-11-22 18:34:45', '22')
;
INSERT INTO `water_system` VALUES
('1', '1', '4', '1'),
('2', '1', '4', '1'),
('3', '2', '3', '1'),
('4', '3', '6', '1'),
('5', '4', '12', '1'),
('6', '5', '8', '1'),
('7', '5', '9', '1'),
('8', '6', '11', '1'),
('9', '7', '2', '1'),
('10', '8', '7', '1')
;
INSERT INTO `nozzle` VALUES
  ('1', '1','23', '34.2345', '45.54332'),
 ('2', '2', '43', '12.1234', '47.54332'),
 ('3', '3', '65', '24.3455', '34.54332'),
 ('4', '4', '22', '56.2666', '66.54332'),
 ('5', '5', '41', '45.7653', '67.4323'),
 ('6', '6', '33', '34.3453', '33.2345'),
 ('7', '7', '23', '36.6765', '35.4555'),
 ('8', '7',  '12','37.7676', '55.8977'),
 ('9', '8', '55', '56.6655', '25.6333'),
 ('10', '9', '51', '77.5555', '27.8998'),
 ('12', '9',  '33','77.5555', '27.8998'),
 ('11', '10', '38', '23.4562', '54.7765');

 ;

