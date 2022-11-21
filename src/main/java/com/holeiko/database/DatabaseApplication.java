package com.holeiko.database;

import com.holeiko.database.dao.impl.AreaDaoImpl;
import com.holeiko.database.domain.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DatabaseApplication implements CommandLineRunner {

	@Autowired
	private  View view;
	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		view.show();
		//view.updateLightSensor();
		//view.findAllLightSensor();


	}

}
