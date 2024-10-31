package db.termproject.tweeter.domain.post.entity;

import db.termproject.tweeter.global.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Post extends BaseEntity {

    @Id
    private Long post_id;

    private String content;

    private Long like_count;

    private Long comment_count;

    private Long retweet_count;

    private Boolean is_pinned;

    private Long writer_id;
}
