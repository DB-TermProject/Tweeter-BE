package db.termproject.tweeter.domain.follow.entity;

import db.termproject.tweeter.global.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Follow extends BaseEntity {

    @Id
    private Long follow_id;

    private Long follower_id;     // from

    private Long following_id;    // to
}
