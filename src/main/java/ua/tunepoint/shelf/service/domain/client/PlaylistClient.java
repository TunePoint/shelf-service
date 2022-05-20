package ua.tunepoint.shelf.service.domain.client;

import org.springframework.cloud.openfeign.FeignClient;
import ua.tunepoint.audio.api.PlaylistEndpoint;

@FeignClient(name = "audio-service", contextId = "playlist-service", configuration = FeignConfiguration.class)
public interface PlaylistClient extends PlaylistEndpoint {
}
