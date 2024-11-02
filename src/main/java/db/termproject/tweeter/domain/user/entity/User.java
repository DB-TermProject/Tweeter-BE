package db.termproject.tweeter.domain.user.entity;

import db.termproject.tweeter.global.common.entity.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.Id;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    private Long user_id;

    private String password;

    private String name;

    private String info;

    private String profile_image_url;

    private String organization;

    private Boolean is_verified;

    private Boolean is_public;

    private Long followers_count;

    private Long following_count;

    private Long post_count;
}
