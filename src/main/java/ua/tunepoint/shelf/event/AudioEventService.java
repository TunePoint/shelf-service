package ua.tunepoint.shelf.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.tunepoint.audio.model.event.audio.AudioCreatedEvent;
import ua.tunepoint.audio.model.event.audio.AudioDeletedEvent;
import ua.tunepoint.audio.model.event.audio.AudioLikeEvent;
import ua.tunepoint.audio.model.event.audio.AudioListenEvent;
import ua.tunepoint.audio.model.event.audio.AudioUnlikeEvent;
import ua.tunepoint.audio.model.event.audio.AudioUpdatedEvent;
import ua.tunepoint.shelf.service.AudioService;
import ua.tunepoint.shelf.service.AuthorService;

@Service
@RequiredArgsConstructor
public class AudioEventService {

    private final AudioService audioService;
    private final AuthorService authorService;

    @Transactional
    public void handleAudioCreated(AudioCreatedEvent event) {
        audioService.save(event.getAudioId(), event.getIsPrivate());
    }

    @Transactional
    public void handleAudioUpdated(AudioUpdatedEvent event) {
        audioService.update(event.getAudioId(), event.getIsPrivate());
    }

    @Transactional
    public void handleAudioDeleted(AudioDeletedEvent event) {
        audioService.delete(event.getAudioId());
    }

    @Transactional
    public void handleAudioLike(AudioLikeEvent event) {
        authorService.incrementInteractions(event.getAudioOwnerId());
        audioService.incrementInteractions(event.getAudioId());
    }

    @Transactional
    public void handleAudioUnlike(AudioUnlikeEvent event) {
        authorService.decrementInteractions(event.getAudioOwnerId());
        audioService.decrementInteractions(event.getAudioId());
    }

    @Transactional
    public void handleAudioListen(AudioListenEvent event) {
        authorService.incrementInteractions(event.getAudioOwnerId());
        audioService.incrementInteractions(event.getAudioId());
    }
}
