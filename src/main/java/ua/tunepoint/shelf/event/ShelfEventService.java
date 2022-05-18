package ua.tunepoint.shelf.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.tunepoint.account.model.event.user.UserFollowedEvent;
import ua.tunepoint.account.model.event.user.UserUnfollowedEvent;
import ua.tunepoint.audio.model.event.audio.AudioCreatedEvent;
import ua.tunepoint.audio.model.event.audio.AudioDeletedEvent;
import ua.tunepoint.audio.model.event.audio.AudioLikeEvent;
import ua.tunepoint.audio.model.event.audio.AudioListenEvent;
import ua.tunepoint.audio.model.event.audio.AudioUnlikeEvent;
import ua.tunepoint.audio.model.event.audio.AudioUpdatedEvent;
import ua.tunepoint.audio.model.event.playlist.PlaylistCreatedEvent;
import ua.tunepoint.audio.model.event.playlist.PlaylistDeletedEvent;
import ua.tunepoint.audio.model.event.playlist.PlaylistLikedEvent;
import ua.tunepoint.audio.model.event.playlist.PlaylistUnlikedEvent;
import ua.tunepoint.audio.model.event.playlist.PlaylistUpdatedEvent;
import ua.tunepoint.auth.model.event.user.UserRegisteredEvent;
import ua.tunepoint.event.starter.handler.DomainEventHandlers;
import ua.tunepoint.event.starter.handler.DomainEventHandlersBuilder;
import ua.tunepoint.event.starter.registry.DomainRegistry;

import static ua.tunepoint.account.model.event.AccountDomain.USER;
import static ua.tunepoint.audio.model.event.Domain.AUDIO;
import static ua.tunepoint.audio.model.event.Domain.PLAYLIST;
import static ua.tunepoint.auth.model.event.AuthDomain.AUTH;

@Service
@RequiredArgsConstructor
public class ShelfEventService {

    private final DomainRegistry domainRegistry;
    private final AudioEventService audioEventService;
    private final UserEventService userEventService;
    private final PlaylistEventService playlistEventService;

    public DomainEventHandlers eventHandlers() {
        return DomainEventHandlersBuilder.withRegistry(domainRegistry)
                .forDomain(AUDIO.getName())
                    .onEvent(AudioCreatedEvent.class, audioEventService::handleAudioCreated)
                    .onEvent(AudioUpdatedEvent.class, audioEventService::handleAudioUpdated)
                    .onEvent(AudioLikeEvent.class, audioEventService::handleAudioLike)
                    .onEvent(AudioUnlikeEvent.class, audioEventService::handleAudioUnlike)
                    .onEvent(AudioListenEvent.class, audioEventService::handleAudioListen)
                    .onEvent(AudioDeletedEvent.class, audioEventService::handleAudioDeleted)
                .forDomain(AUTH.getName())
                    .onEvent(UserRegisteredEvent.class, userEventService::handleUserCreated)
                .forDomain(USER.getName())
                    .onEvent(UserFollowedEvent.class, userEventService::handleUserFollow)
                    .onEvent(UserUnfollowedEvent.class, userEventService::handleUserUnfollow)
                .forDomain(PLAYLIST.getName())
                    .onEvent(PlaylistCreatedEvent.class, playlistEventService::handlePlaylistCreated)
                    .onEvent(PlaylistUpdatedEvent.class, playlistEventService::handlePlaylistUpdated)
                    .onEvent(PlaylistDeletedEvent.class, playlistEventService::handlePlaylistDeleted)
                    .onEvent(PlaylistLikedEvent.class, playlistEventService::handlePlaylistLike)
                    .onEvent(PlaylistUnlikedEvent.class, playlistEventService::handlePlaylistUnlike)
                .build();
    }

}
