package ua.tunepoint.shelf.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.tunepoint.account.model.event.user.UserFollowedEvent;
import ua.tunepoint.account.model.event.user.UserUnfollowedEvent;
import ua.tunepoint.auth.model.event.user.UserRegisteredEvent;
import ua.tunepoint.shelf.service.AuthorService;

@Service
@RequiredArgsConstructor
public class UserEventService {

    private final AuthorService authorService;

    @Transactional
    public void handleUserCreated(UserRegisteredEvent event) {
        authorService.save(event.getUserId());
    }

    @Transactional
    public void handleUserFollow(UserFollowedEvent event) {
        authorService.incrementInteractions(event.getUserId());
    }

    @Transactional
    public void handleUserUnfollow(UserUnfollowedEvent event) {
        authorService.decrementInteractions(event.getUserId());
    }
}
