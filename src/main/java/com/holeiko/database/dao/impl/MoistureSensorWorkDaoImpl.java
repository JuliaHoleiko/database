package com.holeiko.database.dao.impl;

import com.holeiko.database.dao.LightSensorWorkDao;
import com.holeiko.database.dao.MoistureSensorWorkDao;
import com.holeiko.database.domain.LightSensorWork;
import com.holeiko.database.domain.MoistureSensorWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class MoistureSensorWorkDaoImpl implements MoistureSensorWorkDao {
    private static final String FIND_ALL = "SELECT * FROM moisture_sensor_work";
    private static final String CREATE = " INSERT INTO `moisture_sensor_work` (`sensor_id`, `moisture`, `time`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE moisture_sensor_work SET sensor_id=?, moisture=?, time=? WHERE id=?";
    private static final String DELETE = "DELETE FROM moisture_sensor_work WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM moisture_sensor_work WHERE id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<MoistureSensorWork> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(MoistureSensorWork.class));
    }

    @Override
    public Optional<MoistureSensorWork> findById(Integer integer) {
        Optional<MoistureSensorWork> work;
        try {
            work = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(MoistureSensorWork.class), integer));
        } catch (EmptyResultDataAccessException e) {
            work = Optional.empty();
        }
        return work;
    }

    @Override
    public int create(MoistureSensorWork entity) {
        return jdbcTemplate.update(CREATE, entity.getSensorId(), entity.getMoisture(), entity.getTime());

    }

    @Override
    public int update(Integer integer, MoistureSensorWork entity) {
        return jdbcTemplate.update(UPDATE, entity.getSensorId(), entity.getMoisture(), entity.getTime(), integer);
    }

    @Override
    public int delete(Integer integer) {
        return jdbcTemplate.update(DELETE, integer);
    }
}


