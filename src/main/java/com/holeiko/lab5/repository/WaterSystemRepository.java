package com.holeiko.lab5.repository;

import com.holeiko.lab5.domain.WaterSystem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterSystemRepository extends JpaRepository<WaterSystem, Integer> {
}
