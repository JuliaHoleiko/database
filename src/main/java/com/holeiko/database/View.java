package com.holeiko.database;

import com.holeiko.database.controller.*;
import com.holeiko.database.controller.impl.*;
import com.holeiko.database.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.*;

@Component
public class View {
    @Autowired
    private AreaControllerImpl areaController;
    @Autowired
    private ClientController clientController;
    @Autowired
    private MotorController motorController;
    @Autowired
    private NozzleController nozzleController;
    @Autowired
    private PumpControllerImpl pumpController;
    @Autowired
    private LightSensorWorkControllerImpl lightSensorWorkController;
    @Autowired
    private MoistureSensorWorkControllerImpl moistureSensorWorkController;
    @Autowired
    private TemperatureSensorWorkControllerImpl temperatureSensorWorkController;


    @Autowired
    private LightSensorControllerImpl lightSensorController;
    @Autowired
    private TemperatureSensorControllerImpl temperatureSensorController;
    @Autowired
    private MoistureSensorControllerImpl moistureSensorController;
    @Autowired
    private WaterSystemController waterSystemController;
    @Autowired
    private MotorsWorkController motorsWorkController;
    private final Scanner input = new Scanner(System.in);
    private final Area nullArea = new Area(null, null, null, null, null);
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;

    public View() {
        menu = new LinkedHashMap<>();
        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: Area");
        menu.put("11", "  11 - Create Area");
        menu.put("12", "  12 - Update Area");
        menu.put("13", "  13 - Delete from Area");
        menu.put("14", "  14 - Find all areas");
        menu.put("15", "  15 - Find Area by OwnerId");


        menu.put("2", "   2 - Table: Client");
        menu.put("21", "  21 - Create Client");
        menu.put("22", "  22 - Update Client");
        menu.put("23", "  23 - Delete from Client");
        menu.put("24", "  24 - Find all Clients");
        //menu.put("25", "  25 - Find City by ID");

        menu.put("3", "   3 - Table: Light sensor work");
        menu.put("31", "  31 - Create sensor");
        menu.put("32", "  32 - Update sensor");
        menu.put("33", "  33 - Delete from sensor");
        menu.put("34", "  34 - Find all sensors");

        menu.put("4", "   4 - Table: Motors");
        menu.put("41", "  41 - Create Motors");
        menu.put("42", "  42 - Update Motors");
        menu.put("43", "  43 - Delete from Motors");
        menu.put("44", "  44 - Find all Motors");

        menu.put("5", "   5 - Table: pumps");
        menu.put("51", "  51 - Create pumps");
        menu.put("52", "  52 - Update pumps");
        menu.put("53", "  53 - Delete from pumps");
        menu.put("54", "  54 - Find all pumps");

        menu.put("6", "   6 - Table: WaterSystem");
        menu.put("61", "  61 - Create WaterSystem");
        menu.put("62", "  62 - Update WaterSystem");
        menu.put("63", "  63 - Delete from WaterSystem");
        menu.put("64", "  64 - Find all water system");

        menu.put("7", "   7 - Table: Temperature sensor");
        menu.put("71", "  71 - Create Temperature sensor");
        menu.put("72", "  72 - Update Temperature sensor");
        menu.put("73", "  73 - Delete from Temperature sensor");
        menu.put("74", "  74 - Find all water Temperature sensor");

        menu.put("8", "   8 - Table: moisture sensor");
        menu.put("81", "  81 - Create moisture sensor");
        menu.put("82", "  82 - Update moisture sensor");
        menu.put("83", "  83 - Delete from moisture sensor");
        menu.put("84", "  84 - Find all moisture sensor ");

        menu.put("9", "   9 - Table: nozzle");
        menu.put("91", "  91 - Create nozzle");
        menu.put("92", "  92 - Update nozzle");
        menu.put("93", "  93 - Delete from nozzle");
        menu.put("94", "  94 - Find all nozzle ");

        menu.put("B", "   B - Table: light_sensor_work");
        menu.put("B1", "  B1 - Create light_sensor_work");
        menu.put("B2", "  B2 - Update light_sensor_work");
        menu.put("B3", "  B3 - Delete from light_sensor_work");
        menu.put("B4", "  B4 - Find all light_sensor_work");

        menu.put("C", "   C - Table: moisture_sensor_work");
        menu.put("C1", "  C1 - Create moisture_sensor_work");
        menu.put("C2", "  C2 - Update moisture_sensor_work");
        menu.put("C3", "  C3 - Delete from moisture_sensor_work");
        menu.put("C4", "  C4 - Find all moisture_sensor_work");

        menu.put("D", "   D - Table: temperature_sensor_work");
        menu.put("D1", "  D1 - Create temperature_sensor_work");
        menu.put("D2", "  D2 - Update temperature_sensor_work");
        menu.put("D3", "  D3 - Delete from temperature_sensor_work");
        menu.put("D4", "  D4 - Find all temperature_sensor_work");

        menu.put("E", "   E - Table: motors_work");
        menu.put("E1", "  E1 - Create motors_work");
        menu.put("E2", "  E2 - Update motors_work");
        menu.put("E3", "  E3 - Delete from motors_work");
        menu.put("E4", "  E4 - Find all motors_work");


        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createArea);
        methodsMenu.put("12", this::updateArea);
        methodsMenu.put("13", this::deleteFromArea);
        methodsMenu.put("14", this::findAllAreas);
        methodsMenu.put("15", this::findAreaByOwner);


        methodsMenu.put("21", this::createClient);
        methodsMenu.put("22", this::updateClient);
        methodsMenu.put("23", this::deleteFromClient);
        methodsMenu.put("24", this::findAllClients);


        methodsMenu.put("31", this::createLightSensor);
        methodsMenu.put("32", this::updateLightSensor);
        methodsMenu.put("33", this::deleteFromLightSensor);
        methodsMenu.put("34", this::findAllLightSensor);

        methodsMenu.put("44", this::findAllMotors);
        methodsMenu.put("41", this::createMotor);
        methodsMenu.put("42", this::updateMotor);
        methodsMenu.put("43", this::deleteFromMotors);

        methodsMenu.put("54", this::findAllPumps);
        methodsMenu.put("51", this::createPump);
        methodsMenu.put("52", this::updatePumps);
        methodsMenu.put("53", this::deleteFromPump);

        methodsMenu.put("64", this::findAllWaterSystem);
        methodsMenu.put("61", this::createWaterSystem);
        methodsMenu.put("62", this::updateWaterSystem);
        methodsMenu.put("63", this::deleteFromWaterSystem);

        methodsMenu.put("74", this::findAllMoistureSensor);
        methodsMenu.put("71", this::createMoistureSensor);
        methodsMenu.put("72", this::updateMoistureSensor);
        methodsMenu.put("73", this::deleteFromMoistureSensor);

        methodsMenu.put("84", this::findAllTemperatureSensor);
        methodsMenu.put("81", this::createTemperatureSensor);
        methodsMenu.put("82", this::updateTemperatureSensor);
        methodsMenu.put("83", this::deleteFromTemperatureSensor);

        methodsMenu.put("94", this::findAllNozzle);
        methodsMenu.put("91", this::createNozzle);
        methodsMenu.put("92", this::updateNozzle);
        methodsMenu.put("93", this::deleteFromNozzle);

        methodsMenu.put("B4", this::findAllLightSensorWork);
        methodsMenu.put("B1", this::createLightSensorWork);
        methodsMenu.put("B2", this::updateLightSensorWork);
        methodsMenu.put("B3", this::deleteFromLightSensorWor);

        methodsMenu.put("C4", this::findAllMoistureSensorWork);
        methodsMenu.put("C1", this::createMoistureSensorWork);
        methodsMenu.put("C2", this::updateMoistureSensorWork);
        methodsMenu.put("C3", this::deleteFromMoistureSensorWor);

        methodsMenu.put("D4", this::findAllTemperatureSensorWork);
        methodsMenu.put("D1", this::createTemperatureSensorWork);
        methodsMenu.put("D2", this::updateTemperatureSensorWork);
        methodsMenu.put("D3", this::deleteFromTemperatureeSensorWor);

        methodsMenu.put("E4", this::findAllMotorsWork);
        methodsMenu.put("E1", this::createMotorsWork);
        methodsMenu.put("E2", this::updateMotorsrWork);
        methodsMenu.put("E3", this::deleteFromMotorsWork);


    }

    private void selectAllTable() {
        findAllAreas();
        findAllClients();
        findAllMotors();

    }

    //AREA TABLE
    private void findAllAreas() {
        System.out.println("\nTable: BOOK");
        List<Area> areas = areaController.findAll();
        for (Area area : areas) {
            System.out.println(area);
        }
    }

    private void createArea() {
        System.out.println("Input 'area_square': ");
        Integer square = Integer.valueOf(input.nextLine());
        System.out.println("Input 'ownerClient': ");
        Integer ownerClient = Integer.valueOf(input.nextLine());
        System.out.println("Input 'latitude': ");
        Double latitude = Double.valueOf((input.nextLine()));
        System.out.println("Input 'longitude': ");
        Double longitude = Double.valueOf((input.nextLine()));
        Area area = new Area(null, square, ownerClient, latitude, longitude);

        int count = areaController.create(area);
        System.out.printf("There are created %d rows\n", count);
    }
    private void updateArea() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'area_square': ");
        Integer square = Integer.valueOf(input.nextLine());
        System.out.println("Input 'ownerClient': ");
        Integer ownerClient = Integer.valueOf(input.nextLine());
        System.out.println("Input 'latitude': ");
        Double latitude = Double.valueOf((input.nextLine()));
        System.out.println("Input 'longitude': ");
        Double longitude = Double.valueOf((input.nextLine()));
        Area area = new Area(null, square, ownerClient, latitude, longitude);

        int count = areaController.update(id, area);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromArea() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = areaController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAreaByOwner() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        List<Area> areas = areaController.findByOwnerSurname(id);
        for (Area area : areas) {
            System.out.println(area);
        }
    }

// CLIENT TABLE

    public void findAllClients() {
        System.out.println("\nTable: BOOK");
        List<Client> clients = clientController.findAll();
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    private void createClient() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'surname': ");
        String surname = input.nextLine();
        System.out.println("Input 'phone_number': ");
        String phone = input.nextLine();
        System.out.println("Input 'email': ");
        String email = input.nextLine();
        Client client = new Client(null, name, surname, phone, email);

        int count = clientController.create(client);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateClient() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'surname': ");
        String surname = input.nextLine();
        System.out.println("Input 'phone_number': ");
        String phone = input.nextLine();
        System.out.println("Input 'email': ");
        String email = input.nextLine();
        Client client = new Client(null, name, surname, phone, email);
        int count = clientController.update(id, client);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromClient() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = clientController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    // MOTOR TABLE
    public void findAllMotors() {
        System.out.println("\nTable: MOTORS");
        List<Motor> motors = motorController.findAll();
        for (Motor motor : motors) {
            System.out.println(motor);
        }
    }

    private void createMotor() {
        System.out.println("Input 'motor id': ");
        Integer motorId = Integer.valueOf(input.nextLine());
        System.out.println("Input 'pumps_id': ");
        Integer pumpId = Integer.valueOf(input.nextLine());

        Motor motor = new Motor(motorId, pumpId);

        int count = motorController.create(motor);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateMotor() {
        System.out.println("Input 'motor id': ");
        Integer motorId = Integer.valueOf(input.nextLine());
        System.out.println("Input 'pumps_id': ");
        Integer pumpId = Integer.valueOf(input.nextLine());

        Motor motor = new Motor(motorId, pumpId);

        int count = motorController.update(motorId, motor);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromMotors() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = motorController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }


    public void findAllLightSensor() {
        System.out.println("\nTable: eee");
        List<Sensor> sensors = lightSensorController.findAll();
        for (Sensor sensor : sensors) {
            System.out.println(sensor);
        }

    }


    public void updateLightSensor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'area_id': ");
        Integer area_id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'latitude': ");
        Double latitude = Double.valueOf((input.nextLine()));
        System.out.println("Input 'longitude': ");
        Double longitude = Double.valueOf((input.nextLine()));
        Sensor area = new Sensor(id, area_id, latitude, longitude);

        int count = lightSensorController.update(id, area);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void createLightSensor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'area_id': ");
        Integer area_id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'latitude': ");
        Double latitude = Double.valueOf((input.nextLine()));
        System.out.println("Input 'longitude': ");
        Double longitude = Double.valueOf((input.nextLine()));
        Sensor sensor = new Sensor(id, area_id, latitude, longitude);
        int count = lightSensorController.create(sensor);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromLightSensor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = lightSensorController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    public void findAllMoistureSensor() {
        System.out.println("\nTable: eee");
        List<Sensor> sensors = moistureSensorController.findAll();
        for (Sensor sensor : sensors) {
            System.out.println(sensor);
        }

    }


    public void updateMoistureSensor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'area_id': ");
        Integer area_id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'latitude': ");
        Double latitude = Double.valueOf((input.nextLine()));
        System.out.println("Input 'longitude': ");
        Double longitude = Double.valueOf((input.nextLine()));
        Sensor area = new Sensor(id, area_id, latitude, longitude);

        int count = moistureSensorController.update(id, area);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void createMoistureSensor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'area_id': ");
        Integer area_id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'latitude': ");
        Double latitude = Double.valueOf((input.nextLine()));
        System.out.println("Input 'longitude': ");
        Double longitude = Double.valueOf((input.nextLine()));
        Sensor sensor = new Sensor(id, area_id, latitude, longitude);
        int count = moistureSensorController.create(sensor);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromMoistureSensor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = moistureSensorController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }
    public void findAllTemperatureSensor() {
        System.out.println("\nTable: eee");
        List<Sensor> sensors = temperatureSensorController.findAll();
        for (Sensor sensor : sensors) {
            System.out.println(sensor);
        }

    }


    public void updateTemperatureSensor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'area_id': ");
        Integer area_id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'latitude': ");
        Double latitude = Double.valueOf((input.nextLine()));
        System.out.println("Input 'longitude': ");
        Double longitude = Double.valueOf((input.nextLine()));
        Sensor area = new Sensor(id, area_id, latitude, longitude);

        int count = temperatureSensorController.update(id, area);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void createTemperatureSensor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'area_id': ");
        Integer area_id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'latitude': ");
        Double latitude = Double.valueOf((input.nextLine()));
        System.out.println("Input 'longitude': ");
        Double longitude = Double.valueOf((input.nextLine()));
        Sensor sensor = new Sensor(id, area_id, latitude, longitude);
        int count = temperatureSensorController.create(sensor);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromTemperatureSensor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = temperatureSensorController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }


    private void findAllNozzle() {
        System.out.println("\nTable: nozzle");
        List<Nozzle> nozzles = nozzleController.findAll();
        for (Nozzle nozzle : nozzles) {
            System.out.println(nozzle);
        }

    }


    private void updateNozzle() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'system_id': ");
        Integer system_id = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'max_water_consume': ");
        Integer max_water_consume = Integer.valueOf(input.nextLine());

        System.out.println("Input 'longitude': ");
        Double longitude = Double.valueOf((input.nextLine()));
        System.out.println("Input 'latitude': ");
        Double latitude = Double.valueOf((input.nextLine()));
        Nozzle nozzle = new Nozzle(id, system_id, max_water_consume, longitude, latitude);

        int count = nozzleController.update(id, nozzle);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void createNozzle() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'system_id': ");
        Integer system_id = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'max_water_consume': ");
        Integer max_water_consume = Integer.valueOf(input.nextLine());

        System.out.println("Input 'longitude': ");
        Double longitude = Double.valueOf((input.nextLine()));
        System.out.println("Input 'latitude': ");
        Double latitude = Double.valueOf((input.nextLine()));
        Nozzle nozzle = new Nozzle(id, system_id, max_water_consume, longitude, latitude);

        int count = nozzleController.create(nozzle);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromNozzle() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = nozzleController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllPumps() {
        System.out.println("\nTable: pumps");
        List<Pump> pumps = pumpController.findAll();
        for (Pump pump : pumps) {
            System.out.println(pump);
        }

    }


    public void updatePumps() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'area': ");
        Integer area = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'count_of_motors': ");
        Integer count_of_motors = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'water_consume': ");
        Integer water_consume = Integer.valueOf(input.nextLine());


        Pump pump = new Pump(id, area, count_of_motors, water_consume);

        int count = pumpController.update(id, pump);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void createPump() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'area': ");
        Integer area = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'count_of_motors': ");
        Integer count_of_motors = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'water_consume': ");
        Integer water_consume = Integer.valueOf(input.nextLine());


        Pump pump = new Pump(id, area, count_of_motors, water_consume);

        int count = pumpController.create(pump);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromPump() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = pumpController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllMotorsWork() {
        System.out.println("\nTable: sensor work");
        List<MotorsWork> sensors = motorsWorkController.findAll();
        for (MotorsWork sensor : sensors) {
            System.out.println(sensor);
        }

    }
    public void updateMotorsrWork() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'motor id': ");
        Integer motor_id = Integer.valueOf(input.nextLine());

        System.out.println("Input new turn_on_time: ");
        Timestamp turn_on_time = Timestamp.valueOf(input.nextLine());

        System.out.println("Input new 'turn_off_time': ");
        Timestamp turn_off_time = Timestamp.valueOf(input.nextLine());
        System.out.println("Input new ' water_consume': ");
        Integer water_consume = Integer.valueOf(input.nextLine());


        MotorsWork sensor = new MotorsWork(id, motor_id, turn_on_time, turn_off_time, water_consume);

        int count = motorsWorkController.update(id, sensor);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void createMotorsWork() {


        System.out.println("Input new 'motor id': ");
        Integer motor_id = Integer.valueOf(input.nextLine());

        System.out.println("Input new turn_on_time: ");
        Timestamp turn_on_time = Timestamp.valueOf(input.nextLine());

        System.out.println("Input new 'turn_off_time': ");
        Timestamp turn_off_time = Timestamp.valueOf(input.nextLine());
        System.out.println("Input new ' water_consume': ");
        Integer water_consume = Integer.valueOf(input.nextLine());


        MotorsWork sensor = new MotorsWork(null, motor_id, turn_on_time, turn_off_time, water_consume);
        int count = motorsWorkController.create(sensor);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromMotorsWork() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = motorsWorkController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }
    private void findAllLightSensorWork() {
        System.out.println("\nTable: sensor work");
        List<LightSensorWork> sensors = lightSensorWorkController.findAll();
        for (LightSensorWork sensor : sensors) {
            System.out.println(sensor);
        }

    }
    public void updateLightSensorWork() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'sensor id': ");
        Integer sensor_id = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'light': ");
        Integer light = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'time': ");
        Timestamp time = Timestamp.valueOf(input.nextLine());


        LightSensorWork sensor = new LightSensorWork(id, sensor_id, light, time);

        int count = lightSensorWorkController.update(id, sensor);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void createLightSensorWork() {

        System.out.println("Input  'sensor id': ");
        Integer sensor_id = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'light': ");
        Integer light = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'time': ");
        Timestamp time = Timestamp.valueOf(input.nextLine());


        LightSensorWork sensor = new LightSensorWork(null,sensor_id, light, time);


        int count = lightSensorWorkController.create(sensor);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromLightSensorWor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = lightSensorWorkController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllMoistureSensorWork() {
        System.out.println("\nTable: moisture sensor work");
        List<MoistureSensorWork> sensors = moistureSensorWorkController.findAll();
        for (MoistureSensorWork sensor : sensors) {
            System.out.println(sensor);
        }

    }
    public void updateMoistureSensorWork() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'sensor id': ");
        Integer sensor_id = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'moisture': ");
        Integer moisture = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'time': ");
        Timestamp time = Timestamp.valueOf(input.nextLine());


        MoistureSensorWork sensor = new MoistureSensorWork(id, sensor_id, moisture, time);

        int count = moistureSensorWorkController.update(id, sensor);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void createMoistureSensorWork() {

        System.out.println("Input  'sensor id': ");
        Integer sensor_id = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'light': ");
        Integer light = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'time': ");
        Timestamp time = Timestamp.valueOf(input.nextLine());


        MoistureSensorWork sensor = new MoistureSensorWork(null,sensor_id, light, time);


        int count = moistureSensorWorkController.create(sensor);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromMoistureSensorWor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = moistureSensorWorkController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }
    private void findAllTemperatureSensorWork() {
        System.out.println("\nTable: moisture sensor work");
        List<TemperatureSensorWork> sensors = temperatureSensorWorkController.findAll();
        for (TemperatureSensorWork sensor : sensors) {
            System.out.println(sensor);
        }

    }
    public void updateTemperatureSensorWork() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'sensor id': ");
        Integer sensor_id = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'moisture': ");
        Integer moisture = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'time': ");
        Timestamp time = Timestamp.valueOf(input.nextLine());


        TemperatureSensorWork sensor = new TemperatureSensorWork(id, sensor_id, moisture, time);

        int count = temperatureSensorWorkController.update(id, sensor);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void createTemperatureSensorWork() {

        System.out.println("Input  'sensor id': ");
        Integer sensor_id = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'light': ");
        Integer light = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'time': ");
        Timestamp time = Timestamp.valueOf(input.nextLine());


        TemperatureSensorWork sensor = new TemperatureSensorWork(null,sensor_id, light, time);


        int count = temperatureSensorWorkController.create(sensor);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromTemperatureeSensorWor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = temperatureSensorWorkController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }


    public void findAllWaterSystem() {
        System.out.println("\nTable: pumps");
        List<WaterSystem> waterSystems = waterSystemController.findAll();
        for (WaterSystem waterSystem : waterSystems) {
            System.out.println(waterSystem);
        }

    }

    public void updateWaterSystem() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'area': ");
        Integer area = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'count_of_nozzles': ");
        Integer count_of_nozzles = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'pump': ");
        Integer pump = Integer.valueOf(input.nextLine());


        WaterSystem waterSystem = new WaterSystem(id, area, count_of_nozzles, pump);

        int count = waterSystemController.update(id, waterSystem);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void createWaterSystem() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'area': ");
        Integer area = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'count_of_nozzles': ");
        Integer count_of_nozzles = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'pump': ");
        Integer pump = Integer.valueOf(input.nextLine());


        WaterSystem waterSystem = new WaterSystem(id, area, count_of_nozzles, pump);

        int count = waterSystemController.create(waterSystem);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromWaterSystem() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = waterSystemController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }


    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\w")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!keyMenu.equals("Q"));
    }


}
