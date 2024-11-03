package db.termproject.tweeter.domain.user.mapper;

import db.termproject.tweeter.domain.user.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .id(rs.getLong("id"))
                .email(rs.getString("email"))
                .password(rs.getString("password"))
                .name(rs.getString("name"))
                .info(rs.getString("info"))
                .profile_image_url(rs.getString("profile_image_url"))
                .organization(rs.getString("organization"))
                .is_verified(rs.getBoolean("is_verified"))
                .is_public(rs.getObject("is_public") != null ? rs.getBoolean("is_public") : null) // Null-safe 처리
                .followers_count(rs.getLong("followers_count"))
                .following_count(rs.getLong("following_count"))
                .post_count(rs.getLong("post_count"))
                .build();
    }
}