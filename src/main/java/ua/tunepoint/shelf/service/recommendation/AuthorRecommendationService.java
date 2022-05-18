package ua.tunepoint.shelf.service.recommendation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.tunepoint.recommendation.model.request.Request;
import ua.tunepoint.recommendation.model.response.Response;
import ua.tunepoint.shelf.service.recommendation.client.AuthorRecommendationClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorRecommendationService extends RecommendationService {

    private final AuthorRecommendationClient client;

    @Override
    protected ResponseEntity<Response> getRecommendations(Request request) {
        return client.recommendations(request);
    }
}
