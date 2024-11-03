package db.termproject.tweeter.domain.user.repository;

import db.termproject.tweeter.domain.user.entity.User;
import db.termproject.tweeter.domain.user.mapper.UserRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static db.termproject.tweeter.domain.user.dto.UserReqDTO.Profile;
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

    public void updateProfile(Long id, Profile dto) {
        String sql = "UPDATE user SET info = ?, profile_image_url = ?, organization = ?, is_public = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                dto.info(),
                dto.profile_image_url(),
                dto.organization(),
                dto.is_public(),
                id);
    }

    public boolean existsByEmail(String email) {
        String sql = "SELECT 1 FROM user WHERE email = ? LIMIT 1";
        try {
            jdbcTemplate.queryForObject(sql, Integer.class, email);
            return true; // 결과가 있으면 true 반환
        } catch (EmptyResultDataAccessException e) {
            return false; // 결과가 없으면 false 반환
        }
    }

    public void updatePassword(Long id, String password) {
        String sql = "UPDATE user SET password = ? WHERE id = ?";
        jdbcTemplate.update(sql, password, id);
    }
}
