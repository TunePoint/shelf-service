package ua.tunepoint.shelf.service.domain.client;

import org.springframework.cloud.openfeign.FeignClient;
import ua.tunepoint.audio.api.AudioEndpoint;

@FeignClient(name = "audio-service", configuration = FeignConfiguration.class)
public interface AudioClient extends AudioEndpoint {
}
