package com.holeiko.database.controller;

import com.holeiko.database.domain.Area;

import java.util.List;
import java.util.Optional;

public interface AreaController extends GeneralController<Area, Integer>{
    List<Area> findByOwnerSurname(Integer ownerSurname);
}
