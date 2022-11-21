package com.holeiko.database.dao.impl;

import com.holeiko.database.dao.ClientDao;
import com.holeiko.database.domain.Area;
import com.holeiko.database.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ClientDaoImpl implements ClientDao {
        private static final String FIND_ALL = "SELECT * FROM clients";
        private static final String CREATE = " INSERT INTO `clients` ( `name`,`surname`,`phone_number`,`email`) VALUES (?, ?, ?, ?)";
        private static final String UPDATE = "UPDATE clients SET `name`=?, surname=?, phone_number=?, email=? WHERE client_id=?";
        private static final String DELETE = "DELETE FROM clients WHERE client_id=?";
        private static final String FIND_BY_ID = "SELECT * FROM clients WHERE client_id=?";

        @Autowired
        private JdbcTemplate jdbcTemplate;



        @Override
        public List<Client> findAll() {
            return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Client.class));
        }

        @Override
        public Optional<Client> findById(Integer id) {
            Optional<Client> client;
            try {
                client = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                        BeanPropertyRowMapper.newInstance(Client.class), id));
            } catch (EmptyResultDataAccessException e) {
                client = Optional.empty();
            }
            return client;
        }

        @Override
        public int create(Client entity) {
            return jdbcTemplate.update(CREATE, entity.getName(), entity.getSurname(), entity.getPhoneNumber(), entity.getEmail());
        }

        @Override
        public int update(Integer id, Client entity) {
            return jdbcTemplate.update(UPDATE, entity.getName(), entity.getSurname(), entity.getPhoneNumber(), entity.getEmail(), id);
        }

        @Override
        public int delete(Integer id) {
            return jdbcTemplate.update(DELETE, id);
        }



}

