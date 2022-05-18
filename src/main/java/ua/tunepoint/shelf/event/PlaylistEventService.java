package ua.tunepoint.shelf.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.tunepoint.audio.model.event.playlist.PlaylistCreatedEvent;
import ua.tunepoint.audio.model.event.playlist.PlaylistDeletedEvent;
import ua.tunepoint.audio.model.event.playlist.PlaylistLikedEvent;
import ua.tunepoint.audio.model.event.playlist.PlaylistUnlikedEvent;
import ua.tunepoint.audio.model.event.playlist.PlaylistUpdatedEvent;
import ua.tunepoint.shelf.service.AuthorService;
import ua.tunepoint.shelf.service.PlaylistService;

@Service
@RequiredArgsConstructor
public class PlaylistEventService {

    private final PlaylistService playlistService;
    private final AuthorService authorService;

    @Transactional
    public void handlePlaylistCreated(PlaylistCreatedEvent event) {
        playlistService.save(event.getPlaylistId(), event.getIsPrivate());
    }

    @Transactional
    public void handlePlaylistUpdated(PlaylistUpdatedEvent event) {
        playlistService.update(event.getPlaylistId(), event.getIsPrivate());
    }

    @Transactional
    public void handlePlaylistDeleted(PlaylistDeletedEvent event) {
        playlistService.delete(event.getPlaylistId());
    }

    @Transactional
    public void handlePlaylistLike(PlaylistLikedEvent event) {
        playlistService.incrementInteractions(event.getPlaylistId());
        authorService.incrementInteractions(event.getPlaylistOwnerId());
    }

    @Transactional
    public void handlePlaylistUnlike(PlaylistUnlikedEvent event) {
        playlistService.decrementInteractions(event.getPlaylistId());
        authorService.decrementInteractions(event.getPlaylistOwnerId());
    }
}
