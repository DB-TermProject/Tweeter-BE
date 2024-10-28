package db.termproject.tweeter.domain.post.entity;

import db.termproject.tweeter.global.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Post extends BaseEntity {

    private String id;

    private String content;

    private Long likeCount;

    private Long commentCount;

    private Long retweetCount;

    private Boolean isPinned;
}
