package db.termproject.tweeter.domain.follow.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FollowRepository {

    private final JdbcTemplate jdbcTemplate;

    public void save(Long from, Long to) {
        String sql = "INSERT INTO follow (follower_id, following_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, from, to);
    }

    public void delete(Long from, Long to) {
        String sql = "DELETE FROM follow WHERE follower_id = ? AND following_id = ?";
        jdbcTemplate.update(sql, from, to);
    }
}
