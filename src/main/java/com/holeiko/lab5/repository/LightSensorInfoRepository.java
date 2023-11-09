package com.holeiko.lab5.repository;

import com.holeiko.lab5.domain.Clients;
import com.holeiko.lab5.domain.LightSensorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightSensorInfoRepository extends JpaRepository<LightSensorInfo, Integer> {
}
