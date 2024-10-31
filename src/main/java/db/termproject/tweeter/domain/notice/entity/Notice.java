package db.termproject.tweeter.domain.notice.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Notice {

    @Id
    private Long notice_id;

    private String content;

    private Long user_id;

    private Boolean is_checked;
}
