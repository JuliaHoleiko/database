package com.holeiko.database.dao.impl;

import com.holeiko.database.dao.NozzleDao;
import com.holeiko.database.domain.Area;
import com.holeiko.database.domain.Nozzle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class NozzleDaoImpl implements NozzleDao {
    private static final String FIND_ALL = "SELECT * FROM nozzle";
    private static final String CREATE = " INSERT INTO `nozzle` ( `id`,`system_id`,`max_water_consumtion`,`longitude`, `latitude`) VALUES (?, ?, ?, ?,?)";
    private static final String UPDATE = "UPDATE nozzle SET id=?, system_id=?, max_water_consumtion=?, longitude=?, latitude=? WHERE id=?";
    private static final String DELETE = "DELETE FROM nozzle WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM nozzle WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Nozzle> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Nozzle.class));
    }

    @Override
    public Optional<Nozzle> findById(Integer id) {
        Optional<Nozzle> nozzle;
        try {
            nozzle = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Nozzle.class), id));
        } catch (EmptyResultDataAccessException e) {
            nozzle = Optional.empty();
        }
        return nozzle;
    }

    @Override
    public int create(Nozzle entity) {
        return jdbcTemplate.update(CREATE, entity.getId(), entity.getSystemId(), entity.getMaxWaterConsume(), entity.getLongitude(), entity.getLatitude());
    }

    @Override
    public int update(Integer id, Nozzle entity) {
        return jdbcTemplate.update(UPDATE, entity.getId(), entity.getSystemId(), entity.getMaxWaterConsume(), entity.getLongitude(), entity.getLatitude(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}

