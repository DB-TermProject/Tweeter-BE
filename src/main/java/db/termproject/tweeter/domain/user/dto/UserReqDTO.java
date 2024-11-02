package db.termproject.tweeter.domain.user.dto;

import jakarta.validation.constraints.NotEmpty;

public class UserReqDTO {

    public record Login(
            @NotEmpty String id,
            @NotEmpty String password
    ) {}
}
