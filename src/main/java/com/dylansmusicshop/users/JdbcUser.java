package com.dylansmusicshop.users;


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
        public User findByID(Long id) {
            String sql = "SELECT * FROM users WHERE id = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
        }

        @Override
        public User findByUsername(String username) {
            String sql = "SELECT * FROM users WHERE username = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{username}, new UserRowMapper());
        }

        @Override
        public List<User> findAll() {
            String sql = "SELECT * FROM users";
            return jdbcTemplate.query(sql, new UserRowMapper());
        }

        @Override
        public void save(User user) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
        }

        @Override
        public void update(User user) {
            String sql = "UPDATE users SET username = ?, password = ? WHERE id = ?";
            jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getID());
        }

        @Override
        public void deleteByID(Long id) {
            String sql = "DELETE FROM users WHERE id = ?";
            jdbcTemplate.update(sql, id);
        }
    }

