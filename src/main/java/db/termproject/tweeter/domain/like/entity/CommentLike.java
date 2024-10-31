package db.termproject.tweeter.domain.like.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CommentLike {

    @Id
    private Long comment_like_id;

    private Long liker_id;

    private Long comment_id;
}
