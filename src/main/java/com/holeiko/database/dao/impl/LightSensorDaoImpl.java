package com.holeiko.database.dao.impl;

import com.holeiko.database.dao.SensorDao;
import com.holeiko.database.domain.Area;
import com.holeiko.database.domain.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class LightSensorDaoImpl implements SensorDao {
    private static final String FIND_ALL = "SELECT * FROM light_sensor_info";
    private static final String CREATE = " INSERT INTO `light_sensor_info` ( `sensor_id`,`areas_id`,`latitude`,`longitude`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE light_sensor_info SET sensor_id=?, areas_id=?, latitude=?, longitude=? WHERE sensor_id=?";
    private static final String DELETE = "DELETE FROM light_sensor_info WHERE sensor_id=?";
    private static final String FIND_BY_ID = "SELECT * FROM light_sensor_info WHERE sensor_id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Sensor> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Sensor.class));
    }

    @Override
    public Optional<Sensor> findById(Integer id) {
        Optional<Sensor> sensor;
        try {
            sensor = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Sensor.class), id));
        } catch (EmptyResultDataAccessException e) {
            sensor = Optional.empty();
        }
        return sensor;
    }

    @Override
    public int create(Sensor entity) {
        return jdbcTemplate.update(CREATE, entity.getSensor_id(), entity.getAreas_id(), entity.getLatitude(), entity.getLongitude());
    }

    @Override
    public int update(Integer id, Sensor entity) {
        return jdbcTemplate.update(UPDATE,entity.getSensor_id(), entity.getAreas_id(), entity.getLatitude(), entity.getLongitude(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
