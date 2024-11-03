package db.termproject.tweeter.domain.user.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserReqDTO {

    public record Login(
            @NotEmpty String email,
            @NotEmpty String password
    ) {}

    public record SignUp(
            @NotEmpty String email,
            @NotEmpty String password,
            @NotEmpty String name
    ) {}

    public record Profile(
            String info,
            String profile_image_url,
            String organization,
            @NotNull Boolean is_public
    ) {}
}
