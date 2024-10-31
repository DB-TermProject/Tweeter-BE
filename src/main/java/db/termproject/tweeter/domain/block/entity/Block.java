package db.termproject.tweeter.domain.block.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Block {

    @Id
    private Long block_id;

    private Long user_id;     // from

    private Long blocked_user_id;     // to
}
