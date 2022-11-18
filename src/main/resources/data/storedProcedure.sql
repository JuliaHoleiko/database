USE holeiko_db;
DROP TRIGGER IF EXISTS AfterInsertAreas;
DROP TRIGGER IF EXISTS AfterDeleteAreas;
DELIMITER //
#--many to many
CREATE TRIGGER AfterInsertAreas
    AFTER INSERT
    ON areas
    FOR EACH ROW
BEGIN
    DECLARE client_nameIn VARCHAR(50);

    SELECT CONCAT(surname, ' ', name) INTO client_nameIn FROM clients WHERE client_id = new.owner_client;
    INSERT INTO logger (area_id, client_name,  time_stamp, action)
    VALUES (new.id, client_nameIn,  NOW(), 'add');
END //
DELIMITER ;

DELIMITER //

CREATE TRIGGER AfterDeleteAreas
    AFTER DELETE
    ON areas
    FOR EACH ROW
BEGIN
    DECLARE client_name VARCHAR(50);

    SELECT CONCAT(surname, ' ', name) INTO client_name FROM clients WHERE client_id = old.owner_client;
    INSERT INTO logger (area_id, client_name,  time_stamp, action)
    VALUES (old.id, client_name,  NOW(), 'delete');
END //
DELIMITER ;
#--param insert
DROP PROCEDURE IF EXISTS AddClient;
DELIMITER //
CREATE PROCEDURE AddClient(
    IN nameIn varchar(100),
    IN surnameIn varchar(100),
    IN emailIn varchar(100),
    IN phoneIn varchar(100))
BEGIN
    INSERT INTO clients(name, surname, email, phone_number) VALUES (nameIn, surnameIn, emailIn, phoneIn);
END //
DELIMITER ;
#-- ten records
DROP PROCEDURE IF EXISTS AddTenFakeClients;
DELIMITER //
CREATE PROCEDURE AddTenFakeClients()
BEGIN
    DECLARE x INT DEFAULT 0;

    WHILE x < 10 DO
            INSERT INTO clients(name, surname, email, phone_number) VALUES (CONCAT("Noname", x), CONCAT("NoSurn", x), "juju", "090909");
            SET x = x + 1;
        END WHILE;
END //
DELIMITER ;

#-- function
DROP FUNCTION IF EXISTS MaxWaterConsume;
DELIMITER //
CREATE FUNCTION MaxWaterConsume() RETURNS INT
    READS SQL DATA
BEGIN
    RETURN (SELECT Max(water_consume) FROM pumps_info);
END //
DELIMITER ;


DROP TRIGGER IF EXISTS WorkersForeignKeyCheckInsert;
DELIMITER //
CREATE TRIGGER WorkersForeignKeyCheckInsert
    AFTER UPDATE
    ON workers FOR EACH ROW
BEGIN
    DECLARE error_message varchar(255);
    IF NOT (NEW.area_id = ANY (SELECT id FROM areas)) THEN
        SET error_message = CONCAT( 'The area with id ', NEW.area_id, ' does not exist.');
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = error_message;
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS WorkersForeignKeyCheckUpdate;
DELIMITER //
CREATE TRIGGER WorkersForeignKeyCheckUpdate
    AFTER INSERT
    ON workers FOR EACH ROW
BEGIN
    DECLARE error_message varchar(255);
    IF NOT (NEW.area_id = ANY (SELECT id FROM areas)) THEN
        SET error_message = CONCAT( 'The area with id ', NEW.area_id, ' does not exist.');
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = error_message;
    END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS CreateTablesWithCursor;
DELIMITER //
CREATE PROCEDURE CreateTablesWithCursor()
BEGIN
    DECLARE done BOOLEAN DEFAULT FALSE;
    DECLARE client_name varchar(100);
    DECLARE cur CURSOR FOR SELECT name FROM clients LIMIT 4;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;


    OPEN cur;

    create_loop: LOOP
        FETCH cur INTO client_name;
        IF done THEN
            LEAVE create_loop;
        END IF;

        SET @create_database_query = CONCAT('CREATE DATABASE `',  client_name ,'_check`');
        PREPARE create_database FROM @create_database_query;

        SET @create_table_query = CONCAT('CREATE TABLE `',  client_name, '_check`.check (
			id INT UNSIGNED NOT NULL AUTO_INCREMENT,
			point INT NOT NULL DEFAULT 0,
			PRIMARY KEY (id)
			) ENGINE = InnoDB
		');
        PREPARE create_table FROM @create_table_query;

        EXECUTE create_database;
        EXECUTE create_table;
    END LOOP;

    DEALLOCATE PREPARE create_database;
    DEALLOCATE PREPARE create_table;

    CLOSE cur;

END //
DELIMITER ;
DROP TRIGGER IF EXISTS endsWithZero;
DROP TRIGGER IF EXISTS checkName;
DELIMITER //

CREATE TRIGGER endsWithZero
    BEFORE INSERT
    ON clients
    FOR EACH ROW
BEGIN
    IF (new.phone_number REGEXP("00$")) THEN
        SIGNAL SQLSTATE "45000" SET MESSAGE_TEXT = "Phone can not end with two 0";
    END IF;
END //
DELIMITER;


DELIMITER //
CREATE TRIGGER checkName
    BEFORE INSERT
    ON clients
    FOR EACH ROW
BEGIN
    IF(new.name NOT REGEXP("(Svitlana|Petro|Taras|Olga)")) THEN
        SIGNAL SQLSTATE "45000" SET MESSAGE_TEXT = "Name is not from list";
    END IF;
END //


