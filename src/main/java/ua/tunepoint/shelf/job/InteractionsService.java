package ua.tunepoint.shelf.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ua.tunepoint.shelf.service.AudioService;
import ua.tunepoint.shelf.service.AuthorService;
import ua.tunepoint.shelf.service.PlaylistService;

@Service
@Slf4j
@RequiredArgsConstructor
public class InteractionsService {

    private final AudioService audioService;
    private final AuthorService authorService;
    private final PlaylistService playlistService;

    @Scheduled(cron="${shelf.reset-interactions-cron}")
    public void resetAuthorInteractions() {
        log.info("Resetting user interactions...");

        try {
            authorService.resetAllInteractions();
        } catch (Exception ex) {
            log.error("Error occurred while resetting user interactions", ex);
        }
    }

    @Scheduled(cron="${shelf.reset-interactions-cron}")
    public void resetAudioInteractions() {
        log.info("Resetting audio interactions...");

        try {
            audioService.resetAllInteractions();
        } catch (Exception ex) {
            log.error("Error occurred while resetting audio interactions", ex);
        }
    }

    @Scheduled(cron="${shelf.reset-interactions-cron}")
    public void resetPlaylistInteractions() {
        log.info("Resetting playlist interactions...");

        try {
            playlistService.resetAllInteractions();
        } catch (Exception ex) {
            log.error("Error occurred while resetting playlist interactions", ex);
        }
    }
}
