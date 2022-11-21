package com.holeiko.database.dao.impl;

import com.holeiko.database.dao.LightSensorWorkDao;
import com.holeiko.database.domain.Area;
import com.holeiko.database.domain.LightSensorWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class LightSensorWorkDaoImpl implements LightSensorWorkDao {
    private static final String FIND_ALL = "SELECT * FROM light_sensor_work";
    private static final String CREATE = " INSERT INTO `light_sensor_work` (`sensor_id`, `light`, `time`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE light_sensor_work SET sensor_id=?, light=?, time=? WHERE id=?";
    private static final String DELETE = "DELETE FROM light_sensor_work WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM light_sensor_work WHERE id=?";
    private static final String FIND_BY_OWNER_ID = "SELECT * FROM light_sensor_work WHERE owner_client=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<LightSensorWork> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(LightSensorWork.class));
    }

    @Override
    public Optional<LightSensorWork> findById(Integer integer) {
        Optional<LightSensorWork> work;
        try {
            work = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(LightSensorWork.class), integer));
        } catch (EmptyResultDataAccessException e) {
            work = Optional.empty();
        }
        return work;
    }

    @Override
    public int create(LightSensorWork entity) {
        return jdbcTemplate.update(CREATE, entity.getSensorId(), entity.getLight(), entity.getTime());

    }

    @Override
    public int update(Integer integer, LightSensorWork entity) {
        return jdbcTemplate.update(UPDATE, entity.getSensorId(), entity.getLight(), entity.getTime(), integer);
    }

    @Override
    public int delete(Integer integer) {
        return jdbcTemplate.update(DELETE, integer);
    }
}


