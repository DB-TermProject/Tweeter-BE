package db.termproject.tweeter.domain.user.entity;

import db.termproject.tweeter.global.common.entity.BaseEntity;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    private String id;

    private String password;

    private String name;

    private String info;

    private String profileImageUrl;

    private String organization;

    private Boolean isVerified;

    private Boolean isPublic;

    private Long followersCount;

    private Long followingCount;

    private Long postCount;
}
