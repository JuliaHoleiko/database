package com.holeiko.database.dao.impl;

import com.holeiko.database.dao.MoistureSensorWorkDao;
import com.holeiko.database.dao.MotorsWorkDao;
import com.holeiko.database.domain.MoistureSensorWork;
import com.holeiko.database.domain.MotorsWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class MotorsWorkDaoImpl implements MotorsWorkDao {
    private static final String FIND_ALL = "SELECT * FROM motors_work";
    private static final String CREATE = " INSERT INTO `motors_work` (`motor_id`, `turn_on_time`, `turn_on_time`, `water_consume`) VALUES (?, ?, ?, ?,?)";
    private static final String UPDATE = "UPDATE motors_work SET motor_id=?, turn_on_time=?, turn_on_time=?, water_consume=? WHERE id=?";
    private static final String DELETE = "DELETE FROM motors_work WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM motors_work WHERE id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<MotorsWork> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(MotorsWork.class));
    }

    @Override
    public Optional<MotorsWork> findById(Integer integer) {
        Optional<MotorsWork> work;
        try {
            work = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(MotorsWork.class), integer));
        } catch (EmptyResultDataAccessException e) {
            work = Optional.empty();
        }
        return work;
    }

    @Override
    public int create(MotorsWork entity) {
        return jdbcTemplate.update(CREATE, entity.getMotorId(), entity.getTurnOfTime(), entity.getTurnOfTime(), entity.getWaterConsume());

    }

    @Override
    public int update(Integer integer, MotorsWork entity) {
        return jdbcTemplate.update(UPDATE, entity.getMotorId(), entity.getMotorId(), entity.getTurnOfTime(), entity.getTurnOfTime(), entity.getWaterConsume(), integer);
    }

    @Override
    public int delete(Integer integer) {
        return jdbcTemplate.update(DELETE, integer);
    }
}


