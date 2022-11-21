
-- tables
-- Table: areas
CREATE TABLE areas (
    id int NOT NULL,
    square int NOT NULL,
    gps_location int NULL,
    owner_client int NOT NULL,
    CONSTRAINT areas_pk PRIMARY KEY (id)
);

-- Table: clients
CREATE TABLE clients (
    client_id int NOT NULL AUTO_INCREMENT,
    name varchar(45) NOT NULL,
    surname varchar(45) NOT NULL,
    phone_number varchar(13) NOT NULL,
    email varchar(60) NOT NULL,
    CONSTRAINT clients_pk PRIMARY KEY (client_id)
);

-- Table: light_sensor_info
CREATE TABLE light_sensor_info (
    sensor_id int NOT NULL,
    location int NOT NULL,
    areas_id int NOT NULL,
    CONSTRAINT light_sensor_info_pk PRIMARY KEY (sensor_id)
);

-- Table: light_sensor_work
CREATE TABLE light_sensor_work (
    id int NOT NULL AUTO_INCREMENT,
    sensor_id int NOT NULL,
    moisture int NOT NULL,
    time time NOT NULL,
    CONSTRAINT light_sensor_work_pk PRIMARY KEY (id)
);

-- Table: moisture_sensor_info
CREATE TABLE moisture_sensor_info (
    sensor_id int NOT NULL,
    location int NOT NULL,
    area int NOT NULL,
    CONSTRAINT moisture_sensor_info_pk PRIMARY KEY (sensor_id)
);

-- Table: moisture_sensor_work
CREATE TABLE moisture_sensor_work (
    id int NOT NULL AUTO_INCREMENT,
    sensor_id int NOT NULL,
    moisture int NOT NULL,
    time time NOT NULL,
    CONSTRAINT moisture_sensor_work_pk PRIMARY KEY (id)
);

-- Table: motors
CREATE TABLE motors (
    id int NOT NULL,
    pumps_id int NOT NULL,
    power int NULL,
    CONSTRAINT motors_pk PRIMARY KEY (id)
);

-- Table: motors_work
CREATE TABLE motors_work (
    id int NOT NULL AUTO_INCREMENT,
    motor_id int NOT NULL,
    turn_on_time time NOT NULL,
    turn_of_time time NOT NULL,
    water_consumtion int NOT NULL,
    CONSTRAINT motors_work_pk PRIMARY KEY (id)
);

-- Table: nozzle
CREATE TABLE nozzle (
    id int NOT NULL,
    system_id int NOT NULL,
    location int NOT NULL,
    max_water_consumtion int NOT NULL,
    CONSTRAINT nozzle_pk PRIMARY KEY (id)
);

-- Table: pumps_info
CREATE TABLE pumps_info (
    id int NOT NULL,
    area int NOT NULL,
    count_of_motors int NOT NULL,
    CONSTRAINT pumps_info_pk PRIMARY KEY (id)
);

-- Table: temperature_sensor_info
CREATE TABLE temperature_sensor_info (
    sensor_id int NOT NULL,
    location int NOT NULL,
    areas_id int NOT NULL,
    CONSTRAINT temperature_sensor_info_pk PRIMARY KEY (sensor_id)
);

-- Table: temperature_sensor_work
CREATE TABLE temperature_sensor_work (
    id int NOT NULL AUTO_INCREMENT,
    sensor_id int NOT NULL,
    moisture int NOT NULL,
    time time NOT NULL,
    CONSTRAINT temperature_sensor_work_pk PRIMARY KEY (id)
);

-- Table: water_system
CREATE TABLE water_system (
    id int NOT NULL,
    area int NOT NULL,
    count_of_nozzles int NOT NULL,
    pumps int NOT NULL,
    CONSTRAINT water_system_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: areas_clients (table: areas)
ALTER TABLE areas ADD CONSTRAINT areas_clients FOREIGN KEY areas_clients (owner_client)
    REFERENCES clients (client_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: areas_moisture_sensor_info (table: moisture_sensor_info)
ALTER TABLE moisture_sensor_info ADD CONSTRAINT areas_moisture_sensor_info FOREIGN KEY areas_moisture_sensor_info (area)
    REFERENCES areas (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: areas_pumps_info (table: pumps_info)
ALTER TABLE pumps_info ADD CONSTRAINT areas_pumps_info FOREIGN KEY areas_pumps_info (area)
    REFERENCES areas (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: areas_water_system (table: water_system)
ALTER TABLE water_system ADD CONSTRAINT areas_water_system FOREIGN KEY areas_water_system (area)
    REFERENCES areas (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: light_sensor_info_areas (table: light_sensor_info)
ALTER TABLE light_sensor_info ADD CONSTRAINT light_sensor_info_areas FOREIGN KEY light_sensor_info_areas (areas_id)
    REFERENCES areas (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: light_sensor_work_light_sensor_info (table: light_sensor_work)
ALTER TABLE light_sensor_work ADD CONSTRAINT light_sensor_work_light_sensor_info FOREIGN KEY light_sensor_work_light_sensor_info (sensor_id)
    REFERENCES light_sensor_info (sensor_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: moisture_sensor_work_moisture_sensor_info (table: moisture_sensor_work)
ALTER TABLE moisture_sensor_work ADD CONSTRAINT moisture_sensor_work_moisture_sensor_info FOREIGN KEY moisture_sensor_work_moisture_sensor_info (sensor_id)
    REFERENCES moisture_sensor_info (sensor_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: motors_pumps_info (table: motors)
ALTER TABLE motors ADD CONSTRAINT motors_pumps_info FOREIGN KEY motors_pumps_info (pumps_id)
    REFERENCES pumps_info (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: motors_work_motors (table: motors_work)
ALTER TABLE motors_work ADD CONSTRAINT motors_work_motors FOREIGN KEY motors_work_motors (motor_id)
    REFERENCES motors (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: nozzle_water_system (table: nozzle)
ALTER TABLE nozzle ADD CONSTRAINT nozzle_water_system FOREIGN KEY nozzle_water_system (system_id)
    REFERENCES water_system (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: pumps_info_water_system (table: water_system)
ALTER TABLE water_system ADD CONSTRAINT pumps_info_water_system FOREIGN KEY pumps_info_water_system (pumps)
    REFERENCES pumps_info (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: temperature_sensor_info_areas (table: temperature_sensor_info)
ALTER TABLE temperature_sensor_info ADD CONSTRAINT temperature_sensor_info_areas FOREIGN KEY temperature_sensor_info_areas (areas_id)
    REFERENCES areas (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: temperature_sensor_work_temperature_sensor_info (table: temperature_sensor_work)
ALTER TABLE temperature_sensor_work ADD CONSTRAINT temperature_sensor_work_temperature_sensor_info FOREIGN KEY temperature_sensor_work_temperature_sensor_info (sensor_id)
    REFERENCES temperature_sensor_info (sensor_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- End of file.

