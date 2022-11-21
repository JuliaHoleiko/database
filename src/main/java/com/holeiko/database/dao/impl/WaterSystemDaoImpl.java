package com.holeiko.database.dao.impl;

import com.holeiko.database.dao.WaterSystemDao;
import com.holeiko.database.domain.Area;
import com.holeiko.database.domain.WaterSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@SuppressWarnings("SqlResolve")
@Service
public class WaterSystemDaoImpl implements WaterSystemDao {

    private static final String FIND_ALL = "SELECT * FROM water_system";
    private static final String CREATE = " INSERT INTO `water_system` ( `id`,`area`,`count_of_nozzles`,`pump`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE water_system SET area=?, count_of_nozzles=?, pump=? WHERE id=?";
    private static final String DELETE = "DELETE FROM water_system WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM water_system WHERE id=?";
    private static final String FIND_BY_OWNER_ID = "SELECT * FROM areas WHERE owner_client=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public List<WaterSystem> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(WaterSystem.class));
    }

    @Override
    public Optional<WaterSystem> findById(Integer id) {
        Optional<WaterSystem> waterSystem;
        try {
            waterSystem = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(WaterSystem.class), id));
        } catch (EmptyResultDataAccessException e) {
            waterSystem = Optional.empty();
        }
        return waterSystem;
    }

    @Override
    public int create(WaterSystem entity) {
        return jdbcTemplate.update(CREATE, entity.getId(), entity.getArea(), entity.getCount_of_nozzles(), entity.getPump());
    }

    @Override
    public int update(Integer id, WaterSystem entity) {
        return jdbcTemplate.update(UPDATE, entity.getId(), entity.getArea(), entity.getCount_of_nozzles(), entity.getPump(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
