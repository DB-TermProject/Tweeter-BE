package db.termproject.tweeter.domain.user.service;

import db.termproject.tweeter.domain.user.entity.User;
import db.termproject.tweeter.domain.user.repository.UserRepository;
import db.termproject.tweeter.global.error.exception.InvalidAuthenticationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static db.termproject.tweeter.domain.user.dto.UserReqDTO.Login;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public Long login(Login dto) {
        User user = userRepository.findByIdAndPassword(dto.id(), dto.password())    // Hashing?
                .orElseThrow(InvalidAuthenticationException::new);

        return user.getUser_id();
    }
}
