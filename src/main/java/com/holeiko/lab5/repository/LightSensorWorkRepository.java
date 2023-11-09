package com.holeiko.lab5.repository;

import com.holeiko.lab5.domain.LightSensorInfo;
import com.holeiko.lab5.domain.LightSensorWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightSensorWorkRepository extends JpaRepository<LightSensorWork, Integer> {
}
