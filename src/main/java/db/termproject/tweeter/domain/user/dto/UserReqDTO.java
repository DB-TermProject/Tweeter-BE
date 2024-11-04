package db.termproject.tweeter.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class UserReqDTO {

    public record Login(
            @NotEmpty String email,
            @NotEmpty String password
    ) {}

    public record SignUp(
            @NotEmpty @Email String email,
            @NotEmpty @Length(min = 5, max = 20) String password,
            @NotEmpty String name
    ) {}

    public record Profile(
            @Length(max = 50) String  info,
            String profile_image_url,
            @Length(max = 30) String organization,
            @NotNull Boolean is_public
    ) {}

    public record Password(
            @NotEmpty @Length(min = 5, max = 20) String newPassword,
            @NotEmpty String confirmPassword
    ) {}
}
