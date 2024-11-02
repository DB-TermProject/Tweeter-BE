package db.termproject.tweeter.domain.user.repository;

import db.termproject.tweeter.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);

    public Optional<User> findByIdAndPassword(String id, String password) {
        String sql = "SELECT * FROM user WHERE id = ? AND password = ?";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new Object[]{id, password}, rowMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
