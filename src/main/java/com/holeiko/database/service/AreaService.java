package com.holeiko.database.service;

import com.holeiko.database.domain.Area;

import java.util.List;
import java.util.Optional;

public interface AreaService extends GeneralService<Area, Integer>{

    List<Area> findByOwnerSurname(Integer ownerSurname);
}
