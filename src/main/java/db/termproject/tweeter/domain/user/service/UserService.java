package db.termproject.tweeter.domain.user.service;

import db.termproject.tweeter.domain.user.dto.UserResDTO.LoginResponse;
import db.termproject.tweeter.domain.user.entity.User;
import db.termproject.tweeter.domain.user.repository.UserRepository;
import db.termproject.tweeter.global.error.exception.InvalidAuthenticationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static db.termproject.tweeter.domain.user.dto.UserReqDTO.Login;
import static db.termproject.tweeter.domain.user.dto.UserReqDTO.SignUp;

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
        userRepository.save(dto);
    }
}
