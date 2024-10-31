package db.termproject.tweeter.domain.like.entity;

import db.termproject.tweeter.global.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostLike extends BaseEntity {

    @Id
    private Long post_like_id;

    private Long liker_id;

    private Long post_id;
}
