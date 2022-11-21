package com.holeiko.database.dao.impl;

import com.holeiko.database.dao.MoistureSensorWorkDao;
import com.holeiko.database.dao.TemperatureSensorWorkDao;
import com.holeiko.database.domain.MoistureSensorWork;
import com.holeiko.database.domain.TemperatureSensorWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class TemperatureSensorWorkDaoImpl implements TemperatureSensorWorkDao {
    private static final String FIND_ALL = "SELECT * FROM temperature_sensor_work";
    private static final String CREATE = " INSERT INTO `temperature_sensor_work` (`sensor_id`, `temperature`, `time`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE temperature_sensor_work SET sensor_id=?, temperature=?, time=? WHERE id=?";
    private static final String DELETE = "DELETE FROM temperature_sensor_work WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM temperature_sensor_work WHERE id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<TemperatureSensorWork> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(TemperatureSensorWork.class));
    }

    @Override
    public Optional<TemperatureSensorWork> findById(Integer integer) {
        Optional<TemperatureSensorWork> work;
        try {
            work = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(TemperatureSensorWork.class), integer));
        } catch (EmptyResultDataAccessException e) {
            work = Optional.empty();
        }
        return work;
    }

    @Override
    public int create(TemperatureSensorWork entity) {
        return jdbcTemplate.update(CREATE,  entity.getSensorId(), entity.getTemperature(), entity.getTime());

    }

    @Override
    public int update(Integer integer, TemperatureSensorWork entity) {
        return jdbcTemplate.update(UPDATE, entity.getSensorId(), entity.getTemperature(), entity.getTime(), integer);
    }

    @Override
    public int delete(Integer integer) {
        return jdbcTemplate.update(DELETE, integer);
    }
}


