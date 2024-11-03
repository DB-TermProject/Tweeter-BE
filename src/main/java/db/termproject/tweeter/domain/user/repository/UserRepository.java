package db.termproject.tweeter.domain.user.repository;

import db.termproject.tweeter.domain.user.entity.User;
import db.termproject.tweeter.domain.user.mapper.UserRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static db.termproject.tweeter.domain.user.dto.UserReqDTO.SignUp;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRowMapper = new UserRowMapper();

    public Optional<User> findByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new Object[]{email, password}, userRowMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public void save(SignUp dto) {
        String sql = "INSERT INTO user (email, password, name) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, dto.email(), dto.password(), dto.name());
    }
}
