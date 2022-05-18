package ua.tunepoint.shelf.service.recommendation;

import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ua.tunepoint.recommendation.model.request.Request;
import ua.tunepoint.recommendation.model.response.Response;

import java.util.List;

@Slf4j
public abstract class RecommendationService {

    public List<Long> recommendations(Long userId, Integer itemCount) {
        var response = getRecommendations(new Request(userId, false, itemCount));
        if (response.getStatusCode() != HttpStatus.OK || response.getBody() == null) {
            MDC.put("ResponseCode", response.getStatusCode().toString());
            log.warn("Recommendation service returned bad response");
            return null;
        }
        return response.getBody().getPayload().getItems();
    }

    protected abstract ResponseEntity<Response> getRecommendations(Request request);
}
