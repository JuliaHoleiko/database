package com.holeiko.database.dao;

import com.holeiko.database.domain.Area;

import java.util.List;
import java.util.Optional;

public interface AreaDao extends GeneralDao <Area, Integer>{
    List<Area> findByOwnerSurname(Integer ownerSurname);


}
