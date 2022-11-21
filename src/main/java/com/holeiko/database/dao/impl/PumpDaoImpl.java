package com.holeiko.database.dao.impl;

import com.holeiko.database.dao.PumpDao;
import com.holeiko.database.domain.Area;
import com.holeiko.database.domain.Pump;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class PumpDaoImpl implements PumpDao {
    private static final String FIND_ALL = "SELECT * FROM pumps_info";
    private static final String CREATE = " INSERT INTO `pumps_info` ( `id`,`area`,`count_of_motors`,`water_consumtion`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE pumps_info SET square=?, owner_client=?, latitude=?, longitude=? WHERE id=?";
    private static final String DELETE = "DELETE FROM pumps_info WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM pumps_info WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;




    @Override
    public List<Pump> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Pump.class));
    }

    @Override
    public Optional<Pump> findById(Integer id) {
        Optional<Pump> pump;
        try {
            pump = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Pump.class), id));
        } catch (EmptyResultDataAccessException e) {
            pump = Optional.empty();
        }
        return pump;
    }

    @Override
    public int create(Pump entity) {
        return jdbcTemplate.update(CREATE, entity.getId(), entity.getArea(), entity.getCount_of_motors(), entity.getWater_consume());
    }

    @Override
    public int update(Integer id, Pump entity) {
        return jdbcTemplate.update(UPDATE,entity.getId(), entity.getArea(), entity.getCount_of_motors(), entity.getWater_consume(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
