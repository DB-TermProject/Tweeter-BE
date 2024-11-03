package db.termproject.tweeter.domain.user.controller;

import db.termproject.tweeter.domain.user.dto.UserReqDTO.Login;
import db.termproject.tweeter.domain.user.dto.UserReqDTO.SignUp;
import db.termproject.tweeter.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid Login dto) {
        return ResponseEntity.ok(userService.login(dto));
    }

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUp dto) {
        userService.signUp(dto);
        return ResponseEntity.ok().build();
    }
}
