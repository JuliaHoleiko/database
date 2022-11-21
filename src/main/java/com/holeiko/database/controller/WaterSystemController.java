package com.holeiko.database.controller;

import com.holeiko.database.dao.WaterSystemDao;
import com.holeiko.database.domain.WaterSystem;
import org.springframework.data.relational.core.sql.In;

public interface WaterSystemController extends GeneralController<WaterSystem, Integer> {
}
