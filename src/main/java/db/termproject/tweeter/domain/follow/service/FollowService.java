package db.termproject.tweeter.domain.follow.service;

import db.termproject.tweeter.domain.follow.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;

    public void follow(Long from, Long to) {
        followRepository.save(from, to);
    }

    public void unfollow(Long from, Long to) {
        followRepository.delete(from, to);
    }
}
