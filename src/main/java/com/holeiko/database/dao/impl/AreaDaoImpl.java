package com.holeiko.database.dao.impl;
import com.holeiko.database.dao.AreaDao;
import com.holeiko.database.domain.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class AreaDaoImpl implements AreaDao {
    private static final String FIND_ALL = "SELECT * FROM areas";
    private static final String CREATE = " INSERT INTO `areas` ( `square`,`owner_client`,`latitude`,`longitude`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE areas SET square=?, owner_client=?, latitude=?, longitude=? WHERE id=?";
    private static final String DELETE = "DELETE FROM areas WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM areas WHERE id=?";
    private static final String FIND_BY_OWNER_ID = "SELECT * FROM areas WHERE owner_client=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public List<Area> findByOwnerSurname(Integer id) {
        return jdbcTemplate.query(FIND_BY_OWNER_ID, BeanPropertyRowMapper.newInstance(Area.class), id);
    }



    @Override
    public List<Area> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Area.class));
    }

    @Override
    public Optional<Area> findById(Integer id) {
         Optional<Area> area;
        try {
            area = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Area.class), id));
        } catch (EmptyResultDataAccessException e) {
            area = Optional.empty();
        }
        return area;
    }

    @Override
    public int create(Area entity) {
        return jdbcTemplate.update(CREATE, entity.getSquare(), entity.getOwnerClient(), entity.getLatitude(), entity.getLongitude());
    }

    @Override
    public int update(Integer id, Area entity) {
        return jdbcTemplate.update(UPDATE,entity.getSquare(), entity.getOwnerClient(), entity.getLatitude(), entity.getLongitude(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
