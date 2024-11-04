package db.termproject.tweeter.domain.follow.controller;

import db.termproject.tweeter.domain.follow.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/follow")
public class FollowController {

    private final FollowService followService;

    @PostMapping
    public ResponseEntity<?> follow(@RequestParam Long from, @RequestParam Long to) {
        followService.follow(from, to);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> unFollow(@RequestParam Long from, @RequestParam Long to) {
        followService.unfollow(from, to);
        return ResponseEntity.ok().build();
    }
}
