package db.termproject.tweeter.domain.user.service;

import db.termproject.tweeter.domain.user.dto.UserResDTO.LoginResponse;
import db.termproject.tweeter.domain.user.dto.UserResDTO.ProfileResponse;
import db.termproject.tweeter.domain.user.entity.User;
import db.termproject.tweeter.domain.user.repository.UserRepository;
import db.termproject.tweeter.global.error.exception.InvalidAuthenticationException;
import db.termproject.tweeter.global.error.exception.PasswordMismatchException;
import db.termproject.tweeter.global.error.exception.UserExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static db.termproject.tweeter.domain.user.dto.UserReqDTO.*;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public LoginResponse login(Login dto) {
        User user = userRepository.findByEmailAndPassword(dto.email(), dto.password())    // Hashing?
                .orElseThrow(InvalidAuthenticationException::new);

        return new LoginResponse(user.getId());
    }

    public void signUp(SignUp dto) {
        if (userRepository.existsByEmail(dto.email()))
            throw new UserExistsException();

        userRepository.save(dto);
    }

    public ProfileResponse updateProfile(Long id, Profile dto) {
        userRepository.updateProfile(id, dto);
        return new ProfileResponse(dto.info(), dto.profile_image_url(), dto.organization(), dto.is_public());
    }

    public void updatePassword(Long id, Password dto) {
        if(!dto.newPassword().equals(dto.confirmPassword()))
            throw new PasswordMismatchException();

        userRepository.updatePassword(id, dto.newPassword());
    }
}
