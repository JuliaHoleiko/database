package com.holeiko.database.dao.impl;

import com.holeiko.database.dao.MotorDao;
import com.holeiko.database.domain.Area;
import com.holeiko.database.domain.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@SuppressWarnings("SqlResolve")
@Service
public class MotorDaoImpl implements MotorDao {
    private static final String FIND_ALL = "SELECT * FROM motors";
    private static final String CREATE = " INSERT INTO `motors` ( `id`,`pumps_id`) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE motors SET id=?, pumps_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM motors WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM motors WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Motor> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Motor.class));
    }

    @Override
    public Optional<Motor> findById(Integer id) {
        Optional<Motor> motor;
        try {
            motor = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Motor.class), id));
        } catch (EmptyResultDataAccessException e) {
            motor = Optional.empty();
        }
        return motor;
    }

    @Override
    public int create(Motor entity) {
        return jdbcTemplate.update(CREATE, entity.getId(), entity.getPumps_id());
    }

    @Override
    public int update(Integer id, Motor entity) {
        return jdbcTemplate.update(UPDATE, entity.getId(), entity.getPumps_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

}
