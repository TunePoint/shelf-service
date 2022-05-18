package ua.tunepoint.shelf.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.MDC;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ua.tunepoint.shelf.config.props.ShelfConfiguration;
import ua.tunepoint.shelf.service.AudioShelfElementService;
import ua.tunepoint.shelf.service.AudioShelfService;
import ua.tunepoint.shelf.service.AuthorShelfElementService;
import ua.tunepoint.shelf.service.AuthorShelfService;
import ua.tunepoint.shelf.service.PlaylistShelfElementService;
import ua.tunepoint.shelf.service.PlaylistShelfService;
import ua.tunepoint.shelf.service.recommendation.AudioRecommendationService;
import ua.tunepoint.shelf.service.recommendation.AuthorRecommendationService;
import ua.tunepoint.shelf.service.recommendation.PlaylistRecommendationService;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShelfService {

    private final ShelfConfiguration configuration;

    private final AudioShelfService audioShelfService;
    private final AudioRecommendationService audioRecommendationService;
    private final AudioShelfElementService audioShelfElementService;

    private final AuthorShelfService authorShelfService;
    private final AuthorRecommendationService authorRecommendationService;
    private final AuthorShelfElementService authorShelfElementService;

    private final PlaylistShelfService playlistShelfService;
    private final PlaylistRecommendationService playlistRecommendationService;
    private final PlaylistShelfElementService playlistShelfElementService;

    @Scheduled(cron = "${shelf.update-cron}")
    public void updateAuthorShelves() {
        authorShelfService.getAllShelves().forEach(it -> {
            try {
                var recommendations = authorRecommendationService.recommendations(it, configuration.getRecommendationSize());
                authorShelfElementService.updateShelf(it, recommendations);
            } catch (Exception ex) {
                MDC.put("ShelfId", it.toString());
                log.error("Error occurred while constructing author shelf", ex);
            }
        });
    }

    @Scheduled(cron = "${shelf.update-cron}")
    public void updateAudioShelves() {
        audioShelfService.getAllShelves().forEach((it) -> {
            try {
                var recommendations = audioRecommendationService.recommendations(it, configuration.getRecommendationSize());
                audioShelfElementService.updateShelf(it, recommendations);
            } catch (Exception ex) {
                MDC.put("ShelfId", it.toString());
                log.error("Error occurred while constructing audio shelf", ex);
            }
        });
    }

    @Scheduled(cron = "${shelf.update-cron}")
    public void constructPlaylistShelves() {
        playlistShelfService.getAllShelves().forEach((it) -> {
            try {
                var recommendations = playlistRecommendationService.recommendations(it, configuration.getRecommendationSize());
                playlistShelfElementService.updateShelf(it, recommendations);
            } catch (Exception ex) {
                MDC.put("ShelfId", it.toString());
                log.error("Error occurred while constructing playlist shelf", ex);
            }
        });
    }
}
