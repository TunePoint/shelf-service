package ua.tunepoint.shelf.service.recommendation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.tunepoint.recommendation.model.request.Request;
import ua.tunepoint.recommendation.model.response.Response;
import ua.tunepoint.shelf.service.recommendation.client.PlaylistRecommendationClient;

@Service
@RequiredArgsConstructor
public class PlaylistRecommendationService extends RecommendationService {

    private final PlaylistRecommendationClient client;

    @Override
    protected ResponseEntity<Response> getRecommendations(Request request) {
        return client.recommendations(request);
    }
}
