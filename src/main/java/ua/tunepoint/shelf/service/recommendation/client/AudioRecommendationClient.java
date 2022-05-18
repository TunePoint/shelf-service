package ua.tunepoint.shelf.service.recommendation.client;

import org.springframework.cloud.openfeign.FeignClient;
import ua.tunepoint.recommendation.api.RecommendationEndpoint;

@FeignClient(name = "audio-recommendation-service")
public interface AudioRecommendationClient extends RecommendationEndpoint {
}
