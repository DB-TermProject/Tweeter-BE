package db.termproject.tweeter.domain.comment.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Comment {

    @Id
    private Long comment_id;

    private String content;

    private Long like_count;

    private Long writer_id;

    private Long post_id;

    private Long parent_comment_id;
}
