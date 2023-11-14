package com.dylansmusicshop.users;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public class JdbcUser implements UserRepo {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUser(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findByID(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
    }

    @Override
    public User findByUsername(String username) {
        try {
        String sql = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, new UserRowMapper());
    } catch(
    EmptyResultDataAccessException e) {
            return null;
        }
    }


@Override
        public List<User> findAll() {
            String sql = "SELECT * FROM users";
            return jdbcTemplate.query(sql, new UserRowMapper());
        }

        @Override
        public User save(User user) {
            String sql = "INSERT INTO users (username, password, email, authorities, enabled) VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getAuthorities(), user.getEnabled());

            return user;
        }

        @Override
        public void update(User user) {
            String sql = "UPDATE users SET username = ?, password = ? email = ? WHERE id = ?";
            jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getID());
        }

        @Override
        public void deleteByID(int id) {
            String sql = "DELETE FROM users WHERE id = ?";
            jdbcTemplate.update(sql, id);
        }

    @Override
    public int findUserIdByUsername(String username) {
        String sql = "SELECT id from users where id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, username);
    }
}

