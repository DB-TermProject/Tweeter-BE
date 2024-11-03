package db.termproject.tweeter.domain.user.controller;

import db.termproject.tweeter.domain.user.dto.UserReqDTO.Login;
import db.termproject.tweeter.domain.user.dto.UserReqDTO.Password;
import db.termproject.tweeter.domain.user.dto.UserReqDTO.Profile;
import db.termproject.tweeter.domain.user.dto.UserReqDTO.SignUp;
import db.termproject.tweeter.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/profile")
    public ResponseEntity<?> updateProfile(@RequestParam Long id, @RequestBody @Valid Profile dto) {
        return ResponseEntity.ok(userService.updateProfile(id, dto));
    }

    @PatchMapping("/auth")
    public ResponseEntity<?> updatePassword(@RequestParam Long id, @RequestBody @Valid Password dto) {
        userService.updatePassword(id, dto);
        return ResponseEntity.ok().build();
    }
}
